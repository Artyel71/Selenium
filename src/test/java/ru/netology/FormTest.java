package ru.netology;

import com.google.common.annotations.Beta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.files.DownloadActions.click;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormTest {

    private static WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
        //void shouldTestSomething() throws InterruptedException {
        //throw new UnsupportedOperationException();
    void shouldTestForm() {
        driver.get(" http://localhost:7777/");
        // Thread.sleep(50000);
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Артур Тарусов");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+44078830037");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("[type=button]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }
}
