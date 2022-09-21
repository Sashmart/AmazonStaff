package amazon;

import initBrowser.BrowserType;
import initBrowser.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest {
    @Test
    public void testSearchFunctionality() {
        DriverFactory.initDriver(BrowserType.CHROME);
        HomePage homePage1 = new HomePage(DriverFactory.getDriver()).goTo();
        homePage1.waitForPageLoad();
        String myCountryOfResidence = "Armenia";
        Assert.assertEquals(homePage1.defaultCountry(), myCountryOfResidence);
        homePage1.myChooseTypeAndSearchMyFavoriteTopic();


    }

    @Test
    public void checkingQuantityCompliance() {
        DriverFactory.initDriver(BrowserType.CHROME);
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.goTo();
        Integer visibleCountItem = 16;
        productPage.waitForPageLoad();
        Assert.assertEquals(productPage.itemCount(), visibleCountItem);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();


    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

