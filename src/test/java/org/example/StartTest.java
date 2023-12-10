package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class StartTest {
    public static WebDriver driver;
    public static String urlAutth = "https://passport.yandex.ru/auth/"; // страница авторизации

    public static LoginPass loginPass;

    public static SenEmail senEmail;
    @BeforeClass
    public static void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);

        loginPass = new LoginPass(driver);
        senEmail = new SenEmail(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void TestAu() {

        driver.get(urlAutth);

        loginPass.setEmailField();
        loginPass.inputLogin("yourLogin");
        loginPass.clickLoginButton();
        loginPass.inputPassword("yourPassword!");
        loginPass.clickLoginButton();

    }

    @Test
    public void SendMail() {
        String recipient = "addressRecipient"; // Кому предназначено письмо
        String theme = "theme"; // Тема письма
        String message = "WriteMessage"; // Содержание письма
        senEmail.sendEmail(recipient, theme, message);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
