import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import static org.junit.Assert.*;


public class WebDriverTest {
    @Test
    public void shouldLandGoogle() {
        Integer numberOfQuery = 0;
        System.setProperty("webdriver.chrome.driver", "/Users/fxie/Downloads/chromedriver");
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.baidu.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("kw1"));

        // Enter something to search for
        String resultTest = "Cheese";
        element.sendKeys(resultTest);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> findQuery = driver.findElements(By.partialLinkText(resultTest));
        for (WebElement e : findQuery) {

            numberOfQuery = numberOfQuery + 1;
        }
//        driver.navigate().back();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.navigate().forward();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.navigate().refresh();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.quit();

    }
}
