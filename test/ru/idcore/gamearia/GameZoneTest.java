package ru.idcore.gamearia;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameZoneTest {
    public static void main(String[] args) {
        GameAria gameAria = new GameAria(11,11);

        Ship ship = new Ship(4, gameAria, gameAria.getGameZones(), 2);

        //выстрел
        gameAria.getGameZones()[1][3].setStateName(gameAria.getState(5));

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
        for (int i = 0; i < gameAria.getVerticalSize(); i++) {
            for (int j = 0; j < gameAria.getHorizontalSize(); j++) {
                if (gameAria.getGameZones()[i][j].getStateName().equals(" + ")) {
                    System.out.print(gameAria.BACKGROUND_WHITE + gameAria.getGameZones()[i][j].getStateName() + gameAria.ANSI_RESET );
                } else if (gameAria.getGameZones()[i][j].getStateName().equals(" o ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.getGameZones()[i][j].getStateName() + gameAria.ANSI_RESET );
                }else if (gameAria.getGameZones()[i][j].getStateName().equals(" x ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.ANSI_RED + gameAria.getGameZones()[i][j].getStateName() + gameAria.ANSI_RESET );
                }else if (gameAria.getGameZones()[i][j].getStateName().equals(" X ")) {
                    System.out.print(gameAria.BACKGROUND_RED + gameAria.getGameZones()[i][j].getStateName() + gameAria.ANSI_RESET );
                }else {
                    System.out.print(gameAria.getGameZones()[i][j].getStateName());
                }
            }
            System.out.print("\n");
        }


//        if (ship.getGameZones()[2].getStateName().equals(gameAria.getState(5))) {
//            System.out.println(ship.toString() + " -  ранен");
//        } else System.out.println("МИМО");
//

        System.out.println(gameAria.getGameZones().length);
    }

}