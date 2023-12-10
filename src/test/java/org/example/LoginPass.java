package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPass {
    public WebDriver driver;

    public LoginPass(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div/form/div/div[2]/div[1]/div[1]/button")
    private WebElement emailField; // кнопка почта
    @FindBy(id = "passp-field-login")
    private WebElement loginField; // логин

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField; //пароль

    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;

    public void inputLogin(String name) {
        loginField.sendKeys(name);
    }
    public void inputPassword(String password) {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void setEmailField() {
        emailField.click();
    }

}
