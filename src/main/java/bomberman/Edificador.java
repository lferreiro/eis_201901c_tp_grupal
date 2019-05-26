package bomberman;

public class Edificador {

    private Mapa    mapa;
    private Integer tamanioMapa;

    public Edificador(Mapa mapa, Integer tamanioMapa) {
        this.mapa = mapa;
        this.tamanioMapa = tamanioMapa;
    }

    public void cubrirBordes() {
        this.edificarLineaVertical(new Posicion(0,0), new Posicion(0,this.tamanioMapa));
        this.edificarLineaHorizontal(new Posicion(0,0), new Posicion(this.tamanioMapa,0));
        this.edificarLineaHorizontal(new Posicion(0,this.tamanioMapa), new Posicion(this.tamanioMapa,this.tamanioMapa));
        this.edificarLineaVertical(new Posicion(this.tamanioMapa,0), new Posicion(this.tamanioMapa,this.tamanioMapa));
    }

    //Prop: crea una linea de paredes vertical de melamina desde pos1 hasta pos2.
    public void edificarLineaVertical(Posicion pos1, Posicion pos2) {
        Posicion posicionActual;
        int posX = pos1.getX();

        if (pos1.getY()<pos2.getY()) {  //Sube
            for (int posY = pos1.getY(); posY<pos2.getY(); posY++) {
                posicionActual = new Posicion(posX,posY);
                this.mapa.crearPared(posicionActual);
            }
        } else {    //Baja
            for (int posY = pos1.getY(); posY>pos2.getY(); posY--) {
                posicionActual = new Posicion(posX,posY);
                this.mapa.crearPared(posicionActual);
            }
        }
    }

    //Prop: crea una linea de paredes horizontal de melamina desde pos1 hasta pos2.
    public void edificarLineaHorizontal(Posicion pos1, Posicion pos2) {
        Posicion posicionActual;
        int posY = pos1.getY();

        if (pos1.getX()<pos2.getX()) {  //Sube
            for (int posX = pos1.getX(); posX<pos2.getX(); posX++) {
                posicionActual = new Posicion(posX,posY);
                this.mapa.crearPared(posicionActual);
            }
        } else {    //Baja
            for (int posX = pos1.getX(); posX>pos2.getX(); posX--) {
                posicionActual = new Posicion(posX,posY);
                this.mapa.crearPared(posicionActual);
            }
        }
    }

}
