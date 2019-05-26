package bomberman;

public class Celda {

    private Contenido contenido;

    public Celda(){
        this.contenido = new ContenidoVacio();
    }

    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return this.contenido;
    }

    public void vaciarContenido(){ this.contenido = null; }

    public void explotarContenido() {
        this.contenido = this.getContenido().explotar();
    }


}
