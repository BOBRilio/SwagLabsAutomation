Feature: Логин на Swag Labs

  Scenario: Успешный вход
    Given пользователь на странице логина
    When он вводит "standard_user" и "secret_sauce"
    Then он видит страницу с товарами

  Scenario: Неудачный вход
    Given пользователь на странице логина
    When он вводит "wrong_user" и "wrong_pass"
    Then он видит сообщение об ошибке

