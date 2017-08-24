package org.iobserve.workloadgeneration.usertype;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class AbstractUserType {

    protected final String baseUrl;
    protected PhantomJSDriver driver;
    protected final Random random;
    private final String screenshotPath;
    private final String phantomJsPath;

    public AbstractUserType(final String baseUrl, final String phantomJSPath, final String streenshotPath) {
        this.baseUrl = baseUrl;
        this.phantomJsPath = phantomJSPath;
        this.screenshotPath = streenshotPath;

        this.random = new Random();
        this.createNewDriver();
    }

    public void generateUserBehavior(final int numberOfUserInstances) {
        for (int i = 0; i < numberOfUserInstances; i++) {
            this.generateUserBehavior();
            this.driver.quit();
            this.createNewDriver();
        }
    };

    public void generateRandomizedUserBehavior(final int numberOfUserInstances) {

        for (int i = 0; i < numberOfUserInstances; i++) {
            this.generateRandomizedUserBehavior();
            this.driver.quit();
            this.createNewDriver();
        }
    };

    protected abstract void generateRandomizedUserBehavior();

    protected abstract void generateUserBehavior();

    protected void createNewDriver() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, this.phantomJsPath);
        capabilities.setCapability("acceptSslCerts", true);
        capabilities.setCapability("webSecurityEnabled", false);
        final String[] phantomJsArgs = { "--web-security=no", "--ignore-ssl-errors=yes" };
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
        this.driver = new PhantomJSDriver(capabilities);
        // this.driver.setLogLevel(Level.INFO);
        // this.driver = new HtmlUnitDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(800, 600));
    }

    protected void takeScreenshot(final String filename) {
        try {
            final File screenshot = this.driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(this.screenshotPath + filename + ".png"));
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
