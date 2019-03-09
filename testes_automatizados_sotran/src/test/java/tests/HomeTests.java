package tests;

import core.AppSettings;
import core.BaseTest;
import core.GeradorUtils;
import core.WebDriverFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeTests extends BaseTest{
    WebDriver driver;
    HomePage homePage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        gerador = new GeradorUtils();
        homePage = new HomePage(driver);
    }
    
    @Test
    public void cadastra_NewsLetter_Test(){
        
        String nome = gerador.stringAleatoria(10);
        String email = nome + "@test.com";
        
        homePage = homePage.goToHomePage(AppSettings.URL_BASE)
                .setNomeNewsLetter(nome)
                .setEmailNewsLetter(email)
                .clicaEmAssinar();
        
        Assert.assertEquals("Obrigado", homePage.verificaMsgSucesso());
    }
    
}
