package org.iobserve.workloadgeneration.usertype.jpetstore;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class UTAccountManager extends JPetstoreUser {

	public UTAccountManager(final String baseUrl, final String phantomJSPath, final String screenshotPath) {
		super(baseUrl, phantomJSPath, screenshotPath);
	}

	@Override
	protected void generateRandomizedUserBehavior() {
		this.generateUserBehavior();

	}

	@Override
	protected void generateUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
		this.driver.findElement(By.cssSelector("img")).click();
		this.driver.findElement(By.linkText("Sign In")).click();
		this.driver.findElement(By.name("signon")).click();
		this.driver.findElement(By.linkText("My Account")).click();
		this.driver.findElement(By.name("account.firstName")).clear();
		this.driver.findElement(By.name("account.firstName")).sendKeys("OOOO");
		this.driver.findElement(By.name("account.lastName")).clear();
		this.driver.findElement(By.name("account.lastName")).sendKeys("LLLL");
		new Select(this.driver.findElement(By.name("account.favouriteCategoryId"))).selectByVisibleText("REPTILES");
		this.driver.findElement(By.name("account.listOption")).click();
		this.driver.findElement(By.name("editAccount")).click();
		this.driver.findElement(By.linkText("My Orders")).click();
		this.driver.findElement(By.linkText("1000")).click();

	}

}
