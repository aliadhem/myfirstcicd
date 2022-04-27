package test.com.itexps;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 



/**
 *
 * @author Owner
 */
public class ContactUsTest {
    private WebDriver driver;
     private String baseUrl;
     private ContactUs contactus;
    public ContactUsTest() throws InterruptedException, InterruptedException {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
         FileInputStream inputStream = new FileInputStream(new File("c:\\data\\confile.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet
        Sheet firstSheet = workbook.getSheetAt(0);
        //get first row
        Row r =  firstSheet.getRow(1);
        Cell c = r.getCell(0); //username value
        String uname= c.getStringCellValue();
         c = r.getCell(1); //pass value
        String pass= c.getStringCellValue();
        c = r.getCell(2); //email value
        String uemail = c.getStringCellValue();
        contactus = new ContactUs(uname, pass, uemail);
       
        System.out.println (contactus);
        inputStream.close();
    }
   
    @Test
   public void testContactUs() throws InterruptedException {
    driver.get("http://itexps.com/simpleform.html");
    driver.findElement(By.id("uname")).click();
    driver.findElement(By.id("uname")).clear();
    driver.findElement(By.id("uname")).sendKeys(contactus.getUname());
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys(contactus.getPass());
    driver.findElement(By.id("uemail")).clear();
    driver.findElement(By.id("uemail")).sendKeys(contactus.getUemail());
    driver.findElement(By.id("age")).clear();
    driver.findElement(By.id("age")).sendKeys("49");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("usa");
    driver.findElement(By.xpath("//label[2]/input")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[1]/preceding::label[1]")).click();
    driver.findElement(By.xpath("//tr[7]/td[2]/label[2]/input")).click();
    driver.findElement(By.id("city")).click();
    new Select(driver.findElement(By.id("city"))).selectByVisibleText("Detroit");
    driver.findElement(By.xpath("//textarea")).click();
    driver.findElement(By.xpath("//textarea")).clear();
    driver.findElement(By.xpath("//textarea")).sendKeys("This is my address");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(2000);
    driver.close();
       
   }
   @Test
       public void hover() throws Exception {
        //   driver = new ChromeDriver();
        driver.manage().window().maximize();
       // implicit wait condition
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // this opens the url
        driver.get("https://www.redfin.com");
       
        //Mouse hover
        WebElement elem1 = driver.findElement(By.xpath("//a[contains(@title, 'Buy Menu')]"));
        Actions act = new Actions(driver);
        Action a1 = act.moveToElement(elem1).build();
        a1.perform();

        //To wait for element visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home buying guide")));

        WebElement elem2 = driver.findElement(By.linkText("Home buying guide"));
        elem2.click();
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
   }
}