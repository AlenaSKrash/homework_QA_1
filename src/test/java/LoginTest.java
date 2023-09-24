import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    @Test
    void name() {
        String date= "22.03.1993";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        LocalDate dddd = LocalDate.parse(date, formatter);
        for (int i = 0; i < 10; i++) {
            dddd.getDayOfMonth();
            Assertions.assertEquals(dddd, 11);
        }
    }

    @Test
    void successfulLoginTests(){
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password").setValue("qagurupassword");
        $(".btn-success").click();
        $(".btn-success").shouldHave(text("Неверный пароль"));

    }

}
