package stepDefinitions;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AccountsPageSteps {
	
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	private AccountsPage  accountsPage; 
	
	public String title;
	
	
	
	@Given("User has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
		
		List<Map<String, String>> credList = credTable.asMaps();
		
		String usrname = credList.get(0).get("username");
		String pws = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(usrname, pws);
	   
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		
		 title = accountsPage.getAccountsPageTitle();
		 
		 System.out.println("Accounts page title is s"+title);
	    
	}

	@SuppressWarnings("deprecation")
	@Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
	    
		Assert.assertEquals(title,pageTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable sectionsTable) {
		
		List<String> expectedAccountSectionList = sectionsTable.asList();
		
		System.out.println("Expected accounts section list "+expectedAccountSectionList);
		
		List<String> actualAcountSectionList = accountsPage.getAccountsSectionList();
		
		System.out.println("Actual accounts section list "+actualAcountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAcountSectionList));
		
	    
	    
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer accepteedSectionCount) {
		
		Assert.assertTrue(accountsPage.getAccountSectionCount()== accepteedSectionCount);
		
	   
	}

}
