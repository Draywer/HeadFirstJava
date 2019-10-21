package ru.idcore.gamearia;

//*

import java.util.ArrayList;

/**
 * Класс GameArea
 *
 * @author Draywer
 */
public class GameArea {
    private int horizontalSize;
    private int verticalSize;
    private String[] state = {"   ", " o ", " + ", " v ", " x ", " X "};
    private String[] verticalCoordinate = {"  ", " А ", " Б "," В "," Г "," Д "," Е "," Ж "," З "," И "," К "};
    private String[] horizontalCoordinate = {"  ", " 1 ", " 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "," 10 "};
    //private String[][] stateArea;
    private GameZone[][] gameZones;
    private ArrayList<Ship> ships;

    /**
     * The constant ANSI_RESET.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The constant ANSI_BLACK.
     */
    public static final String ANSI_BLACK = "\u001B[30m";
    /**
     * The constant ANSI_RED.
     */
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * The constant ANSI_GREEN.
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    /**
     * The constant ANSI_YELLOW.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    /**
     * The constant ANSI_BLUE.
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    /**
     * The constant ANSI_PURPLE.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";
    /**
     * The constant ANSI_CYAN.
     */
    public static final String ANSI_CYAN = "\u001B[36m";
    /**
     * The constant ANSI_WHITE.
     */
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * The constant BACKGROUND_BLACK.
     */
    public static final String BACKGROUND_BLACK = "\u001b[40m";
    /**
     * The constant BACKGROUND_RED.
     */
    public static final String BACKGROUND_RED = "\u001b[41m";
    /**
     * The constant BACKGROUND_GREEN.
     */
    public static final String BACKGROUND_GREEN = "\u001b[42m";
    /**
     * The constant BACKGROUND_YELLOW.
     */
    public static final String BACKGROUND_YELLOW = "\u001b[43m";
    /**
     * The constant BACKGROUND_BLUE.
     */
    public static final String BACKGROUND_BLUE = "\u001b[44m";
    /**
     * The constant BACKGROUND_MAGENTA.
     */
    public static final String BACKGROUND_MAGENTA = "\u001b[45m";
    /**
     * The constant BACKGROUND_CYAN.
     */
    public static final String BACKGROUND_CYAN = "\u001b[46m";
    /**
     * The constant BACKGROUND_WHITE.
     */
    public static final String BACKGROUND_WHITE = "\u001b[47;1m";


    /**
     * Instantiates a new Game area.
     *
     * @param verticalSize   the vertical size
     * @param horizontalSize the horizontal size
     */
    public GameArea(int verticalSize, int  horizontalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        //stateArea = new String[verticalSize][horizontalSize];
        this.gameZones = new GameZone[verticalSize][horizontalSize];
        this.ships = new ArrayList<Ship>();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (i == 0 && j == 0) {
                    gameZones[i][j] = new GameZone(this,0, i, j);
                    gameZones[i][j].setStateName(state[0]);
                } else if (i == 0 && j > 0) {
                    gameZones[i][j] = new GameZone(this, j, i, j);
                    gameZones[i][j].setStateName(getHorizontalCoordinate(j));
                } else if (i > 0 && j == 0) {
                    gameZones[i][j] = new GameZone(this, i, i, j);
                    gameZones[i][j].setStateName(getVerticalCoordinate(i));
                } else if (i > 0 && j > 0) {
                    gameZones[i][j] = new GameZone(this, 1, i, j);
                    gameZones[i][j].setStateName(getState(1));
                }
            }
        }

    }

    /**
     * Gets ships.
     *
     * @return the ships
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    /**
     * Sets ships.
     *
     * @param ship the ship
     */
    public void setShips(Ship ship) {
        this.ships.add(ship);
    }

    /**
     * Gets horizontal size.
     *
     * @return the horizontal size
     */
    public int getHorizontalSize() {
        return horizontalSize;
    }

    /**
     * Sets horizontal size.
     *
     * @param horizontalSize the horizontal size
     */
    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    /**
     * Gets vertical size.
     *
     * @return the vertical size
     */
    public int getVerticalSize() {
        return verticalSize;
    }

    /**
     * Sets vertical size.
     *
     * @param verticalSize the vertical size
     */
    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }

    /**
     * Gets state.
     *
     * @param index the index
     * @return the state
     */
    public String getState(int index) {return state[index];
    }

    /**
     * Gets vertical coordinate.
     *
     * @param index the index
     * @return the vertical coordinate
     */
    public String getVerticalCoordinate(int index) {return verticalCoordinate[index];
    }

    /**
     * Gets horizontal coordinate.
     *
     * @param index the index
     * @return the horizontal coordinate
     */
    public String getHorizontalCoordinate(int index) {
        return horizontalCoordinate[index];
    }

    /**
     * Get game zones game zone [ ] [ ].
     *
     * @return the game zone [ ] [ ]
     */
    public GameZone[][] getGameZones() {
        return gameZones;
    }

    /**
     * Sets game zones.
     *
     * @param gameZones the game zones
     */
    public void setGameZones(GameZone[][] gameZones) {
        this.gameZones = gameZones;
    }


    /**
     * Draw game aria.
     */
    public void drawGameArea() {
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

    //рисование рядом двух игровых полей
    public static void drawGameArea(GameArea gameArea, GameArea gameAreaComputer) {
        //отрисовка GameAria
        String stringGameArea = "";
        String stringGameAreaComputer = "";
        for (int i = 0; i < gameArea.getVerticalSize(); i++) {
            stringGameArea = "";
            stringGameAreaComputer = "";
            for (int j = 0; j < gameArea.getVerticalSize(); j++) {
                stringGameArea = stringGameArea + gameArea.getGameZones()[i][j].drawGameZone(gameArea);
            }
            for (int k = 0; k < gameAreaComputer.getVerticalSize(); k++) {
                stringGameAreaComputer = stringGameAreaComputer + gameAreaComputer.getGameZones()[i][k].drawGameZone(gameAreaComputer);
            }
            System.out.print(stringGameArea + "\t" + stringGameAreaComputer);
            System.out.print("\n");
        }

        stringGameArea = "Игрок1: Александр";
        stringGameAreaComputer = "Игрок2: Компьютер";
        System.out.print("\t" + stringGameArea + "\t\t\t\t\t" + stringGameAreaComputer);
        System.out.print("\n");
    }

    //вывод общей информации по всем кораблям
    public static void shipNotes(GameArea gameArea, GameArea gameAreaComputer){
        String shipNotesGameArea = "";
        String shipNotesGameAreaComputer = "";

        for (Ship ship: gameArea.getShips()
             ) {
            shipNotesGameArea = shipNotesGameArea + ship.getShipNote(gameArea) + "\n";

        }
        for (Ship ship : gameAreaComputer.getShips()
        ){
            shipNotesGameAreaComputer = shipNotesGameAreaComputer + ship.getShipNote(gameAreaComputer) + "\n";
        }
        System.out.println(shipNotesGameArea + "\t\t\t\t\t" + shipNotesGameAreaComputer);
    }

}
