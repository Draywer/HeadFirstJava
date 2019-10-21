package ru.idcore.gamearia;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    //тип корабля
    private String nameShip;
    //размер корабля
    private int size;
    //начальные координаты для рисования корабля
    private int verticalStartPoint;
    private int horizontalStartPoint;
    //зона(область), занимаемая кораблем
    private GameZone[] gameZones;
    //ориентация корабля: true - горизонтально, false - вертикально
    private boolean shipOrient;
    //количество попаданий
    private int countHit;
    //состояние корабля
    private String shipState;
    //соседние корабли
    private Set<Ship> shipSet;

    public Ship(int size, GameZone[][] gameZones, String stateOld, String stateNew) {
        //размер корабля
        this.size = size;
        String[] nameCatalog = {"Торпедный катер (однопалубный)", "Эсминец (двухпалубный)", "Крейсер (трехпалубный)", "Линкор (четырехпалубный)", "Адмирал (пятипалубный)"};
        this.nameShip = nameCatalog[size - 1];
        this.gameZones = new GameZone[size];
        this.shipSet = new HashSet<>();
        this.countHit = 0;
        this.shipState = "НЕПОВРЕЖДЕН";

        //поиск расположения корабля и определение начальной зоны расположения корабля
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

    //определяем состояние корабля
    public String getShipState() {
        if (this.countHit > 0 && this.countHit < this.size) {
            shipState = "РАНЕН";
        } else if (this.countHit == this.size) {
            shipState = "ПОТОПЛЕН";
            return shipState;
        }
        return shipState;
    }

    //получаем название корабля
    public String getNameShip() {
        return nameShip;
    }

    //устанавливаем название корабля
    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
    }

    //получаем размер корабля
    public int getSize() {
        return size;
    }

    //задаем размер корабля
    public void setSize(int size) {
        this.size = size;
    }

    //получаем область занимаемую кораблем
    public GameZone[] getGameZones() {
        return gameZones;
    }

    //устанавливаем зону занимаемую кораблем
    public void setGameZones(GameZone[] gameZones) {
        this.gameZones = gameZones;
    }

    //поучаем ориентацию корабля
    public boolean isShipOrient() {
        return shipOrient;
    }

    //устанавливаем ориентацию корабля
    public void setShipOrient(boolean shipOrient) {
        this.shipOrient = shipOrient;
    }

    //узнаем количество попаданий в корабль
    public int getCountHit() {
        return countHit;
    }

    //устанавливаем количество попаданий в корабль
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
    private void findShipPosition(int size, GameZone[][] gameZones, String state){
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
            }
//            else if (!gameZones[verticalStartPoint][horizontalStartPoint].getStateName().equals(state)) {
//                //если начальная зона занята
//                positionShipFound = false;
//            }
        }
    }

    //проверка горизонтального расположения корабля
    private boolean checkHorizontalShipPosition(int size, GameZone[][] gameZones, String state, int verticalStartPoint, int horizontalStartPoint){
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
    private boolean checkVerticalShipPosition(int size, GameZone[][] gameZones, String state, int verticalStartPoint, int horizontalStartPoint){
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

    //вариант ориентации корабля
    public boolean randomOrientShip(){
        //
        return false;
    }

    //привет коробль
    public void hiShip(Ship ship){
        //
    }

    //получить окружение корабля
    public Set<Ship> getShipSet() {
        return shipSet;
    }


    //установить окружение корабля
    public void setShipSet(Set<Ship> shipSet) {
        this.shipSet = shipSet;

        if (isShipOrient()) {
            //если корабль горизонтально ориентирован

        }else {
            //если корабль вертикально ориентирован

        }
    }
    //получение строки координат зон, занимаемых кораблем в формате А1
    public String getShipGameZone(GameAria gameAria){
        //
        StringBuilder shipGameZone = new StringBuilder();

        for (GameZone gameZone : this.gameZones
             ) {
            shipGameZone.append(gameZone.getGameZoneCoordinate(gameAria)).append(" ");
        }
        return shipGameZone.toString();
    }

    //получение состояния зон корабля ф формате: зона - состояние
    public String getShipGameZoneState (GameAria gameAria){
        //
        String shipGameZoneState = "";
        for (GameZone gameZone : this.gameZones
             ) {
            shipGameZoneState = shipGameZoneState + gameZone.getGameZoneState(gameAria) + "\n\t\t\t\t\t\t";
        }

        return shipGameZoneState;
    }

    //toString
    public String getShipNote(GameAria gameAria){
        String shipNote = "";

        shipNote = "Корабль: " + this.toString() + "\n" + "Тип: " + this.nameShip + "\n" +
                "Размер: " + this.size + "\n" +
                "Начальные координаты: " + gameAria.getVerticalCoordinate(verticalStartPoint) + horizontalStartPoint + "\n" +
                "Тип расположения: " + (isShipOrient()? "горизонтально":"вертикально") + "\n" +

                "Расположение: " + this.getShipGameZone(gameAria) + "\n" +
                "Состояние частей корабля: " + "\n\t\t\t\t\t\t" + this.getShipGameZoneState(gameAria);

//
//
//
//
//        //начальные координаты для рисования корабля
//        private int verticalStartPoint;
//        private int horizontalStartPoint;
//        //зона(область), занимаемая кораблем
//        private GameZone[] gameZones;
//        //ориентация корабля: true - горизонтально, false - вертикально
//        private boolean shipOrient;
//        //количество попаданий
//        private int countHit;
//        //состояние корабля
//        private String shipState;
//        //соседние корабли
//        private Set<Ship> shipSet;

        return shipNote;
    }

    //можно ли сдвинуть корабль вправо
    //можно ли сдвинуть корабль влево
    //можно ли сдвинуть корабль вверх
    //можно ли сдвинуть корабль вниз
    //можно ли повернуть корабль относительно начальной позиции, если да то насколько: 90, 180(изменить начальную позицию), 270(изменить начальную позицию). 0 - если нельзя повернуть.
    //сдвиг корабля вправо (изменение начальнй позиции)
    //сдвиг корабля влево (изменение начальнй позиции)
    //сдвиг корабля вверх (изменение начальнй позиции)
    //сдвиг корабля вниз (изменение начальнй позиции)
    //поворот корабля относительно начальной позиции на 90, 180(изменение начальнй позиции), 270(изменить начальную позицию).

}

