package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SenEmail {
    public WebDriver driver;
    public SenEmail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div[1]/nav/div[2]/div/div/div/a") // кнопка написать
    private WebElement btnWrite;

    @FindBy(id = "compose-field-1") // кому
    private WebElement sendAvtor;
    @FindBy(xpath = "//*[@id=\"compose-field-subject-4\"]") // тема
    private WebElement themeWrite;
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div") // текст сообщения
    private WebElement messageText;
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button") // кнопка отправить
    private WebElement btnSend;

    public void sendEmail(String recipient, String theme, String message) {

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.urlContains("https://id.yandex.ru/"));

        driver.get("https://mail.yandex.ru/?uid=1024782275#tabs/relevant");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnWrite.click();
        sendAvtor.sendKeys(recipient);
        themeWrite.sendKeys(theme);
        messageText.sendKeys(message);
        btnSend.click();
    }
}
