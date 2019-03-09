package pages;

import core.DSL;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    DSL dsl;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        dsl = new DSL(driver);
    }
    
    public HomePage goToHomePage(String url){
        driver.get(url);
        return this; 
    }
    
    public HomePage setNomeNewsLetter(String nome){
        dsl.esperaPorXpath("//*[@id=\'rainmaker_form_1808\']/form/div[1]/input");
        dsl.escrevePorNome("name", nome);
        return this;
    }
    
    public HomePage setEmailNewsLetter(String email){
        dsl.escrevePorNome("email", email);
        return this;
    }
    
    public HomePage clicaEmAssinar(){
        dsl.clicaPorXpath("//*[@id=\'rainmaker_form_1808\']/form/div[3]/input");
        return this;
    }
    
    public String verificaMsgSucesso(){
        dsl.esperaPorXpath("//*[@id=\'rm_form_message_1808\']");
        return dsl.retornaTextoLabel("//*[@id=\'rm_form_message_1808\']");
    }
}
