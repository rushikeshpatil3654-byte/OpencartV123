package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
	@Test(groups={"Sanity","Master"})
      public void verify_login()
      {
    	  logger.info("*** Statring TC002_LginTest****");
    	  
    	  try
    	  {
    	  //HomePAge
    	  HomePage hp= new HomePage(driver);
    	  hp.clickMyAccount();
    	  hp.clicklogin();
    	  
    	  
    	 // Login Page
    	  LoginPage lp=new LoginPage(driver);
    	  lp.setEmail(p.getProperty("email"));
    	  lp.setPassword(p.getProperty("password"));
    	  lp.clickLogin();
    	  
    	  //My Account
    	  
    	  MyAccountPage MyAccpg=new MyAccountPage(driver);
    	 boolean targatePage= MyAccpg.isMyAccountPAgeExists();
    	 
    	 Assert.assertTrue(targatePage);         //Assert.assertEquals(targatePage, true, "login failed");   //OR
    	  }
    	  catch(Exception e)
    	  {
    		  Assert.fail();
    	  }
    	 logger.info("*** Finished TC002_LginTest****");
      }
}
