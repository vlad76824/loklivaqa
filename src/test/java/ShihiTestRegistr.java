import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;



import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ShihiTestRegistr {


    @Test
    public void opengethabhomwork() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);







            // Открываем главную страницу GitHub
            driver.get("https://github.com/search?q=&type=repositories");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            // Находим поле ввода поиска
        WebElement element = driver.findElement(By.className("UnstyledTextInput__ToggledUnstyledTextInput-sc-14ypya-0"));

            // Вводим запрос в строку поиска
            String query = "Manish-Jn/Repo50";
            element.click();
            element.sendKeys(query);
            actions.moveToElement(element).sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);
         WebElement rezult = driver.findElement(By.className(".Text__StyledText-sc-17v1xeu-0 dafPaR"));

      //  String rezulString= rezult.getText();
//String actualText="1";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Это ваше сообщение: " + "Э" + "');");
      //   assertTrue("Тест прошел успешно: значения верны", actualText.equals(rezulString));


        // Вывести сообщение на экране браузера через alert



    }
}



/*
    @Test
    public void openPageUserMenuRegist(){
            WebDriver driver = new ChromeDriver();
      //  ci_session=b9d48059a6307fbb0a66e43de0b51dbcd12772e9;
     //   Path=/; HttpOnly; Expires=Sun, 10 Nov 2024 01:31:22 GMT;

            driver.get("https://shishi.co.il/auth/create_user");
            Cookie cookie = new Cookie("ci_session","0f2e347ebf24815a31ba8de17ef342c039515fdd");
            driver.manage().addCookie(cookie);
            driver.navigate().refresh();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    // вод для работы с уже имеющимеся данными логина и пароля
    public void openPageUserMenu(){
        WebDriver driver = new ChromeDriver();
        //  ci_session=b9d48059a6307fbb0a66e43de0b51dbcd12772e9;
        //   Path=/; HttpOnly; Expires=Sun, 10 Nov 2024 01:31:22 GMT;

        driver.get("https://shishi.co.il/auth/login");
        Cookie cookie = new Cookie("ci_session","594aef66f7b17166edc4ae909423e9e3508bec8c");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

