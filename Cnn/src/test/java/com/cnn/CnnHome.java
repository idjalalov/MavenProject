package com.cnn;

import baseAPI.Base;
import org.testng.annotations.Test;

/**
 * Created by idjalalov on 8/26/2015.
 */
public class CnnHome extends Base {
    @Test
    public void printHomePage(){
        System.out.println(driver.getCurrentUrl());
    }
}
