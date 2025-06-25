package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//button[text()='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath="//a[text()='Logout']")
    @CacheLookup
    WebElement btnLogout;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    @FindBy(xpath = "//*[@id=\"loadCustomerStatisticsAlert-action-alert\"]/div[1]/div/div[3]/span")
    @CacheLookup
    WebElement alert;

    @FindBy(xpath = "//*[@id=\"loadOrderStatisticsAlert-action-alert\"]/div[1]/div/div[3]/span")
    @CacheLookup
    WebElement alert1;

    public void setUserName(String username){
        txtEmail.clear();
        txtEmail.sendKeys(username);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 可选：记录日志或处理中断
            Thread.currentThread().interrupt(); // 保留中断状态
        }
    }

    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 可选：记录日志或处理中断
            Thread.currentThread().interrupt(); // 保留中断状态
        }
    }

    public void clickLogin(){
        btnLogin.click();
    }
 
    public void clickLogout(){
        alert.click();
        alert1.click();
        btnLogout.click();
    }





}
