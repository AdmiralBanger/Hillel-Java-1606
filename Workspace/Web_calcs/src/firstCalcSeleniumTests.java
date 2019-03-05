import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstCalcSeleniumTests
{

	@Test
	public void testDiv()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/firstCalc.html");
		drv.findElement(By.id("aField")).sendKeys("12");
		drv.findElement(By.id("opField")).sendKeys("/");
		drv.findElement(By.id("bField")).sendKeys("0");
		drv.findElement(By.id("calc")).click();
		String str = drv.findElement(By.id("output")).getAttribute("value");
		assertEquals("dividing by zero", str);
		drv.close();
	}

	@Test
	public void testMul()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/firstCalc.html");
		drv.findElement(By.id("aField")).sendKeys("7");
		drv.findElement(By.id("opField")).sendKeys("*");
		drv.findElement(By.id("bField")).sendKeys("3");
		drv.findElement(By.id("calc")).click();
		String str = drv.findElement(By.id("output")).getAttribute("value");
		assertEquals("21", str);
		drv.close();
	}

	@Test
	public void testMin()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/firstCalc.html");
		drv.findElement(By.id("aField")).sendKeys("5");
		drv.findElement(By.id("opField")).sendKeys("-");
		drv.findElement(By.id("bField")).sendKeys("8");
		drv.findElement(By.id("calc")).click();
		String str = drv.findElement(By.id("output")).getAttribute("value");
		assertEquals("-3", str);
		drv.close();
	}

	@Test
	public void testSum()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/firstCalc.html");
		drv.findElement(By.id("aField")).sendKeys("3");
		drv.findElement(By.id("opField")).sendKeys("+");
		drv.findElement(By.id("bField")).sendKeys("7");
		drv.findElement(By.id("calc")).click();
		String str = drv.findElement(By.id("output")).getAttribute("value");
		assertEquals("10", str);
		drv.close();
	}
	
	
	/*@Test
	public void test_minus()
	{
		System.setProperty("webdriver.chrome.driver", "D:/Workspace/Web_calcs/src/firstCalc.html");
		WebDriver drv = new ChromeDriver();
		drv.get("file:///D:/JavaScript/calculator2.html");
		drv.findElement(By.name("btnOne")).click();
		drv.findElement(By.name("btnPlus")).click();
		drv.findElement(By.name("btnThree")).click();
		drv.findElement(By.name("btnEquals")).click();
		String str=drv.findElement(By.name("ReadOut")).getAttribute("value");
		assertEquals("4", str);
		drv.close();
	}*/
}
