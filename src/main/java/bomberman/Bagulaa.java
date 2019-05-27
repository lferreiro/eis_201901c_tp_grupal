package bomberman;

public class Bagulaa extends Enemigo {

    public Bagulaa(Bomberman bomberman){
        super(bomberman);
        this.poder = new PoderLanzar(bomberman);
    }

}
