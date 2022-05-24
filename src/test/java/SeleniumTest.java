import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumTest {
    @Test
    public void WebTest(){
        WebDriver driver;
        try {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver();
        }
        catch (Exception e){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get(System.getProperty("user.dir")+"\\src\\test\\resources\\main.html");
        for (int k=0;k<100;k++){
            int i = (int)(Math.random()*100);
            int j = (int)(Math.random()*100);
            driver.findElement(By.id("firstnum")).clear();
            driver.findElement(By.id("secondnum")).clear();
            driver.findElement(By.id("firstnum")).sendKeys(String.valueOf(i));
            driver.findElement(By.id("secondnum")).sendKeys(String.valueOf(j));
            driver.findElement(By.id("calcbtn")).click();
            String add = driver.findElement(By.id("add")).getText();
            String sub = driver.findElement(By.id("sub")).getText();
            String mult = driver.findElement(By.id("mult")).getText();
            String divide = driver.findElement(By.id("divide")).getText();
            System.out.printf("Num 1: %d, Num 2: %d\n", i, j);
            System.out.printf("#ADD# Output: %d, Expected: %d\n", Integer.parseInt(add),i+j);
            assertEquals(Integer.parseInt(add), i+j);
            System.out.printf("#SUBTRACT# Output: %d, Expected: %d\n", Integer.parseInt(sub),i-j);
            assertEquals(Integer.parseInt(sub), i-j);
            System.out.printf("#MULTIPLY# Output: %d, Expected: %d\n", Integer.parseInt(mult),i*j);
            assertEquals(Integer.parseInt(mult), i*j);
            System.out.printf("#DIVIDE# Output: %.2f, Expected: %.2f\n\n", Double.parseDouble(divide),(double)i/j);
            if(j==0){
                if(i==0){
                    assertEquals(divide, "NaN");
                    continue;
                }
                assertEquals(divide, "Infinity");
                continue;
            }
            assertEquals(Double.parseDouble(divide), (double) i/j, 0.01);
        }
    }
}
