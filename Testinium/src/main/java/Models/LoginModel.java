package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModel {
    private String email ;
    private  String password ;
    public WebDriver driver;

    public LoginModel(WebDriver webDriver,String email, String password) {
        this.driver = webDriver;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private WebElement emailBox() {
        return driver.findElement(By.id("L-UserNameField"));
    }
    private WebElement passwordBox() { return driver.findElement(By.id("L-PasswordField")); }
    private WebElement loginButton() {
        return driver.findElement(By.id("gg-login-enter"));
    }

    public void testLogin()
    {
        driver.get("https://www.gittigidiyor.com/uye-girisi");
        emailBox().clear();
        emailBox().sendKeys(getEmail());
        passwordBox().clear();
        passwordBox().sendKeys(getPassword());
        loginButton().click();
    }
}
