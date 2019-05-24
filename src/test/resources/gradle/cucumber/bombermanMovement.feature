# new feature
# Tags: optional
    
Feature: Movimientos de bomberman.
    
Scenario: Bomberman se mueve a una celda vacia.
    Given Bomberman esta en una celda
    When Intenta moverse a una celda vacia
    Then bomberman cambio su posicion a la nueva celda