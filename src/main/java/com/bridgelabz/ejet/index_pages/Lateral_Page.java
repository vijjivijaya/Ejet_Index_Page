package com.bridgelabz.ejet.index_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lateral_Page {

    @FindBy(name = "ContactNumber")
    WebElement phone_Number;
    @FindBy(name = "fullName")
    WebElement full_Name;
    @FindBy(name="")
    WebElement email;
    @FindBy(id = "deftdegree")
    WebElement stream;
    @FindBy(xpath = "//div[text()=' Engineering (CS/IT) ']")
    WebElement select_Stream;
    @FindBy (id = "deftyexpr")
    WebElement experience;
    public Lateral_Page(WebDriver driver) {

    }
}
