package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.myAccountPage;
import testBase.baseclass;

public class tc002_LoginTest extends baseclass {
    @Test(groups = {"Sanity","Master"})
    public void login()
    {
        logger.info("** verifying logging **");
        try {
            HomePage hp = new HomePage(driver);
            hp.ClickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("Email"));
            lp.EnterPwd(p.getProperty("password"));
            lp.ClickLogin();

            myAccountPage acc = new myAccountPage(driver);
            boolean targetPage = acc.isMyAccountPageExists();
            //Assert.assertEquals(targetPage,true,"log in failed");
            Assert.assertTrue(targetPage); // we can use this in place above
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("*** login test passed ***");

    }
}
