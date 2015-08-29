package baseAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 8/26/2015.
 */
public class Base {
    public WebDriver driver = null;

    @Parameters({"url"})


    @BeforeMethod
    public void setUp(String url){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }

    @AfterMethod

    public void cleanUp(){
        driver.quit();
    }





}
