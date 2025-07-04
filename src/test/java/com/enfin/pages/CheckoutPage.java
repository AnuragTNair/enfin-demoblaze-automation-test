package com.enfin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By creditCardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By successMsg = By.xpath("//h2[text()='Thank you for your purchase!']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(creditCardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void purchase() {
        driver.findElement(purchaseBtn).click();
    }

    public boolean isSuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
