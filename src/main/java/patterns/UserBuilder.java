package patterns;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

// Builder pattern
@Builder
@Data
@ToString
public class UserBuilder {

    private String email;
    private String password;
}
