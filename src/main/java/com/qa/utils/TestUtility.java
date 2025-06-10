package com.qa.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class TestUtility {
    private static WebDriver driver;

    private static Faker faker = new Faker();
    private static String randomPassword;
    public static String generatedFirstName;
    static ConfigReader config = new ConfigReader();
    public static String lastGeneratedUsername;


    // Open a URL
    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static WebElement findElement(WebDriver driver, By selector) {
        return driver.findElement(selector);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void enterTextWithBy(WebDriver driver, By ele, String text) {
        driver.findElement(ele).sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    // File upload using Robot class
    public static void fileupload(String filepath) throws Exception {
    	
             Thread.sleep(4000);
        // Copy path to clipboard
        StringSelection str = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // Create Robot instance
        Robot rb = new Robot();

        // Simulate CTRL+V
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        // Wait a bit before pressing Enter
        Thread.sleep(1000);

        // Press Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    // Enter random first name
    public static void enterRandomFirstName(WebElement element) {
        generatedFirstName = faker.name().firstName();
        element.sendKeys(generatedFirstName);
        System.out.println("Entered Random First Name: " + generatedFirstName);
    }

    // Enter random last name
    public static void enterRandomLastName(WebElement element) {
        String lastName = faker.name().lastName();
        element.sendKeys(lastName);
        System.out.println("Entered Random Last Name: " + lastName);
    }

    // Print text if displayed
    public static void printIfDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Text: " + element.getText());
        } else {
            System.out.println("Element not displayed.");
        }
    }

    public static String enterUsername(WebElement element) {
        lastGeneratedUsername = faker.name().username();  // generate username
        element.sendKeys(lastGeneratedUsername);           // enter in input field
        config.writeConfig("lastGeneratedUsername", lastGeneratedUsername);  // save to config file
        return lastGeneratedUsername;                       // return username if needed
    }
    public static String getLastGeneratedUsername() {
        return lastGeneratedUsername;
    }
    // Enter random password matching regex pattern
    public static void enterRandomPassword(WebElement element) {
        randomPassword = Faker.instance().regexify("[A-Z]{1}[a-z]{1}[0-9]{1}[!@#$%^&*]{1}[A-Za-z0-9!@#$%^&*]{7,8}");
        element.sendKeys(randomPassword);
        System.out.println("Entered Random Password: " + randomPassword);
    }
    
    public static void enterRandomMobileNumber(WebElement element) {
        // Generate a random 10-digit number starting with 9, 8, or 7
        String randomMobileNumber = Faker.instance().regexify("[987]{1}[0-9]{9}");
        element.sendKeys(randomMobileNumber);
        System.out.println("Entered Random Mobile Number: " + randomMobileNumber);
    }


    // Return last generated password (if needed)
    public static String getRandomPassword() {
        return randomPassword;
    }

    // Select dropdown option by visible text
    public static void selectByVisibleText(WebElement dropdown, String visibleText) {
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    // Select dropdown option by value
    public static void selectByValue(WebElement dropdown, String value) {
        new Select(dropdown).selectByValue(value);
    }

    // Select dropdown option by index
    public static void selectByIndex(WebElement dropdown, int index) {
        new Select(dropdown).selectByIndex(index);
    }

    // Get selected option text from dropdown
    public static String getSelectedOptionText(WebElement dropdown) {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

    // Get all options from dropdown
    public static List<WebElement> getAllOptions(WebElement dropdown) {
        return new Select(dropdown).getOptions();
    }

    // Check if option present in dropdown
    public static boolean isOptionPresent(WebElement dropdown, String optionText) {
        for (WebElement option : getAllOptions(dropdown)) {
            if (option.getText().equals(optionText)) {
                return true;
            }
        }
		return false;
    }
   
}

    // Count dropdown option
