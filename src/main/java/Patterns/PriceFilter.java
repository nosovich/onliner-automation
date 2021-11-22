package Patterns;

import lombok.Data;

//ValueObject pattern
@Data
public class PriceFilter {

    private String  minPrice;
    private String  maxPrice;
}
