package bomberman;

public class Mapa {

    private Celda[][] celdas;

    public Mapa(int tamanio){
        this.celdas = new Celda[tamanio][tamanio];
    }

    public Celda getCelda(Posicion posicion){
        return celdas[posicion.getX()][posicion.getY()];
    }

    public void setCelda(Posicion posicion, Contenido contenido){
        celdas[posicion.getX()][posicion.getY()].setContenido(contenido);
    }

    public void vaciarCelda(Posicion posicion){
        getCelda(posicion).vaciarContenido();
    }

    public Celda[][] getCeldas() {return this.celdas;}
}
