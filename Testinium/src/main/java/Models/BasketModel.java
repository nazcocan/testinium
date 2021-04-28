package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasketModel {
    String price;
    String amount;
    private WebDriver driver;

    public BasketModel(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    private WebElement getBasketPrice(){
        return driver.findElement(By.className("new-price"));
    }
    private WebElement increaseAmount(){return driver.findElement(By.xpath("//*[@class='amount']")); }
    private void goToBasket(){driver.get( "https://www.gittigidiyor.com/sepetim");}

    public WebElement delete(){
        return driver.findElement(By.xpath("//*[@class='btn-delete btn-update-item']"));
    }

    public void testBasket()
    {
        goToBasket();
        setPrice(getBasketPrice().getText());
    }
    public void testAmount()
    {
        Select amount = new Select(increaseAmount());
        amount.selectByVisibleText("2");
        amount.selectByValue("2");
    }
   }
