package de.cdor.msc.workloadgeneration.usertype.jpetstore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

/**
 *
 * Representing a user buying lots of fish
 *
 * @author Christoph Dornieden
 *
 */
public class UTBuyCats extends JPetstoreUser {
    private static final String DEFAULT_NAME = "j2ee";
    private static final String DEFAULT_PASSWORD = "j2ee";

    private final List<String> items;

    public UTBuyCats(final String baseUrl) {
        super(baseUrl);

        this.items = new ArrayList<>();
        this.items.add("FL-DSH-01");
        this.items.add("FL-DLH-02");
    }

    @Override
    protected void generateUserBehavior() {
        final int itemsToBuy = 8;
        this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");

        // buy fish
        for (int j = 0; j < itemsToBuy; j++) {
            this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[4]/img")).click();
            this.driver.findElement(By.linkText(this.items.get(0))).click();
            this.driver.findElement(By.linkText("Add to Cart")).click();
        }

        // login
        this.driver.findElement(By.linkText("Sign In")).click();

        // this.driver.findElement(By.id("stripes-1347630246")).clear();
        // this.driver.findElement(By.id("stripes-1347630246")).sendKeys("j2ee");
        // this.driver.findElement(By.name("username")).clear();
        // this.driver.findElement(By.name("password")).sendKeys("j2ee");
        this.driver.findElement(By.name("signon")).click();

        this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[4]/img")).click();

        this.driver.findElement(By.linkText("FL-DSH-01")).click();

        this.driver.findElement(By.xpath("(//a[contains(text(),'Add to Cart')])[2]")).click();

        this.driver.findElement(By.linkText("Proceed to Checkout")).click();

        this.driver.findElement(By.name("newOrder")).click();

        this.driver.findElement(By.linkText("Confirm")).click();

    }

    @Override
    protected void generateRandomizedUserBehavior() {
        final int itemsToBuy = 3 + this.random.nextInt(5);
        this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");

        // buy fish
        for (int j = 0; j < itemsToBuy; j++) {
            if (this.random.nextBoolean()) {
                this.randomAnimalFromCategory(JPetstoreCategory.FISH);
                this.driver.findElement(By.linkText("Add to Cart")).click();

            } else {
                this.driver.findElement(By.cssSelector("#QuickLinks > a > img")).click();
                this.driver.findElement(By.linkText(this.items.get(this.random.nextInt(this.items.size() - 1))))
                        .click();
                this.driver.findElement(By.linkText("Add to Cart")).click();
            }

        }

        // login
        this.driver.findElement(By.linkText("Sign In")).click();

        // this.driver.findElement(By.id("stripes-1347630246")).clear();
        // this.driver.findElement(By.id("stripes-1347630246")).sendKeys("j2ee");
        // this.driver.findElement(By.name("username")).clear();
        // this.driver.findElement(By.name("password")).sendKeys("j2ee");
        this.driver.findElement(By.name("signon")).click();

        this.driver.findElement(By.cssSelector("#QuickLinks > a > img")).click();

        this.driver.findElement(By.linkText("FI-FW-01")).click();

        this.driver.findElement(By.xpath("(//a[contains(text(),'Add to Cart')])[2]")).click();

        this.driver.findElement(By.linkText("Proceed to Checkout")).click();

        this.driver.findElement(By.name("newOrder")).click();

        this.driver.findElement(By.linkText("Confirm")).click();

    }

}
