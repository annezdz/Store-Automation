package pages;

import org.apache.log4j.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base  {

    protected static WebDriver driver;
    protected static Properties properties = new Properties();
    protected static String path = System.getProperty("user.dir");

    protected static Logger log = Logger.getLogger(Base.class);

    public static Logger initializeLogger(Object name) {
        return Logger.getLogger((Class) name);
    }


    public Base() throws IOException {
//        initialize();
        initialize();
        basicConfigurations();
    }

    @Before
    public void initialize() throws IOException {
        if(driver == null) {
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

                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
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
        }
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.navigate().refresh();
//        basicConfigurations();
    }

    @AfterClass
    public static void quit()
    {
        driver.quit();
        driver=null;
    }
    public static void close()
    {
        driver.close();
        driver=null;
    }
    public static void openurl(String URL)
    {
        driver.get(URL);
    }

    @Before
    public static void basicConfigurations() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        System.out.println("TESTE BASIC CONFIGURATIONS");
    }


}
