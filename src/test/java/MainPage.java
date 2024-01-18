import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//паттерн PageObject - выносим все веб-эл-ты и методы, связанные с бизнес-логикой стр
// 1 Page = 1 страница (карточка продукта - другой page)
// описывается все, что делаем на странце
//в тесте (тест продж) пишем методы, вызывая их из мейнпедж
public class MainPage {
    //WebDriver driver;
    //WebElement catalog = driver.findElement(By.xpath("//*[@class = 'sz-header-category-item ']"));

    // Элементы
    @FindBy(xpath = "//div[@class = 'sz-header-category-list uk-visible@l']//a[@class = 'sz-header-category-item']")
    List<WebElement> categoryProducts; //инициализ только во время вызова

    @FindBy(xpath = "//a[contains(@class, 'sz-button-sub-category')]")
    List<WebElement> subCategoryProducts;

    @FindBy(xpath = "//input[contains(@id , 'arrFilter_1842_')]/..//span[@class = 'bx_filter_param_text']")
    List<WebElement> parameterProducts;

    @FindBy(xpath = "//input[@id = 'set_filter']")
    public WebElement buttonShow;

    @FindBy(xpath = "//div[@class = 'uk-margin-remove-top']//a")
    public WebElement buttonBuy;

    // Конструктор
    public MainPage(WebDriver driver){
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Методы
    public void selectCategory(String value) {
        for (WebElement webElement : categoryProducts) {
            if (webElement.getText().contains(value)) {
                webElement.click();
                break; // Выходим из цикла после первого клика
            }
        }
    }

    public void selectSubCategory(String value) {
        for (WebElement webElement : subCategoryProducts) {
            if (webElement.getText().contains(value)) {
                webElement.click();
                break; // Выходим из цикла после первого клика
            }
        }
    }

    public void getParameter(String value) {
        for (WebElement webElement : parameterProducts) {
            if (webElement.getAttribute("title").contains(value)) {
                webElement.click();
                break; // Выходим из цикла после первого клика
            }
        }
    }
}