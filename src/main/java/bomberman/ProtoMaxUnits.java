package bomberman;

public class ProtoMaxUnits extends Enemigo {

    public ProtoMaxUnits(Bomberman bomberman){
        super(bomberman);
        this.poder = new PoderLanzarYSaltar(bomberman);
    }
}
