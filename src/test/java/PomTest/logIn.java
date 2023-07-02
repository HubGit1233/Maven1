package PomTest;

import POM.DashboardPage;
import BasicTestPack.Basic;
import POM.LoginPage;
import org.testng.annotations.Test;

public class logIn extends Basic {

    @Test
    public void SuccessfulLogin() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.verifyUsernameLabelText("Milen Strahinski");
    }

    @Test
    public void UnsuccessfulLogin() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("invalid password");
        LoginPage.clickLoginButton();
        LoginPage.verifyValidationMessage("Wrong Username and/or Password!");
    }
}
