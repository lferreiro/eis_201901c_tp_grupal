package bomberman;

public class PoderLanzar extends Poder {

    public PoderLanzar(Bomberman bomberman) {
        super(bomberman);
    }

    @Override
    public void lanzarBomba(Celda celdaOrigen, Celda celdaDestino){ //bomberman lanza la bomba a 3 casilleros de donde el se encuentra. Si el rango supera el limte la bomba se pone en la posicion actual de bomberman.
        celdaDestino.setContenido(new Bomba());
    }
}
