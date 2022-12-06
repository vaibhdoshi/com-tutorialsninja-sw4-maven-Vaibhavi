package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopandNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopAndNotebooksPageTest extends BaseTest {

    LaptopandNotebooksPage laptopandNotebooksPage = new LaptopandNotebooksPage();


    @Test

    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopandNotebooksPage.clickOnLaptop();
        laptopandNotebooksPage.clickOnShowAllLaptopsAndNoteBooks();
        laptopandNotebooksPage.selectSortByPriceHighToLow();
        //Assert.assertEquals("originalProductPrice", "afterSortByPrice", "Product not sorted by price High to Low");


    }


    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        laptopandNotebooksPage.selectCurrencyTab();
        laptopandNotebooksPage.changeCurrencyToSterling();
        laptopandNotebooksPage.clickOnLaptop();
        laptopandNotebooksPage.clickOnShowAllLaptopsAndNoteBooks();
        laptopandNotebooksPage.selectSortByPriceHighToLow();
        laptopandNotebooksPage.selectProductMacBook();
        Assert.assertEquals(laptopandNotebooksPage.verifyTextMacBook(), "MacBook", "MacBook Product not display");
        laptopandNotebooksPage.clickOnAddToCart();
        Assert.assertTrue(laptopandNotebooksPage.shoppingCartMessage().contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        laptopandNotebooksPage.clickOnShoppingCart();
        Assert.assertTrue(laptopandNotebooksPage.verifyShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(laptopandNotebooksPage.verifyProductNameMacBook(), "MacBook", "Product name not matched");
        //clearing qty
        WebElement qty = driver.findElement(By.cssSelector("input[value='1']"));
        qty.clear();
        laptopandNotebooksPage.enterQuantity("2");
        laptopandNotebooksPage.clickOnUpdateTab();
        Assert.assertTrue(laptopandNotebooksPage.modifyShoppingCartMessage().contains("Success: You have modified your shopping cart!"), "Cart not modified");
        Assert.assertEquals(laptopandNotebooksPage.verifyTotal(), "£737.45", "Total not matched");
        laptopandNotebooksPage.clickOnCheckout();
        Assert.assertEquals(laptopandNotebooksPage.verifyCheckoutText(), "Checkout", "not check out");
        Assert.assertEquals(laptopandNotebooksPage.verifyNewCustomer(),"New Customer","correct customer");
        laptopandNotebooksPage.clickOnGuestCheckOut();
        laptopandNotebooksPage.clickOnContinueButton();
        laptopandNotebooksPage.enterFirstName("Vaibhavi");
        laptopandNotebooksPage.enterLastName("Doshi");
        laptopandNotebooksPage.enterEmail("test123@gmail.com");
        laptopandNotebooksPage.enterTelephone("12345678977");
        laptopandNotebooksPage.enterAddress1("123,camerose avenue");
        laptopandNotebooksPage.enterCity("London");
        laptopandNotebooksPage.enterPostcode("HA11AF");
        laptopandNotebooksPage.selectCountry();
        laptopandNotebooksPage.selectRegion();
        laptopandNotebooksPage.clickOnContinue();
        laptopandNotebooksPage.addComments("Hello,Please leave my order near the door");
        laptopandNotebooksPage.clickonTermsAndConditions();
        laptopandNotebooksPage.clickOnContinueTab();
        Assert.assertEquals(laptopandNotebooksPage.paymentWarningMessage(),"Warning: Payment method required!\n" + "×");






    }


}
