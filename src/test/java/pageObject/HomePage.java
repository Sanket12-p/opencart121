package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath ="//span[normalize-space()='My Account']") WebElement lnkMyAccount;

   @FindBy(xpath ="//a[normalize-space()='Register']") WebElement lnkRegister;

    @FindBy(linkText="Login") WebElement lnkLogin;


    public void ClikcMyAccount()
    {
        lnkMyAccount.click();
    }
    public void ClikcRegister()
    {
        lnkRegister.click();
    }
    public void ClickLogin()
    {
        ClikcMyAccount();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));
        System.out.println("Is login link displayed? " + lnkLogin.isDisplayed());
        System.out.println("Is login link enabled? " + lnkLogin.isEnabled());
        lnkLogin.click();
        System.out.println("Clicked login link");
    }

}
