package web.test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class login {
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/misha/Загрузки/chromedriver");
        Configuration.browser = "chrome";
        open("https://unsplash.com");
    }

    @Test
    public void userLogin() {
        $(By.linkText("Login")).click();
        $(By.id("user_email")).setValue("zb2507194@mvrht.net");
        $(By.id("user_password")).setValue("tralivali");
        $(By.xpath("//input[@value='Login'and @type='submit']")).click();
        $(By.cssSelector("div.ODWzM:nth-child(3) > a:nth-child(1)")).shouldBe(visible);
    }
}
