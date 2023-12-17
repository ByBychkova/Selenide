
package ru.netology.javaqa.card;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ARROW_RIGHT;

public class DZ2 {
    @Test
    void dropDownList() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Мо");
        $$(" .menu-item__control").findBy(Condition.text("Москва")).click();
        $("[data-test-id='date'] input").click();
        int days = 4;
        for (int cycle = 0; cycle < days; cycle++) {
            $(" .calendar").sendKeys(Keys.ARROW_RIGHT);
        }
        $(" .calendar").sendKeys(Keys.ENTER);
        $("[data-test-id='name'] input").setValue("Бычкова Мария");
        $("[data-test-id='phone'] input").setValue("+79100341186");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        String verefecationDate = LocalDate.now().plusDays(7)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='notification']")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + verefecationDate),
                        Duration.ofSeconds(15));
    }
}

