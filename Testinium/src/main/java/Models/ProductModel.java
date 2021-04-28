package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductModel {
    private String price;
    private WebDriver driver;
    JavascriptExecutor jse;

    public ProductModel(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    private WebElement passDetail(){return driver.findElement(By.xpath("//li[@product-index='4']")); }
    private WebElement addToBasket(){
        return driver.findElement(By.id("add-to-basket"));
    }
    private WebElement getProductPrice(){
        return driver.findElement(By.id("sp-price-discountPrice"));
    }


    public void testProductModel()
    {
        passDetail().click();
        setPrice(getProductPrice().getText());
        jse.executeScript("arguments[0].scrollIntoView()", addToBasket());
        addToBasket().click();


    }
}
