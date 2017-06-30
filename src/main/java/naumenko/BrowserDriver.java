package naumenko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    private static WebDriver mDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    public static synchronized WebDriver getCurrentDriver() {
        if (mDriver == null) {
            try {
                mDriver = new ChromeDriver();
                mDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return mDriver;
    }

    public static void loadPage(String url) {
        getCurrentDriver().get(url);
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            mDriver = null;
        } catch (UnreachableBrowserException e) {
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }
}

