package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("JSONPlaceholder API")
@Feature("Пользователи")

public class ApiTest {
    @Test
    @Description("Проверяем данные пользователя с id=1")
    @Severity(SeverityLevel.NORMAL)
    public void apiTest(){
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                  .get("/users/1")
                .then()
                  .statusCode(200)
                 .body("name", equalTo("Leanne Graham"))
                 .body("email", equalTo("Sincere@april.biz"))
                 .body("username", equalTo("Bret"));
    }
}
