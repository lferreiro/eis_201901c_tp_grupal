package bomberman;

public class ParedMelamina extends Contenido {

    @Override
    public Boolean esCaminable() {
        return false;
    }

    @Override
    public Contenido explotar() {
        return new ContenidoVacio();
    }
}
