package com.kar.pages.objects;

import com.kar.pages.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestObjects extends PageBase {

    @FindBy(id = "header_logo")
    private WebElement siteLogo;


}
