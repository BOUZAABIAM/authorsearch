package stepstone;

import java.net.Authenticator;
import java.net.PasswordAuthentication;



class RHAuthenticator extends Authenticator {
    /**
     * Username.
     */
    static final String kuser = "testuser";
    /**
     * User Password
     */
    static final String kpass = "testpassword";

    /**
     * Get Password Authentication
     * @return
     */
    public PasswordAuthentication getPasswordAuthentication() {
        return (new PasswordAuthentication(kuser, kpass.toCharArray()));
    }
}
