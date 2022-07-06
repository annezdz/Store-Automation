package runners;

import org.junit.After;
import pages.Base;

public abstract class BaseRunner {

    @After
    public void tearDown() {
        System.out.println("Close browser");
        Base.quit();
    }
}
