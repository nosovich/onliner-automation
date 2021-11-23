package restAPI.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartProduct {
    public int product_id;
    public String position_id;
    public String name;
}
