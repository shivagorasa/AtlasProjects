package makemytripTest.makemytripTest;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MakeMyTripRailwaysTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivagor\\eclipse-workspace\\com.mmtrip\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMakeMyTripRailways() throws InterruptedException, IOException, CsvValidationException {
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
        driver.get("https://www.makemytrip.com/railways/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".commonModal__close")).click();

        WebElement span1 = driver.findElement(By.xpath("//span[text()='From']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", span1);
        Thread.sleep(2000);
        WebElement FromLocation = driver.findElement(By.xpath("//input[@placeholder='From']"));
        FromLocation.sendKeys("Delhi");
        Thread.sleep(2000);
        FromLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        FromLocation.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement span2=driver.findElement(By.xpath("//span[text()=\"To\"]"));
        executor.executeScript("arguments[0].click();",span2);
        Thread.sleep(2000);
        WebElement ToLocation=driver.findElement(By.xpath("//input[@placeholder='To']"));
        ToLocation.sendKeys("Lucknow");
        Thread.sleep(2000);
        ToLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        ToLocation.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement e5=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/label/span"));
        executor.executeScript("arguments[0].click();",e5);
        Thread.sleep(2000);
        WebElement e6= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]"));
        executor.executeScript("arguments[0].click();",e6);
        Thread.sleep(2000);


        WebElement e7=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/label/span"));
        executor.executeScript("arguments[0].click();",e7);
        Thread.sleep(2000);
        WebElement e8= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/ul/li[3]"));
        executor.executeScript("arguments[0].click();",e8);
        Thread.sleep(2000);

        WebElement e9=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
        executor.executeScript("arguments[0].click();",e9);
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/div[1]/div[4]/ul/li[1]/span[1]/label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"train_options_25-11-2023_0\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[3]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/section[1]/div[3]/div[2]/div/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Shiva");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='age']")).sendKeys("28");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='mmt-rails-add-traveller']/div/li/div[3]/div[2]/div/form/div[3]/div/p")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='mmt-rails-add-traveller']/div/li/div[3]/div[2]/div/form/div[3]/div/ul/li[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='mmt-rails-add-traveller']/div/li/div[3]/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='contactEmail']")).sendKeys("xyz@email.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9999999999");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"dt_state_gst_info\"]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/section[1]/div[8]/div[2]/div/ul/li[12]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/section[1]/div[8]/div[3]/p")).click();
        Thread.sleep(2000);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src1 = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "successRailTest" + timestamp + ".jpg";
        File destinationFile = new File("C:\\Users\\shivagor\\eclipse-workspace\\makemytripTest\\Screenshots"+fileName);
        FileUtils.copyFile(src1, destinationFile);

        System.out.println("Testing Successful");
            }
        } else {
            System.out.println("CSV file does not have the expected number of elements");
        }
    }
}
