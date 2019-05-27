package bomberman;

public class Bagulaa extends Enemigo {

    private PoderLanzar poder;
    private Bomberman bomberman;

    public Bagulaa(Bomberman bomberman){
        this.bomberman = bomberman;
        this.poder = new PoderLanzar();
    }

    public void morir(){
        this.bomberman.setPoder(poder);
    }

    @Override
    public Contenido explotar(){
        this.morir();
        return new ContenidoVacio();
    }
}
