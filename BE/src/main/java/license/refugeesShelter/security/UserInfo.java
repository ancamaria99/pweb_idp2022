package license.refugeesShelter.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private String uid;

    private String name;

    private String email;

    private boolean isEmailVerified;

    private String issuer;

    private String picture;

}
