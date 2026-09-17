package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("Swag Labs")
@Feature("Логин")
public class FirstTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {

        // WebDriverManager сам скачает нужный chromedriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @Description("Проверяем, что пользователь standard_user может войти")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void successfullLogin(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    }
    @Test
    public void invalidLogin(){
        loginPage.login("wrong_user","wrong_pass");
        String error = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Username and password do not match any user in this service", error);


    }
    @Description("Проверяем, что пользователь wrong_user не может войти")
    @Severity(SeverityLevel.NORMAL)
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
