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

    public void setCoordenada(Pair<Integer, Integer> coordenada) {
        this.coordenada = coordenada;
    }

    public Posicion nextPosicion (Direccion direccion){

        Integer x = this.getX();
        Integer y = this.getY();
        switch(direccion){
            case ARRIBA:
                y = (y + 1);
                break;
            case ABAJO:
                y = y - 1;
                break;
            case DERECHA:
                x = x + 1;
                break;
            case IZQUIERDA:
                x = x - 1;
                break;
        }

        return new Posicion(x, y);

    }

}
