package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("пользователь на странице логина")
    public void openLoginPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @When("он вводит {string} и {string}")
    public void enterCredentials(String name, String password){
        loginPage.login(name, password);

    }

    @Then("он видит страницу с товарами")
    public void verifyProductsPage(){
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

    @Then("он видит сообщение об ошибке")
    public void verifyErrorMessage(){
        String error = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Username and password do not match any user in this service", error);

    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


