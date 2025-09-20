package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.myAccountPage;
import testBase.baseclass;
import utilities.DataProviders;

public class tc003_loginDDTest extends baseclass {
@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
    public void logindata(String email,String pwd,String exp)
{

    logger.info("*** starting tc003_loginDDTest  ****");

    try {
        HomePage hp = new HomePage(driver);
        hp.ClikcMyAccount();
        hp.ClickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.EnterEmail(email);
        lp.EnterPwd(pwd);
        lp.ClickLogin();

        myAccountPage mp = new myAccountPage(driver);
        boolean targetPage = mp.isMyAccountPageExists();

        if (exp.equalsIgnoreCase("Valid")) {
            if (targetPage == true) {
                mp.clicklogout();
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
        if (exp.equalsIgnoreCase("Invalid")) {
            if (targetPage == true) {
                mp.clicklogout();
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }
    } catch (Exception e) {
       Assert.fail();
    }
    logger.info("*** tc003_loginDDTest finished ***");
}

}
