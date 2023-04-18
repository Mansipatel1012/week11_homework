package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        WebElement Registerlink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        Registerlink.click();
        String expectedMessage = "Register";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page registration-page']/div/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        WebElement Registerlink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        Registerlink.click();
        // Select gender radio button
        WebElement genderButton = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        genderButton.click();
        // Enter First name
        WebElement firstname = driver.findElement(By.id("FirstName"));
        firstname.sendKeys("Ram");
        // Enter Last name
        WebElement lastname = driver.findElement((By.id("LastName")));
        lastname.sendKeys("sita");
        //  Select Day from dropdown
        WebElement dateOfBirth = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='1']"));
        dateOfBirth.click();
        // Select Month from dropdown
        WebElement month = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='March']"));
        month.click();
        // select year from dropdown
        WebElement year = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='1991']"));
        year.click();
        //Enter email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("Ram" + randomInt + "Sita@gmail.com");// creating random email generator
        // Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Ram123");
        // Enter confirm Password
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("Ram123");
        //  Click on REGISTER button
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }

}
