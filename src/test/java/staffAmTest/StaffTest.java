package staffAmTest;

import initBrowser.BrowserType;
import initBrowser.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import staff.HomePage;
import staff.SearchResultPage;

public class StaffTest {

    @Test
    public void staffAmTest() {
        DriverFactory.initDriver(BrowserType.CHROME);
        HomePage homePage = new HomePage(DriverFactory.getDriver()).goTo();
        homePage.waitForPageLoad();
        homePage.chooseJobCategoryAndCity();
        SearchResultPage searchResultPage = new SearchResultPage(DriverFactory.getDriver());
        searchResultPage.waitForPageLoad();
        Integer visiblyCountJob = 118;
        Assert.assertEquals(searchResultPage.countJob(), visiblyCountJob);


    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }}
