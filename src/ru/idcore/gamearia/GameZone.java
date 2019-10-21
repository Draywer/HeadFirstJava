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
    public GameZone(GameAria gameAria, int stateNameIndex, int verticalCoordinate, int horizontalCoordinate) {
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
    public String getGameZoneCoordinate(GameAria gameAria){
        //
        String gameZoneCoordinate = gameAria.getVerticalCoordinate(verticalCoordinate) + horizontalCoordinate;
        return gameZoneCoordinate;
    }
    //получение состояния зоны
    public String getGameZoneState(GameAria gameAria){
        //
        String getGameZoneState = "";
        switch (this.getStateNameIndex()) {
            case 0:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - ";
                return getGameZoneState;
            case 1:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - " + "Cвободная игровая зона";
                return getGameZoneState;
            case 2:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - " + "Активная зона корабля";
                return getGameZoneState;
            case 3:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - " + "тех.зона";
                return getGameZoneState;
            case 4:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - " + "Пораженная зона корабля. Ранение";
                return getGameZoneState;
            case 5:
                getGameZoneState = getGameZoneCoordinate(gameAria) + " - " + "Пораженная зона корабля. Ранение";
                return getGameZoneState;

        }
        return getGameZoneState;
    }
}
