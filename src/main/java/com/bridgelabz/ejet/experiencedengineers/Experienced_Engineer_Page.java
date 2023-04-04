package com.bridgelabz.ejet.experiencedengineers;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.index_pages.Lateral_Page;
import com.bridgelabz.ejet.index_pages.Webinar_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class Experienced_Engineer_Page extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'Click To Register')]")
    WebElement click_To_Register;
    @FindBy(xpath = "//span[contains(text(),'Register Below To Know More!')]")
    WebElement unique_element;
//    @FindBy(xpath = "//span[contains(text(),'Download Here')]")
//    WebElement download_Here_Button;
    @FindBy(id = "FirstName")
    WebElement name;
    @FindBy(id = "Alert_Mandatory_FirstName")
    WebElement name_required;
    @FindBy(id = "EmailAddress")
    WebElement email;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_EmailAddress']")
    WebElement email_required;
    @FindBy(xpath = "//label[@id='Alert_Valid_EmailAddress']")
    WebElement email_invalid;
    @FindBy(xpath = "//div[@class='arrow']")
    WebElement country_code_drop;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_Phone']")
    WebElement select_country_code_error;
    @FindBy(xpath = "//li[3]")
    WebElement india;
    @FindBy(xpath = "//input[@class='number-input']")
    WebElement phone_number;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_Phone']")
    WebElement phone_number_required;
    @FindBy(xpath = "//label[@id='Alert_Valid_Phone']")
    WebElement invalid_phn_number;
    @FindBy(xpath = "//select[@id='mx_Qualification_Background']")
    WebElement qualification_drop;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_mx_Qualification_Background']")
    WebElement qualification_required;
    @FindBy(xpath = "//select[@id='mx_Tech_Work_Ex']")
    WebElement work_experience;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_mx_Tech_Work_Ex']")
    WebElement work_experience_required;
    public Experienced_Engineer_Page(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public RegisterWebsiteLateral_Page click_To_Register() throws InterruptedException {
        click_To_Register.click();
        Thread.sleep(3000);
        String parentId = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("The current window id is: " + parentId);
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println("The all window id's are: " + allWindowID);
        int count = allWindowID.size();
        System.out.println("The number of windows opened by selenium are: " + count);
        for (String windowHandle : allWindowID) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            System.out.println("The title is :" + title);
            if (windowHandle.equals(parentId)) {
                driver.close();
            }
        }
        unique_element.isDisplayed();
        return new RegisterWebsiteLateral_Page(driver);
    }
    public Free_EBOOK_Page click_On_Download_Here_Button() throws InterruptedException, IOException {
        String parentId = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("The current window id is: " + parentId);
        WebElement download_Here_Button = new WebDriverWait(driver, Duration.ofMinutes(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download Here')]")));
        download_Here_Button.click();
        Thread.sleep(30000);
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println("The all window id's are: " + allWindowID);
        int count = allWindowID.size();
        System.out.println("The number of windows opened by selenium are: " + count);
        for (String windowHandle : allWindowID) {
            driver.switchTo().window(windowHandle);
            if (windowHandle.equals(parentId)) {
                driver.close();
            }
        }
        return new Free_EBOOK_Page(driver);
    }
}