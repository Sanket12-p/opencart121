package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.AccountRegisterPage;
import pageObject.HomePage;
import testBase.baseclass;

import java.time.Duration;
import java.util.Random;

public class tc001_AccountRegistrationTest extends baseclass {
    @Test(groups = {"Regression","Master"})
    void Verify_Account_Registration()
    {
        logger.info("*** Starting Account RegistrationTest ***");
        logger.debug("*** This is debugMessage ***");
        try{
        HomePage hp=new HomePage(driver);
        hp.ClikcMyAccount();
        logger.info("*** Clicked on My account ***");

        hp.ClikcRegister();
        logger.info("*** Clicked On Register ***");

        AccountRegisterPage ap=new AccountRegisterPage(driver);
        logger.info("*** Provided Customer details ***");

       ap.setTxtFirstName(randomString().toUpperCase());
       // ap.setTxtFirstName("Sanket");
        ap.setTxtLastName(randomString().toUpperCase());
        //ap.setTxtLastName("Dh");
        ap.setTxtEmail(randomString()+"@gmail.com");
       // ap.setTxtEmail("sankd@gmail.com");

        ap.setTxtTelephone(randomNumber());
        //ap.setTxtTelephone("2345128932");

        String Password=randomPwd();
        ap.setTxtPassword(Password);
        //ap.setTxtPassword("282628");
        ap.setTxtConfirmPasword(Password);
        //ap.setTxtConfirmPasword("282628");
        ap.setChkdPolicy();
        ap.setBtnContinue();
        logger.info("*** Validation expected Message");

        String confirmationmsg=ap.getConfirmationMsg();
        if(confirmationmsg.equals("Your Account Has Been Created!"))
        {
            Assert.assertTrue(true);
        }
        else {
            logger.error("Test failed");
            logger.debug("Debug log");
            Assert.assertTrue(false);
        }
        //Assert.assertEquals(confirmationmsg,"Your Account Has Been Created!!!");

        logger.info("** Test Passed **");

    } catch (Exception e) {
            Assert.fail();
        }
        finally {
            logger.info("*** Finished tc001Account Registration Test *** ");
        }
        }
}
