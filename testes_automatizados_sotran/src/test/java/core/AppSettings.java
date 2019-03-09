package core;

import org.openqa.selenium.Dimension;

public class AppSettings {
    
    public static String URL_BASE = "http://www.sotran.com.br/";

    //Propriedades = true, não fecha os browsers ao fim de cada teste
    public static boolean FECHAR_BROWSER = true;

    //Resolução do Browser
    public static Dimension RESOLUCAO_BROWSER = new Dimension(1920, 1080);

    //Escolhe em qual browser rodar
    public static Browsers BROWSER = Browsers.CHROME;

    public enum Browsers {
        CHROME,
        PHATOMJS,
        CHROME_HEADLESS
    }
}
