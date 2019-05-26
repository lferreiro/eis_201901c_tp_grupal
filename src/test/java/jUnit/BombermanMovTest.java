package jUnit;

import bomberman.*;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static bomberman.Direccion.DERECHA;
import static junit.framework.TestCase.assertEquals;

public class BombermanMovTest {
    private Controlador controlador;
    private Mapa mapa;
    private Bomberman bomberman;
    private Pair<Integer, Integer> coordenada;

    @Before
    public void setUp() {
        controlador = new Controlador(5);
        mapa = controlador.getMapa();
        bomberman = controlador.getBomberman();
    }


    @Test
    public void testBombermanEstaEnCeldaYSeMueveHaciaLaDerecha() {

        coordenada = new Pair<>(0, 0);

        assertEquals(coordenada, bomberman.getPoisicion().getCoordenada()); // Bomberman esta en la posición inicial.

        controlador.moverEnDireccion(DERECHA);

        Pair<Integer, Integer> coordenadaNueva;
        coordenadaNueva = new Pair<>(1, 0);

        Bomberman bombermanTest = controlador.getBomberman();
        assertEquals(coordenadaNueva, bombermanTest.getPoisicion().getCoordenada());

    }

}
