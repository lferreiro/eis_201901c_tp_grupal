package gradle.cucumber;

import bomberman.*;
import cucumber.api.java.en.Given;

public class BombermanMov {

    private Bomberman bomberman;
    private Mapa mapa;
    private posicionInicial;
    private posicionFinal;

    @Given("^Bomberman esta en una celda$")
    public void bombermanEnCelda() throws Throwable{
        this.mapa = new Mapa(5);
        this.bomberman = new Bomberman();

    }

}
