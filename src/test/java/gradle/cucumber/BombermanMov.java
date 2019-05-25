package gradle.cucumber;

import bomberman.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static bomberman.Direccion.*;
import static junit.framework.TestCase.assertTrue;

public class BombermanMov {

    private Controlador controlador;
    private Bomberman bomberman;
    private Mapa mapa;
    private Posicion posicionInicial;
    private Posicion posicionFinal;

    @Given("^Bomberman esta en una celda$")
    public void bombermanEnCelda() throws Throwable{
        this.controlador = new Controlador(5);
        this.mapa = controlador.getMapa();
        this.bomberman = controlador.getBomberman();
        this.posicionInicial = bomberman.getPoisicion();
        //this.posicionFinal = posicionInicial.posicionEnDireccion(ARRIBA);

    }

    @When("^Intenta moverse a una celda vacia$")
    public void moverACeldaVacia() throws Throwable{
        this.controlador.moverEnDireccion(Direccion.ARRIBA);
    }

    @Then("^bomberman cambio su posicion a la nueva celda$")
    public void mePudeMoverACedaVacia() throws Throwable{
        Bomberman bombermanTest = this.controlador.getBomberman();
        assertTrue(bombermanTest.getPoisicion().getX() == 0);
        assertTrue(bombermanTest.getPoisicion().getY() == 1);
    }
}
