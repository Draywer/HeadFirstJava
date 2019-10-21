package ru.idcore.gamearia;

import java.util.HashMap;
import java.util.Map;

public class GameZone {
    private String stateName;
    private int stateNameIndex;
    private final int verticalCoordinate;
    private final int horizontalCoordinate;
    private Map<Map<Integer, Integer>, String> mapGameZone;

    //String stateName
    public GameZone(GameArea gameArea, int stateNameIndex, int verticalCoordinate, int horizontalCoordinate) {
        //this.stateName = gameAria.getState(stateNameIndex);
        this.stateNameIndex = stateNameIndex;
        this.verticalCoordinate = verticalCoordinate;
        this.horizontalCoordinate = horizontalCoordinate;
        this.mapGameZone = new HashMap<Map<Integer, Integer>, String>();
//        Map<Integer, Integer> mapCoordinate = new HashMap<>();
//        mapCoordinate.put(verticalCoordinate, horizontalCoordinate);
//        mapGameZone.put(mapCoordinate, stateName);
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;

    }
    public void setStateAfterFire(GameArea gameArea, int stateNameIndex){
        this.stateNameIndex = stateNameIndex;
        this.stateName = gameArea.getState(stateNameIndex);
    }


    public int getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public int getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public Map<Map<Integer, Integer>, String> getMapGameZone() {
        return mapGameZone;
    }

    public void setMapGameZone(Map<Map<Integer, Integer>, String> mapGameZone) {
        this.mapGameZone = mapGameZone;
    }

    public int getStateNameIndex() {
        return stateNameIndex;
    }

    public void setStateNameIndex(int stateIndex) {
        this.stateNameIndex = stateIndex;
    }

    //проверка занятости зоны
    public boolean checkGameZoneFree(String stateName) {
        if (this.stateName.equals(stateName)) {
            return true;
        }
        return false;
    }

    //получение координат зоны
    public String getGameZoneCoordinate(GameArea gameArea){
        //
        String gameZoneCoordinate = gameArea.getVerticalCoordinate(verticalCoordinate) + horizontalCoordinate;
        return gameZoneCoordinate;
    }

    //получение состояния зоны
    public String getGameZoneState(GameArea gameArea){
        //
        String getGameZoneState = "";
        switch (this.getStateNameIndex()) {
            case 0:
                getGameZoneState = getGameZoneCoordinate(gameArea) + " - ";
                return getGameZoneState;
            case 1:
                getGameZoneState = getGameZoneCoordinate(gameArea) + " - " + "Cвободная игровая зона";
                return getGameZoneState;
            case 2:
                getGameZoneState = getGameZoneCoordinate(gameArea) + " - " + "Активная зона корабля";
                return getGameZoneState;
            case 3:
                getGameZoneState = getGameZoneCoordinate(gameArea) + " - " + "тех.зона";
                return getGameZoneState;
            case 4:
            case 5:
                getGameZoneState = getGameZoneCoordinate(gameArea) + " - " + "Пораженная зона корабля. Ранение";
                return getGameZoneState;

        }
        return getGameZoneState;
    }

    public String drawGameZone(GameArea gameArea){
        switch (this.getStateName()) {
            case " + ":
                return gameArea.BACKGROUND_YELLOW + this.getStateName() + gameArea.ANSI_RESET;
            case " o ":
                return gameArea.BACKGROUND_BLUE + this.getStateName() + gameArea.ANSI_RESET;
            case " x ":
                return gameArea.BACKGROUND_BLUE + gameArea.ANSI_RED + this.getStateName() + gameArea.ANSI_RESET;
            case " X ":
                return gameArea.BACKGROUND_RED + this.getStateName() + gameArea.ANSI_RESET;
            default:
                return this.getStateName();
        }
    }
}
