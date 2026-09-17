package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Логин с именем {name} и паролем {password}")
    public void login(String name, String password){
        driver.findElement(usernameField).sendKeys(name);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }
    @Step("Получение текста ошибки: {result}")
    public String getErrorMessage(){
        String result = driver.findElement(errorMessage).getText();
        return result;
    }

}
