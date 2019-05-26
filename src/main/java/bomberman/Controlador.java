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
            verificarEnemigo(celda);
        }

    }

    public void verificarEnemigo(Celda celda) {
        if(celda.getContenido() instanceof Enemigo) {
            this.bomberman.morir();
        }
    }

    public Mapa getMapa(){ return this.mapa ;}

    public Bomberman getBomberman(){return this.bomberman ;}

    public void setBomberman(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void sembrarBomba() {
        Integer tick = 3;
        Posicion posicionBomberman = this.bomberman.getPoisicion();
        Celda celda = this.mapa.getCelda(posicionBomberman);

        this.bomberman.ponerBomba(celda);

        while (tick > 0) {
            tick--;
        }
        this.explotarBomba(posicionBomberman);
    }


    public void explotarBomba(Posicion posicion) {
        Integer posx = posicion.getX();
        Integer posy = posicion.getY();
        Integer radx = posx + 3;
        Integer rady = posy + 3;

        for (int fila = posx; fila < radx; fila++) {
            for (int columna = posy; columna < rady; columna++) {
                this.mapa.getCelda(new Posicion(fila, columna)).explotarContenido();
            }
        }
    }
}
