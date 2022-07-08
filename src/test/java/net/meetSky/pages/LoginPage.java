package net.meetSky.pages;

import net.meetSky.utilities.BrowserUtils;
import net.meetSky.utilities.ConfigurationReader;
import net.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id ="user")
    public WebElement usernameBox;

    @FindBy(id ="password")
    public WebElement passwordBox;

    @FindBy(id ="submit-form")
    public WebElement logInButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUsernamePasswordMessage;

    @FindBy (xpath = "//img[@src='/core/img/actions/toggle.svg']")
    public WebElement showPasswordExplicitlyIcon;

    @FindBy(id="lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(id="reset-password-submit")
    public WebElement resetPasswordButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        //loginPage.logInButton.click();
        BrowserUtils.clickWithJS(logInButton);
        BrowserUtils.waitFor(5);
    }
}
