package com.amazon;

import baseAPI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.*;

/**
 * Created by idjalalov on 8/26/2015.
 */
public class AmazonHome extends Base {

    @Test

    public void makeSearchList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        search.sendKeys("photo printer");
        search.submit();

        // Creat a list of Webelements from Titles
        List<WebElement> allTitles = driver.findElements(By.cssSelector(".a-size-medium.a-color-null.s-inline.s-access-title.a-text-normal"));
        String[] titlesText = new String[allTitles.size()];
        for (WebElement eachTitle : allTitles) {
            for (int j = 0; j <(allTitles.size()-1); j++) {
                titlesText[j] = eachTitle.getText();
            }
        }

        // Creat a list of Webelements from Prices
        List<WebElement> allPrices = driver.findElements(By.cssSelector(".a-size-base.a-color-price.s-price.a-text-bold"));
        String[] prices = new String[allPrices.size()];
        for (WebElement eachPrice : allPrices) {
            for (int k = 0; k < (allPrices.size()-1); k++) {
                titlesText[k] = eachPrice.getText();
                System.out.println(titlesText[k]);
            }
        }


        SearchList[] mySearch = new SearchList[allTitles.size()];

        for (int i = 0; i < (allTitles.size()-1); i++) {
            mySearch[i] = new SearchList(titlesText[i], prices[i]);
        }

    }




}



