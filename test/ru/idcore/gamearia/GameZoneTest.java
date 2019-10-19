package ru.idcore.gamearia;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameZoneTest {
    public static void main(String[] args) {
        GameAria gameAria = new GameAria();

        Ship ship = new Ship(3, gameAria.gameZones, gameAria.getState(2));

        //выстрел
        gameAria.gameZones[1][3].setStateName(gameAria.getState(5));

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
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (gameAria.gameZones[i][j].getStateName().equals(" + ")) {
                    System.out.print(gameAria.BACKGROUND_WHITE + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
                } else if (gameAria.gameZones[i][j].getStateName().equals(" o ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
                }else if (gameAria.gameZones[i][j].getStateName().equals(" x ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.ANSI_RED + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
                }else if (gameAria.gameZones[i][j].getStateName().equals(" X ")) {
                    System.out.print(gameAria.BACKGROUND_RED + gameAria.gameZones[i][j].getStateName() + gameAria.ANSI_RESET );
                }else {
                    System.out.print(gameAria.gameZones[i][j].getStateName());
                }
            }
            System.out.print("\n");
        }


        if (ship.gameZones[2].getStateName().equals(gameAria.getState(5))) {
            System.out.println(ship.toString() + " -  ранен");
        } else System.out.println("МИМО");
    }

}