
/*Otići na kupujemprodajem.com, u pretragu ukucati iphone 13, kliknuti na prvi rezultat.
Proveriti da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //naslov pronadjenog rezultata prilikom izvodjenja manuelnog testa
        String titleMTC = "iPhone 13, iPhone 12, iPhone 11 - NOVO!";

        //1. otici na sajt
        driver.get("https://www.kupujemprodajem.com/");

        //2.zatvoriti iskacuci prozor na x ako se pojavi
        WebElement element = driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
        if(element.isDisplayed() && element.isEnabled()){
            element.click();
        }

        //3.kliknuti u polje za pretragu
        WebElement element1 = driver.findElement(By.id("searchKeywordsInput"));

        //4.upisati iphone13
        element1.sendKeys("iphone13");

        //5.enter
        element1.sendKeys(Keys.ENTER);

        //6.kliknuti na prvi rezultat pretrage
            WebElement element2 = driver.findElement(By.xpath
                    ("//*[@id=\"adDescription103865646\"]/div/section[2]/div[1]/div[1]/a"));
            element2.click();

        //7.uzeti naslov rezultata
        String resultTitle = driver.getTitle();

        //8.uporediti sa ocekivanim naslovom rezultata
        if(resultTitle.equals(titleMTC)){
            System.out.println("TC valid. Title is the same.");
        }else{
            System.out.println("TC invalid. Title is not the same.");
        }



    }
}
