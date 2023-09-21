package org.example;

import io.cucumber.java.en.And;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertTrue;
import static jxl.biff.FormatRecord.logger;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("I open the Google homepage")
    public void openGoogle() {
        logger.info("Opening Google homepage");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for $term")
    public void search(String term) {
        driver.findElement(By.name("q")).sendKeys(term);
        driver.findElement(By.name("q")).submit();
    }

    @Then("the first result title contains $text")
    public void validateTitle(String text) {
        String title = driver.getTitle();
        assertTrue(title.contains(text));
    }

    @And("if it does not contain {string}")
    public void validateTitleNotContains(String text) {
        String title = driver.getTitle();
        if(!title.contains(text)) {
            throw new AssertionError("First result did not contain expected title");
        }
    }
}