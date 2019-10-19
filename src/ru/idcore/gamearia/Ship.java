package ru.idcore.gamearia;

import java.util.ArrayList;

public class Ship {
    private int size;
    public GameZone[] gameZones;

    public Ship(int size, GameZone[][] gameZones, String state) {
        this.size = size;
        this.gameZones = new GameZone[size];
        this.gameZones[0] = gameZones[1][1];
        this.gameZones[1] = gameZones[1][2];
        this.gameZones[2] = gameZones[1][3];
        for (GameZone gameZone: this.gameZones
             ) {
            gameZone.setStateName(state);
        }

    }
}
