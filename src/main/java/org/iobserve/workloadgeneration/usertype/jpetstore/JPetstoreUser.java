package org.iobserve.workloadgeneration.usertype.jpetstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.iobserve.workloadgeneration.usertype.AbstractUserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Christoph Dornieden
 *
 */
public abstract class JPetstoreUser extends AbstractUserType {

    public JPetstoreUser(final String baseUrl, final String phantomJSPath, final String screenshotPath) {
        super(baseUrl, phantomJSPath, screenshotPath);
    }

    protected void randomAnimal() {
        this.randomCategory();
        this.randomElementFromTable();
        this.randomElementFromTable();
    }

    protected void randomAnimalFromCategory(final JPetstoreCategory category) {
        this.category(category);
        this.randomElementFromTable();
        this.randomElementFromTable();
    }

    protected void randomCategory() {

        final List<JPetstoreCategory> categories = new ArrayList<>();
        categories.add(JPetstoreCategory.BIRD);
        categories.add(JPetstoreCategory.CAT);
        categories.add(JPetstoreCategory.DOG);
        categories.add(JPetstoreCategory.REPTILE);
        categories.add(JPetstoreCategory.FISH);

        this.category(categories.get(this.random.nextInt(categories.size())));
    }

    protected void category(final JPetstoreCategory category) {
        switch (category) {
        case BIRD:
            this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[5]/img")).click();
            break;
        case CAT:
            this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[4]/img")).click();
            break;
        case DOG:
            this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[2]/img")).click();
            break;

        case FISH:
            this.driver.findElement(By.cssSelector("#SidebarContent > a > img")).click();
            break;

        case REPTILE:
            this.driver.findElement(By.xpath("//div[@id='QuickLinks']/a[3]/img")).click();
            break;
        default:
        }
    }

    protected void randomElementFromTable() {
        final Random random = new Random();
        final List<WebElement> elems = this.driver.findElements(By.xpath("//td/a[contains(@href,*) and not(@class)]"));

        // TODO DEBUG elems.stream().map(WebElement::getText).forEach(System.out::println);

        elems.get(random.nextInt(elems.size())).click();
    }

    protected void login(final String username, final String password) {
        this.driver.findElement(By.linkText("Sign In")).click();
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys(username);
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys(password);
        this.driver.findElement(By.name("signon")).click();
    }

    protected void checkout(final WebDriver driver) {
        driver.findElement(By.name("img_cart")).click();
        driver.findElement(By.linkText("Proceed to Checkout")).click();
        driver.findElement(By.name("newOrder")).click();
        driver.findElement(By.linkText("Confirm")).click();
    }

}
