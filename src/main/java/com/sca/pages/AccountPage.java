package com.sca.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;

public class AccountPage extends TestBase {
	@FindBy(xpath="//div[@class=\"slds-icon-waffle\"]/span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="//span[contains(text(),'Accounts')]")
	WebElement accountObj;
	
	@FindBy(xpath="//p[@class=\"slds-truncate\"]/b")
	WebElement acc;

	@FindBy(linkText = "New")
	WebElement newAccount;
		
	@FindBy(xpath = "//input[@name=\"Name\"]")
	WebElement accName;

	@FindBy(xpath ="//button[@class=\"slds-button slds-button_brand\"]")
	WebElement savebtn;

	@FindBy(xpath = "//lightning-formatted-text[@class=\"custom-truncate\"]")
	WebElement createdAccountName;
	
	@FindBy(xpath="//input[@class=\"slds-combobox__input slds-input\"]")
	WebElement parentaccName;
	
	@FindBy(xpath="(//input[@class=\"slds-combobox__input slds-input slds-combobox__input-value\"])[2]")
	WebElement parentbox;
	
//	@FindBy(xpath="(//div[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left\"]/ul/li)[2]")
//	WebElement selectparentoption;

	@FindBy(xpath="(//ul[@role=\"group\"]/li)[1]")
	WebElement selectparentoption;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickonAccounts() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		search.sendKeys("Accounts");
		Thread.sleep(3000);
		acc.click();
		Thread.sleep(3000);
	}

	public void createNewAccount(String Accountname) throws InterruptedException {
		Thread.sleep(2000);
		newAccount.click();
		Thread.sleep(9000);
		accName.sendKeys(Accountname);
		Thread.sleep(6000);
		savebtn.click();
	}

	public void createChildAccount(String Accountname,String parentName) throws InterruptedException {
		Thread.sleep(2000);
		newAccount.click();
		Thread.sleep(9000);
		accName.sendKeys(Accountname);
		Thread.sleep(6000);
		parentaccName.sendKeys(parentName);
		Thread.sleep(2000);
	//	parentbox.click();
		//parentbox.sendKeys(Keys.ARROW_DOWN);
		selectparentoption.click();
		Thread.sleep(7000);
		savebtn.click();
	}

	public String verifyaccountname() {
		return createdAccountName.getText();
	}

}
