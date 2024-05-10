package demo;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait!
        driver.manage().window().maximize();

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");

        driver.get("https://leetcode.com/");
        String url = driver.getCurrentUrl();
        if (url.contains("leetcode")) {
            System.out.println("Test Passed: URL contains 'leetcode'");
        } else {
            System.out.println("Test Failed: URL does not contain 'leetcode'");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");

        driver.get("https://leetcode.com/explore/");
        WebElement problem = driver.findElement(By.xpath("//a[text()='Problems']"));
        problem.click();
        if (driver.getCurrentUrl().contains("problemset")) {
            System.out.println("Test Passed: URL contains 'problemset'");
        } else {
            System.out.println("Test Failed: URL does not contain 'problemset'");
        }
        Thread.sleep(8000);
        List<WebElement> questionElements = driver
                .findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        for (int i = 1; i < 6 && i < questionElements.size(); i++) {
            WebElement questionElement = questionElements.get(i);
            String questionTitle = questionElement.getText();
            Thread.sleep(8000);
            System.out.println("Question " + (i + 1) + ": " + questionTitle);
        }
        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        driver.get(
                "https://leetcode.com/problemset/?sorting=W3sic29ydE9yZGVyIjoiQVNDRU5ESU5HIiwib3JkZXJCeSI6IkZST05URU5EX0lEIn1d");
       Thread.sleep(5000);
                WebElement twoSum = driver
                .findElement(By.xpath("(//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'])[2]"));
        twoSum.click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("two-sum")) {
            System.out.println("Test Passed: URL contains 'two-sum'");
        } else {
            System.out.println("Test Failed: URL does not contain 'two-sum'");
        }
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
driver.get("https://leetcode.com/problems/two-sum/description/");

Thread.sleep(5000);

WebElement sub = driver.findElement(By.xpath("(//div[contains(@class,'flexlayout__tab_button ')])[4]"));
sub.click();

WebElement reg = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
String get = reg.getText();
if (get.contains("Register or Sign In")){
    System.out.println("Test Passed: URL contains 'Register or Sign In'");
}
    else{                                              
System.out.println("Test Failed: URL contains 'Register or Sign In'");
    }


        System.out.println("end Test case: testCase04");
    }

}