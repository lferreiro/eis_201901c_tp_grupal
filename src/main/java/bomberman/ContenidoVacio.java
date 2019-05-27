package bomberman;

public class ContenidoVacio extends Contenido {
    public Boolean esCaminable() {
        return true;
    }

    @Override
    public Contenido explotar() {
        return new ContenidoVacio();
    }
}
