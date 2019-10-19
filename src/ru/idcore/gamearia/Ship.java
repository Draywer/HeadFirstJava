package ru.idcore.gamearia;

import java.util.ArrayList;

public class Ship {
    //размер корабля
    private int size;
    //начальные координаты для рисования корабля
    private int verticalStartPoint;
    private int horizontalStartPoint;
    //зона занимаемая кораблем
    private GameZone[] gameZones;
    //ориентация корабля: true - горизонтально, false - вертикально
    private boolean shipOrient;

    public Ship(int size, GameZone[][] gameZones, String state) {
        this.size = size;
        this.gameZones = new GameZone[size];
        //поиск расположения корабля
        findShipPosition(size, gameZones, state);
        //располагаем корабль на игровом поле
        this.gameZones[0] = gameZones[1][1];
        this.gameZones[1] = gameZones[1][2];
        this.gameZones[2] = gameZones[1][3];
        for (GameZone gameZone: this.gameZones
             ) {
            gameZone.setStateName(state);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public GameZone[] getGameZones() {
        return gameZones;
    }

    public void setGameZones(GameZone[] gameZones) {
        this.gameZones = gameZones;
    }

    public boolean isShipOrient() {
        return shipOrient;
    }

    public void setShipOrient(boolean shipOrient) {
        this.shipOrient = shipOrient;
    }

    //поиск расположения корабля
    public void findShipPosition(int size, GameZone[][] gameZones, String state){
        boolean positionShipFound = false;

        while (!positionShipFound) {
            //задаем координаты начальной зоны
            int verticalStartPoint = (int) (Math.random() * 9 + 1);
            int horizontalStartPoint = (int) (Math.random() * 9 + 1);

            //проверяем занята ли начальная зона для расположения корабля
            if (gameZones[verticalStartPoint][horizontalStartPoint].getStateName().equals(state)) {
                //если начальная зона свободна
                //проверяем можно ли расположить корабль горизонтально
                if (checkHorizontalShipPosition(size, gameZones, state, verticalStartPoint, horizontalStartPoint)) {
                    //располагаем горизонтально
                    this.verticalStartPoint = verticalStartPoint;
                    this.horizontalStartPoint = horizontalStartPoint;
                    this.shipOrient = true;
                    positionShipFound = true;
                } else if (checkVerticalShipPosition(size, gameZones, state, verticalStartPoint, horizontalStartPoint)) {
                    //располагаем вертикально
                    this.verticalStartPoint = verticalStartPoint;
                    this.horizontalStartPoint = horizontalStartPoint;
                    this.shipOrient = false;
                    positionShipFound = true;
                }
            } else if (!gameZones[verticalStartPoint][horizontalStartPoint].getStateName().equals(state)) {
                //если начальная зона занята
                positionShipFound = false;
            }
        }
    }

    //проверка горизонтального расположения корабля
    public boolean checkHorizontalShipPosition(int size, GameZone[][] gameZones, String state, int verticalStartPoint, int horizontalStartPoint){
        if (verticalStartPoint == 1 && horizontalStartPoint == 1) {
            //расположение корабля от правого верхнего угла


        } else if (verticalStartPoint > 1 && verticalStartPoint < gameZones.length - 1 && horizontalStartPoint == 1) {
            //расположение корабля от левой границы поля

        } else if (verticalStartPoint == gameZones.length - 1 && horizontalStartPoint == 1) {
            //расположение корабля от левого нижнего угла

        } else if (verticalStartPoint == 1 && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1 - size) {
            //расположение корабля у верхней границы игрового поля

        } else if (verticalStartPoint > 1 && verticalStartPoint < gameZones.length - 1 && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1 - size) {
            //расположение корабля на игровом поле

        } else if (verticalStartPoint == gameZones.length - 1 && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1 - size) {
            //расположение корабля у нижней границы игрового поля

        }
        return false;
    }

    //проверка вертикального расположения корабля
    public boolean checkVerticalShipPosition(int size, GameZone[][] gameZones, String state, int verticalStartPoint, int horizontalStartPoint){
        //
        return false;
    }


}
