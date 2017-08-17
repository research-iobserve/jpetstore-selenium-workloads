package org.iobserve.workloadgeneration.usertype.jpetstore;

import org.openqa.selenium.By;

import org.iobserve.workloadgeneration.usertype.jpetstore.JPetstoreUser;

/**
 *
 * Representing a one stop shopper
 * 
 * @author Christoph Dornieden
 *
 */
public class UTFastBuy extends JPetstoreUser {

	public UTFastBuy(String baseUrl) {
		super(baseUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void generateUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
		this.driver.findElement(By.xpath("//div[@id='SidebarContent']/a[4]/img")).click();
		this.driver.findElement(By.linkText("RP-SN-01")).click();
		this.driver.findElement(By.linkText("Add to Cart")).click();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("signon")).click();
		this.driver.findElement(By.name("img_cart")).click();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("newOrder")).click();
		this.driver.findElement(By.linkText("Confirm")).click();
	}

	@Override
	protected void generateRandomizedUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");

		this.randomAnimal();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("signon")).click();

		this.driver.findElement(By.name("img_cart")).click();
		this.driver.findElement(By.linkText("Proceed to Checkout")).click();
		this.driver.findElement(By.name("newOrder")).click();
		this.driver.findElement(By.linkText("Confirm")).click();

	}

}
