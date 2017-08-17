package org.iobserve.workloadgeneration.usertype.jpetstore;

import org.iobserve.workloadgeneration.usertype.AbstractUserType;
import org.openqa.selenium.By;

/**
 * Representing a user just navigating the page without buying anything
 *
 * @author Christoph Dornieden
 *
 */
public class UTJustNavigate extends AbstractUserType {

	public UTJustNavigate(String baseUrl) {
		super(baseUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void generateUserBehavior() {
		this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
		this.driver.findElement(By.cssSelector("img")).click();
		// browse fishes

		// browses reptiles
		this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[3]/img")).click();
		this.driver.findElement(By.linkText("RP-SN-01")).click();
		this.driver.findElement(By.linkText("EST-12")).click();
		this.driver.findElement(By.linkText("Return to RP-SN-01")).click();
		this.driver.findElement(By.linkText("EST-12")).click();
		this.driver.findElement(By.linkText("Return to RP-SN-01")).click();
		// browse fishes
		this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
		this.driver.findElement(By.linkText("AV-CB-01")).click();
		this.driver.findElement(By.linkText("EST-18")).click();
		this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
		this.driver.findElement(By.linkText("AV-SB-02")).click();
		this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
		this.driver.findElement(By.linkText("AV-SB-02")).click();
		this.driver.findElement(By.linkText("EST-19")).click();
		this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
		this.driver.findElement(By.linkText("AV-SB-02")).click();
		this.driver.findElement(By.linkText("EST-19")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("dog");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.linkText("Friendly dog from England")).click();
		this.driver.findElement(By.linkText("EST-7")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("ape");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("hamster");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("fish");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.linkText("Fresh Water fish from China")).click();
		this.driver.findElement(By.linkText("EST-21")).click();

	}

	@Override
	protected void generateRandomizedUserBehavior() {
		this.navigateToRandomAnimalProfile();
		this.navigateToRandomAnimalProfile();
		this.navigateToRandomAnimalProfile();
		this.navigateToRandomAnimalProfile();
		this.navigateToRandomAnimalProfile();

		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("dog");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.linkText("Friendly dog from England")).click();
		this.driver.findElement(By.linkText("EST-7")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("ape");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("hamster");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.name("keyword")).clear();
		this.driver.findElement(By.name("keyword")).sendKeys("fish");
		this.driver.findElement(By.name("searchProducts")).click();
		this.driver.findElement(By.linkText("Fresh Water fish from China")).click();
		this.driver.findElement(By.linkText("EST-21")).click();
	}

	private void navigateToRandomAnimalProfile() {

		switch (this.random.nextInt(3)) {
		case 0:
			this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
			this.driver.findElement(By.linkText("AV-CB-01")).click();
			this.driver.findElement(By.linkText("EST-18")).click();
			break;
		case 1:
			this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
			this.driver.findElement(By.linkText("AV-SB-02")).click();
			this.driver.findElement(By.linkText("EST-19")).click();
			break;
		case 2:
			this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[3]/img")).click();
			this.driver.findElement(By.linkText("RP-SN-01")).click();
			this.driver.findElement(By.linkText("EST-12")).click();
			break;
		default:
			this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
			this.driver.findElement(By.linkText("AV-SB-02")).click();
		}

	}

}
