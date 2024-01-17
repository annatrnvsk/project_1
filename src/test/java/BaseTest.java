import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver; //экземпляр класса - инициализируем (объявлем, что есть перменнаяч класса WebDriver)

    @BeforeEach
    public void setUp(){
        driver = getDriver(); //вызываем метод getDriver, внутри ктр происходит конфигурирование и создание объекта new ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // объявление неявных ожиданий!, чтобы ожидать появления эл-та
        driver.get("https://bio-textiles.ru/");
    }

    @AfterEach
    public void setDown(){
        if(driver != null) {
            //driver.quit();
        }
    }

    public WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }
}

// = присвоили значение
//. вызываем доступные методы объекта
