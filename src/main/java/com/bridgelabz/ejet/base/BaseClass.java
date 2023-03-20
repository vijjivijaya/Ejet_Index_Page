package com.bridgelabz.ejet.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;

    public BaseClass() throws IOException {
        prop = new Properties();
        FileInputStream ip;
        ip = new FileInputStream(
                "src/main/java/com/bridgelabz/ejet/config/RegisterWebsiteUser.properties");
        prop.load(ip);
    }

    public void launch_Index() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        WebDriverManager.firefoxdriver().setup();
//        ChromeOptions chrome_options = new ChromeOptions();
//        chrome_options.addArguments("--disable-blink-features=AutomationControlled");
//        driver = new FirefoxDriver(chrome_options);
        driver.manage().window().maximize();
        driver.get("https://bldev.bridgelabz.com/?utm_source=abc&utm_medium=efg&utm_campaign=lmn&utm_id=xyx&fc=y&sc=d");
    }

    public void launch_RegisterwebsiteUser(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        if (url.equals(prop.getProperty("RegisterwebsiteUserUrl"))) {
            driver.get(prop.getProperty("RegisterwebsiteUserUrl"));
        }
    }
}
