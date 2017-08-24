package org.iobserve.workloadgeneration.usertype.jpetstore;

import org.openqa.selenium.By;

/**
 * @author Christoph Dornieden
 *
 */
public class UTBuySeperate extends JPetstoreUser {

	public UTBuySeperate(final String baseUrl, final String phantomJSPath, final String screenshotPath) {
		super(baseUrl, phantomJSPath, screenshotPath);
	}

	@Override
	protected void generateUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
		this.driver.findElement(By.cssSelector("img")).click();
		this.login();
		this.driver.findElement(By.cssSelector("#QuickLinks > a > img")).click();
		this.driver.findElement(By.linkText("FI-SW-01")).click();
		this.driver.findElement(By.linkText("Add to Cart")).click();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("newOrder")).click();
		this.driver.findElement(By.linkText("Confirm")).click();
	}

	@Override
	protected void generateRandomizedUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
		this.driver.findElement(By.cssSelector("img")).click();
		this.login();
		this.randomAnimal();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("newOrder")).click();
		this.driver.findElement(By.linkText("Confirm")).click();
		this.driver.findElement(By.cssSelector("#QuickLinks > a > img")).click();
		this.driver.findElement(By.linkText("FI-SW-01")).click();
		this.driver.findElement(By.xpath("(//a[contains(text(),'Add to Cart')])[2]")).click();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("newOrder")).click();
		this.driver.findElement(By.linkText("Confirm")).click();

	}

}
