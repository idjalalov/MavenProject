package com.amazon;

import baseAPI.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Createyd by idjalalov on 9/2/2015.
 */
public class AmazonHome1 extends Base {
    @Test
    public void openUP() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        search.sendKeys("laser printer");
        search.submit();


        List<WebElement> allTitles = driver.findElements(By.cssSelector(".a-size-base.a-color-null.s-inline.s-access-title.a-text-normal"));
        List<WebElement> allSalePrices = driver.findElements(By.cssSelector(".a-size-base.a-color-price.s-price.a-text-bold"));
        //List<WebElement> allOriginalPrices = driver.findElements(By.cssSelector(".a-size-small.a-color-secondary.a-text-strike"));


        System.out.println(allTitles.size());
        System.out.println(allSalePrices.size());
        //System.out.println(allOriginalPrices.size());

        String [][] str = new String[allTitles.size()-1][2];


        for (int i=0; i < allTitles.size()-2; i++){
            str[i][0]=allTitles.get(i).getText();
            str[i][1]=allSalePrices.get(i).getText();
            //str[i][2]=allOriginalPrices.get(i).getText();
        }
        for (int k=0; k < allTitles.size()-2; k++){
            System.out.println(str[k][0]+"-----"+str[k][1]);
        }

            //Delimiter used in CSV file
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";

        //CSV file header
        String FILE_HEADER = "NameOfThePrinter,SalePrice";

        String fileName = "C:\\Users\\idjalalov\\Desktop\\Test.csv";

        FileWriter fileWriter = null;

        try {
           fileWriter = new FileWriter(fileName);

             //Write the CSV file header
           fileWriter.append(FILE_HEADER.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);

                //Write a new student object list to the CSV file
                for (int i=0; i<allSalePrices.size()-2; i++) {
                    fileWriter.append('"');
                    fileWriter.append(str[i][0]);
                    fileWriter.append('"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(str[i][1]);
                    //fileWriter.append(COMMA_DELIMITER);
                    //fileWriter.append('"');
                    //fileWriter.append(str[i][2]);
                    //fileWriter.append('"');
                    //fileWriter.append(COMMA_DELIMITER);
                    //fileWriter.append("=(1-B"+(i+2)+"/"+"C"+(i+2)+")*100");
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }

                System.out.println("CSV file was created successfully !!!");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }
            }
        }
}
