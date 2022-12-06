package com.tutorialsninja.testsuite;


import com.tutorialsninja.pages.TopMenu;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TopMenuTest extends BaseTest {

    TopMenu topMenu = new TopMenu();



    @Test
    public void userShouldNavigateToDesktopPageSucessfully() {
        topMenu.clickOnDesktop();
        topMenu.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        Assert.assertEquals(topMenu.getDesktopText(), expectedText, "Not navigate to Desktop page");


    }

    @Test
    public void userShouldNavigateToLaptopsAndNotebooksPageSucessfully() {
        topMenu.clickOnLaptop();
        topMenu.selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(topMenu.getLaptopandNotebookText(), expectedText, "Not navigate to Laptops and Notebooks page");

    }

    @Test
    public void userShouldNavigateToComponentsPageSucessfully() {
        topMenu.clickOnComponents();
        topMenu.selectMenu("Show All Components");
        String expectedText = "Components";
        Assert.assertEquals(topMenu.getComponentText(), expectedText, "Not navigate to Components page");


    }


}