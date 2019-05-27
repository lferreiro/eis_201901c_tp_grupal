package bomberman;

public class Enemigo extends Contenido {

    protected Bomberman bomberman;
    protected Poder     poder;

    public Enemigo(Bomberman bomberman){
        this.bomberman = bomberman;
    }

    public Boolean esCaminable() {
        return true;
    }

    public void morir() {
        this.bomberman.setPoder(this.poder);
    }

    @Override
    public Contenido explotar() {
        this.morir();
        return new ContenidoVacio();
    }

}
