package com.internshala;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    private WebDriver driver;
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String searchQuery) {
        driver.findElement(searchBox).sendKeys(searchQuery);
        driver.findElement(searchButton).click();
    }
    
}
