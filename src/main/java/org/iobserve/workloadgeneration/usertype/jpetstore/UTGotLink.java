package org.iobserve.workloadgeneration.usertype.jpetstore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Representing a user following an item link and leaving the page
 *
 * @author Christoph Dornieden
 *
 */
public class UTGotLink extends JPetstoreUser {
    private final List<String> items;

    public UTGotLink(final String baseUrl, final String phantomJSPath, final String screenshotPath) {
        super(baseUrl, phantomJSPath, screenshotPath);
        this.items = new ArrayList<>();

        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-6");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-3");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-9");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-8");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-13");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-14");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-15");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-17");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-16");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-3");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-5");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-18");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-19");
        this.items.add("/actions/Catalog.action?viewItem=&itemId=EST-1");
    }

    @Override
    protected void generateRandomizedUserBehavior() {
        this.driver.get(this.items.get(this.random.nextInt(this.items.size() - 1)));

    }

    @Override
    protected void generateUserBehavior() {
        this.driver.get("/actions/Catalog.action?viewItem=&itemId=EST-6");
    }

}
