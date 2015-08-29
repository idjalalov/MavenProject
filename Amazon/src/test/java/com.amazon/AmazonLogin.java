package com.amazon;

import baseAPI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by idjalalov on 8/28/2015.
 */
public class AmazonLogin extends Base {

    @Test
    public void GoToAccount() {
        System.out.println(driver.getTitle());//gets title of current page

        driver.findElement(By.xpath(".//*[@id='nav-your-amazon']")).click();//clicks on sign in element lin
        System.out.println(driver.getTitle());//gets title of current page
        WebElement emailBox = driver.findElement(By.xpath(".//*[@id='ap_email']"));// finds email box
        emailBox.sendKeys("john_jackson_1982@yahoo.com");// enters your email
        WebElement passBox = driver.findElement(By.xpath(".//*[@id='ap_password']"));//finds passwordbox
        passBox.sendKeys("bestpassword");//enters your password
        passBox.submit();//submits
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Ipad");//enters ipad into search box
        searchBox.submit();//submits
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='result_0']/div/div[1]/div/div/a/img")));//waits until first element is seen


        System.out.println(driver.getTitle());//gets title of current page


    }
}
