package ru.idcore.gamearia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ship {
    //размер корабля
    private String[] nameCatalog = {"Торпедный катер (однопалубный)", "Эсминец (двухпалубный)", "Крейсер (трехпалубный)", "Линкор (четырехпалубный)"};
    private String nameShip;
    private int size;
    //начальные координаты для рисования корабля
    private int verticalStartPoint;
    private int horizontalStartPoint;
    //зона занимаемая кораблем
    private GameZone[] gameZones;
    //ориентация корабля: true - горизонтально, false - вертикально
    private boolean shipOrient;
    //количество попаданий
    private int countHit;
    //состояние корабля
    private String shipState;

    public Ship(int size, GameZone[][] gameZones, String stateOld, String stateNew) {
        this.size = size;
        this.nameShip = nameCatalog[size - 1];
        this.gameZones = new GameZone[size];
        this.countHit = 0;
        this.shipState = "НЕПОВРЕЖДЕН";
        //поиск расположения корабля
        findShipPosition(size, gameZones, stateOld);
        //располагаем корабль на игровом поле

        for (int i = 0; i < size; i++) {
            if (shipOrient) {
                //располагаем корабль горизонтально
                this.gameZones[i] = gameZones[verticalStartPoint][horizontalStartPoint + i];
            } else {
                //располагаем кораюль вертикально
                this.gameZones[i] = gameZones[verticalStartPoint + i][horizontalStartPoint];
            }
        }
        //изменям название зоны, в привязке к кораблю
        for (GameZone gameZone: this.gameZones) {
                gameZone.setStateName(stateNew);
            }
    }

    public String getShipState() {
        if (this.countHit > 0 && this.countHit < this.size) {
            shipState = "РАНЕН";
        } else if (this.countHit == this.size) {
            shipState = "ПОТОПЛЕН";
            return shipState;
        }
        return shipState;
    }

    public String getNameShip() {
        return nameShip;
    }

    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
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

    public int getCountHit() {
        return countHit;
    }

    public void setCountHit(GameAria gameAria) {
        //this.countHit = 0;
        for (GameZone zone: gameZones
             ) {
            if (zone.getStateName().equals(gameAria.getState(4))) {
                this.countHit++;
                zone.setStateName(gameAria.getState(5));
            }
        }
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
            //горизонтальное расположение корабля от левого верхнего угла
            for (int i = verticalStartPoint; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint < gameZones.length - 1 && horizontalStartPoint == 1) {
            //горизонтальное расположение корабля от левой границы поля
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == gameZones.length - 1 && horizontalStartPoint == 1) {
            //горизонтальное расположение корабля от левого нижнего угла
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == 1 && horizontalStartPoint > 1 && horizontalStartPoint <= gameZones.length - 1 - size) {
            //горизонтальное расположение корабля по верхней границе игрового поля
            for (int i = verticalStartPoint; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == 1 && horizontalStartPoint == gameZones.length - size) {
            //горизонтальное расположение корабля по верхней границе игрового поля к правому верхнему углу
            for (int i = verticalStartPoint; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size - 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint < gameZones.length - 1 && horizontalStartPoint > 1 && horizontalStartPoint <= gameZones.length - 1 - size) {
            //горизонтальное расположение корабля на игровом поле
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint < gameZones.length - 1 && horizontalStartPoint == gameZones.length - size) {
            //горизонтальное расположение корабля на игровом поле в притык к правой границе
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size - 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == gameZones.length - 1 && horizontalStartPoint > 1 && horizontalStartPoint <= gameZones.length - 1 - size) {
            //горизонтальное расположение корабля у нижней границы игрового поля
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == gameZones.length - 1 && horizontalStartPoint == gameZones.length - size) {
            //горизонтальное расположение корабля у нижней границы игрового поля в притык к правой границе
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + size - 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    //проверка вертикального расположения корабля
    public boolean checkVerticalShipPosition(int size, GameZone[][] gameZones, String state, int verticalStartPoint, int horizontalStartPoint){
        if (verticalStartPoint == 1 && horizontalStartPoint == 1) {
            //вертикальное расположение корабля от левого верхнего угла
            for (int i = verticalStartPoint; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        }else if (verticalStartPoint > 1 && verticalStartPoint <= gameZones.length - size - 1 && horizontalStartPoint == 1) {
            //вертикальное расположение корабля по левой границе поля
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint == gameZones.length - size && horizontalStartPoint == 1) {
            //вертикальное расположение корабля по левой границе поля в притык к левому нижнему углу
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size - 1; i++) {
                for (int j = horizontalStartPoint; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        }else if (verticalStartPoint == 1 && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1 ) {
            //вертикальное расположение корабля от верхней границы поля
            for (int i = verticalStartPoint; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint <= gameZones.length - size - 1 && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1 ) {
            //вертикальное расположение корабля по игровому полю
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        }else if (verticalStartPoint == gameZones.length - size && horizontalStartPoint > 1 && horizontalStartPoint < gameZones.length - 1) {
            //вертикальное расположение корабля по игровому полю в притык у нижней границе
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size - 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint + 1; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == 1 && horizontalStartPoint ==gameZones.length - 1 ) {
            //вертикальное расположение корабля от правого верхнего угла
            for (int i = verticalStartPoint; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint > 1 && verticalStartPoint <= gameZones.length - size - 1 && horizontalStartPoint == gameZones.length - 1 ) {
            //вертикальное расположение корабля по правой границе поля
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (verticalStartPoint == gameZones.length - size && horizontalStartPoint == gameZones.length - 1 ) {
            //вертикальное расположение корабля впритык к правому нижнему углу
            for (int i = verticalStartPoint - 1; i <= verticalStartPoint + size - 1; i++) {
                for (int j = horizontalStartPoint - 1; j <= horizontalStartPoint; j++){
                    if (!gameZones[i][j].checkGameZoneFree(state)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }


}
