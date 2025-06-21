package com.enfin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By productRow = By.xpath("//tbody/tr[1]/td[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductDisplayed(String productName) {
        return driver.findElement(productRow).getText().equals(productName);
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}
