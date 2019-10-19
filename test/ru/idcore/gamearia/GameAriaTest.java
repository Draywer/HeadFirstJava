package ru.idcore.gamearia;

import static org.junit.jupiter.api.Assertions.*;

class GameAriaTest {
    public static void main(String[] args) throws InterruptedException {
        GameAria gameAria = new GameAria(10,10);
        gameAria.setStateArea(0,0," + ");
        gameAria.setStateArea(0,1," + ");
        gameAria.setStateArea(0,2," X ");
        gameAria.setStateArea(0,3," X ");

        gameAria.setStateArea(1,0," x ");
        gameAria.setStateArea(1,1," x ");
        gameAria.setStateArea(1,2," x ");
        gameAria.setStateArea(1,3," x ");
        gameAria.setStateArea(1,4," x ");
        gameAria.setStateArea(0,4," x ");

        gameAria.setStateArea(0,5," X ");
        gameAria.setStateArea(1,5," + ");
        gameAria.setStateArea(2,5," X ");
        gameAria.setStateArea(3,5," + ");

        gameAria.setStateArea(7,0," + ");
        gameAria.setStateArea(7,1," X ");
        gameAria.setStateArea(7,2," + ");

        gameAria.setStateArea(3,3," X ");


        System.out.print("   ");
        for (int i = 0; i < gameAria.getHorizontalSize(); i++) {
            System.out.print(gameAria.getHorizontalCoordinate(i));
        }
        System.out.print("\n");
        for (int i = 0; i < gameAria.getHorizontalSize(); i++) {
            System.out.print(gameAria.getVerticalCoordinate(i));
            for (int j= 0; j < gameAria.getHorizontalSize(); j++) {
                if (gameAria.getStateArea(i,j).equals(" + ")) {
                    System.out.print(gameAria.BACKGROUND_WHITE + gameAria.getStateArea(i,j) + gameAria.ANSI_RESET );
                } else if (gameAria.getStateArea(i,j).equals(" o ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.getStateArea(i,j) + gameAria.ANSI_RESET );
                }else if (gameAria.getStateArea(i,j).equals(" x ")) {
                    System.out.print(gameAria.BACKGROUND_BLUE + gameAria.ANSI_RED + gameAria.getStateArea(i,j) + gameAria.ANSI_RESET );
                }else if (gameAria.getStateArea(i,j).equals(" X ")) {
                    System.out.print(gameAria.BACKGROUND_RED + gameAria.getStateArea(i,j) + gameAria.ANSI_RESET );
                }
            }
            System.out.print("\n");
        }
    }


}