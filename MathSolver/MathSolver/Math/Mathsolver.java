package Math;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mathsolver {

	public static void main(String[] args) throws IOException {
		
		//Reads data from excel
		/*FileInputStream file=new FileInputStream("/Users/alurisrinivasarao/Downloads/English URL's.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
    	XSSFSheet sheet=workbook.getSheetAt(0);
    	XSSFCell cell=null;     
    		int s=sheet.getLastRowNum()+1;
    
    			for(int i=0; i<s; i++){
    				try {
    						cell=sheet.getRow(i).getCell(0);
        
    							String url=cell.toString(); */
    							
    							//Starting WebDriver
    			    			System.setProperty("webdriver.chrome.driver", "/Users/alurisrinivasarao/Downloads/chromedriver");
    			    	//Opening Chrome in headless browser
    			    			ChromeOptions options = new ChromeOptions();
    			    			options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
    			    			 options.addArguments("--new-tab");
    			    			//options.addArguments("--headless");
    			    			WebDriver driver = new ChromeDriver(options); 
    			    			
    			    			FileInputStream file=new FileInputStream("/Users/alurisrinivasarao/Downloads/Production Spanish URL's.xlsx");
    			    			XSSFWorkbook workbook=new XSSFWorkbook(file);
    			    	    	XSSFSheet sheet=workbook.getSheetAt(0);
    			    	    	XSSFCell cell=null;     
    			    	    		int s=sheet.getLastRowNum()+1;
    			    	    
    			    	    			for(int i=0; i<s; i++){
    			    	    				try {
    			    	    						cell=sheet.getRow(i).getCell(0);
    			    	        
    			    	    							String url=cell.toString();
    			    			
    			    			//Navigating to Video Solutions URL
    			    			driver.get(url);
    			    			
    			    			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    			                 try {
    			                     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[2]/div[2]/h1")));
    			                   
    			                     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[2]/div[2]/div[2]/h1")));
    			                     System.out.println("Page loaded successfully: " + url);
    			                   //Writing the status of the video into excel, if video doesn't play it will do not any comment
    					    			XSSFCell cell1= sheet.getRow(i).createCell(2);
    					    			cell1.setCellValue("Page loaded successfully");
    					    			FileOutputStream outputStream = new FileOutputStream("/Users/alurisrinivasarao/Downloads/Production Spanish URL's.xlsx");
    					    			workbook.write(outputStream);
    			                    
    			                 } catch (TimeoutException e) {
    			                     System.out.println("Page failed to load: " + url);
    			                     
    			                   //Writing the status of the video into excel, if video doesn't play it will do not any comment
    					    			XSSFCell cell1= sheet.getRow(i).createCell(2);
    					    			cell1.setCellValue("Page failed to load");
    					    			FileOutputStream outputStream = new FileOutputStream("/Users/alurisrinivasarao/Downloads/Production Spanish URL's.xlsx");
    					    			workbook.write(outputStream);
    			                     
    			                    
    			                 }
    			    			
		
		
	}
    				catch (org.openqa.selenium.NoSuchElementException e) 
    				{
		    System.out.println("Page failed to load");

}
    			}
	}
}
