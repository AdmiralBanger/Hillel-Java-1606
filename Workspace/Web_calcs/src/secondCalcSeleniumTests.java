import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class secondCalcSeleniumTests
{

	@Test
	public void testDiv()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/secondCalc.html");
		drv.findElement(By.name("btnOne")).click();
		drv.findElement(By.name("btnTwo")).click();
		drv.findElement(By.name("btnDivide")).click();
		drv.findElement(By.name("btnZero")).click();
		drv.findElement(By.name("btnEquals")).click();
		String str = drv.findElement(By.id("editWide")).getAttribute("value");
		assertEquals("dividing by zero", str);
		drv.close();
	}
	@Test
	public void testMul()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/secondCalc.html");
		drv.findElement(By.name("btnTwo")).click();
		drv.findElement(By.name("btnMultiple")).click();
		drv.findElement(By.name("btnEight")).click();
		drv.findElement(By.name("btnEquals")).click();
		String str = drv.findElement(By.id("editWide")).getAttribute("value");
		assertEquals("16", str);
		drv.close();
	}
	@Test
	public void testSum()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/secondCalc.html");
		drv.findElement(By.name("btnOne")).click();
		drv.findElement(By.name("btnTwo")).click();
		drv.findElement(By.name("btnPlus")).click();
		drv.findElement(By.name("btnEight")).click();
		drv.findElement(By.name("btnEquals")).click();
		String str = drv.findElement(By.id("editWide")).getAttribute("value");
		assertEquals("20", str);
		drv.close();
	}
	@Test
	public void testMin()
	{
		WebDriver drv = new FirefoxDriver();
		drv.get("file:///D:/Workspace/Web_calcs/src/secondCalc.html");
		drv.findElement(By.name("btnTwo")).click();
		drv.findElement(By.name("btnMinus")).click();
		drv.findElement(By.name("btnFive")).click();
		drv.findElement(By.name("btnEquals")).click();
		String str = drv.findElement(By.id("editWide")).getAttribute("value");
		assertEquals("-3", str);
		drv.close();
	}
	
	
}