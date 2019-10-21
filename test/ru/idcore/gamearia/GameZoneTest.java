package ru.idcore.gamearia;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameZoneTest {
    public static void main(String[] args) {
        GameArea gameArea = new GameArea(11,11);

        Ship ship = new Ship(4, gameArea, gameArea.getGameZones(), 2);

        //выстрел
        //gameArea.getGameZones()[1][3].setStateName(gameArea.getState(5));

//        System.out.print("   ");
//        for (int i = 0; i < gameAria.getHorizontalSize(); i++) {
//            System.out.print(gameAria.getHorizontalCoordinate(i));
//        }
//        System.out.print("\n");
//        for (int i = 0; i < gameAria.getVerticalSize(); i++) {
////            System.out.print(gameAria.getVerticalCoordinate(i));
////            for (int j= 0; j < gameAria.getHorizontalSize(); j++) {
////                if (gameAria.gameZones[i][j].getStateName().equals(" + ")) {
////                    System.out.print(gameAria.BACKGROUND_WHITE + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
////                } else if (gameAria.gameZones[i][j].getStateName().equals(" o ")) {
////                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
////                }else if (gameAria.gameZones[i][j].getStateName().equals(" x ")) {
////                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.ANSI_RED + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
////                }else if (gameAria.gameZones[i][j].getStateName().equals(" X ")) {
////                    System.out.print(gameAria.BACKGROUND_RED + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
////                }
////            }
////            System.out.print("\n");
////        }
        //отрисовка GameAria
        for (int i = 0; i < gameArea.getVerticalSize(); i++) {
            for (int j = 0; j < gameArea.getHorizontalSize(); j++) {
                if (gameArea.getGameZones()[i][j].getStateName().equals(" + ")) {
                    System.out.print(gameArea.BACKGROUND_WHITE + gameArea.getGameZones()[i][j].getStateName() + gameArea.ANSI_RESET );
                } else if (gameArea.getGameZones()[i][j].getStateName().equals(" o ")) {
                    System.out.print(gameArea.BACKGROUND_BLUE + gameArea.getGameZones()[i][j].getStateName() + gameArea.ANSI_RESET );
                }else if (gameArea.getGameZones()[i][j].getStateName().equals(" x ")) {
                    System.out.print(gameArea.BACKGROUND_BLUE + gameArea.ANSI_RED + gameArea.getGameZones()[i][j].getStateName() + gameArea.ANSI_RESET );
                }else if (gameArea.getGameZones()[i][j].getStateName().equals(" X ")) {
                    System.out.print(gameArea.BACKGROUND_RED + gameArea.getGameZones()[i][j].getStateName() + gameArea.ANSI_RESET );
                }else {
                    System.out.print(gameArea.getGameZones()[i][j].getStateName());
                }
            }
            System.out.print("\n");
        }


//        if (ship.getGameZones()[2].getStateName().equals(gameAria.getState(5))) {
//            System.out.println(ship.toString() + " -  ранен");
//        } else System.out.println("МИМО");
//

        System.out.println(gameArea.getGameZones().length);
    }

}