package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import util.ElementUtil;
import util.TestUtil;

public class Hotwire_Search extends TestBase {
TestUtil util;
ElementUtil elementUtil;
String nextdaydate;
String Afterthreeweekdate;
//Hotwire_Search class constructor

public Hotwire_Search() {
	//load testbase class constucor
	 super();
	 PageFactory.initElements(driver, this); 
	 util=new TestUtil();
	 elementUtil= new ElementUtil();
}


// Locate all essential element on website
//select vacation tab element
//@FindBy(xpath="//li[@class='hidden-xs']/a")
By vacation= By.xpath("//li[@class='hidden-xs']/a");
//select car search
By carsearch= By.xpath("//button[@class='hw-btn hw-btn-check']");
//@FindBy(xpath="//button[@class='hw-btn hw-btn-check']")
//WebElement carsearch;
//Flyform element
By Flyform= By.xpath("//input[@id='farefinder-package-origin-location-input']");

//@FindBy(xpath="//input[@id='farefinder-package-origin-location-input']")
//WebElement Flyform;

//Fly to element
By FlyTo= By.xpath("//input[@id='farefinder-package-destination-location-input']");

//select Departure date
By Departuredate= By.xpath("//input[@id='farefinder-package-startdate-input']");

@FindBy(xpath="//input[@id='farefinder-package-startdate-input']")
WebElement Departuredates;

//select ruturn date
By returndate= By.xpath("//input[@id='farefinder-package-enddate-input']");

@FindBy(xpath="//input[@id='farefinder-package-enddate-input']")
WebElement Returndate;

//select departuretime
//By Pickuptime= By.xpath("select[@id='farefinder-package-pickuptime-input']");

@FindBy(xpath="//select[@id='farefinder-package-pickuptime-input']")
WebElement pickuptime;


//select returntime
By Returntime= By.xpath("//select[@id='farefinder-package-dropofftime-input']");

@FindBy(xpath="//select[@id='farefinder-package-dropofftime-input']")
WebElement returntime;
//find deal button

//button[@id='farefinder-package-search-button']
By FindDealButton= By.xpath("//button[@id='farefinder-package-search-button']");

//Assermsg as result return
By assermsg=By.xpath("//h1[@class='section-header-main']");

@FindBy(xpath="//button[@id='farefinder-package-search-button']")
WebElement finddealbutton;

//method to serach hotel based on conditopn
public void SearchVacation(String FlyFrom, String FlyTo, String date, String picktime, String Droptime) {
	
	//calculate next day date & date after 3 week from input date
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Calendar c = Calendar.getInstance();
	try {
		c.setTime(sdf.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c.add(Calendar.DATE, 1);  // number of days to add
	nextdaydate = sdf.format(c.getTime()); 
	c.add(Calendar.DATE, 24);
	Afterthreeweekdate=sdf.format(c.getTime());
	
	elementUtil.doClick(vacation);
	elementUtil.doClick(carsearch);
	elementUtil.doSendkeys(Flyform, FlyFrom);
	elementUtil.doSendkeys(this.FlyTo,FlyTo);
	elementUtil.doSendkeys(Departuredate, nextdaydate);
	elementUtil.doSendkeys(returndate, Afterthreeweekdate);
	elementUtil.SelectValue(pickuptime, picktime);
	elementUtil.SelectValue(returntime, Droptime);
	elementUtil.doClick(FindDealButton);
	
	
	
	//method to return asset result
	
	
}



public String Assrtmsg() {
	
	elementUtil.doGetText(assermsg);
	System.out.println(elementUtil.doGetText(assermsg));
	return elementUtil.doGetText(assermsg);
	}


}
