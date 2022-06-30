package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {


    protected static WebDriver driver;
    protected static Properties properties;
    protected static String path = System.getProperty("user.dir");

    protected static Logger log = Logger.getLogger(Base.class);

    public static Logger initializeLogger(Object name) {
        return Logger.getLogger((Class) name);
    }

    public WebDriver selectBrowser() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/data.properties");
        properties.load(fileInputStream);

        String browser = properties.getProperty("browser");

        switch (browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
//                DesiredCapabilities caps = new DesiredCapabilities();
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", path);
                chromePrefs.put("excludeSwitches", List.of("disable-popup-blocking"));

                //options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
                //caps.setCapability(ChromeOptions.CAPABILITY,options);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);

                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                log.info("Chrome Browser Initialized");
                break;
            }
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile customProfile = profile.getProfile("SeleniumProfile");
                customProfile.setPreference("dom.disable_beforeunload", true);
                customProfile.setPreference("browser.download.manager.closeWhenDone", true);
                customProfile.setPreference("browser.download.folderList", 1);

                driver = new FirefoxDriver((Capabilities) customProfile);
                log.info("Firefox Browser Initialized");
                break;
            }
            case "opera": {
                System.setProperty("webdriver.opera.driver", "src/main/resources/drivers/operadriver3.exe");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                OperaOptions options = new OperaOptions();
                options.setBinary("src/main/resources/drivers/operadriver3.exe");
                capabilities.setCapability(OperaOptions.CAPABILITY, options);
                log.info("Opera Browser Initialized");
                driver = new OperaDriver();
                break;
            }
//            case "ie" : {
//                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//                System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/iedriver.exe");
//                driver = new InternetExplorerDriver(capabilities);
//                break;
//            }
            case "edge": {
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                log.info("Edge Browser Initialized");
                break;
            }
            default: {
                System.out.println("Incorrect browser. Please choice" +
                        "edge, firefox, ie, opera e chrome.");
            }
        }
        return driver;
    }

    public void initializeDriver() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }
}
