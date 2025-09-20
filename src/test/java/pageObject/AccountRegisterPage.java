package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

public class AccountRegisterPage extends BasePage {
    public AccountRegisterPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtTelephone;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPasword;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setTxtFirstName(String fName)
    {
        txtFirstName.sendKeys(fName);
    }
    public void setTxtLastName(String lName)
    {
        txtLastName.sendKeys(lName);
    }
    public void setTxtEmail(String Email)
    {
        txtEmail.sendKeys(Email);
    }
    public void setTxtTelephone(String telephone)
    {
        txtTelephone.sendKeys(telephone);
    }
    public void setTxtPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }
    public void setTxtConfirmPasword(String pwd)
    {
        txtConfirmPasword.sendKeys(pwd);
    }
    public void setChkdPolicy()
    {
        chkdPolicy.click();
    }
    public void setBtnContinue()
    {
        btnContinue.click();
    }
    public String getConfirmationMsg(){
        try{
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }



}
