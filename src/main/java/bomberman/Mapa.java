package bomberman;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Mapa {

    private Map<Posicion, Celda> celdas = new HashMap<>();

    public Mapa(int tamanio){
        for (int fila = 0; fila < tamanio; fila++){
            for(int columna = 0; columna < tamanio; columna ++){
                this.celdas.put(new Posicion(fila, columna), new Celda());
            }
        }
    }

    public Celda getCelda(Posicion posicion){
        return celdas.get(posicion.getCoordenada());
    }

    public void setCelda(Posicion posicion, Celda celda){
        celdas.put(posicion, celda);
    }

    public void vaciarCelda(Posicion posicion){
        celdas.put(posicion, new Celda());
    }

    public Collection<Celda> getCeldas() {return this.celdas.values();}
}
