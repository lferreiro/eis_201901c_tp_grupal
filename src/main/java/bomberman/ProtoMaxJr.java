package bomberman;

public class ProtoMaxJr extends Enemigo {

    public ProtoMaxJr(Bomberman bomberman) {
        super(bomberman);
        this.poder = new PoderSaltar(bomberman);
    }

}
