package util;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ElementUtil extends TestBase {
	
	public WebElement getElement(By locator) {
		waitForElementPresent(locator);

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			
				JavaScriptUtil.flash(element, driver);
			
		} catch (Exception e) {
			System.out.println("Some exception occurred while creating webelement " + locator);
		}
		return element;
	}
public void doClick(By locator) {
	try {
	getElement(locator).click();
	}catch (Exception e) {
		System.out.println("Some excepction occured while clicking on webelement" + locator);
	}
}

public void doMoucehover(WebElement element) {
	Actions click= new Actions(driver);
	WaitForElementPresent(element);
	click.moveToElement(element).build().perform();;
	
	
}
public void doSendkeys(By locator, String value) {

	try {
	getElement(locator).clear();
	waitForElementPresent(locator);
    getElement(locator).sendKeys(value);
	}catch (Exception e) {
		System.out.println("Some exception occurred while sending to webelement " + locator);
	}
}

public String doGetText(By locator) {
	
	String text=null;
	try {
		waitForElementPresent(locator);
	text= getElement(locator).getText().trim();
	
	}catch (Exception e) {
		System.out.println("Some excepction occured while clicking on webelement" + locator);

	}
	return text;
}

public void waitForElementPresent(By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}


public String waitForPageTitle(String title) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.titleContains(title));
	return driver.getTitle();
}

public boolean isElementDisplayed(By locator) {
	try {
		return getElement(locator).isDisplayed();
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Some excepction occured while clicking on webelement" + locator);
   return false;
	}
}



public void WaitForElementPresent(WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

public String getchilewindow() {
	String mainwindow=driver.getWindowHandle();
	String chilewindow=null;
	Set<String>set= driver.getWindowHandles();	
	java.util.Iterator<String>itr= set.iterator();
	while(itr.hasNext()) {
		 chilewindow= itr.next();
		if(! mainwindow.equals(chilewindow)) {
			driver.switchTo().window(chilewindow);
		}
	}
	return chilewindow;
}



public void SelectValue(WebElement element, String value) {
	waitForElementPresent(element);
	Select selectvalue= new Select(element);
	
	
	selectvalue.selectByVisibleText(value);
	
	}
private void waitForElementPresent(WebElement element) {
	// TODO Auto-generated method stub
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));

}


}


