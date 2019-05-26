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
        celda.setContenido(new Pared());
        posicion.setCoordenada(new Pair<>(1, 0));
        controlador.getMapa().setCelda(posicion, celda);
        Celda celdaExplotada = controlador.getMapa().getCelda(posicion);

        assertTrue(celdaExplotada.getContenido() instanceof Pared);

        controlador.sembrarBomba();

        assertTrue(celdaExplotada.getContenido() instanceof ContenidoVacio);
    }
}
