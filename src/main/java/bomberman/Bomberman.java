package bomberman;

public class Bomberman {

    private Posicion posicion;
    private Boolean estaVivo;
    private Poder poder;
    private Mapa mapa;

    public Bomberman(){
        this.posicion = new Posicion(1,1);
        this.estaVivo = true;
        this.poder = new Poder(this);
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }


    public Posicion getPoisicion(){ return this.posicion;}

    public void moverBomberman(Posicion posicion, Direccion direccion){
        if(estaVivo) {
            this.poder.mover(posicion, this.mapa, direccion);
        }
    }

    public void verificarEnemigo(Celda celda) {
        if(celda.getContenido() instanceof Enemigo) {
            this.morir();
        }
    }

    public void morir() {
        this.estaVivo = false;
    }

    public Boolean getEstaVivo() {
        return this.estaVivo;
    }

    public void ponerBomba(Direccion direccion) {
        Celda celdaActual = mapa.getCelda(this.getPoisicion());
        Celda celdaDestino = this.calcularCeldaDestino(direccion);
        this.poder.lanzarBomba(celdaActual, celdaDestino);
    }

    public void setPoder(Poder poder){
        this.poder = poder;
    }

    public Poder getPoder(){
        return this.poder;
    }

    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public Mapa getMapa(){
        return this.mapa;
    }

    public Celda calcularCeldaDestino(Direccion direccion){
        Posicion posicionAPlantar = this.posicion.nextPosicion(direccion, 3, this.getMapa());
        Celda celdaDestino = this.getMapa().getCelda(posicionAPlantar);
        return celdaDestino;
    }

}
