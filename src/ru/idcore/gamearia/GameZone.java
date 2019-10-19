package ru.idcore.gamearia;

import java.util.HashMap;
import java.util.Map;

public class GameZone {
    private String stateName;
    private final int verticalCoordinate;
    private final int horizontalCoordinate;
    private Map<String, Map<Integer, Integer>> mapGameZone;

    public GameZone(String stateName, int verticalCoordinate, int horizontalCoordinate) {
        this.stateName = stateName;
        this.verticalCoordinate = verticalCoordinate;
        this.horizontalCoordinate = horizontalCoordinate;
        this.mapGameZone = new HashMap<String, Map<Integer, Integer>>();
        Map<Integer, Integer> mapCoordinate = new HashMap<>();
        mapCoordinate.put(verticalCoordinate, horizontalCoordinate);
        mapGameZone.put(stateName, mapCoordinate);
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

    public Map<String, Map<Integer, Integer>> getMapGameZone() {
        return mapGameZone;
    }

    public void setMapGameZone(Map<String, Map<Integer, Integer>> mapGameZone) {
        this.mapGameZone = mapGameZone;
    }

    public boolean checkGameZoneFree(String stateName) {
        if (this.stateName.equals(stateName)) {
            return true;
        }
        return false;
    }
}
