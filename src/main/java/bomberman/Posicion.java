package bomberman;

import javafx.util.Pair;

public class Posicion {

    private Pair<Integer, Integer> coordenada;

    public Posicion(Integer x, Integer y) {
        this.coordenada = new Pair<>(x, y);
    }

    public Integer getX() {
        return coordenada.getKey();
    }

    public Integer getY() {
        return coordenada.getValue();
    }

    public Pair<Integer, Integer> getCoordenada() {
        return this.coordenada;
    }

    public void setCoordenada(Pair<Integer, Integer> coordenada) {
        this.coordenada = coordenada;
    }

    public Posicion nextPosicion(Direccion direccion, int n, Mapa mapa) {

        Integer x = this.getX();
        Integer y = this.getY();
        int tamanioDelMapa = mapa.getTamanio();
        switch (direccion) {
            case ARRIBA:
                if(y+n <= tamanioDelMapa) {
                    y = (y + n);
                    break;
                }
            case ABAJO:
                if(y-n >= 0) {
                    y = y - n;
                    break;
                }
            case DERECHA:
                if(x+n <= tamanioDelMapa) {
                    x = x + n;
                    break;
                }
            case IZQUIERDA:
                if(x-n >= 0) {
                    x = x - n;
                    break;
                }
        }
        return new Posicion(x,y);

    }



}
