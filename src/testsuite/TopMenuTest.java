package testsuite;

import browserfactory.BaseTest;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        // click on the ‘Computers’ Tab
        driver.findElement(By.xpath("//a[text()='Computers ']")).click();
        // Verify the text ‘Computers’
        String expectedMessage = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
         String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
       // click on the ‘Electronics’Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]")).click();
        // Verify the text ‘Electronics’
        String expectedMessage = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfull(){
        // click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[3]")).click();
        //Verify the text ‘Apparel’
        String expectedMessage = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfull(){
        // click on the ‘digital download’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[4]")).click();
        //Verify the text ‘Digital download’
        String expectedMessage = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        // click on the ‘Books’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[5]")).click();
        //Verify the text ‘Books’
        String expectedMessage = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void  userShouldNavigateToJewelryPageSuccessfully(){
        // click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[6]")).click();
        //Verify the text ‘Jewelry’
        String expectedMessage = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfull(){
        // click on the ‘Gift Cards’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[7]")).click();
        //Verify the text ‘Gift cards’
        String expectedMessage = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}


