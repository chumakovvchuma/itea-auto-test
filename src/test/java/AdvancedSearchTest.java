import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

/**
 * Created by Chu on 12.11.2016.
 */
public class AdvancedSearchTest extends BaseTest {

    public HomePage homePage;

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"HR", "HR"},
                {"hr", "hr"}
        };
    }

    @BeforeClass
    public  void  beforeTest() {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.LogIn("0ipysc92b8@hostcalls.com", "chumachuma");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    @Test(dataProvider = "searchTerms")
    public void advancedSearchTest(String searchTerm, String countFindElement  ) {
        SearchPage searchPage = homePage.clickAdvSearchButton();
        searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "actual result is wrong");
        Assert.assertTrue(searchPage.getDescriptionStringList().get(10).contains(countFindElement));

    }
}
