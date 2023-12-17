package ru.netology.javaqa.card;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;

class PozitivTest {
    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void ifTheRegistrationDataIsCorrect() {

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        String planingDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planingDate);
        $("[data-test-id='name'] input").setValue("Бычкова Мария");
        $("[data-test-id='phone'] input").setValue("+79100341186");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(Selectors.withText("Успешно!")).shouldBe(exist, Duration.ofSeconds(15));
        $(" .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planingDate),
                Duration.ofSeconds(15));
    }


}