package web.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class add_photo {
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/misha/Загрузки/chromedriver");
        Configuration.browser = "chrome";
        open("https://unsplash.com");
    }
    @Test
    public void userLogin() {
        $(By.linkText("Login")).click();
        SelenideElement user_email = $(By.id("user_email")).setValue("zb2507194@mvrht.net");
        $(By.id("user_password")).setValue("tralivali");
        $(By.xpath("//input[@value='Login'and @type='submit']")).click();
        $(By.linkText("Submit a photo")).click();
        $(By.linkText("Add a photo")).click();

        File file = new File("/home/misha/Загрузки/proverka_tcveta.jpg"); //("/home/misha/UnsplashTest/src/prverka_tcveta.jpg");
        $("#file").uploadFile(file);

        $$(By.xpath("//input[@class='ui-autocomplete-input']")).shouldHave(size(1));
        $(By.xpath("//input[@class='ui-autocomplete-input']")).setValue("piz,de,ts,");

        $$(By.xpath("//input[@value='Next'and @type='submit']")).shouldHave(size(1));
        $(By.xpath("//input[@value='Next'and @type='submit']")).click();
        $$(By.xpath("//input[@value='Next'and @type='submit']")).shouldHave(size(1));
        $(By.xpath("//input[@value='Next'and @type='submit']")).click();

        $(By.xpath("//input[@name='story_attributes[title]'and @type='text']")).setValue("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        $(By.name("story_attributes[description]")).setValue("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        $$(By.xpath("//input[@value='Next'and @type='submit']")).shouldHave(size(1));
        $(By.xpath("//input[@value='Next'and @type='submit']")).click();

        $(By.xpath("//input[@type='checkbox'and @name='photo_location_attributes[confidential]']")).click();

        $$(By.xpath("//input[@type='submit'and @value='Submit']")).shouldHave(size(1));
        $(By.xpath("//input[@type='submit'and @value='Submit']")).click();
        $(By.cssSelector("h1[class='alpha text-center text-sans text-weight--bold']")).
                shouldBe(text("Thank you"));

        $(By.cssSelector("a[href='/@mv1']")).click();
        $(By.cssSelector("div._27nWV:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)")).
                shouldBe(visible);
    }
}
