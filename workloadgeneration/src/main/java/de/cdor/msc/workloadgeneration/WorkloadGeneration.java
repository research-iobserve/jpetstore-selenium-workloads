package de.cdor.msc.workloadgeneration;

import java.util.ArrayList;
import java.util.List;

import de.cdor.msc.workloadgeneration.usertype.AbstractUserType;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTAccountManager;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTBuyCats;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTBuyFish;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTBuySeperate;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTFastBuy;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTGotLink;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTJustNavigate;
import de.cdor.msc.workloadgeneration.usertype.jpetstore.UTNewCustomer;

/**
 * Generate Workload for Website
 *
 * @author Christoph Dornieden
 */
public class WorkloadGeneration {
    public static final String DEFAULT_SITE = "http://172.17.0.2:8080";
    public static final int DEFAULT_RUNS = 20;

    public static void main(final String[] args) {
        final String baseUrl = WorkloadGeneration.DEFAULT_SITE;
        final int runs = WorkloadGeneration.DEFAULT_RUNS;

        // add users
        final List<AbstractUserType> users = new ArrayList<>();
        //
        users.add(new UTBuyFish(baseUrl));
        users.add(new UTBuyCats(baseUrl));
        users.add(new UTBuySeperate(baseUrl));
        users.add(new UTAccountManager(baseUrl));
        users.add(new UTFastBuy(baseUrl));
        users.add(new UTGotLink(baseUrl));
        users.add(new UTNewCustomer(baseUrl));
        users.add(new UTJustNavigate(baseUrl));

        // users.add(new UTNeverCheckout(baseUrl));

        // users.add(new ScanXLoopY(baseUrl, 1, 8));
        // users.add(new ScanXLoopY(baseUrl, 8, 1));
        // users.add(new ScanXLoopY(baseUrl, 4, 4));
        // users.add(new ScanXLoopY(baseUrl, 8, 8));

        // generateWorkload
        users.stream().forEach(user -> {
            System.out.println(user.getClass().toString());
            user.generateUserBehavior(runs);
        });
        System.out.println("Finished");

    }
}