package de.cdor.msc.workloadgeneration.usertype.jpetstore;

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

    public UTGotLink(String baseUrl) {
        super(baseUrl);
        this.items = new ArrayList<>();

        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-6");
        this.items.add("jpetstore/actions/Catalog.action?viewItem=&itemId=EST-3");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-9");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-8");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-13");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-14");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-15");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-17");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-16");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-3");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-5");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-18");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-19");
        this.items.add("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-1");
    }

    @Override
    protected void generateRandomizedUserBehavior() {
        this.driver.get(this.items.get(this.random.nextInt(this.items.size() - 1)));

    }

    @Override
    protected void generateUserBehavior() {
        this.driver.get("/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-6");
    }

}
