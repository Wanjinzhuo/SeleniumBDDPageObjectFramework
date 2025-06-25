package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Adminpage;
import pageObjects.LoginPage;
import static org.junit.jupiter.api.Assertions.*;


public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public Adminpage ap;

}
