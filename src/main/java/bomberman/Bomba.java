package bomberman;

public class Bomba extends Contenido {
    @Override
    public Boolean esCaminable() {
        return true;
    }

    @Override
    public Contenido explotar() {
        return new ContenidoVacio();
    }
}
