package org.iobserve.workloadgeneration;

import java.util.ArrayList;
import java.util.List;

import org.iobserve.workloadgeneration.usertype.AbstractUserType;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTAccountManager;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTBuyCats;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTBuyFish;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTBuySeperate;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTFastBuy;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTJustNavigate;
import org.iobserve.workloadgeneration.usertype.jpetstore.UTNewCustomer;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.IntegerConverter;

/**
 * Generate Workload for Website
 *
 * @author Christoph Dornieden
 */
public class WorkloadGeneration {

	// private static final String PHANTOM_JS_PATH =
	// "/usr/lib/node_modules/phantomjs/bin/phantomjs";
	// private static final String PHANTOM_JS_PATH =
	// "/home/reiner/node_modules/phantomjs/lib/phantom/bin/phantomjs";

	@Parameter(names = { "-b", "--base-url" }, description = "URL to the JPetStore", required = true)
	private String baseUrl;

	@Parameter(names = { "-i",
			"--iterations" }, description = "Iterations of the behavior mix", required = true, converter = IntegerConverter.class)
	private Integer iterations;

	@Parameter(names = { "-s", "--screenshot-path" }, description = "Path for screenshots", required = true)
	private String screenshotPath;

	@Parameter(names = { "-p", "--phantom-js" }, description = "Path to PhantomJS executable", required = true)
	private String phantomJSPath;

	public static void main(final String[] args) {
		final WorkloadGeneration workloadGeneration = new WorkloadGeneration();
		final JCommander commander = new JCommander(workloadGeneration);
		try {
			commander.parse(args);
			workloadGeneration.execute(commander);
		} catch (final ParameterException e) {
			System.err.println(e.getLocalizedMessage());
			commander.usage();
		}
	}

	private void execute(final JCommander commander) {
		// add users
		final List<AbstractUserType> users = new ArrayList<>();
		//
		users.add(new UTBuyFish(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		users.add(new UTBuyCats(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		users.add(new UTBuySeperate(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		users.add(new UTAccountManager(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		users.add(new UTFastBuy(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		// // // users.add(new UTGotLink(baseUrl, phantomJSPath,
		// screenshotPath));
		users.add(new UTNewCustomer(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		users.add(new UTJustNavigate(this.baseUrl, this.phantomJSPath, this.screenshotPath));
		// users.add(new UTNeverCheckout(this.baseUrl, phantomJSPath,
		// this.screenshotPath));

		// generateWorkload
		users.stream().forEach(user -> {
			System.out.println(user.getClass().toString());
			user.generateUserBehavior(this.iterations);
		});
		System.out.println("Finished");
	}
}
