import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class play {
	static WebDriver driver= new FirefoxDriver();
	@BeforeClass
	public static void befor(){
		driver.get("http://timvroom.com/selenium/playground/");
	}
	@Test
	public void test1() {

		driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());;

		driver.findElement(By.id("name")).sendKeys("Kilgore Trout");;
		WebElement dropDownList = driver.findElement(By.id("occupation"));
		new Select(dropDownList).selectByVisibleText("Science Fiction Author");
		int number=driver.findElements(By.className("bluebox")).size();
		driver.findElement(By.id("answer4")).sendKeys(Integer.toString(number));;
		driver.findElement(By.linkText("click me")).click();
		String red =driver.findElement(By.id("redbox")).getAttribute("class");
		driver.findElement(By.id("answer6")).sendKeys(red);;
		JavascriptExecutor executor = (JavascriptExecutor)
				driver;executor.executeScript("ran_this_js_function()");
				long returnValue = (Long)executor.executeScript("return got_return_from_js_function()");
				driver.findElement(By.id("answer8")).sendKeys(""+returnValue);

				driver.findElement(By.name("wrotebook")).click();
				String redbox= driver.findElement(By.id("redbox")).getText();
				driver.findElement(By.id("answer10")).sendKeys(redbox);
				Point g= driver.findElement(By.id("greenbox")).getLocation();
				Point o= driver.findElement(By.id("orangebox")).getLocation();
				if (g.y<o.y){driver.findElement(By.id("answer11")).sendKeys("green");}
				else{driver.findElement(By.id("answer11")).sendKeys("orange");}
				driver.manage().window().setSize(new Dimension(850, 650));
				try{
					driver.findElement(By.id("ishere"));
					driver.findElement(By.id("answer13")).sendKeys("yes");
				}
				catch(NotFoundException nfe)
				{
					driver.findElement(By.id("answer13")).sendKeys("no");   
				}
			

				driver.findElement(By.xpath("//a[.='click then wait']")).click();
				WebDriverWait wait = new WebDriverWait (driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='click after wait']")));
				wait.pollingEvery(10,  TimeUnit.MILLISECONDS);
				driver.findElement(By.xpath("//a[.='click after wait']")).click();
				driver.switchTo().alert().accept();

				Boolean isElement = driver.findElement(By.id("purplebox")).isDisplayed();
				  if (isElement ){
				   //yes
				   driver.findElement(By.id("answer14")) .sendKeys("yes");

				  } else {
				   driver.findElement(By.id("answer14")) .sendKeys("no");
				  }



				driver.findElement(By.id("submitbutton")).click();



	}

}
