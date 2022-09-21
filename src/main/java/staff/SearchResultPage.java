package staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='right_radius_change hb_list_item clearfix featured-job']")
    protected List <WebElement> jobList;
    @FindBy(xpath = "//img[@alt='Banner']")
    protected WebElement elementForVisibly;


    public Integer countJob(){
        int count=0;
        for (int i = 0; i < jobList.size(); i++) {
            count++;

        }return count;
    } public void waitForPageLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elementForVisibly));
    }
}
