package bomberman;

import javafx.geometry.Pos;

public class PoderSaltar extends Poder {

    public PoderSaltar(Bomberman bomberman) {
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
    }

}
