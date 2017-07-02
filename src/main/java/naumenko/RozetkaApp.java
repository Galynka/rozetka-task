package naumenko;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by galynashine on 6/26/17.
 */
public class RozetkaApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("analysing rozetka.com ... uuu");
        BrowserDriver.loadPage("http://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/");

        Thread.sleep(20000l);

//        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"3361\"]/a")).click();
//        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[1]/h4/a")).click();
//        BrowserDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[1]/div/a[1]")).click();
        List<WebElement> webElements = BrowserDriver.getCurrentDriver().findElements(By.cssSelector(".g-tag.g-tag-icon-middle-popularity.sprite"));
        for (WebElement we : webElements) {
            WebElement parent = we.findElement(By.xpath("../../.."));

            WebElement nameElement = parent.findElement(By.cssSelector(".g-i-tile-i-title.clearfix"));
            System.out.println(nameElement.getText());

            WebElement priceElement = parent.findElement(By.cssSelector(".g-price-uah"));
            System.out.println(priceElement.getText());

        }

        Thread.sleep(5000l);
    }
}
