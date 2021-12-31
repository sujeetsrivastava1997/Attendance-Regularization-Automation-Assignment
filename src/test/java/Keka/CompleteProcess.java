package Keka;

import lib.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CompleteProcess {

    //.....Making WebDriver's global variable.....//
    WebDriver driver;


    //.....Getting data from Excel sheet.....//
    @DataProvider(name = "wordpressData")

    public Object[][] passData() {

        ExcelDataConfig config = new ExcelDataConfig("TestingData/tdata.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            data[i][0] = config.getData(0, i, 0);
            data[i][1] = config.getData(0, i, 1);
        }
        return data;

}
    //
    /*This chromeBrowser method will open chrome browser and all automated test scripts will be executed in chrome browser*/
    //
    @Test(dataProvider = "wordpressData")
    public void chromeBrowser(String username, String password) throws InterruptedException {
        System.out.println(username);
        System.out.println(password);

        //.....Providing path of chromedriver.....//
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver_linux64/chromedriver");

        //.....Using Headless chrome browser.....//           /*IMPORTANT*/
        //ChromeOptions options = new ChromeOptions(); /*To run script in headless browser ,you need to uncomment headless browser part and give "options" parameter in driver = new ChromeDriver();*/
        //options.addArguments("--headless");

        //.....Opening browser.....//
        driver = new ChromeDriver();

        //.....Maximizing the browser window.....//
        driver.manage().window().maximize();

        //.....Providing implicit wait.....//
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //.....Opening KEKA landing page.....//
        driver.get("https://app.keka.com/Account/Login");

        //.....Step by step locating the elements and doing required operations.....//
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"login-container-center\"]/div/div/form/div/div[2]/div/button")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.cssSelector("body.nyoS7c.UzCXuf.EIlDfe:nth-child(2) div.H2SoFe.LZgQXe.TFhTPc:nth-child(1) div.RAYh1e.LZgQXe div.xkfVF div.Aa1VU div.JhUD8d.SQNfcc.vLGJgb div.zWl5kd div.DRS7Fe.bxPAYd.k6Zj8d div.pwWryf.bxPAYd:nth-child(2) div.Wxwduf.Us7fWe.JhUD8d div.zQJV3 div.dG5hZc div.qhFLie div.FliLIb.DL0QTb div.VfPpkd-dgl2Hf-ppHlrf-sM5MNb button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc.lw1w4b > span.VfPpkd-vQzf8d")).click();
        driver.findElement(By.cssSelector("body.nyoS7c.UzCXuf.EIlDfe:nth-child(2) div.H2SoFe.LZgQXe.TFhTPc:nth-child(1) div.RAYh1e.LZgQXe div.xkfVF div.Aa1VU div.JhUD8d.SQNfcc.vLGJgb div.zWl5kd div.DRS7Fe.bxPAYd.k6Zj8d div.pwWryf.bxPAYd:nth-child(2) div.Wxwduf.Us7fWe.JhUD8d div.WEQkZc div.bCAAsb:nth-child(2) section.aTzEhb div.CxRgyd div.SdBahf.VxoKGd:nth-child(3) div.eEgeR div.W498nc div.fdWl7b div.hDp5Db div.rFrNMe.ze9ebf.YKooDc.q9Nsuf.zKHdkd.sdJrJc div.aCsJod.oJeWuf div.aXBtI.Wic03c div.Xb9hP > input.whsOnd.zHQkBf")).sendKeys(password);
        driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"accordion\"]/li[2]/a/span[2]")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/xhr-left-nav[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Attendance')]")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/employee-me[1]/div[1]/employee-attendance[1]/div[1]/div[1]/div[1]/div[1]/employee-attendance-logs[1]/div[1]/employee-attendance-list-view[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.linkText("Regularize")).click();
        driver.findElement(By.xpath("//button[contains(text(),'+Add Log')]")).click();
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("09:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("18:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[3]/div[1]/textarea[1]")).sendKeys("regularize today's attendance.");
        driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();
    }



    //
    /*This firefoxBrowser method will open firefox browser and all automated test scripts will be executed in firefox browser*/
    //
    @Test(dataProvider = "wordpressData")
    public void fireFoxBrowser(String username, String password) throws InterruptedException {
        System.out.println(username);
        System.out.println(password);

        //.....Providing path of chromedriver.....//
        System.setProperty("webdriver.gecko.driver", "src/test/geckodriver-v0.30.0-linux64/geckodriver");

        //.....Using Headless firefox browser.....//      /*IMPORTANT*/
        //FirefoxOptions options = new FirefoxOptions();  /*To run script in headless browser ,you need to uncomment headless browser part and give "options" parameter in driver = new FirefoxDriver();*/
        //options.addArguments("--headless");

        //.....Opening browser.....//
        driver = new FirefoxDriver();

        //.....Maximizing the browser window.....//
        driver.manage().window().maximize();

        //.....Providing implicit wait.....//
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //.....Opening KEKA landing page.....//
        driver.get("https://app.keka.com/Account/Login");

        //.....Step by step locating the elements and doing required operations.....//
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"login-container-center\"]/div/div/form/div/div[2]/div/button")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.cssSelector("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
        driver.findElement(By.cssSelector("body.nyoS7c.UzCXuf.EIlDfe:nth-child(2) div.H2SoFe.LZgQXe.TFhTPc:nth-child(1) div.RAYh1e.LZgQXe div.xkfVF div.Aa1VU div.JhUD8d.SQNfcc.vLGJgb div.zWl5kd div.DRS7Fe.bxPAYd.k6Zj8d div.pwWryf.bxPAYd:nth-child(2) div.Wxwduf.Us7fWe.JhUD8d div.WEQkZc div.bCAAsb:nth-child(2) section.aTzEhb div.CxRgyd div.SdBahf.VxoKGd:nth-child(3) div.eEgeR div.W498nc div.fdWl7b div.hDp5Db div.rFrNMe.ze9ebf.YKooDc.q9Nsuf.zKHdkd.sdJrJc div.aCsJod.oJeWuf div.aXBtI.Wic03c div.Xb9hP > input.whsOnd.zHQkBf")).sendKeys(password);
        driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"accordion\"]/li[2]/a/span[2]")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/xhr-left-nav[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Attendance')]")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/employee-me[1]/div[1]/employee-attendance[1]/div[1]/div[1]/div[1]/div[1]/employee-attendance-logs[1]/div[1]/employee-attendance-list-view[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.linkText("Regularize")).click();
        driver.findElement(By.xpath("//button[contains(text(),'+Add Log')]")).click();
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("09:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("18:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[3]/div[1]/textarea[1]")).sendKeys("regularize today's attendance.");
        driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();
    }

    //.....This tearDown function closes the browser after all tests got executed.....//
    @AfterTest
    public void tearDown() {
        driver.close();

    }
}
