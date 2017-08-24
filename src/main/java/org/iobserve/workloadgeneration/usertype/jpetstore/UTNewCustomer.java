package org.iobserve.workloadgeneration.usertype.jpetstore;

import java.util.Random;

import org.openqa.selenium.By;

public class UTNewCustomer extends JPetstoreUser {

    public UTNewCustomer(final String baseUrl, final String phantomJSPath, final String screenshotPath) {
        super(baseUrl, phantomJSPath, screenshotPath);
    }

    @Override
    protected void generateRandomizedUserBehavior() {
        this.generateUserBehavior();

    }

    @Override
    protected void generateUserBehavior() {
        final char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int i = 0; i < 20; i++) {
            final char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        final String id = sb.toString();
        this.driver.get(this.baseUrl + "/jpetstore/actions/Catalog.action");
        this.driver.findElement(By.linkText("Sign In")).click();
        this.driver.findElement(By.linkText("Register Now!")).click();
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys(id);
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys(id);
        this.driver.findElement(By.name("repeatedPassword")).clear();
        this.driver.findElement(By.name("repeatedPassword")).sendKeys(id);
        this.driver.findElement(By.name("account.firstName")).clear();
        this.driver.findElement(By.name("account.firstName")).sendKeys("Mister " + id);
        this.driver.findElement(By.name("account.lastName")).clear();
        this.driver.findElement(By.name("account.lastName")).sendKeys("Mister " + id);
        this.driver.findElement(By.name("account.email")).clear();
        this.driver.findElement(By.name("account.email")).sendKeys(id + "@example.com");
        this.driver.findElement(By.name("account.phone")).clear();
        this.driver.findElement(By.name("account.phone")).sendKeys("110");
        this.driver.findElement(By.name("account.address1")).clear();
        this.driver.findElement(By.name("account.address1")).sendKeys("streeet 42");
        this.driver.findElement(By.name("account.city")).clear();
        this.driver.findElement(By.name("account.city")).sendKeys("city");
        this.driver.findElement(By.name("account.state")).clear();
        this.driver.findElement(By.name("account.state")).sendKeys("state");
        this.driver.findElement(By.name("account.zip")).clear();
        this.driver.findElement(By.name("account.zip")).sendKeys("42");
        this.driver.findElement(By.name("account.country")).clear();
        this.driver.findElement(By.name("account.country")).sendKeys("de");
        this.takeScreenshot("register");
        this.driver.findElement(By.name("newAccount")).click();

        this.driver.findElement(By.linkText("Sign In")).click();
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys(id);
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys(id);
        this.driver.findElement(By.name("signon")).click();
        this.driver.findElement(By.xpath("//div[@id='SidebarContent']/a[4]/img")).click();
        this.driver.findElement(By.linkText("RP-SN-01")).click();
        this.driver.findElement(By.linkText("Add to Cart")).click();
        this.driver.findElement(By.linkText("Proceed to Checkout")).click();
        this.driver.findElement(By.name("newOrder")).click();
        this.driver.findElement(By.linkText("Confirm")).click();
    }

}
