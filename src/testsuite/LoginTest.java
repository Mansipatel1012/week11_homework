package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/* Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully
        * click on the ‘Login’ link
        * Verify the text ‘Welcome, Please Sign In!’
        2. userShouldLoginSuccessfullyWithValidCredentials
        * click on the ‘Login’ link
        * Enter valid username
        * Enter valid password
        * Click on ‘LOGIN’ button
        * Verify the ‘Log out’ text is display
        3. verifyTheErrorMessage
        * click on the ‘Login’ link
        * Enter invalid username
        * Enter invalid password
        * Click on Login button
        * Verify the error message ‘
‘Login was unsuccessful.
 Please correct the errors and try again. No customer account found’
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login link and click on login link
        WebElement loginLink = driver.findElement((By.linkText("Log in")));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Welcome, Please Sign In!", actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // find the Email field element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("pat_man@gmail.com");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("M123456789");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginbutton.click();
        // Verify the ‘Log out’ text is display
        String expectedMessage = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Log out", actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("prime123@gmail.com");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}