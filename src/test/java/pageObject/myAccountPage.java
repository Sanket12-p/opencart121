package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{
    public myAccountPage(WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement lnkMyAccount;
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement btnlogout;


    public boolean isMyAccountPageExists()
    {
        try{
            return (lnkMyAccount.isDisplayed());
        }catch (Exception e)
        {
            return false;
        }
    }
    public void clicklogout()
    {
        btnlogout.click();
    }
}
