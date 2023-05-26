package com.neotech.cucumber.testbase;

import com.neotech.cucumber.utils.ConfigsReader;
import com.neotech.cucumber.utils.Driver;
import org.openqa.selenium.WebDriver;


public class BaseClass { protected static WebDriver driver;


    public static void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigsReader.getProperties("url"));
    }

    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}


