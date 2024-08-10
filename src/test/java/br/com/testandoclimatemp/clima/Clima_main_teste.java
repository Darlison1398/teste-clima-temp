package br.com.testandoclimatemp.clima;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Clima_main_teste {

    private Dsl dsl;
    private WebDriver driver;

    @Before
    public void inicializa() {
        driver = new ChromeDriver();
        driver.get("http://drsilva-clima-temp.netlify.app");
        dsl = new Dsl(driver);
    }

    @After
    public void fecha() {
        driver.quit();
    }


    @Test
    public void testandoCampoInput() {
        dsl.PesquisarCidade("city-input", "São Paulo");
        dsl.clicarBotaoPesquisar("search");
        dsl.verificarNomeDaCidade("São Paulo", "city");

    }

    @Test
    public void testandoClimaManaus() {
        dsl.clicarBotaoPesquisar("manaus");
        dsl.verificarNomeDaCidade("Manaus", "city");
    }

    @Test
    public void testandoClimaSaoPaulo() {
        dsl.clicarBotaoPesquisar("sp");
        dsl.verificarMensagemDeErro("Não foi possível encontrar o clima de uma cidade com este nome.");
    }

    @Test
    public void testandoClimaCuritiba() {
        driver.findElement(By.id("curitiba")).click();

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        String cidadeEncontrda = cidadeElemento.getText();
        Assert.assertEquals("Curitiba", cidadeEncontrda);
    }

    @Test
    public void testandoClimaFlorianopolis() {
        driver.findElement(By.id("floripa")).click();
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));

        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals("Não foi possível encontrar o clima de uma cidade com este nome.", cidadeEncontrada);
    }

    @Test
    public void testandoClimaBelem() {
        driver.findElement(By.id("belem")).click();

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals("Belém", cidadeEncontrada);
    }

    @Test
    public void testandoClimaCriciuma() {
        driver.findElement(By.id("criciuma")).click();
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals("Criciúma", cidadeEncontrada);
    }

    @Test
    public void testandoClimaRioDeJaneiro() {
        driver.findElement(By.id("rj")).click();
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals("Não foi possível encontrar o clima de uma cidade com este nome.", cidadeEncontrada);
    }

    @Test
    public void testandoClimaMacio() {
        driver.findElement(By.id("maceio")).click();
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement cidadeElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        String cidadeEncontrada = cidadeElemento.getText();
        Assert.assertEquals("Maceió", cidadeEncontrada);

        Assert.assertEquals("27°C", driver.findElement(By.id("temperature")).getText());
    }










}
