package bomberman;

import static bomberman.Direccion.*;

public class Controlador {

    private Bomberman bomberman;
    private Mapa mapa;

    public Controlador(){
        this.bomberman = new Bomberman();
        this.mapa = new Mapa(5);
        mapa.setCelda(bomberman.posicion, bomberman);
    }

    public void moverEnDireccion(Direccion direccion){
        Posicion posicionInicial = bomberman.posicion;
        Posicion posicionFinal = bomberman.posicion.posicionEnDireccion(ARRIBA);
        mapa.vaciarCelda(posicionInicial);
        mapa.getCelda(posicionFinal).setContenido(bomberman);
    }
}
