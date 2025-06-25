package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Adminpage {
    public WebDriver ldriver;
    public Adminpage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


//    @FindBy(xpath="html/body/div[3]/nav")
//    @CacheLookup
//    WebElement nopCnavheader;
//
    By elementLocator = By.xpath("html/body/div[3]/nav");

    public WebElement getNopCnavheader() {
    	return ldriver.findElement(elementLocator);
    }

}
