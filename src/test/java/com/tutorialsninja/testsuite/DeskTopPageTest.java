package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DeskTopPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeskTopPageTest extends BaseTest {

    DeskTopPage deskTopPage = new DeskTopPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        deskTopPage.clickOnDesktop();
        deskTopPage.clickOnShowAllDesktops();
        deskTopPage.getAllProductsNameAndFilterProductByZtoA();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() {
        deskTopPage.selectCurrencyTab();
        deskTopPage.changeCurrencyToSterling();
        deskTopPage.clickOnDesktop();
        deskTopPage.clickOnShowAllDesktops();
        deskTopPage.arrangeProductAtoZ();
        deskTopPage.selectProductHPLP3065();
        Assert.assertEquals(deskTopPage.verifyTextHPLP3065(), "HP LP3065", "HP LP3065 Product not display");
        deskTopPage.selectDeliveryDate();
        //delete qty from qty tab
        WebElement qty = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]"));
        qty.sendKeys(Keys.CONTROL + "a");
        qty.sendKeys(Keys.DELETE);
        deskTopPage.enterQuantity("1");
        deskTopPage.addToCart();
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals(deskTopPage.shoppingCartMessage(), expectedMessage, "Product not added to cart");
        deskTopPage.clickOnShoppingCart();
        Assert.assertTrue(deskTopPage.verifyShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(deskTopPage.verifyProductNameHPLP3065(), "HP LP3065", "Product name not matched");
        Assert.assertEquals("Delivery Date: 2022-11-30", deskTopPage.verifyDeliveryDate(), "Delivery date not matched");
        Assert.assertEquals(deskTopPage.verifyProductModel(), "Product 21", "Model not matched");
        Assert.assertEquals(deskTopPage.verifyTotal(), "£74.73", "Total not matched");


    }


}
