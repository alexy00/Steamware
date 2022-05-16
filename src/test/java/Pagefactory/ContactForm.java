package Pagefactory;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContactForm {

    public ContactForm contact(){
        SelenideElement contactBtn = $(byText("Contact"));
        contactBtn.click();
        SelenideElement fname = $(byId("swcontactform-firstname"));
        fname.sendKeys("First");
        SelenideElement lname = $(byId("swcontactform-lastname"));
        lname.sendKeys("Last");
        SelenideElement city = $(byId("swcontactform-city"));
        city.sendKeys("City");
        SelenideElement state = $(byId("swcontactform-state"));
        state.sendKeys("State");
        SelenideElement zip = $(byId("swcontactform-zip"));
        zip.sendKeys("11111");
        SelenideElement email = $(byId("swcontactform-email"));
        email.sendKeys("email@gmail.com");
        SelenideElement phone = $(byId("swcontactform-phone"));
        phone.sendKeys("1231231235");
        SelenideElement selector = $(byId("swcontactform-pain_area"));
        selector.selectOptionByValue("2");
        SelenideElement referral = $(byId("swcontactform-referral"));
        referral.selectOptionByValue("4");
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        //$(".recaptcha-checkbox-border").click();
       $("span[role='checkbox']")
                .shouldBe(Condition.visible)
                .click();
        switchTo().defaultContent();
        return page(ContactForm.class);
    }
}
