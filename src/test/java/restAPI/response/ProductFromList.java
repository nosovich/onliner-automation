package restAPI.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFromList {
    public int id;
    public String key;
    public String name;
}
