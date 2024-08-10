package br.com.testandoclimatemp.clima;

import org.openqa.selenium.WebDriver;

public class Page {

    private Dsl dsl;

    public Page(WebDriver driver) {
        dsl = new Dsl(driver);
    }

    public void setCidade(String cidade) {
        dsl.PesquisarCidade("input-city", cidade);
    }

}
