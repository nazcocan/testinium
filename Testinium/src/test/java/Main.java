import Models.BasketModel;
import Models.LoginModel;
import Models.ProductModel;
import Models.SearchModel;
import Utilities.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public WebDriver driver;
    public static LoginModel loginModelPage;
    public static SearchModel searchModelPage;
    public static ProductModel productModelPage;
    public static BasketModel basketModelPage;
    protected static String url = "https://www.gittigidiyor.com/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Enter Email and Password
        loginModelPage = new LoginModel(driver,"Enter Mail","Enter Password");
        searchModelPage = new SearchModel(driver);
        productModelPage = new ProductModel(driver);
        basketModelPage = new BasketModel(driver);
    }

    @Test
    public void main()
    {
        Log4j.info("Test starting opening gittigidiyor.com");
        driver.get(url);
        Log4j.info("Login test starting");
        loginModelPage.testLogin();
        Log4j.info("Login successfully");
        searchModelPage.testSearch();
        Log4j.info("2nd page opening successfully");
        productModelPage.testProductModel();
        Log4j.info("Product added to basket successfully");
        new WebDriverWait(driver, 30000);
        basketModelPage.testBasket();
        if (productModelPage.getPrice().equals(basketModelPage.getPrice()))
        {
            Log4j.info("Price comparison successfully");
        }
        basketModelPage.testAmount();
        Log4j.info("Amount increase successfully");
        basketModelPage.delete().click();
        Log4j.info("Delete operation successfully");
    }
    @After
    public void endTest() {
        Log4j.info("Test closing");
        driver.quit();
    }

}
