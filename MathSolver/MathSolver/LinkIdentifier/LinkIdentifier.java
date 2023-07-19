package LinkIdentifier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkIdentifier {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/alurisrinivasarao/Downloads/chromedriver");
        
        // Create ChromeOptions and set User-Agent header
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.9999.99 Safari/537.36");

        // Create a new instance of the Chrome driver with options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the webpage
        driver.get("https://dev-qna.byjusweb.com/question-answer/functional-group/");  // Replace with the URL of the webpage you want to scrape
        
       

        // Find the specific area element
        WebElement areaElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[2]/span")); // Replace "specific-area" with the ID or any other suitable selector of the desired area

        // Find all the link elements within the area
        java.util.List<WebElement> linkElements = areaElement.findElements(By.tagName("a"));
        
       

        // Extract the URLs from the link elements within the area
        for (WebElement linkElement : linkElements) {
            String url = linkElement.getAttribute("href");
            System.out.println(url);
     
        }

        // Close the browser
        driver.quit();
    }
        
    }

