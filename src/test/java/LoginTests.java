import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test

    public static void LoginEmptyEmailPasswordTest() throws InterruptedException {
        // Simple comment
        public static void LoginEmptyEmailPasswordTest () {

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://apps.testpro.io/";
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

        @Test
        public static void LoginInvalidEmail () {
            //Login Not Existing Email:
            //Precondition: Chrome browser should be opened DONE
            // declare driver
            //Step1. Open koel login page DONE
            // tell driver to load koel page
            //Step2. Enter Not Existing email
            // find email field
            // click into email field
            // enter invalid email inside email field
            //Step3. Enter Correct password
            // find password field
            // click into password field
            // enter anything
            //Step4. Click Login button
            // find the login button
            // click the login button
            //Expected result: User should stay on login page
            // assert the present of email field

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            //Step2. Enter Not Existing email
            // find email field
            // click into email field
            // enter invalid email inside email field
            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("cucaracha@class.com");

            //Step3. Enter Correct password
            // find password field
            // click into password field
            // enter anything
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("ayCaramba");

            //Step4. Click Login button
            // find the login button
            // click the login button
            WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
            loginButton.click();

            //Expected result: User should stay on login page
            // assert the present of email field
            Assert.assertTrue(emailField.isDisplayed());
            driver.quit();
        }

        @Test
        public static void LoginValidEmailPasswordTest () {
            // Precondition: Chrome browser should be opened DONE
            //Step1. Open koel login page DONE
            //Step2. Enter Existing username
            //Step3. Enter Correct password
            //Step4. Click Login button
            //Expected result: User should be directed to the home page
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

            //Step3. Enter Correct password
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            //Step4. Click Login button
            WebElement loginField = driver.findElement(By.cssSelector("[type='submit'"));
            loginField.click();

            //Expected result: User should be directed to the home page
            WebElement avatar = driver.findElement(By.className("avatar"));
            Assert.assertTrue(avatar.isDisplayed());

            driver.quit();
        }
    }
}


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        setupClass();
        launchBrowser();
        navigateToPage();
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmit();

        createPlaylist();
        searchKeyWord("dark");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        messageDisplay();
        Assert.assertTrue(messageDisplay().contains("Added 1 song into"));

    }


    public void createPlaylist() throws InterruptedException {
        WebElement newPlaylistName = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        newPlaylistName.click();
        WebElement clickPlusButton = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickPlusButton.click();
        WebElement typeNewName = driver.findElement(By.cssSelector("[name='name']"));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);
        Thread.sleep(2000);

    }

    public void searchKeyWord(String songKeyWord) throws InterruptedException {
        //search for a song
        WebElement newQuery = driver.findElement(By.cssSelector("input[type='search']"));
        newQuery.click();
        newQuery.clear();
        newQuery.sendKeys(songKeyWord);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        // Click View All to display the search results
        WebElement viewAllBtn = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllBtn.click();
        Thread.sleep(2000);
    }
    public void selectFirstSong() throws InterruptedException {
        //Click the first song in the search results
        driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//tr[@class='song-item']//td[@class='title']")).click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        // Click ADD TO...
        driver.findElement(By.className("btn-add-to")).click();
        Thread.sleep(1000);

    }
    public void choosePlaylist() throws InterruptedException {
        //Choose the playlist to add it to (create a new playlist)
        WebElement playlistClickInMenu = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestNewPlaylist')]"));
        playlistClickInMenu.click();
        Thread.sleep(2000);
    }
    // Verify that the notification appears
    public String messageDisplay() throws InterruptedException {
        WebElement notificationRightTop = driver.findElement(By.cssSelector("div.success.show"));
        return notificationRightTop.getText();
    }}