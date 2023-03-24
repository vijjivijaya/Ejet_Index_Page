package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Submit_Button extends BaseClass {

    @FindBy(id="deftsbtn")
    WebElement submit_btn;
    public Submit_Button(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String click_enable_Submit_Button() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        String classValue = submit_btn.getAttribute("class");
        Thread.sleep(3000);
        submit_btn.click();
        System.out.println(classValue);
        return classValue;
    }
    public String click_Disable_Submit_Button() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        String classValue = submit_btn.getAttribute("class");
        submit_btn.click();
        System.out.println(classValue);
        return classValue;
    }
}

