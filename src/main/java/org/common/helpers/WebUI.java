package org.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebUI {

    private WebDriver driver;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    public void setText (By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement (By element) {
        driver.findElement(element).click();
    }

    public boolean verifyUrl (String url) {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        return driver.getCurrentUrl().contains(url);
    }

    public boolean verifyElementText(By headerPageText,String pageText) {
        return driver.findElement(headerPageText).getText().equals(pageText);
    }

    public void scrollUp (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollDown (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }



}
