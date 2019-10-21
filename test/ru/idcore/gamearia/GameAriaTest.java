package ru.idcore.gamearia;

import static org.junit.jupiter.api.Assertions.*;

class GameAriaTest {
    public static void main(String[] args) throws InterruptedException {
        GameArea gameArea = new GameArea(11, 11);
        GameArea gameAreaComputer = new GameArea(11, 11);
//        gameArea.drawGameArea();
//        gameAreaComputer.drawGameArea();

        //Формируем флотилию и расставляем ее на игровом поле
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= 4 - i +1; j++) {
                Ship ship = new Ship(i, gameArea, gameArea.getGameZones(),  2);
                gameArea.setShips(ship);
                //System.out.println(ship.getShipNote(gameArea));
                //System.out.println("\n");
            }
        }

        //Формируем флотилию и расставляем ее на игровом поле
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= 4 - i +1; j++) {
                Ship ship = new Ship(i, gameAreaComputer, gameAreaComputer.getGameZones(),  2);
                gameAreaComputer.setShips(ship);
                //System.out.println(ship.getShipNote(gameAreaComputer));
                //System.out.println("\n");
            }
        }

        GameArea.drawGameArea(gameArea, gameAreaComputer);
        //GameArea.shipNotes(gameArea, gameAreaComputer);

        //потопить все корабли - залп из всех орудий
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                gameArea.getGameZones()[i][j].setStateAfterFire(gameArea, 4);
            }
        }

        //потопить все корабли - залп из всех орудий
        for (int i = 4; i <= 9; i++) {
            for (int j = 4; j <= 9; j++) {
                gameAreaComputer.getGameZones()[i][j].setStateAfterFire(gameAreaComputer, 4);
            }
        }

        System.out.println("");
        System.out.println("Обстреляли зоны");
        System.out.println("");

        //проверка попаданий в корабли
        for (Ship ship: gameArea.getShips()
        ) {
            ship.setCountHit(gameArea);
        }

        //проверка попаданий в корабли
        for (Ship ship: gameAreaComputer.getShips()
        ) {
            ship.setCountHit(gameArea);
        }

        GameArea.drawGameArea(gameArea, gameAreaComputer);

        //выводим состояния кораблей после атаки
        System.out.println("\n");
        System.out.println("Состояние кораблей - Игрок2: Компьютер");
        System.out.println("\n");
        for (Ship ship: gameAreaComputer.getShips()
        ) {
            System.out.println(ship.getShipNote(gameAreaComputer));
        }
    }
}