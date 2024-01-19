import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestProject extends BaseTest{

    @Test
    public void testProject1(){
        // Явные ожидания
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // объявили объект wait для явных ожиданий

        WebElement catalog = driver.findElement(By.xpath("//*[@class = 'sz-header-category-item ']"));
        catalog.click();
        WebElement tovaryAvto = driver.findElement(By.xpath("//a[text() = 'Товары для авто']"));
        tovaryAvto.click();
        WebElement travelPillows = driver.findElement(By.xpath("//a[@class = 'sz-button-sub-category uk-first-column']"));
        travelPillows.click();
        WebElement fabricVelor = driver.findElement(By.xpath("//span[@title= 'Велюровая']/preceding-sibling::input[@class = 'uk-checkbox']"));
        fabricVelor.click();
        WebElement showButton = driver.findElement(By.xpath("//input[@value= 'Показать']"));
        // wait.until(ExpectedConditions.elementToBeClickable(showButton)); // условие - пока кнопка не станет кликабельной, будем пытатться нажать ее в течение 5 секунд. Только после 5 сек выпадет ошибка
        showButton.click();

        int xpathCount = driver.findElements(By.xpath("//*[@class = 'uk-button uk-button-secondary uk-button-secondary-style-text uk-width-1-1@s uk-width-auto']")).size();
        System.out.println("Количество товаров на странице: " + xpathCount);
        int sumOfItem = Integer.parseInt(driver.findElement(By.xpath("//div[@class = 'sz-count-product-list']/child::span")).getText());
        System.out.println("Всего товаров на странице: " + sumOfItem);

        //Каждый тест должен заканчиваться assertом
        Assertions.assertEquals(xpathCount, sumOfItem, "Количество товаров на странице не соответствует указанному"); //сообщение, если проверка не прошла
        Assertions.assertTrue(showButton.isDisplayed(), "Кнопка видна"); // виден - true, не виден - false - тест падает
        // Assertions.assertFalse();

        // Actions actions = new Actions(driver); //класс для более сложных действий с эл-тами
        // actions.doubleClick(showButton);

    }


    @Test
    public void testProject2(){
        // Паттерн ААА:
        // Arrange - подготовка тестовых данных (берем параметр, присваиваем значение, устанавливаем вх данные)
        String category = "Авто";
        String subCategory = "Дорожные подушки";
        String parameter = "Велюровая";
        // Act - необходимые действия перед проверкой (выполнение не тест. сценария, а выполнение операций)
        MainPage mainPage = new MainPage(driver); // создание нового объекта класса MainPage
        mainPage.selectCategory(category);
        mainPage.selectSubCategory(subCategory);
        mainPage.getParameter(parameter);
        mainPage.buttonShow.click();
        mainPage.buttonBuy.click();
        ProductPage productPage = new ProductPage(driver);
        boolean result  = productPage.buttonAddToFavorites.isDisplayed();
        // Assert - сама проверка (вызов Assertions и сравнение ОР и ФР)
        Assertions.assertTrue(result);
    }
}


// = Присвоение значения
//. Вызов доступных методов объекта
// Объявлять переменную необходимо с указанием класса String, int