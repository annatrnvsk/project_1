import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestProject extends BaseTest{

    @Test
    public void testProject1(){
        WebElement catalog = driver.findElement(By.xpath("//*[@class = 'sz-header-category-item ']")); //объявили эл-т
        catalog.click();
        WebElement tovaryAvto = driver.findElement(By.xpath("//a[text() = 'Товары для авто']"));
        tovaryAvto.click();
        WebElement travelPillows = driver.findElement(By.xpath("//a[@class = 'sz-button-sub-category uk-first-column']"));
        travelPillows.click();
        WebElement fabricVelor = driver.findElement(By.xpath("//span[@title= 'Велюровая']/preceding-sibling::input[@class = 'uk-checkbox']"));
        fabricVelor.click();
        WebElement showButton = driver.findElement(By.xpath("//input[@value= 'Показать']"));
        showButton.click();


        int xpathCount = driver.findElements(By.xpath("//*[@class = 'uk-button uk-button-secondary uk-button-secondary-style-text uk-width-1-1@s uk-width-auto']")).size();
        System.out.println("Количество товаров на странице: " + xpathCount);

        int sumOfItem = Integer.parseInt(driver.findElement(By.xpath("//div[@class = 'sz-count-product-list']/child::span")).getText());
        System.out.println("Всего товаров на странице: " + sumOfItem);

        if(xpathCount == sumOfItem){
            System.out.println("Количество товаров на странице соответствует указанному");
        }else{
            System.out.println("Количество товаров на странице не соответствует указанному");
        }


        // Actions actions = new Actions(driver); //класс для более сложных действий с эл-тами
        // actions.

    }
}
