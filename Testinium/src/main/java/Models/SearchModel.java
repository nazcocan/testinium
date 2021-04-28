package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.Log4j;

public class SearchModel {
    public WebDriver driver;
    JavascriptExecutor jse;

    public SearchModel(WebDriver driver) {
        this.driver=driver;
        jse = (JavascriptExecutor) driver;
    }
    private WebElement searchBox() {
        return driver.findElement(By.xpath("//input[@name='k']"));
    }
    private WebElement searchButton(){
        return driver.findElement(By.cssSelector(".hKfdXF"));
    }
    private WebElement passSecondPage(){
        return driver.findElement(By.xpath("//a[@href='/arama/?k=bilgisayar&sf=2']"));
    }

    public void testSearch()
    {
        searchBox().clear();
        searchBox().sendKeys("bilgisayar");
        searchButton().click();
        Log4j.info("Searched successfull ");
        jse.executeScript("arguments[0].scrollIntoView()", passSecondPage());
        passSecondPage().click();

    }


}
