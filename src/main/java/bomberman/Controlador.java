package bomberman;

import static bomberman.Direccion.*;

public class Controlador {

    private Bomberman bomberman;
    private Mapa mapa;

    public Controlador(int tamanioMapa){
        this.mapa = new Mapa(tamanioMapa);
        this.bomberman = new Bomberman();
    }

    public void moverEnDireccion(Direccion direccion){
        Posicion posicionInicial = bomberman.getPoisicion();
        
        this.bomberman.moverBomberman(direccion);

    }

    public Mapa getMapa(){ return this.mapa ;}

    public Bomberman getBomberman(){return this.bomberman ;}
}
