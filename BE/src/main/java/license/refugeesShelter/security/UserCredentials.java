package license.refugeesShelter.security;

import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCredentials {

    public FirebaseToken decodedToken;

    public String idToken;
}
