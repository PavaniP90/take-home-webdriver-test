package Main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

import static Utilities.DriverHelper.getDriver;

public class LoginPage {

    @FindBy(id="username")
    public WebElement UserName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash-messages']")
    public WebElement messages;

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);}



}