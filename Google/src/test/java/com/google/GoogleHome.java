package com.google;

import baseAPI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 8/26/2015.
 */
public class GoogleHome extends Base {
    @Test
    public void makeSearchList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("photo printer");
        search.submit();


        List<WebElement> allSearchResults = driver.findElements(By.cssSelector(".r>a"));

        //iterate the above list to get all the search titles & links from that page
        for (WebElement eachResult : allSearchResults) {
            System.out.println("Title : " + eachResult.getText() + ", Link : " + eachResult.getAttribute("href"));
        }
    }
}