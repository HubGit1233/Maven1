package PomTest;

import java.util.ResourceBundle;
public class SourceCode {

    public String userLogin(String in_user, String in_pwd) {
        ResourceBundle rb = ResourceBundle.getBundle("Configs");
        String username = rb.getString("username");
        String password = rb.getString("password");

        if (in_user.equals(username) && in_pwd.equals(password)) {
            return "Success!";
        } else {
            return "Failed";
        }
    }
}
