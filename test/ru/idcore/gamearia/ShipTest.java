package ru.idcore.gamearia;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    public static void main(String[] args) {
//        for (int i = 1; i <= 11; i++) {
//            GameAria gameAria = new GameAria(i, i);
//            gameAria.drawGameAria();
//        }

        GameArea gameArea = new GameArea(11, 11);
//
//        //левый верхний угол
//        gameAria.getGameZones()[3][1].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][2].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][3].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][4].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][5].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][6].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[2][6].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[2][5].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[1][5].setStateName(gameAria.getState(2));
//
//        //правый верхний угол
//        gameAria.getGameZones()[1][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[2][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][9].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[3][10].setStateName(gameAria.getState(2));
//
//        //правый нижний угол
//        gameAria.getGameZones()[10][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[9][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[8][8].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[8][9].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[8][10].setStateName(gameAria.getState(2));
//
//        //левый нижний угол
//        gameAria.getGameZones()[8][1].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[8][2].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[8][3].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[9][3].setStateName(gameAria.getState(2));
//        gameAria.getGameZones()[10][3].setStateName(gameAria.getState(2));

//        //выстрел
//        gameAria.getGameZones()[1][6].setStateName(gameAria.getState(2));

//        Ship ship1 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship2 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship3 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship4 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship5 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship6 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship7 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));
//        Ship ship8 = new Ship(4, gameAria.getGameZones(), gameAria.getState(1), gameAria.getState(2));

        //Формируем флотилию и расставляем ее на игровом поле
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= 4 - i +1; j++) {
                Ship ship = new Ship(i, gameArea, gameArea.getGameZones(),  2);
                gameArea.setShips(ship);
                System.out.println(ship.getShipNote(gameArea));
                //System.out.println("\n");
            }
        }

        gameArea.drawGameArea();
        //System.out.println("");
        System.out.println("ПРИКАЗЫВАЮ: ПОТОПИТЬ ВРАЖЕСКУЮ ФЛОТИЛИЮ! ЗАЛП ИЗ ВСЕХ ОРУДИЙ! ОГОНЬ!");
        //System.out.println("");

        //выстрел
//        gameAria.getGameZones()[5][5].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[1][1].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[1][10].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[10][1].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[10][10].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[3][6].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[4][10].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[8][9].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[8][1].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[9][4].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[9][9].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[1][6].setStateName(gameAria.getState(4));
//        gameAria.getGameZones()[4][7].setStateName(gameAria.getState(4));

        //потопить все корабли - залп из всех орудий
        for (int i = 2; i <= 8; i++) {
            for (int j = 2; j <= 8; j++) {
                gameArea.getGameZones()[i][j].setStateAfterFire(gameArea, 4);
            }
        }

        //проверка попаданий в корабли
        for (Ship ship: gameArea.getShips()
             ) {
            ship.setCountHit(gameArea);
        }


        gameArea.drawGameArea();
        System.out.println("");
        System.out.println("КРЫМ НАШ! УРА!");
        System.out.println("");

//
//        System.out.println(gameAria.getGameZones()[1][1].checkGameZoneFree(gameAria.getState(1)));
//        System.out.println(gameAria.getGameZones()[1][2].checkGameZoneFree(gameAria.getState(1)));
//        System.out.println(gameAria.getGameZones()[1][3].checkGameZoneFree(gameAria.getState(1)));


        //выводим состояния кораблей после атаки
        for (Ship ship: gameArea.getShips()
             ) {
            //System.out.println(ship.getNameShip() + " : " + "Количество попаданий - " + ship.getCountHit() + "; Состояние - " + ship.getShipState());
            System.out.println(ship.getShipNote(gameArea));
        }

    }
}