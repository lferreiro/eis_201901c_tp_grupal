package bomberman;

public class Bomberman {

    Posicion posicion;

    public Bomberman(){
        this.posicion = new Posicion(0,0);
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }


    public Posicion getPoisicion(){ return this.posicion;}

    public void moverBomberman(Posicion posicion){
        this.setPosicion(posicion);
//        Integer x = this.posicion.getX();
//        Integer y = this.posicion.getY();
//        switch(direccion){
//            case ARRIBA:
//                this.setPosicion(x, y + 1);
//                break;
//            case ABAJO:
//                this.setPosicion(x, y - 1);
//                break;
//            case DERECHA:
//                this.setPosicion(x + 1, y);
//                break;
//            case IZQUIERDA:
//                this.setPosicion(x - 1, y);
//                break;
//        }
    }
}
