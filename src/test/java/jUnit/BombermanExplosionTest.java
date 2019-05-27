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

    @Before
    public void setUp() {
        controlador = new Controlador(5);
        coordenada = new Pair<>(0, 0);
        celda = new Celda();
        posicion = new Posicion(0, 0);

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

        celda.setContenido(new Enemigo());
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
        celda.setContenido(new Bagulaa(controlador.getBomberman()));
        posicion.setCoordenada(new Pair<>(3, 1));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaExplotada.getContenido() instanceof Bagulaa);
        assertTrue(controlador.getBomberman().getPoder() instanceof Poder);

        controlador.sembrarBomba(Direccion.ARRIBA);

        assertTrue(celdaExplotada.getContenido() instanceof ContenidoVacio);
        assertTrue(controlador.getBomberman().getPoder() instanceof PoderLanzar);
    }

}
