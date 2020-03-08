package stepstone;

import java.net.Authenticator;
import java.net.PasswordAuthentication;



class RHAuthenticator extends Authenticator {
    static final String kuser = "testuser";
    static final String kpass = "testpassword";
    public PasswordAuthentication getPasswordAuthentication() {
        return (new PasswordAuthentication(kuser, kpass.toCharArray()));
    }
}
