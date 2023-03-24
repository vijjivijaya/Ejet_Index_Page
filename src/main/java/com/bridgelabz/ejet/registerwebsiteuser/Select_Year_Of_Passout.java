package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Select_Year_Of_Passout extends BaseClass {

    @FindBy(id="deftyear")
    WebElement passout_drop;
    @FindBy(xpath="//div[@value='2023']")
    WebElement year_2023;
    @FindBy(xpath="//div[@value='2022']")
    WebElement year_2022;
    @FindBy(xpath="//div[@value='2021']")
    WebElement year_2021;
    @FindBy(xpath="//div[@value='2020']")
    WebElement year_2020;
    @FindBy(xpath="//div[@value='2024']")
    WebElement year_2024;
    @FindBy(xpath="//div[@value='Before 2020']")
    WebElement before_2020;
    @FindBy(xpath="//div[@value='After 2024']")
    WebElement after_2024;
    @FindBy(xpath="//p[text()='Year Required']")
    WebElement year_Required;
    public Select_Year_Of_Passout(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String passOut_Year(String pass) throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        passout_drop.click();
        Thread.sleep(3000);
        String value = null;
        if (pass.equals("2023")) {
            value=year_2023.getText();
            year_2023.click();
            Thread.sleep(2000);
        } else if (pass.equals("2022")) {
            value=year_2022.getText();
            year_2022.click();
            Thread.sleep(2000);
        } else if (pass.equals("2021")) {
            value=year_2021.getText();
            year_2021.click();
            Thread.sleep(2000);
        } else if (pass.equals("2024")) {
            value=year_2024.getText();
            year_2024.click();
            Thread.sleep(2000);
        } else if (pass.equals("2020")) {
            value=year_2020.getText();
            year_2020.click();
            Thread.sleep(2000);
        } else if (pass.equals("After 2024")) {
            value=after_2024.getText();
            after_2024.click();
            Thread.sleep(2000);
        } else if (pass.equals("Before 2020")) {
            value=before_2020.getText();
            before_2020.click();
            Thread.sleep(2000);
        }
        return value;
    }
    public String empty_PassOut_Value() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        passout_drop.click();
        Thread.sleep(3000);
        String value =year_Required.getText();
        return value;
    }
}
