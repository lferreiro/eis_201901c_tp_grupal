package bomberman;

import javafx.util.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Mapa {

    private Map<Pair<Integer, Integer>, Celda> celdas = new HashMap<>();

    public Mapa(int tamanio){
        for (int fila = 0; fila < tamanio; fila++){
            for(int columna = 0; columna < tamanio; columna ++){
                this.celdas.put(new Posicion(fila, columna).getCoordenada(), new Celda());
            }
        }
    }

    public Celda getCelda(Posicion posicion){
        return celdas.get(posicion.getCoordenada());
    }

    public void setCelda(Posicion posicion, Celda celda){
        celdas.put(posicion.getCoordenada(), celda);
    }

    public void vaciarCelda(Posicion posicion){
        celdas.put(posicion.getCoordenada(), new Celda());
    }

    public Collection<Celda> getCeldas() {return this.celdas.values();}
}
