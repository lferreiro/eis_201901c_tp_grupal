package bomberman;

public class Celda {

    private Contenido contenido;

    public Celda(){
        this.contenido = null;
    }

    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return this.contenido;
    }

    public void vaciarContenido(){ this.contenido = null; }
}