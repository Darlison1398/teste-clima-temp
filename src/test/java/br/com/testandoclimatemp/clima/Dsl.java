package br.com.testandoclimatemp.clima;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dsl {

    private WebDriver driver;

    public Dsl(WebDriver driver) {
        this.driver = driver;
    }

    public void PesquisarCidade(String id, String texto) {
        driver.findElement(By.id(id)).sendKeys(texto);
    }

    public void clicarBotaoPesquisar(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void verificarNomeDaCidade(String cidadeEsperada, String elementoId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementoId)));
        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals(cidadeEsperada, cidadeEncontrada);
    }

    public void verificarMensagemDeErro(String mensagemEsperada) {
        verificarNomeDaCidade(mensagemEsperada, "error-message");
    }


}
