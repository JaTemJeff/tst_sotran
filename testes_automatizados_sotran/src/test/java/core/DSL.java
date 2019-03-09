package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

    WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    //-------------------------------------------------------------- METODOS ESCREVER (SENDKEYS) -------------------------------------------------------------- 
    public void escrevePorXpath(String xpath, String texto) {
        WebElement input = driver.findElement(By.xpath(xpath));
        input.clear();
        input.sendKeys(texto);
    }

    public void escrevePorNome(String nome, String texto) {
        WebElement dataInicio = driver.findElement(By.name(nome));
        dataInicio.clear();
        dataInicio.sendKeys(texto);
    }

    public void escrevePorId(String id, String texto) {
        WebElement dataInicio = driver.findElement(By.id(id));
        dataInicio.clear();
        dataInicio.sendKeys(texto);
    }

    //-------------------------------------------------------------- METODOS CLICAR (CLICK) ------------------------------------------------------------------
    public void clicaPorXpath(String xpath) {
        WebElement elemento = driver.findElement(By.xpath(xpath));
        elemento.click();
    }

    public void clicaPorLinkText(String linkText) {
        WebElement elemento = driver.findElement(By.linkText(linkText));
        elemento.click();
    }

    public void clicaPorId(String id) {
        WebElement elemento = driver.findElement(By.id(id));
        elemento.click();
    }

    public void clicaPorCss(String css) {
        WebElement elemento = driver.findElement(By.cssSelector("i.ico-trash"));
        elemento.click();
    }

    //-------------------------------------------------------------- METODOS SELECIONAR (SELECT) -------------------------------------------------------------- 
    public void selecionaPorXpath(String xpath, String valor) {
        Select elemento = new Select(driver.findElement(By.xpath(xpath)));
        elemento.selectByValue(valor);
    }

    public void selecionaPorId(String id, String valor) {
        Select elemento = new Select(driver.findElement(By.id(id)));
        elemento.selectByValue(valor);
    }

    public void selecionaPorNome(String nome, String valor) {
        Select elemento = new Select(driver.findElement(By.name(nome)));
        elemento.selectByValue(valor);
    }

    //-------------------------------------------------------------- TECLAS DO TECLADO ------------------------------------------------------------------------
    public void pressionaEnterPorXpath(String xpath) {
        WebElement input = driver.findElement(By.xpath(xpath));
        input.sendKeys(Keys.ENTER);
    }

    //-------------------------------------------------------------- METODOS DE ESPERA ------------------------------------------------------------------------
    public void esperaPorXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public void esperaPorId(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
    }
    
    public void esperaPorTexto(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(texto)));
    }
    
    public void esperaClassName(String className) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(className)));
    }
    
    public void esperaFicarClicavel(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    
    public void esperaElementoSumir(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
    
    //-------------------------------------------------------------- Retornar valor ------------------------------------------------------------------------
    public String retornaTextoDoAlert() {
        Alert alerta = driver.switchTo().alert();
        String texto = alerta.getText();
        return texto;
    }
    
    public String retornTextoDoInput(String xpath){
        String texto = driver.findElement(By.xpath(xpath)).getAttribute("value");
        return texto;
    }
    
    public String retornaTextoLabel(String xpath) {
        String texto = driver.findElement(By.xpath(xpath)).getText();
        return texto;
    }

    public boolean retornaSeTextoExisteNaPagina(String texto) {
        boolean verifica = driver.getPageSource().contains(texto);
        return verifica;
    }
    
    public int retornaTamanhoDaTela(){
        //return driver.manage().window().getSize();
        return driver.manage().window().getSize().width;
    }
    
    //-------------------------------------------------------------- Verificação ------------------------------------------------------------------------
    
    public boolean verificaSeCheckBoxEstáSelecionado(String xpath){
        WebElement checkBox = driver.findElement(By.xpath(xpath));
        if(checkBox.isSelected() == true){
            return true;
        }else{
            return false;
        }
    }
    
    //-------------------------------------------------------------- Submit --------------------------------------------------------------
    public void submeterPorNome(String nome){
         driver.findElement(By.name(nome)).submit();//Submete
    }
}
