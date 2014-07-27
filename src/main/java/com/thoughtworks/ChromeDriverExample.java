package com.thoughtworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverExample {
    public static void main(String[] args){
            Integer numberOfQuery = 0;
            System.setProperty("webdriver.chrome.driver", "/Users/fxie/Downloads/chromedriver");
            WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

            // And now use this to visit Google
            driver.get("http://www.google.com");

            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));

            // Enter something to search for
            String resultTest = "Cheese";
            element.sendKeys(resultTest);

            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            List<WebElement> findQuery = driver.findElements(By.partialLinkText(resultTest));
            for (WebElement e : findQuery) {

                numberOfQuery = numberOfQuery+1;
            }

            if(numberOfQuery != 0){
                System.out.println("The "+resultTest+" has already existed in the result of query!");
            }
            else{
                System.out.println("The "+resultTest+" do not exist in the result of query!");
            }
            // Check the title of the page
            System.out.println("The number of query is "+numberOfQuery);

            driver.quit();
        }
    }

