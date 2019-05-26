package bomberman;

public class Bomberman {

    private Posicion posicion;
    private Boolean estaVivo;

    public Bomberman(){
        this.posicion = new Posicion(0,0);
        this.estaVivo = true;
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }


    public Posicion getPoisicion(){ return this.posicion;}

    public void moverBomberman(Posicion posicion){
        if(estaVivo) {
            this.setPosicion(posicion);
        }
    }

    public void morir() {
        this.estaVivo = false;
    }

    public Boolean getEstaVivo() {
        return this.estaVivo;
    }

    public void ponerBomba(Celda celda) {
        celda.setContenido(new Bomba());
    }
}
