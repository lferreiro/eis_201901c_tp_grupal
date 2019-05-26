package jUnit;

import bomberman.*;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static bomberman.Direccion.DERECHA;
import static junit.framework.TestCase.*;

public class BombermanMovTest {
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
    public void testBombermanEstaEnCeldaYSeMueveHaciaLaDerecha() {

        assertEquals(coordenada, controlador.getBomberman().getPoisicion().getCoordenada()); // Bomberman esta en la posición inicial.

        controlador.moverEnDireccion(DERECHA);

        Pair<Integer, Integer> coordenadaNueva;
        coordenadaNueva = new Pair<>(1, 0);

        Bomberman bombermanTest = controlador.getBomberman();
        assertEquals(coordenadaNueva, bombermanTest.getPoisicion().getCoordenada());

    }


    @Test
    public void testBombermanCambiaSuPosicionAUnaCeldaVacia() {
        assertEquals(new Pair<>(0, 0), controlador.getBomberman().getPoisicion().getCoordenada());

        posicion.setCoordenada(new Pair<>(1, 0));
        controlador.moverEnDireccion(DERECHA);

        assertEquals(new Pair<>(1, 0), controlador.getBomberman().getPoisicion().getCoordenada());
       assertTrue(controlador.getMapa().getCelda(controlador.getBomberman().getPoisicion()).getContenido() instanceof ContenidoVacio) ;
    }

    @Test
    public void testBombermanNoCambiaSuPosicionPorqueLaCeldaNoEstaVacia() {
        assertEquals(new Pair<>(0, 0), controlador.getBomberman().getPoisicion().getCoordenada());

        posicion.setCoordenada(new Pair<>(1, 0));
        celda.setContenido(new Pared());
        controlador.getMapa().setCelda(posicion, celda);

        controlador.moverEnDireccion(DERECHA);

        assertEquals(new Pair<>(0, 0), controlador.getBomberman().getPoisicion().getCoordenada());

    }

}
