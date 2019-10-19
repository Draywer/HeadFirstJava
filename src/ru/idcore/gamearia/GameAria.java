package ru.idcore.gamearia;

//*

import java.util.ArrayList;

public class GameAria {
    //
    private int horizontalSize;
    private int verticalSize;
    private String[] state = {"   ", " o ", " + ", " v ", " x ", " X "};
    private String[] verticalCoordinate = {"  ", " А ", " Б "," В "," Г "," Д "," Е "," Ж "," З "," И "," К "};
    private String[] horizontalCoordinate = {"  ", " 1 ", " 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "," 10 "};
    //private String[][] stateArea;
    private GameZone[][] gameZones;
    private ArrayList<Ship> ships;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String BACKGROUND_BLACK = "\u001b[40m";
    public static final String BACKGROUND_RED = "\u001b[41m";
    public static final String BACKGROUND_GREEN = "\u001b[42m";
    public static final String BACKGROUND_YELLOW = "\u001b[43m";
    public static final String BACKGROUND_BLUE = "\u001b[44m";
    public static final String BACKGROUND_MAGENTA = "\u001b[45m";
    public static final String BACKGROUND_CYAN = "\u001b[46m";
    public static final String BACKGROUND_WHITE = "\u001b[47;1m";


    public GameAria(int verticalSize, int  horizontalSize, String s) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        //stateArea = new String[verticalSize][horizontalSize];
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
//                if (i == 0 && j == 0) {
//                    stateArea[i][j] = state[0];
//                } else if (i == 0 && j > 0) {
//                    stateArea[i][j] = horizontalCoordinate[j];
//                } else if (i > 0 && j == 0) {
//                    stateArea[i][j] = verticalCoordinate[j];
//                } else if (i > 0 && j > 0) {
//                    stateArea[i][j] = state[1];
//                }
            }
        }

    }

    public GameAria(int verticalSize, int  horizontalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        //stateArea = new String[verticalSize][horizontalSize];
        this.gameZones = new GameZone[verticalSize][horizontalSize];
        this.ships = new ArrayList<Ship>();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (i == 0 && j == 0) {
                    gameZones[i][j] = new GameZone(state[0], i, j);
                } else if (i == 0 && j > 0) {
                    gameZones[i][j] = new GameZone(horizontalCoordinate[j], i, j);
                } else if (i > 0 && j == 0) {
                    gameZones[i][j] = new GameZone(verticalCoordinate[i], i, j);
                } else if (i > 0 && j > 0) {
                    gameZones[i][j] = new GameZone(state[1], i, j);
                }
            }
        }

    }



//    public String getStateArea(int i, int j) {
//        return stateArea[i][j];
//    }

//    public void setStateArea(int i, int j, String state) {
//        this.stateArea[i][j] = state;
//    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(Ship ship) {
        this.ships.add(ship);
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }

    public String getState(int index) {return state[index];
    }

    public String getVerticalCoordinate(int index) {return verticalCoordinate[index];
    }

    public String getHorizontalCoordinate(int index) {
        return horizontalCoordinate[index];
    }

    public GameZone[][] getGameZones() {
        return gameZones;
    }

    public void setGameZones(GameZone[][] gameZones) {
        this.gameZones = gameZones;
    }

    public void drawGameAria() {
        //отрисовка GameAria
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (gameZones[i][j].getStateName().equals(" + ")) {
                    System.out.print(BACKGROUND_YELLOW + gameZones[i][j].getStateName() + ANSI_RESET );
                } else if (gameZones[i][j].getStateName().equals(" o ")) {
                    System.out.print(BACKGROUND_BLUE + gameZones[i][j].getStateName() + ANSI_RESET );
                }else if (gameZones[i][j].getStateName().equals(" x ")) {
                    System.out.print(BACKGROUND_BLUE + ANSI_RED + gameZones[i][j].getStateName() + ANSI_RESET );
                }else if (gameZones[i][j].getStateName().equals(" X ")) {
                    System.out.print(BACKGROUND_RED + gameZones[i][j].getStateName() + ANSI_RESET );
                }else {
                    System.out.print(gameZones[i][j].getStateName());
                }
            }
            System.out.print("\n");
        }
    }
}
