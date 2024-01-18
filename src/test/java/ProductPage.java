import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    // Элементы
    @FindBy(xpath = "//*[@class='uk-wishlist sz-wishlist-element']")
    public WebElement buttonAddToFavorites;

    // Конструктор
    public ProductPage(WebDriver driver){
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
}