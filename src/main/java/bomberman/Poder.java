package bomberman;

public class Poder {

    protected Bomberman bomberman;

    public Poder(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    public void lanzarBomba(Celda celda, Celda celdaDestino){
        celda.setContenido(new Bomba());
    }

    public void mover(Posicion posicion, Mapa mapa, Direccion direccion) {
        Celda celda = mapa.getCelda(posicion);
        if (celda.getContenido().esCaminable()) {
            this.bomberman.setPosicion(posicion);
        }
    }

}
