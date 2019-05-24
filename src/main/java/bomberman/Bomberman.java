package bomberman;

public class Bomberman extends Contenido {

    Posicion posicion;

    public Bomberman(){
        posicion.setX(0);
        posicion.setY(0);
    }

    public void moverA(Posicion posicionDestino){
        this.posicion = posicionDestino;
    }
}
