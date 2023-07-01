package com.internshala;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    
    private WebDriver driver;
    private By resultItems = By.cssSelector(".s-result-item");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFifthElement() {
        List<WebElement> items = driver.findElements(resultItems);
        if (items.size() >= 5) {
            return items.get(4);
        } else {
            throw new IllegalStateException("Less than 5 search results found.");
        }
    }
    
}
