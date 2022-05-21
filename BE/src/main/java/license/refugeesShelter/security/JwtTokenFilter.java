package license.refugeesShelter.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Strings.isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        FirebaseToken decodedToken = null;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }

        UserInfo userInfo = getUserInfoFromToken(decodedToken);

        if (!Objects.isNull(userInfo)) {
            UserCredentials userCredentials = new UserCredentials(decodedToken, token);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userInfo, userCredentials, null);

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private UserInfo getUserInfoFromToken(FirebaseToken decodedToken) {
        UserInfo userInfo = null;

        if (!Objects.isNull(decodedToken)) {
            userInfo = new UserInfo();

            userInfo.setUid(decodedToken.getUid());
            userInfo.setName(decodedToken.getName());
            userInfo.setEmail(decodedToken.getEmail());
            userInfo.setEmailVerified(decodedToken.isEmailVerified());
            userInfo.setIssuer(decodedToken.getIssuer());
            userInfo.setPicture(decodedToken.getPicture());
        }

        return userInfo;
    }
}
