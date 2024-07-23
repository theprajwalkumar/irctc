package irctc;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctc {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("From where you want to go ?");
		String FromAnswer=sc.next();
		
		Scanner sc1=new Scanner(System.in);
		System.out.println("To where you want to go ?");
		String ToAnswer=sc1.next();
		Thread.sleep(4000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);
		
		//From : Where to catch train from 
		WebElement From=driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
		From.sendKeys(FromAnswer);
		Thread.sleep(5000);
	    List<WebElement>auto=driver.findElements(By.xpath("//ul[@id= \"pr_id_1_list\"]/li"));
	    auto.size();
	    int count =auto.size();
	    System.out.println(count);
	    Thread.sleep(3000);
	    try {
	    	auto.get(0).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
		
		//To:To which place you want to travel
		WebElement To=driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
		To.sendKeys(ToAnswer);
		Thread.sleep(5000);
		List<WebElement>auto1=driver.findElements(By.xpath("//ul[@id= \"pr_id_2_list\"]/li"));
		auto1.size();
		int count1=auto.size();
		System.out.println(count1);
		try {
			auto1.get(0).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		WebElement Quota =driver.findElement(By.xpath("//*[@id=\"journeyQuota\"]/div"));
		Quota.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"journeyQuota\"]/div/div[4]/div/ul/p-dropdownitem[1]/li")).click();
	
		//driver.close();
		
		
		//Date:When To Travel (Calendar)
		String ExpectedMonth="August";
		String ExpectedYear="2024";
		String ExpectedDate="20";
		WebElement Date=driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/input"));
		Date.click();
		Thread.sleep(3000);
		
		while(true) {
		String MonthText=driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/div/span[1]")).getText();
		String YearText=driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/div/span[2]")).getText();
		
		if(ExpectedMonth.equals(MonthText) && ExpectedYear.equals(YearText)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/a[2]/span")).click();
		}
		}
		driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[2]/table/tbody/tr[4]/td[3]/a")).click();
		
		//Classes
		WebElement Classes=driver.findElement(By.xpath("//*[@id=\"journeyClass\"]/div"));
		Classes.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@aria-label='AC 3 Tier (3A)']")).click();
		
		
		System.out.println("Waiting");
		
		Thread.sleep(3000);
		
		//SearchButton
		WebElement SearchB=driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[5]/div[1]/button"));
		SearchB.click();
		
		Thread.sleep(3000);
		System.out.println("Executed");
		
		TakesScreenshot sc2 = ((TakesScreenshot) driver);
		File src = sc2.getScreenshotAs(OutputType.FILE);
		File f2 = new File("/Users/prajwal/Downloads/irctc.png");
		FileUtils.copyFile(src, f2);
		
		Thread.sleep(3000);
		
		//driver.close();
		
		//WebElement Ticket=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[3]/div[1]/app-train-list[1]/div[4]/div[1]/div[5]/div[1]/div[1]/app-train-avl-enq[1]/div[1]/div[5]/div[1]/table[1]/tr[1]/td[1]/div[1]/div[2]"));
		//Ticket.click();
		//Thread.sleep(3000);
		
		//WebElement TicketS=driver.findElement(By.xpath())
	

		
		
		
		
		
	}

}
