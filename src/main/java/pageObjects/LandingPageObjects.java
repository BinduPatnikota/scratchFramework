package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {
	
WebDriver driver;
	public LandingPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//span[contains(.,'Register')]")
 WebElement register;
@FindBy(css="#user_name")
WebElement username;

@FindBy(css="#user_email")
WebElement email;

  public WebElement register() {
	  return register;
	
  }
  public WebElement username() {
	  return username;
	
  }
  
  public WebElement email() {
	  return email;
	
  }
	
	
}
