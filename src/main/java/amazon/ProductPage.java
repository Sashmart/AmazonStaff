package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver webDriver;
    protected final String SITE_URL = "https://www.amazon.com/s?k=Grammar&i=stripbooks-intl-ship&ref=nb_sb_noss";

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public ProductPage goTo() {
        webDriver.get(SITE_URL);
        return this;
    }


    @FindBy(xpath = "//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']")
    private List<WebElement> generalItemInPage;
    @FindBy(xpath = "//div[@class='a-section a-spacing-none']")
    private WebElement elementForVisibly;

    public void waitForPageLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementForVisibly));
    }

    public Integer itemCount() {
        int count = 0;
        for (int i = 0; i < generalItemInPage.size(); i++) {
            count++;
        }
        return count;
    }
}
