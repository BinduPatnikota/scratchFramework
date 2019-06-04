package res;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class base {
	public static WebDriver driver;
	public static Properties prop;
	
	@SuppressWarnings("deprecation")
	
	public  WebDriver initializeDriver() throws IOException {
	 prop = new Properties();
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\res\\data.properties");
		
		prop.load(file);
		
		String name =prop.getProperty("browser");
		
		if (name.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else if (name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else if (name.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\IEDriverServer.exe");
			DesiredCapabilities d =  DesiredCapabilities.internetExplorer();
			d.setCapability("ignoreZoomSetting",true);
		 driver = new InternetExplorerDriver(d);
			driver.manage().window().maximize();
			
			
}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void screehShot(String result) throws IOException {
		
File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("C:\\Users\\bpatnikota\\Desktop\\scratchFramework\\resources\\failPictures\\fail"+result+".png"));
	    
	
	}
	
	
	
}
