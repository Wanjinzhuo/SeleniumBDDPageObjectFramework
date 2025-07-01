package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPage {
    public WebDriver driver;
    public BingSearchPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@id=\"sb_form_q\"]")
    @CacheLookup
    WebElement txtSearch;

    @FindBy(xpath = "//*[@id=\"search_icon\"]")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(xpath = "//a[@href='https://cucumber.io/']/strong")
    @CacheLookup
    WebElement lnkCucumber;

    public void setSearch(String searchText) {
        txtSearch.clear();
        txtSearch.sendKeys(searchText);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 可选：记录日志或处理中断
            Thread.currentThread().interrupt(); // 保留中断状态
        }
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public void clickCucumber() {
        lnkCucumber.click();
    }
}
