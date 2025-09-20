package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement lnkEmail;

    @FindBy(xpath = "//input[@id='input-password']") WebElement lnkPwd;

    @FindBy(xpath = "//input[@value='Login']") WebElement btnLogin;

    public void EnterEmail(String Email)
    {
        lnkEmail.sendKeys(Email);
    }
    public void EnterPwd(String Pwd)
    {
        lnkPwd.sendKeys(Pwd);
    }
    public void ClickLogin()
    {
        btnLogin.click();
    }
}
