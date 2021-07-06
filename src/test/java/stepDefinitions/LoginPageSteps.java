package stepDefinitions;

import com.aventstack.extentreports.gherkin.model.Given;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

public class LoginPageSteps  {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	
	
	@Given("User in on the login page")
	public void user_in_on_the_login_page() {
	System.out.println("Scenario 1:: User is on the login page");
	//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   
	
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is "+title);
	    
	}
	

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
			Assert.assertTrue(title.contains(expectedTitleName));
	    
	}
	
	

	@Given("user is on the login page to check forgot password link")
	public void user_is_on_the_login_page_to_check_forgot_password_link()  {
		
		System.out.println("user is on login page to check forgot password link");
		
		}


	@Then("forgot Your Password link should be displayed")
	public void forgot_your_password_link_should_be_displayed()  {
		
		
		try {
			Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}




	@Given("User is on the login page")
	public void user_is_on_the_login_page()  {
		
		
		System.out.println("user is on login page");
	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String username)  {
		
		loginPage.enterUserName(username);
	    
	}

	@When("user enters password {string}")
	public void user_enters_password(String password)  {
		
	
		loginPage.enterPassWord(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		loginPage.clickOnLogin();
		
	
	    
	}

	

	
	

}
