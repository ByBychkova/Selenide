package ru.netology.javaqa.card;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;

class PozitivTest {
    private String generateDate(int addDays, String pattern){
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }
@Test

    void ifTheRegistrationDataIsCorrect(){

    open("http://localhost:9999");
    //$(".menu-item__control").setValue("Москва");
    $("['data-test-id='city']input").setValue("Москва");
    String planingDate = generateDate(3,"dd.MM.yyyy");
    $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
    $("[data-test-id='date'] input").setValue(planingDate);
    $("[data-test-id='name']input").setValue("Бычкова Мария");
    $("[data-test-id='phone']input").setValue("+79100341186");
    $("[data-test-id='agreement']checkbox").click();
    $("button.button").click();
   // $$(".input_type_tel").click;



    }



}