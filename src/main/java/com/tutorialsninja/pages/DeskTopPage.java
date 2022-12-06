package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopPage extends Utility {
    By desktop = By.linkText("Desktops");
    By showAllDesktops = By.linkText("Show All Desktops");
    By products = By.xpath("//h4/a");
    By sortBy = By.id("input-sort");
    By currencyTab = By.xpath("//span[contains(text(),'Currency')]");
    By currencyList1 = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By HPLP3065product = By.xpath("//a[contains(text(),'HP LP3065')]");
    By HPLP3065productText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By quantity = By.name("quantity");
    By cartButton = By.xpath("//button[@id='button-cart']");
    By shoppingCartMsg = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingcartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By getShoppingCartMsg = By.xpath("//div[@id='content']//h1");
    By HPLP3065verification = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By modelProduct21 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By total = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]");


    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktop);

    }

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDesktops);
    }

    public void getAllProductsNameAndFilterProductByZtoA() {
        List<WebElement> products1 = driver.findElements(products);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products1) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products1 = driver.findElements(products);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products1) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //originalProductsName, afterSortByZToAProductsName);


    }

    public void selectCurrencyTab() {
        clickOnElement(currencyTab);
    }

    public void changeCurrencyToSterling() {
        List<WebElement> currencyList = driver.findElements(currencyList1);
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void arrangeProductAtoZ() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.sort(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals(originalProductsName, afterSortByZToAProductsName,"Product not sorted into Z to A order");


    }

    public void selectProductHPLP3065() {
        clickOnElement(HPLP3065product);
    }

    public String verifyTextHPLP3065() {

        return getTextFromElement(HPLP3065productText);

    }

    public void selectDeliveryDate() {
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {

                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
                break;
            } else
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
        }

        //Select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']//td"));
        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equalsIgnoreCase(date)) {
                ele.click();
                break;


            }

        }


    }


    public void enterQuantity(String qty) {
        sendTextToElement(quantity, qty);
    }

    public void addToCart() {
        clickOnElement(cartButton);
    }

    public String shoppingCartMessage() {
        return getTextFromElement(shoppingCartMsg);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingcartLink);
    }

    public String verifyShoppingCartText() {
        return getTextFromElement(getShoppingCartMsg);
    }

    public String verifyProductNameHPLP3065() {
        return getTextFromElement(HPLP3065verification);
    }

    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDateText);
    }

    public String verifyProductModel() {
        return getTextFromElement(modelProduct21);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }


}










