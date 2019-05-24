package bomberman;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() { return y;}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {this.y = y;}

    public Posicion posicionEnDireccion(Direccion direccion){
        int x = 0;
        int y = 0;
        switch(direccion){
            case ARRIBA:
                y=1;
                break;
            case ABAJO:
                y=-1;
                break;
            case IZQUIERDA:
                x=-1;
                break;
            case DERECHA:
                x=1;
                break;
        }
        return new Posicion(this.x + x, this.y + y);
    }
}
