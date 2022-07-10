package net.meetSky.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetSky.pages.LoginPage;
import net.meetSky.pages.MainPage;
import net.meetSky.utilities.ConfigurationReader;
import net.meetSky.utilities.Driver;
import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();




    @Given("user go to the login page")
    public void user_go_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    @When("user enters valid {string} to the username box")
    public void user_enters_valid_to_the_username_box(String string) {
        String userName;
        userName = ConfigurationReader.getProperty(string);
        loginPage.usernameBox.sendKeys(userName);

    }
    @When("user enters valid {string} to the password box")
    public void user_enters_valid_to_the_password_box(String string) {
       String password;
       password = ConfigurationReader.getProperty(string);
        loginPage.passwordBox.sendKeys(password);
    }
    @When("user clicks the log in button")
    public void user_clicks_the_log_in_button() {
        loginPage.logInButton.click();
    }
    @Then("user should be navigate to main page")
    public void user_should_be_navigate_to_main_page() {
        Assert.assertTrue(mainPage.avatarButton.isDisplayed());
       // Assert.assertFalse(loginPage.usernameBox.isDisplayed());
    }


    @And("user enters invalid password to the password box")
    public void userEntersInvalidPasswordToThePasswordBox() {
        loginPage.passwordBox.sendKeys("invalid.password");
    }

    @Then("user should see Wrong username or password")
    public void userShouldSeeWrongUsernameOrPassword() {
        String message =loginPage.wrongUsernamePasswordMessage.getText();
        Assert.assertEquals( "Wrong username or password.", message);
    }


    @When("user enters invalid username to username box")
    public void userEntersInvalidUsernameToUsernameBox() {
        loginPage.usernameBox.sendKeys("invalid.username");
    }

    @Then("user should see please fill out this filed message in password box")
    public void userShouldSeePleaseFillOutThisFiledMessageInPasswordBox() {
        String message= loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Please fill in this field.",message);
    }

    @Then("user can see the password in a form of dots by default")
    public void userCanSeeThePasswordInAFormOfDotsByDefault() {
        Assert.assertEquals(loginPage.passwordBox.getAttribute("type"), "password");
        
    }

    @And("user click eye icon next to password")
    public void userClickEyeIconNextToPassword() {
        loginPage.showPasswordExplicitlyIcon.click();
        
    }

    @Then("user can see the password explicitly if needed")
    public void userCanSeeThePasswordExplicitlyIfNeeded() {
        Assert.assertEquals(loginPage.passwordBox.getAttribute("type"), "text");
    }

    @When("user clicks Forgot password link on the login page")
    public void userClicksForgotPasswordLinkOnTheLoginPage() {
        loginPage.forgotPasswordLink.click();
    }

    @Then("user can see Reset Password button on the next page")
    public void userCanSeeResetPasswordButtonOnTheNextPage() {
        Assert.assertTrue(loginPage.resetPasswordButton.isDisplayed());
    }

    @Then("user can see valid placeholders on username")
    public void userCanSeeValidPlaceholdersOnUsername() {
        String placeholder = loginPage.usernameBox.getAttribute("placeholder");
        Assert.assertEquals("Username or email", placeholder);

    }

    @Then("user can see valid placeholders on password")
    public void userCanSeeValidPlaceholdersOnPassword() {
        String placeholder = loginPage.passwordBox.getAttribute("placeholder");
        Assert.assertEquals("Password", placeholder);
    }
}
