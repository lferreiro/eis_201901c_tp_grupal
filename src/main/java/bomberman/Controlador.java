package bomberman;

import javafx.util.Pair;

public class Controlador {

    private Bomberman bomberman;
    private Mapa mapa;

    public Controlador(int tamanioMapa){
        this.mapa = new Mapa(tamanioMapa);
        this.bomberman = new Bomberman();
    }

    public void moverEnDireccion(Direccion direccion){
        Posicion posicionFinal = this.bomberman.getPoisicion();

        Celda celda = this.mapa.getCelda(posicionFinal.nextPosicion(direccion));

        if(celda.getContenido().esCaminable()) {
            this.bomberman.moverBomberman(posicionFinal.nextPosicion(direccion));

//        Pair<Integer, Integer> coordenadaInicial = new Pair<>(0, 0);
//        coordenadaInicial = this.bomberman.posicion.getCoordenada();
//        Posicion posicionInicial = new Posicion(0,0);
//        posicionInicial.setCoordenada(coordenadaInicial);
//        Posicion posicionFinal = new Posicion(0,0);
//        posicionFinal.cambiarPosicion(posicionInicial, direccion);
//
//        Celda celda = this.mapa.getCelda(posicionFinal);
//
//        if(celda.getEstaVacia()) {
//            this.bomberman.moverBomberman(direccion);
        }

    }

    public Mapa getMapa(){ return this.mapa ;}

    public Bomberman getBomberman(){return this.bomberman ;}

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }
}
