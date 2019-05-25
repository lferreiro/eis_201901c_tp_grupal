package bomberman;

import javafx.util.Pair;

public class Posicion {

    private Pair<Integer , Integer> coordenada;

    public Posicion(Integer x, Integer y){
         this.coordenada = new Pair<>(x, y);
    }

    public Integer getX() {
       return coordenada.getKey();
    }

    public Integer getY() {
        return coordenada.getValue();
    }

    public Pair<Integer, Integer> getCoordenada(){
        return this.coordenada;
    }

}
