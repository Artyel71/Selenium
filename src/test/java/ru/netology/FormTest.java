package ru.netology;

import com.google.common.annotations.Beta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FormTest {

        private WebDriver driver;
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
            driver.get(" http://localhost:7777");
           // Thread.sleep(50000);
        }
}
