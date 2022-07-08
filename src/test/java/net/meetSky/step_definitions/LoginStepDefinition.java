package net.meetSky.step_definitions;

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

    @Given("user go to meetSky page")
    public void user_go_to_meet_sky_page() {
       Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }


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
      //  Assert.assertFalse(loginPage.usernameBox.isDisplayed());
    }





}
