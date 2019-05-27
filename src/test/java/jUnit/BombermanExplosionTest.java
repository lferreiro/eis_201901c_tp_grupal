package jUnit;

import bomberman.*;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BombermanExplosionTest {
    private Controlador controlador;
    private Pair<Integer, Integer> coordenada;
    private Celda celda;
    private Posicion posicion;
    private Bomberman bomberman;

    @Before
    public void setUp() {
        controlador = new Controlador(5);
        coordenada = new Pair<>(0, 0);
        celda = new Celda();
        posicion = new Posicion(0, 0);
        bomberman = controlador.getBomberman();

    }

    @Test
    public void testBombermanPoneUnaBombaEnUnaCeldaConUnaParedYLaExplota() {
        celda.setContenido(new ParedMelamina());
        posicion.setCoordenada(new Pair<>(1, 0));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaExplotada.getContenido() instanceof ParedMelamina);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(celdaExplotada.getContenido() instanceof ContenidoVacio);
    }

    @Test
    public void testBombermanPoneBombaYExplotanEnemigoYPared(){

        celda.setContenido(new Enemigo(bomberman));
        posicion.setCoordenada(new Pair<>(2, 2));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaEnPosicionx1y0 = controlador.getMapa().getCelda(new Posicion(1,0));
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaEnPosicionx1y0.getContenido() instanceof ParedMelamina);
        assertTrue(celdaExplotada.getContenido() instanceof Enemigo);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(celdaEnPosicionx1y0.getContenido() instanceof ContenidoVacio);
        assertTrue(celdaExplotada.getContenido() instanceof ContenidoVacio);

    }

    @Test
    public void hayUnaParedDeAceroEnRangoDeExplosionPeroQuedaIntacta(){

        celda.setContenido(new ParedAcero());
        posicion.setCoordenada(new Pair<>(1, 0));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaExplotada.getContenido() instanceof ParedAcero);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(celdaExplotada.getContenido() instanceof ParedAcero);

    }

    @Test
    public void testBombermanMataABagulaaConUnaBombaYTieneElPoderNuevo(){
        celda.setContenido(new Bagulaa(bomberman));
        posicion.setCoordenada(new Pair<>(3, 1));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaExplotada.getContenido() instanceof Bagulaa);
        assertTrue(bomberman.getPoder() instanceof Poder);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(celdaExplotada.getContenido() instanceof ContenidoVacio);
        assertTrue(bomberman.getPoder() instanceof PoderLanzar);
    }

    @Test
    public void testBombermanMataAProtoMaxJrConUnaBombaYObtienePoderParaSaltarParedes() {
        Celda celdaConProtoMaxJr = new Celda();
        celdaConProtoMaxJr.setContenido(new ProtoMaxJr(bomberman));
        Posicion posicionCeldaJr = new Posicion(2,2);
        controlador.getMapa().setCelda(posicionCeldaJr, celdaConProtoMaxJr);
        celda.setContenido(new ParedAcero());
        posicion.setCoordenada(new Pair<>(2, 1));
        controlador.getMapa().setCelda(posicion, celda);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(bomberman.getPoder() instanceof PoderSaltar);

        controlador.moverEnDireccion(Direccion.DERECHA);

        assertEquals(new Pair<>(3,1), bomberman.getPoisicion().getCoordenada());
    }

    @Test
    public void testBombermanMataAProtoMaxUnitsConUnaBombaYObtienePoderSaltarYLanzar(){
        Celda celdaConProtoMaxUnits = new Celda();
        celdaConProtoMaxUnits.setContenido(new ProtoMaxUnits(bomberman));
        Posicion posicionCeldaUnits = new Posicion(2,2);
        Celda celdaMelamina = new Celda();
        celdaMelamina.setContenido(new ParedMelamina());
        Posicion posicionMelamina = new Posicion(4,3);
        controlador.getMapa().setCelda(posicionMelamina, celdaMelamina);
        controlador.getMapa().setCelda(posicionCeldaUnits, celdaConProtoMaxUnits);
        celda.setContenido(new ParedAcero());
        posicion.setCoordenada(new Pair<>(2, 1));
        controlador.getMapa().setCelda(posicion, celda);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(bomberman.getPoder() instanceof PoderLanzarYSaltar);
        assertTrue(celdaMelamina.getContenido() instanceof ParedMelamina);

        controlador.moverEnDireccion(Direccion.DERECHA);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertEquals(new Pair<>(3,1), bomberman.getPoisicion().getCoordenada());
        assertTrue(celdaMelamina.getContenido() instanceof ContenidoVacio);
    }

}
