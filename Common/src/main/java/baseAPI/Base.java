package baseAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 8/26/2015.
 */
public class Base {
    public WebDriver driver = null;

    @Parameters({"useSauceLabs", "userName", "key", "os", "browserName", "browserVersion", "url"})


    @BeforeMethod
    public void setUp(boolean useSauceLabs, String userName, String key, String os, String browserName, String browserVersion, String url) throws MalformedURLException {
        if (useSauceLabs){
            setUpCloudEnvironment(userName, key,os, browserName, browserVersion, url);
        } else {getLocalDriver(browserName, url);}

    }

    public void setUpCloudEnvironment(String userName, String key, String os, String browserName, String browserVersion, String url) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);
        cap.setCapability("platform", os);
        this.driver = new RemoteWebDriver(new URL("http://"+userName+":"+key+"@ondemand.saucelabs.com:80/wd/hub"), cap);
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void getLocalDriver(String browserName, String url){
        if (browserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\idjalalov\\java-selenium\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
        } else if (browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "C:\\Users\\idjalalov\\java-selenium\\IEDriverServer\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod

    public void cleanUp(){
        driver.quit();
    }





}
