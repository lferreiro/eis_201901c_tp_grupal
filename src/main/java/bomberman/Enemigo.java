package bomberman;

public class Enemigo extends Contenido {

    private Bomberman bomberman;

    public Enemigo(){
    }

    public Boolean esCaminable() {
        return true;
    }

    @Override
    public Contenido explotar() {
        return new ContenidoVacio();
    }

}
