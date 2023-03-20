package com.bridgelabz.ejet.index_pages;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RegisterWebsiteUser_Page extends BaseClass {
    public RegisterWebsiteUser_Page(WebDriver driver) throws IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}

