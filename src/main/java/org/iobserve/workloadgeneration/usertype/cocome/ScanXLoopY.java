package org.iobserve.workloadgeneration.usertype.cocome;

import org.iobserve.workloadgeneration.usertype.AbstractUserType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ScanXLoopY extends AbstractUserType {
	final int scans;
	final int loops;

	public ScanXLoopY(final String baseUrl, final int x, final int y) {
		super(baseUrl);
		this.scans = x;
		this.loops = y;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void generateRandomizedUserBehavior() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void generateUserBehavior() {

		// login
		this.driver.get(this.baseUrl + "/cloud-web-frontend/faces/enterprise/main.xhtml");
		// this.takeScreenshot("login1");
		new Select(this.driver.findElement(By.id("j_idt10"))).selectByVisibleText("Cashier");
		// this.takeScreenshot("login2");
		// this.driver.findElement(By.cssSelector("option[value=\"CASHIER\"]")).click();
		this.driver.findElement(By.name("j_idt21")).clear();
		this.driver.findElement(By.name("j_idt21")).sendKeys("2");
		this.driver.findElement(By.name("j_idt27")).clear();
		this.driver.findElement(By.name("j_idt27")).sendKeys("cashier");
		this.driver.findElement(By.name("j_idt24")).clear();
		this.driver.findElement(By.name("j_idt24")).sendKeys("cashier");
		this.driver.findElement(By.name("j_idt29")).click();

		this.driver.findElement(By.linkText("Cashdesk")).click();
		this.driver.findElement(By.name("j_idt37:j_idt40")).click();

		for (int i = 0; i < this.loops; i++) {
			this.driver.findElement(By.id("j_idt42:barcodetext")).clear();
			this.driver.findElement(By.id("j_idt42:barcodetext")).sendKeys("12345678");
			// scan "scans" times
			for (int j = 0; j < this.scans; j++) {
				this.driver.findElement(By.name("j_idt42:j_idt66")).click();
			}
			// this.takeScreenshot("scanned");
			// pay
			this.driver.findElement(By.id("j_idt42:pay-bar")).click();
			this.driver.findElement(By.name("j_idt42:j_idt53")).clear();
			this.driver.findElement(By.name("j_idt42:j_idt53")).sendKeys("20");
			this.driver.findElement(By.id("j_idt42:pay-sum")).click();
			// this.takeScreenshot("pay");
			if (i < (this.loops - 1)) { // do not click on start in the last iteration
				this.driver.findElement(By.name("j_idt42:j_idt98")).click();
			}

		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
