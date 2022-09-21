package staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "jobsfilter-category")
    protected WebElement chooseJobCategory;
    @FindBy(xpath = "//option[text()='Banking/credit']")
    protected WebElement jobCategory;
    @FindBy(id = "jobsfilter-job_city")
    protected WebElement chooseCity;
    @FindBy(xpath = "//option[text()='Yerevan']")
    protected WebElement searchJobCity;
    @FindBy(xpath= "//button[@data-url='/en/site/search']")
    protected WebElement searchButton;


    public HomePage goTo(){
       webDriver.get(SITE_URL);
       return this;
   }
   public void chooseJobCategoryAndCity(){
        chooseJobCategory.click();
        jobCategory.click();
        chooseCity.click();
        searchJobCity.click();
        searchButton.click();
   }
   public void waitForPageLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(chooseJobCategory));
    }
}
