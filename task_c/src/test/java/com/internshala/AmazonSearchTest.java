package com.internshala;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;

public class AmazonSearchTest {
    
    private WebDriver driver;
    // private HomePage homePage;
    // private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setUp() {

        // Creating a new ChromeDriver instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        // Initializing Page Objects
        // homePage = new HomePage(driver);
        // searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testSearchAndGetFifthElementName() throws InterruptedException {

        driver.get("https://amazon.in");

        // homePage.searchFor("Wrist Watches");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

        searchBox.sendKeys("Wrist Watches");
        searchButton.click();

        driver.findElement(By.xpath("//div[@id='filters']//span[@class='a-size-base a-color-base'][normalize-space()='Analogue']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Leather']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Titan']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'25% Off or more')]")).click();
        Thread.sleep(3000);

        // WebElement fifthElement = searchResultsPage.getFifthElement();
        // String fifthElementTitle = fifthElement.findElement(By.cssSelector("h2")).getText();

        // System.out.println("Title of the fifth search item: " + fifthElementTitle);
        // Assert.assertNotNull(fifthElement, "Fifth element not found.");

        List<WebElement> items = driver.findElements(By.cssSelector(".s-result-item"));
        if (items.size() >= 5) {
            WebElement fifthElement = items.get(4);
            String fifthElementTitle = fifthElement.findElement(By.cssSelector("h2")).getText();

            System.out.println("Name of the fifth item: " + fifthElementTitle);
            Assert.assertNotNull(fifthElementTitle, "Fifth item name not found.");
        } else {
            throw new IllegalStateException("Less than 5 search results found.");
        }

    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        AmazonSearchTest test = new AmazonSearchTest();
        test.setUp();
        test.testSearchAndGetFifthElementName();
        test.tearDown();
    }

}
