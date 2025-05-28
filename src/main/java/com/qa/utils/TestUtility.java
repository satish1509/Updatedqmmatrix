package com.qa.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.qa.timeUnits.TimeUnits;

public class TestUtility {

    private static Faker faker = new Faker(); 
    static String randomPassword;
    public static String generatedFirstName;
// static class-level variable to hold the password
// single shared Faker instance

    // Existing utility methods (openPage, clickElement, etc.)
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

    public static void fileupload(String filepath) throws Exception {
        Robot rb = new Robot();

        StringSelection str = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    // --- New Faker-based methods ---

    // Enter random first name into given WebElement
    public static void enterRandomFirstName(WebElement element) {
          generatedFirstName = faker.name().firstName();
        
        element.sendKeys(generatedFirstName);
        System.out.println("Entered Random First Name: " + generatedFirstName);
    }


    // Enter random last name into given WebElement
    public static void enterRandomLastname(WebElement element) {
        String lastName = faker.name().lastName();
        element.sendKeys(lastName);
        System.out.println("Entered Random Last Name: " + lastName);
    }
    public static void printIfDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Text: " + element.getText());
        } else {
            System.out.println("Element not displayed.");
        }
    }
        public static void enterRandomUsername(WebElement element) {
            String username = faker.name().username();  // generate random username
            element.sendKeys(username);
            System.out.println("Entered Random Username: " + username);
        }
    
        public static void enterRandomPassword(WebElement element) {
            // Ensures at least 1 upper, 1 lower, 1 digit, 1 special, plus 4–8 more mixed characters
            randomPassword = Faker.instance().regexify("[A-Z]{1}[a-z]{1}[0-9]{1}[!@#$%^&*]{1}[A-Za-z0-9!@#$%^&*]{7,8}");
            element.sendKeys(randomPassword);
            System.out.println("Entered Random Password: " + randomPassword);
        }
       
       

	

		public static String getRandomPassword() {
			// TODO Auto-generated method stub
			return randomPassword;
	
		
		
		}
		
		// Method to select an option by visible text
		public static void selectByVisibleText(WebElement dropdown, String visibleText) {
			Select select = new Select(dropdown);
			select.selectByVisibleText(visibleText);
		}

		// Method to select an option by value attribute
		public static void selectByValue(WebElement dropdown, String value) {
			Select select = new Select(dropdown);
			select.selectByValue(value);
		}

		// Method to select an option by index
		public static void selectByIndex(WebElement dropdown, int index) {
			Select select = new Select(dropdown);
			select.selectByIndex(index);
		}

		// Method to get the selected option text
		public static String getSelectedOptionText(WebElement dropdown) {
			Select select = new Select(dropdown);
			WebElement selectedOption = select.getFirstSelectedOption();
			return selectedOption.getText();
		}

		// Method to get all options from the dropdown
		public static java.util.List<WebElement> getAllOptions(WebElement dropdown) {
			Select select = new Select(dropdown);
			return select.getOptions();
		}

		// Method to check if a specific option is present in the dropdown
		public static boolean isOptionPresent(WebElement dropdown, String optionText) {
			for (WebElement option : getAllOptions(dropdown)) {
				if (option.getText().equals(optionText)) {
					return true;
				}
			}
			return false;
		}
		
		/**Count DropDown Options */
		public static int countDropdownOptions(WebElement dropdown) {
	        // Initialize a Select object with the dropdown WebElement
	        Select select = new Select(dropdown);

	        // Get the list of options from the Select object
	        java.util.List<WebElement> options = select.getOptions();

	        // Return the count of options
	        return options.size();
	    }

		// Method to wait until an element is clickable
	    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    // Method to wait until an element is visible
	    public static void waitForElementToBeVisible(WebDriver driver, By selector, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	    }

	    // Method to wait until a specific text is present in an element
	    public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	    }

	    // Method to wait until an element is present in the DOM
	    public static void waitForElementToBePresent(WebDriver driver, By selector, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
	    }

	    // Method to wait until a custom condition is met (you can pass your own ExpectedCondition)
	    public static void waitForCustomCondition(WebDriver driver, ExpectedCondition<Boolean> condition, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(condition);
	    }
	    
	    public static WebElement waitForWebElement(WebDriver driver, WebElement element, int timeOut) {
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }	
	 // Execute JavaScript code
	    public static void executeJavaScript(WebDriver driver, String script) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(script);
	    }

	    // Execute JavaScript code with arguments
	    public static void executeJavaScript(WebDriver driver, String script, Object args) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(script, args);
	    }

	    // Scroll to the top of the page
	    public static void scrollToTop(WebDriver driver) {
	        executeJavaScript(driver, "window.scrollTo(0, 0)");
	    }

	    // Scroll to the bottom of the page
	    public static void scrollToBottom(WebDriver driver) {
	        executeJavaScript(driver, "window.scrollTo(0, document.body.scrollHeight)");
	    }

	    // Highlight an element using JavaScript and after few seconds change it again to normal Position
	    public static void highlightElement(WebDriver driver, WebElement element) {
	        executeJavaScript(driver, "arguments[0].style.border='3px solid red'", element);
	        waitForSeconds(driver, TimeUnits.KEEP_HIGHLIGHTED);
	     //   executeJavaScript(driver, "arguments[0].style.border=''", element);
	    }

	    // Get the page title using JavaScript
	    public static String getPageTitle(WebDriver driver) {
	       JavascriptExecutor js=(JavascriptExecutor)driver;
	        return (String)js.executeScript("return document.title;");
	    }

	    // Wait for a specific duration using JavaScript
	    public static void waitForSeconds(WebDriver driver, int seconds) {
	        executeJavaScript(driver, "var date = new Date(); var start = date.getTime(); " +
	                "var end = start; while(end < start + " + (seconds * 1000) + ") {end = new Date().getTime();}");
	    }
	    // click on WebElement using javaScript Executor
	    public static void clickWithJavaScript(WebDriver driver, WebElement element) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", element);
	    }
	    
	    //get Text
	    public static String getInputText(WebDriver driver, WebElement inputElement) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        // Execute JavaScript to get the value of the input element
	        return (String) js.executeScript("return arguments[0].value", inputElement);
	    }
	}
		









    // You can add more faker helpers here, e.g. email, phone, etc.

