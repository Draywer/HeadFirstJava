package ru.idcore.sinksite;

public class Ship {
    //размер корабля
    private final int Size;
    private char[] shipParts;
    private char[] conds = {'N', 'H', 'X'};
    public int getSize() {
        return Size;
    }

    public Ship(int size) {
        Size = size;
        shipParts = new char[Size];
        for (int i = 0; i <= shipParts.length - 1; i++){
            shipParts[i] = conds[0];
        }
    }
    public void drawShip(char[][] chars, int x, int y, boolean b){
        //начальные координаты
        int x1 = x;
        int y1 = y;

        //рисуем горизонтально b = true
        if (b) {
            for (int i = 0; i <= Size - 1; i++) {
                chars[x + i - 1][y - 1] = shipParts[i];
            }
        } else {
            //рисуем вертикально
            for (int i = 0; i <= Size - 1; i++) {
                chars[x - 1][y + i - 1] = shipParts[i];
            }
        }

    }

    public boolean checkShipAreaHorizontalFree(char[][] chars, int x, int y, int size, int linesLeft, int linesRight, int linesUp, int linesDown){
        for (int i = x - linesLeft; i <= x + size; i++){
            for (int j = y - linesUp; j <= y + linesDown; j++){
                if (chars[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkShipAreaVerticalFree(char[][] chars, int x, int y, int size, int linesLeft, int linesRight, int linesUp, int linesDown){
        for (int i = x - linesLeft; i <= x + linesRight; i++){
            for (int j = y - linesUp; j <= y + size; j++){
                if (chars[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }




    public ShipPositionForDraw setPosition(char[][] chars, int size){
        int x;
        int y;
        boolean b;
        boolean placeFound = false;
        ShipPositionForDraw forDraw;

        switch (size) {

            case 1:
                while (!placeFound) {
                    x = (int) (Math.random() * 9);
                    y = (int) (Math.random() * 9);

                    //левый угол
                    if (x == 0 && y == 0 && chars[x][y] == ' ') {
                        if (chars[x][y + 1] == ' ' && chars[x + 1][y] == ' ' && chars[x + 1][y + 1] ==' ') {
                                b = true;
                                forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                                placeFound = true;
                                return forDraw;
                            }
                            //правый угол
                    } else if (x == 9 && y == 0 && chars[x][y] == ' ') {
                        if (chars[x - 1][y] == ' ' && chars[x - 1][y + 1] == ' ' && chars[x][y + 1] == ' ') {
                                b = true;
                                forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                                placeFound = true;
                                return forDraw;
                            }
                            //нижний правый угол
                    } else if (x == 9 && y == 9 && chars[x][y] == ' ') {
                        if (chars[x - 1][y] == ' ' && chars[x - 1][y - 1] == ' ' && chars[x][y - 1] ==' ') {
                                b = true;
                                forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                                placeFound = true;
                                return forDraw;
                            }
                            //нижний левый угол
                    } else if (x == 0 && y == 9 && chars[x][y] == ' ') {
                        if (chars[x][y - 1] == ' ' && chars[x + 1][y - 1] == ' ' && chars[x + 1][y] ==' ') {
                                b = true;
                                forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                                placeFound = true;
                                return forDraw;
                            }
                             //в ряду А
                    } else if (x > 0 && x < 9 && y == 0 && chars[x][y] == ' ') {
                        if (chars[x - 1][y] == ' ' && chars[x - 1][y + 1] == ' ' && chars[x][y + 1] ==' '
                                    && chars[x + 1][y + 1] ==' ' && chars[x + 1][y] ==' ') {
                                b = true;
                                forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                                placeFound = true;
                                return forDraw;
                            }
                            //в колонке 10
                    } else if (x == 9 && y > 0 && y < 9 && chars[x][y] == ' ') {
                        if (chars[x][y - 1] == ' ' && chars[x - 1][y - 1] == ' ' && chars[x - 1][y] ==' '
                                && chars[x - 1][y + 1] ==' ' && chars[x][y + 1] ==' ') {
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                        //в ряду К
                    } else if (x > 0 && x < 9 && y == 9 && chars[x][y] == ' ') {
                        if (chars[x - 1][y] == ' ' && chars[x - 1][y - 1] == ' ' && chars[x][y - 1] ==' '
                                && chars[x + 1][y - 1] ==' ' && chars[x + 1][y] ==' ') {
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                        //в колонке 1
                    } else if (x == 0 && y > 0 && y < 9 && chars[x][y] == ' ') {
                        if (chars[x][y - 1] == ' ' && chars[x + 1][y - 1] == ' ' && chars[x + 1][y] ==' '
                                && chars[x + 1][y + 1] ==' ' && chars[x][y + 1] ==' ') {
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                        //в любом месте поля
                    } else if (x > 0 && x < 9 && y > 0 && y < 9 && chars[x][y] == ' ') {
                        if (chars[x - 1][y - 1] == ' ' && chars[x][y - 1] == ' ' && chars[x + 1][y - 1] ==' '
                                && chars[x + 1][y] ==' ' && chars[x + 1][y + 1] ==' ' && chars[x][y + 1] ==' '
                                && chars[x - 1][y + 1] ==' ' && chars[x - 1][y] ==' ') {
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }
                }

            case 2:
                //
                while (!placeFound) {
                    x = (int) (Math.random() * 9);
                    y = (int) (Math.random() * 9);

                    //левый нижний угол
                    if (x == 0 && y == 9 && chars[x][y] == ' '){
                        if(checkShipAreaHorizontalFree(chars, x, y, size, 0, 0,1,0)){
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        } else if (checkShipAreaVerticalFree(chars, x, y, 0, 0,1,y - size - 1,0)) {
                            b = false;
                            forDraw = new ShipPositionForDraw(x + 1, y - size + 2, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }

                    //правый нижний угол
                    if (x == 9 && y == 9 && chars[x][y] == ' '){
                        if(checkShipAreaHorizontalFree(chars, x, y, 0, 2, 0,1,1)){
                            b = true;
                            forDraw = new ShipPositionForDraw(x - size + 2, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        } else if (checkShipAreaVerticalFree(chars, x, y, 0, 1,0,y - size - 1,0)) {
                            b = false;
                            forDraw = new ShipPositionForDraw(x + 1, y - size + 2, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }

                    //правый верхний угол
                    if (x == 9 && y == 0 && chars[x][y] == ' '){
                        if(checkShipAreaHorizontalFree(chars, x, y, 0, 2, 0,0,1)){
                            b = true;
                            forDraw = new ShipPositionForDraw(x - size + 2, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        } else if (checkShipAreaVerticalFree(chars, x, y, size, 1,0,0,1)) {
                            b = false;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }

                    //левый верхний угол
                    if (x == 0 && y == 0 && chars[x][y] == ' '){
                        if(checkShipAreaHorizontalFree(chars, x, y, size, 0, 0,0,1)){
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        } else if (checkShipAreaVerticalFree(chars, x, y, size, 0,1,0,1)) {
                            b = false;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }
                    //в любом месте доски
                    if (x > 0 && x < 9 - size && y > 0 && y < 9 - size && chars[x][y] == ' '){
                        if(checkShipAreaHorizontalFree(chars, x, y, size, 1, 0,1,1)){
                            b = true;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        } else if (checkShipAreaVerticalFree(chars, x, y, size, 1,1,1,0)) {
                            b = false;
                            forDraw = new ShipPositionForDraw(x + 1, y + 1, b);
                            placeFound = true;
                            return forDraw;
                        }
                    }
                }

            case 3:
                //
            case 4:
                //
        }









        return null;
    }


}
