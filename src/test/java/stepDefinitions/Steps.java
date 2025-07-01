package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.Adminpage;
import pageObjects.BingSearchPage;
import utilities.WaitHelper;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class Steps extends BaseClass{

    String originalWindow;
    @Before
    public void setUp() {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("无法找到配置文件");
                return;
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String browser = prop.getProperty("browser", "edge").toLowerCase(); // 默认使用 edge

        // 根据配置选择浏览器
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", prop.getProperty("edge.driver.path"));
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("不支持的浏览器类型: " + browser);
        }
    }
    @Given("User Launch browser")
    public void user_launch_browser() {

        lp=new LoginPage(driver);
        ap = new Adminpage(driver);
        bp=new BingSearchPage(driver);

    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("User enters Email {string} and Password {string}")
    public void user_enters_email_and_password(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        lp.setUserName( email);
        lp.setPassword( password);

    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        lp.clickLogin();
    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedText) {
        //WebElement adminNavheader = ap.getNopCnavheader();
        // 等待页面标题变为预期值
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WaitHelper wh = new WaitHelper(driver);
        //wh.waitforElement(adminNavheader, 10);
        // 获取当前页面标题并打印
        String actualTitle = driver.getTitle();
        //System.out.println("当前页面标题是: " + actualTitle); // 👈 打印页面标题

        // 获取实际标题并断言

        assertEquals(expectedText, actualTitle, "实际标题不匹配，期望: " + expectedText + ", 实际: " + actualTitle);

        try {
            Thread.sleep(10000); // 已处理异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        lp.clickLogout();
        Thread.sleep(3000);
    }
    @Then("close browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }

    @When("I search for {string}")
    public void i_search_for(String search) {
        // Write code here that turns the phrase above into concrete actions
        bp.setSearch(search);
        bp.clickSearch();
    }
    @When("I click the first search result")
    public void i_click_the_first_search_result() {
        // Write code here that turns the phrase above into concrete actions
        originalWindow = driver.getWindowHandle();
        bp.clickCucumber();
    }
}
