package makemytripTest.makemytripTest;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelsearchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    public void hotelflow() throws InterruptedException, IOException {
        // Test name: hotelflow
        // Step # | name | target | value
        // 1 | open | https://www.makemytrip.com/hotels/ |
        driver.get("https://www.makemytrip.com/hotels/");
        // 2 | setWindowSize | 1920x1080 |
        driver.manage().window().maximize();
        // 3 | click | css=.commonModal__close |
        driver.findElement(By.cssSelector(".commonModal__close")).click();
        // 4 | click | id=city |
        WebElement span1 = driver.findElement(By.xpath("//span[text()='City, Property name or Location']"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", span1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement FromLocation = driver.findElement(By.xpath("//input[@placeholder='Where do you want to stay?']"));
        FromLocation.sendKeys("Goa");

        driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-3\"]/div/div/div/p")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[6]")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[2]")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/ul/li[1]")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/button")).click();
	    driver.findElement(By.xpath("//*[@id=\"hsw_search_button\"]")).click();
	    driver.findElement(By.xpath("//*[@id='BRAND_FILTER']/ul/li[10]/span[1]/label/div/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[5]/div[2]/div/div/div/div[2]/div/a/div")).click();
	    Set<String> windowHandles = driver.getWindowHandles();

	     // Iterate over the handles to switch to the new window
	     for (String windowHandle : windowHandles) {
	         // Switch to the new window
	         driver.switchTo().window(windowHandle);

	         // Optionally, check the title or other attributes to confirm that it's the desired window
	         if (driver.getTitle().equals("New Window Title")) {
	             break; // Exit the loop if it's the desired window
	         }
	     }
	     
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/span/div/div/div[1]/div[2]/span/a")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"fName\"]")).sendKeys("Shiva");
	     Thread.sleep(2000);
	     //lastname
	     driver.findElement(By.xpath("//*[@id=\"lName\"]")).sendKeys("Gorasa");
	     Thread.sleep(2000);
	     //enter mobile
	     driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("xyz@email.com");
	     Thread.sleep(2000);
	     //enter and select email
	     driver.findElement(By.xpath("//*[@id=\"mNo\"]")).sendKeys("9999999999");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[2]/div[1]/div[6]/div/a")).click();

        Thread.sleep(2000);
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        File src1 = ts1.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "successHotelTest" + timestamp + ".jpg";
        
        File destinationFile1 = new File("C:\\Users\\shivagor\\eclipse-workspace\\makemytripTest\\Screenshots\\"+fileName);
        FileUtils.copyFile(src1, destinationFile1);
    }
}
