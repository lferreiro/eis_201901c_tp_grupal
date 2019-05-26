package bomberman;

public class Enemigo extends Contenido {
    public Boolean esCaminable() {
        return true;
    }

    @Override
    public Contenido explotar() {
        return null;
    }
}
