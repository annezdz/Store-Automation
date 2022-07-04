//package stepDefinitions;
//
//import org.junit.After;
//import org.junit.Before;
//import pages.Base;
//
//import java.io.IOException;
//
//public class Hooks extends Base  {
//
//
//    public Hooks() throws IOException {
//    }
//
//    @Before
//    public void initDriver() throws IOException {
//        System.out.println("Open Browser");
//        Base.initialize();
//        Base.basicConfigurations();
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("Close browser");
//        Base.quit();
//    }
//}
