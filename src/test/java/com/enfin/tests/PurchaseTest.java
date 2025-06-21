package com.enfin.tests;

import com.enfin.pages.*;
import com.enfin.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void testProductPurchaseFlow() {
        String username = "user" + System.currentTimeMillis();
        String password = "Test@123";
        String productName = "Samsung galaxy s6";

        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.signUp(username, password);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, password);

        HomePage homePage = new HomePage(getDriver());
        homePage.openProduct(productName);

        ProductPage productPage = new ProductPage(getDriver());
        productPage.addToCart();

        homePage.goToCart();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Product not found in cart!");

        cartPage.clickPlaceOrder();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.fillForm("John Doe", "USA", "NY", "1234123412341234", "12", "2028");
        checkoutPage.purchase();
        Assert.assertTrue(checkoutPage.isSuccess(), "Purchase confirmation not displayed!");
    }
}
