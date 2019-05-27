package bomberman;

public class Poder {

    public void lanzarBomba(Celda celda, Celda celdaDestino){
        celda.setContenido(new Bomba());
    }

}
