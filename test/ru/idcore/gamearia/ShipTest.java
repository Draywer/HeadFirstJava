package ru.idcore.gamearia;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    public static void main(String[] args) {
//        for (int i = 1; i <= 11; i++) {
//            GameAria gameAria = new GameAria(i, i);
//            gameAria.drawGameAria();
//        }

        GameAria gameAria = new GameAria(11, 11);

        //левый верхний угол
        gameAria.getGameZones()[3][1].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][2].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][3].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][4].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][5].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[2][5].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[1][5].setStateName(gameAria.getState(2));

        //правый верхний угол
        gameAria.getGameZones()[1][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[2][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][9].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[3][10].setStateName(gameAria.getState(2));

        //правый нижний угол
        gameAria.getGameZones()[10][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[9][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[8][8].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[8][9].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[8][10].setStateName(gameAria.getState(2));

        //левый нижний угол
        gameAria.getGameZones()[8][1].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[8][2].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[8][3].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[9][3].setStateName(gameAria.getState(2));
        gameAria.getGameZones()[10][3].setStateName(gameAria.getState(2));

//        //выстрел
//        gameAria.getGameZones()[1][2].setStateName(gameAria.getState(4));

        gameAria.drawGameAria();

        System.out.println(gameAria.getGameZones()[1][1].checkGameZoneFree(gameAria.getState(1)));
        System.out.println(gameAria.getGameZones()[1][2].checkGameZoneFree(gameAria.getState(1)));
        System.out.println(gameAria.getGameZones()[1][3].checkGameZoneFree(gameAria.getState(1)));
    }
}