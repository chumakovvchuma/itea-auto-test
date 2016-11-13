import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;


public class LogInRegistrationTest extends BaseTest {
    @Test
    public void errorMessageForEmptyField() {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        loginRegistrationPage.RegistrationFieldSubmit("", "", "", "");
        Assert.assertEquals(loginRegistrationPage.GetErrorMessageText(), "Please enter your first name", "not found error message");
    }

    @Test
    public void LogInTest() {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.LogIn("0ipysc92b8@hostcalls.com", "chumachuma");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    @Test
    public void SearchHRTest() {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.LogIn("0ipysc92b8@hostcalls.com", "chumachuma");
        Assert.assertTrue(homePage.isPageLoaded());
        SearchPage searchPage = homePage.clickAdvSearchButton();
        searchPage.fillKeywordSearchTermAndSubmit("HR");
        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "actual result is wrong");
        //Assert.assertTrue(searchPage.getDescriptionStringList());


    }


}
