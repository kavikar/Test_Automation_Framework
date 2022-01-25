package com.kar.pages.objects;

import com.kar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestObjects extends PageBase {

    public TestObjects(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[class*=navbar-brand]")
    public WebElement siteLogo;
}
