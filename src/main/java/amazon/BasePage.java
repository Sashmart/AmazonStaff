package amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String SITE_URL = "https://www.amazon.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@title='Search in']")
    protected WebElement chooseType;

    @FindBy(xpath = "//option[text()='Books']")
    protected WebElement myFavoriteTopic;
    @FindBy(xpath = "//input[@type='text']")
    protected WebElement inputSearchName;
    @FindBy(id = "glow-ingress-line2")
    protected WebElement defaultCountry;


    public void myChooseTypeAndSearchMyFavoriteTopic() {
        chooseType.click();
        myFavoriteTopic.click();
        inputSearchName.click();
        inputSearchName.sendKeys("Grammar");
        inputSearchName.sendKeys(Keys.ENTER);

    }

    public String defaultCountry() {
        return defaultCountry.getText();
    }
}
