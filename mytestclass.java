package mytestpack;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.*;


public class mytestclass {
     public static WebDriver mydriver = new FirefoxDriver();
     public static void main(String[] args) {
         // Create a new instance of firefox driver
         final String baseUrl;
         baseUrl = "http://mobile.walmart.com";
         String userName = "waltest835@gmail.com";
         String passWd = "got2win1";
      
         sleepWait(10);
         mydriver.get(baseUrl);
         mydriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         mydriver.manage().window().maximize();
      
         mydriver.findElement(By.name("query")).sendKeys("tv");
         mydriver.findElement(By.cssSelector(".js-searchbar-submit")).click();
         sleepWait(3);
         mydriver.findElement(By.className("js-product-title")).click();
         sleepWait(3);
      
         mydriver.findElement(By.id("WMItemAddToCartBtn")).click();
         mydriver.findElement(By.id("PACCheckoutBtn")).click();
      
         // Login with walmart account at this point
         accountLogin(userName,passWd);
       
         // Login successful, validate that the item is added to the cart.
         validateText("Qty 1");
      
         // validate if the correct item is added to the cart
         validateText("SCEPTRE");
         sleepWait(10);
      
         mydriver.findElement(By.id("COAC1ShpOptContBtn")).click();
         sleepWait(10);
         mydriver.findElement(By.id("COAC2ShpAddrContBtn")).click();
      
         // validate if on Payment details page
         validateText("Select payment method");
      
         sleepWait(10);
         mydriver.findElement(By.className("wmicon-cart")).click();
         sleepWait(10);
      
         // remove item from cart
         mydriver.findElement(By.id("CartRemItemBtn")).click();
      
         // validate if item is removed
         // validateText("has been deleted");
         validateText("Your cart: 0 items");
      
         // sign out
         WebElement signOut = mydriver.findElement(By.linkText("My Account"));
         Actions action = new Actions(mydriver);
         action.moveToElement(signOut).build().perform();
         mydriver.findElement(By.linkText("Sign Out")).click();
   
         sleepWait(2);
         mydriver.quit();
    }
	
    private static boolean validateText(String text){
         if (mydriver.getPageSource().contains(text)) {
	    	  System.out.println(text + " is on the page, validation successful");
	    	  return true;
         }
         else{
	    	  System.out.println(text + " not on the page, validation is not successful");
	    	  return false;
         }
    }
	
    private static void accountLogin(String userNameTest,String passWdTest){
         mydriver.findElement(By.id("COAC0WelAccntEmail")).sendKeys(userNameTest);
	 mydriver.findElement(By.id("COAC0WelAccntPswd")).sendKeys(passWdTest);
	 mydriver.findElement(By.id("COAC0WelAccntSignInBtn")).click();
    }
	
	
    public static void sleepWait(long timeInSeconds) {
	 long t= System.currentTimeMillis();
         timeInSeconds = timeInSeconds*1000;
         long end = t + timeInSeconds;
         while(System.currentTimeMillis() < end) {
              // waiting to do something
         }
    }
	
	
	
}
