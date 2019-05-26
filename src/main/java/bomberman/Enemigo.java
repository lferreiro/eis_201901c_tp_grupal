package bomberman;

public class Enemigo extends Contenido {
    @Override
    public Boolean esCaminable() {
        return true;
    }

    @Override
    public Contenido explotar() {
        return new ContenidoVacio();
    }
}
