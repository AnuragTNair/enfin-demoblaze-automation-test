package com.enfin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By cartLink = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
