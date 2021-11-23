package restAPI;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restAPI.request.DeleteProduct;
import restAPI.request.Position;
import restAPI.request.Product;
import restAPI.response.CartProduct;
import restAPI.response.ProductFromList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestApiTests {

    String cartId;
    ProductFromList product;
    CartProduct cartProduct;
    int shopId;

    @BeforeTest
    public void preconditions() {
        baseURI = "https://catalog.onliner.by/";
    }

    @Description("Getting the product from a product list on FilterPage")
    @Test(priority = 1)
    public void getProduct_Test() {
        String endpoint = "sdapi/catalog.api/search/mobile?group=1&page=1";
        Response response = given()
                .get(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        product = response.jsonPath().getObject("products[0]", ProductFromList.class);
        Assert.assertTrue(product.id > 0);
        Assert.assertTrue(StringUtils.isNotEmpty(product.key));
    }

    @Description("Getting the shop on ProductPage")
    @Test(priority = 2, dependsOnMethods = "getProduct_Test")
    public void getProductShop_Test() {
        String endpoint = "sdapi/shop.api/products/" + product.key + "/positions?town=all&has_prime_delivery=0";
        Response response = given()
                .get(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        LinkedHashMap<String, Object> shops = response.jsonPath().get("shops");
        shopId = Integer.parseInt(shops.keySet().iterator().next());
        Assert.assertTrue(shopId > 0);
    }

    @Description("Add selected product to the cart")
    @Test(priority = 3, dependsOnMethods = "getProductShop_Test")
    public void addProductToCart_Test() {
        Product productToAdd = new Product() {{
            position_id = shopId + ":" + product.id + "001";
            product_id = product.id;
            product_key = product.key;
            shop_id = shopId;
            quantity = 1;
        }};
        String endpoint = "sdapi/cart.api/detached-cart/add";
        Response response = given()
                .header("Content-type", "application/json")
                .and().body(productToAdd)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        cartId = response.jsonPath().getString("cart_id");
        Assert.assertTrue(StringUtils.isNotEmpty(cartId));
    }

    @Description("Check that exactly selected product was added to cart")
    @Test(priority = 4, dependsOnMethods = "addProductToCart_Test")
    public void checkCart_Test() {
        String endpoint = "sdapi/cart.api/v2/detached-cart/" + cartId;
        Response response = given()
                .get(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        List<CartProduct> cartProducts = response.jsonPath().getList("position_groups[0].positions", CartProduct.class);
        cartProduct = cartProducts.get(0);
        int cartProductShopId = Integer.parseInt(cartProduct.position_id.split(":")[0]);
        Assert.assertEquals(shopId, cartProductShopId);
        Assert.assertTrue(cartProducts.size() == 1);
        Assert.assertEquals(product.id, cartProducts.get(0).product_id);
    }

    @Description("Delete product from cart")
    @Test(priority = 5, dependsOnMethods = "checkCart_Test")
    public void deleteProductFromCart_Test() {
        String endpoint = "sdapi/cart.api/detached-cart/" + cartId;
        DeleteProduct productToDelete = new DeleteProduct();
        productToDelete.positions = new ArrayList<Position>();
        Position position = new Position() {{
            position_id = cartProduct.position_id;
            product_id = cartProduct.product_id;
            shop_id = shopId;
        }};
        productToDelete.positions.add(position);
        Response response = given()
                .header("Content-type", "application/json")
                .and().body(productToDelete)
                .and().delete(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);

    }

    @Description("Check that cart is empty")
    @Test(priority = 6, dependsOnMethods = "deleteProductFromCart_Test")
    public void ensureCartEmptiness_Test() {
        String endpoint = "sdapi/cart.api/v2/detached-cart/" + cartId;
        Response response = given()
                .get(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        List<Object> cartProducts = response.jsonPath().getList("position_groups");
        Assert.assertEquals(cartProducts.size(), 0);
    }
}
