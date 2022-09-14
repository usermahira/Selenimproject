package SELENIUMPROJECT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class seleniumProject {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//seleniumProject obj=new seleniumProject();
		
		browser();
		launchNSignin();
		//emailId();
	   readdata();
		women();
		processtoCheckout();
		processtoCheckout2();
	}	
       
		public static void browser() {
		System.setProperty("webdriver.chrome.driver",
		
		"C:\\Users\\nutan\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		////"C:\\Users\\nutan\\OneDrive\\Desktop\\AllStudyFiles\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
	

		public static void launchNSignin() {
		driver.get("http://automationpractice.com/index.php"); 
		WebElement signin=driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		signin.click();
		}
	
	
	
//	public static void emailId() {
//		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
//		email.sendKeys("nutan@gmail.com");
//		
//		WebElement pass=driver.findElement(By.xpath("//input[@id='passwd']"));
//		pass.sendKeys("nutan123");
//		WebElement sign=driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span/i"));
//		sign.click();
//}
		
		
	
		 public static void readdata() throws IOException {
			 String filepath="C:\\Users\\nutan\\ProgramStudy\\SeleniumStudy\\src\\seleniumproject\\data1.properties";
		     File file=new File(filepath);
		    
		    FileInputStream fis=new FileInputStream(file);
		    Properties prop=new Properties();
		    prop.load(fis);
		    System.out.println(prop.get("email"));
		    System.out.println(prop.get("pass"));
		    System.out.println(prop.get("browser"));
		
		    String user=prop.getProperty("email");
		    String password=prop.getProperty("pass");
		    
		    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);
		    driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		    
		    WebElement sign=driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span/i"));
         	sign.click();		
		}
		
		

		public static void women()  {
			WebElement title=driver.findElement(By.xpath("//a[@title='Women']"));
			title.click();
			WebElement sortfn=driver.findElement(By.id("selectProductSort"));
			sortfn.click();
			Select select = new Select(sortfn);
			select.selectByIndex(1);
			WebElement dress = driver.findElement(By.xpath("//a[normalize-space()='Printed Chiffon Dress']"));
			dress.click();
			WebElement addcart = driver.findElement(By.xpath("//span[normalize-space()='Add to cart']"));
			addcart.click();
		}

	
			public static void processtoCheckout() throws InterruptedException {			
			Thread.sleep(5000);
			WebElement price1 = driver.findElement(By.xpath("//p[@class='our_price_display']"));
		    String v1=price1.getText();
		    System.out.println(v1);
		    
		    Thread.sleep(5000);
		    WebElement asd = driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']"));
			asd.click();
			
		    WebElement price2 = driver.findElement(By.xpath("//span[@class='price special-price']"));
		    String v2=price2.getText();
		    System.out.println(v2);
		     if(v1.contentEquals(v2)) {
		    	 System.out.println("both price match");  	 
		            }
		     else {
		    	 System.out.println("unit price does not match");
		          }
			}
		
			

		public static void processtoCheckout2() throws InterruptedException {
	
		 Thread.sleep(5000);
		 WebElement processCheck1 =driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"));
		 processCheck1.click();		
		
		 WebElement processCheck2 =driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]"));
		 processCheck2.click();
		 
		WebElement checkbox= driver.findElement(By.xpath("//input[@id='cgv']"));
		checkbox.click();		
		WebElement shippingProceed= driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"));
		shippingProceed.click();
		
		WebElement bankwirePayment =driver.findElement(By.xpath("//a[@title='Pay by bank wire']//span[contains(text(),'(order processing will be longer)')]"));
		bankwirePayment.click();
		
		WebElement order= driver.findElement(By.xpath("//span[normalize-space()='I confirm my order']"));
		order.click();
		
		WebElement completeOrder=driver.findElement(By.xpath("//strong[normalize-space()='Your order on My Store is complete.']"));
		System.out.println(completeOrder.getText());
		
		}
		
}				
			