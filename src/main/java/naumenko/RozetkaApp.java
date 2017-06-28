package naumenko;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by galynashine on 6/26/17.
 */
public class RozetkaApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("analysing rozetka.com ... uuu");
        BrowserDriver.loadPage("http://rozetka.com.ua/");
        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"3361\"]/a")).click();
        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[1]/h4/a")).click();
        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[1]/div/a[1]")).click();
        BrowserDriver.getCurrentDriver().findElement(By.className("g-tag g-tag-icon-middle-popularity sprite")).click();

        Thread.sleep(5000l);
    }
}
