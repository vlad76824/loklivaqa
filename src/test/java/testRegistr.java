import org.eclipse.sisu.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


public class testRegistr {

    WebElement first_name;
    WebElement last_name  ;
    WebElement birthdate  ;
    WebElement aliya_year  ;
    WebElement email ;
    WebElement password  ;
    WebElement password_confirm  ;
    WebElement phone  ;
    Select select  ;
    WebElement teuda  ;
    WebElement registerButton  ;
    WebElement successMessage  ;
    WebDriver driver = new ChromeDriver();



    @Feature("Регистрация")
    @Story("Регистрация нового пользователя")

    @Description("Проверка не успешной регистрации  ")
    @Step("Открытие страницы регистрации")

    public void Elements(String linh) {

        driver.get(linh);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
     first_name = driver.findElement(By.id("first_name"));
     last_name = driver.findElement(By.id("last_name"));
     birthdate = driver.findElement(By.id("birthdate"));
     aliya_year = driver.findElement(By.id("aliya_year"));
     email = driver.findElement(By.id("email"));
     password = driver.findElement(By.id("password"));
     password_confirm = driver.findElement(By.id("password_confirm"));
     phone = driver.findElement(By.id("phone"));
     select = new Select(driver.findElement(By.name("sex")));
     teuda = driver.findElement(By.id("teuda"));
         registerButton = driver.findElement(By.cssSelector(".col-sm-offset-3.col-sm-8 .button.gradient"));


    }

    @Step("Заполнение формы регистрации: {name}, {email}, {password}")

    @Test
    public void testUserRegistration() {


        Elements("https://shishi.co.il/auth/create_user/");

        first_name.sendKeys("TestUser");
        last_name.sendKeys("TestUser_!");
        birthdate.sendKeys("2024-11-05");
        aliya_year.sendKeys("1997");
        email.sendKeys("Vlassssssss@gmail.com");
        password.sendKeys("22222222");
        password_confirm.sendKeys("22222222");
        phone.sendKeys("23536134123123");
        select.selectByValue("2");
        teuda.sendKeys("3456789");

        registerButton.click();


        successMessage = driver.findElement(By.id("infoMessage"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Аккаунт \"Email\" уже зарегистрирован на нашем сайте, если вы не помните пароль, то его можно сбросить";

        assertTrue("Текст сообщения не совпадает с ожидаемым", actualMessage.contains(expectedMessage));


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUserRegistration_positiv() {


        Elements("https://shishi.co.il/auth/create_user/");

        first_name.sendKeys("TestUser");
        last_name.sendKeys("TestUser_!");
        birthdate.sendKeys("2024-11-05");
        aliya_year.sendKeys("1997");
        email.sendKeys("Vlassssssss552443123@gmail.com");
        password.sendKeys("22222222");
        password_confirm.sendKeys("22222222");
        phone.sendKeys("23536134123123");
        select.selectByValue("2");
        teuda.sendKeys("3456789");

        registerButton.click();


        successMessage = driver.findElement(By.id("infoMessage"));
        String expectedUrl = "https://shishi.co.il/auth/login/r";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("Не удалось перейти на целевую страницу", actualUrl.equals(expectedUrl));


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



//first_name.sendKeys("TestUser");first_name.sendKeys("TestUser");first_name.sendKeys("TestUser");first_name.sendKeys("TestUser");first_name.sendKeys("TestUser");git commit -m "Описание изменений"


