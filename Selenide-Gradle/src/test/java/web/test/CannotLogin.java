package web.test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CannotLogin {
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/misha/Загрузки/chromedriver");
        Configuration.browser = "chrome";
        open("https://unsplash.com");
    }

    @Test
    public void errorwithlogin(){
        $(By.linkText("Login")).click();
        $(By.id("user_email")).setValue("chernov_math@mail.ru");
        $(By.id("user_password")).setValue("urauraura");
        $(By.xpath("//input[@value='Login'and @type='submit']")).click();
        $(By.xpath("//div[@class='col-xs-10 col-sm-6 center-block flash__message']")).
                shouldHave(text("Invalid email or password."));
    }
}
