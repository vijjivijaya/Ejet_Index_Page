package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Educational_Qualification extends BaseClass {

    @FindBy(id="deftdegree")
    WebElement stream;
    @FindBy(xpath="//p[text()='Stream Required']")
    WebElement stream_required;
    @FindBy(xpath="//div[text()=' Engineering (CS/IT) ']")
    WebElement engineering_cs;
    @FindBy(xpath="//div[text()=' Engineering (Non IT) ']")
    WebElement engineering_non_It;
    @FindBy(xpath="//div[text()=' Masters (CS/IT) ']")
    WebElement masters_cs;
    @FindBy(xpath="//div[text()=' Masters (Non IT) ']")
    WebElement masters_non_It;
    @FindBy(xpath="//div[text()=' Others (Non Engineering and Non MSc/MCA) ']")
    WebElement others;
    public Educational_Qualification(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String education_Qualification(String education) throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        String value = null;
        stream.click();
        Thread.sleep(3000);
        if (education.equals("Engineering (CS/IT)")) {
            value=engineering_cs.getText();
            engineering_cs.click();
            Thread.sleep(3000);
        } else if (education.equals("Engineering (Non IT)")) {
            value=engineering_non_It.getText();
            engineering_non_It.click();
            Thread.sleep(3000);
        } else if (education.equals("Masters (CS/IT)")) {
            value=masters_cs.getText();
            masters_cs.click();
            Thread.sleep(3000);
        } else if (education.equals("Masters (Non IT)")) {
            value=masters_non_It.getText();
            masters_non_It.click();
            Thread.sleep(3000);
        } else if (education.equals("Others (Non Engineering and Non MSc/MCA)")) {
            value=others.getText();
            others.click();
            Thread.sleep(3000);
        }
        return value;
    }
    public String without_Selecting_Education_Qualification() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        stream.click();
        Thread.sleep(3000);
        String value =stream_required.getText();
        Thread.sleep(3000);
        return value;
    }
}
