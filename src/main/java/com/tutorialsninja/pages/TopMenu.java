package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenu extends Utility {
    By desktop = By.linkText("Desktops");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By lapTops = By.linkText("Laptops & Notebooks");
    By laptopandNotebookText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.linkText("Components");
    By componentText = By.xpath("//h2[contains(text(),'Components')]");


    public void selectMenu(String menu) {
        //This method should click on the menu
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }


    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktop);

    }



    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    public void clickOnLaptop() {
        mouseHoverToElementAndClick(lapTops);
    }

    public String getLaptopandNotebookText() {
        return getTextFromElement(laptopandNotebookText);
    }

    public void clickOnComponents() {
        mouseHoverToElementAndClick(components);
    }

    public String getComponentText() {
        return getTextFromElement(componentText);
    }
}
