package makemytripTest.makemytripTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FlightsSearchTest {

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivagor\\eclipse-workspace\\com.mmtrip\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void searchFlights() throws InterruptedException, IOException, CsvValidationException {
        
    	String csvFilePath = "C:\\Users\\shivagor\\Documents\\assignments\\testdata.csv";

        // Load csv file
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));

        // Read the headers
        String[] headers = reader.readNext();

        // Validate headers
        if (headers != null && headers.length >= 2) {
            // Assuming 'from' is the first column and 'to' is the second column
            int fromIndex = 0;
            int toIndex = 1;

            // Create Iterator reference
            Iterator<String[]> iterator = reader.iterator();

            // Iterate all values
            while (iterator.hasNext()) {
                String[] row = iterator.next();

                // Extract values based on index
                String from = row[fromIndex];
                String to = row[toIndex];

                System.out.println("Values are: From - " + from + ", To - " + to);

                driver.get("https://www.makemytrip.com/flights/");
                Thread.sleep(3000);
                driver.findElement(By.cssSelector(".commonModal__close")).click();
                TakesScreenshot ts1 = (TakesScreenshot) driver;
                File src1 = ts1.getScreenshotAs(OutputType.FILE);
                File destinationFile1 = new File("C:\\Users\\shivagor\\Documents\\assignments\\screenshoot1.jpg");
                FileUtils.copyFile(src1, destinationFile1);
                WebElement span1 = driver.findElement(By.xpath("//span[text()='From']"));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", span1);
                Thread.sleep(2000);
                WebElement FromLocation = driver.findElement(By.xpath("//input[@placeholder='From']"));
                FromLocation.sendKeys(from);
                Thread.sleep(2000);
                FromLocation.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(2000);
                FromLocation.sendKeys(Keys.ENTER);
                Thread.sleep(2000);

                WebElement span2 = driver.findElement(By.xpath("//span[text()='To']"));
                executor.executeScript("arguments[0].click();", span2);
                Thread.sleep(2000);
                WebElement ToLocation = driver.findElement(By.xpath("//input[@placeholder='To']"));
                ToLocation.sendKeys(to);
                Thread.sleep(2000);
                ToLocation.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(2000);
                ToLocation.sendKeys(Keys.ENTER);
                Thread.sleep(2000);

                WebElement e5 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/span"));
                executor.executeScript("arguments[0].click();", e5);
                Thread.sleep(2000);
                WebElement e6 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[5]/div/p[1]"));
                executor.executeScript("arguments[0].click();", e6);
                Thread.sleep(2000);

                WebElement e7 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[5]/label/span"));
                executor.executeScript("arguments[0].click();", e7);
                Thread.sleep(2000);
                WebElement e8 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[5]/div[2]/div[1]/ul[1]/li[1]"));
                executor.executeScript("arguments[0].click();", e8);
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[5]/div[2]/div[2]/button")).click();
                Thread.sleep(2000);

                WebElement e9 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/p/a"));
                executor.executeScript("arguments[0].click();", e9);
                Thread.sleep(20000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div[6]/div/div[6]/label/div/p")).click();
                Thread.sleep(2000);

                if (driver.getPageSource().contains("BOOK NOW")) {
                    driver.findElement(By.xpath("//div[@class='priceSection priceLockPersuasionExists']/div/button")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div[2]/button[2]")).click();
                    Thread.sleep(2000);

                } else {
                    driver.findElement(By.xpath("//button//span[@class='appendRight8']")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/button")).click();
                    Thread.sleep(2000);
                }

                Set<String> windowHandles = driver.getWindowHandles();

                for (String windowHandle : windowHandles) {
                    driver.switchTo().window(windowHandle);

                    if (driver.getTitle().equals("New Window Title")) {
                        break;
                    }
                }

                Thread.sleep(10000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[4]/div/div/div[4]/div[2]/label/div/p/span")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[1]/div[3]/div[3]/div[3]/button")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[1]/div[3]/div[3]/div[2]/div[2]/div/div/div[1]/div[1]/div/input")).sendKeys("Shiva");
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[1]/div[3]/div[3]/div[2]/div[2]/div/div/div[1]/div[2]/div/input")).sendKeys("Gorasa");
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[1]/div[3]/div[3]/div[2]/div[2]/div/div/div[1]/div[3]/div/div/label[1]")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[2]/div[1]/div/div[2]/div/input")).sendKeys("9999999999");
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[2]/div[1]/div/div[3]/div/input")).sendKeys("xyz@gmail.com");
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[5]/div/div/div[2]/div[1]/div/div[3]/div/div/div")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[1]/div/div[6]/div/div/div[3]/p")).click();
                Thread.sleep(2000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[1]/div[2]/button")).click();
                Thread.sleep(50000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/button")).click();
                Thread.sleep(50000);

                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/form[3]/div[1]/div/div[4]/div/div/button")).click();
                Thread.sleep(3000);

                // Taking a screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "successFlightTestTest" + timestamp + ".jpg";
                File destinationFile = new File("C:\\Users\\shivagor\\eclipse-workspace\\makemytripTest\\Screenshots\\" + fileName);
                FileUtils.copyFile(src, destinationFile);
            }
        } else {
            System.out.println("CSV file does not have the expected number of elements");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
