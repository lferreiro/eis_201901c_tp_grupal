package bomberman;

public class ParedAcero extends Contenido {

    @Override
    public Boolean esCaminable() {
        return false;
    }

    @Override
    public Contenido explotar()  { return this; }

}