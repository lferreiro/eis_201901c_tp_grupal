package bomberman;

public class PoderLanzarYSaltar extends Poder {
    public PoderLanzarYSaltar(Bomberman bomberman) {
        super(bomberman);
    }

    @Override
    public void mover(Posicion posicion, Mapa mapa, Direccion direccion) {
        Celda celda = mapa.getCelda(posicion);
        if (celda.getContenido().esCaminable()) {
            this.bomberman.setPosicion(posicion);
        } else {
            Posicion salteada = posicion.nextPosicion(direccion,1,mapa);
            this.bomberman.setPosicion(salteada);
        }
        this.bomberman.verificarEnemigo(celda);
    }

    @Override
    public void lanzarBomba(Celda celdaOrigen, Celda celdaDestino){ //bomberman lanza la bomba a 3 casilleros de donde el se encuentra. Si el rango supera el limte la bomba se pone en la posicion actual de bomberman.
        celdaDestino.setContenido(new Bomba());
    }


}
