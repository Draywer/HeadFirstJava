package ru.idcore.sinksite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeaAriaGameTest {
    public static void main(String[] args) {
        SeaAriaGame ariaGame = new SeaAriaGame();


        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {

                ariaGame.setConditionPartOfShip(i, j, ' ');
            }
        }
        //создадим корабль
        Ship ship1 = new Ship(4);
        ariaGame.setConditionPartOfShip(0, 3, 'N');
        ariaGame.setConditionPartOfShip(0, 4, 'N');
        ariaGame.setConditionPartOfShip(0, 5, 'N');
        ariaGame.setConditionPartOfShip(0, 6, 'N');

//
//        Ship ship3 = new Ship(3);
//        ship3.drawShip(ariaGame.getConditions(), 1,1,false);
//
        Ship ship4 = new Ship(3);
        ship4.drawShip(ariaGame.getConditions(), 3,8,true);

//        Ship ship5 = new Ship(1);
//        ship5.drawShip(ariaGame.getConditions(), 10,1,true);

//        Ship ship6 = new Ship(2);
//        ship6.drawShip(ariaGame.getConditions(), 9,9,true);

//
        Ship ship7 = new Ship(1);
        ShipPositionForDraw forDraw = ship7.setPosition(ariaGame.getConditions(), ship7.getSize());
        ship7.drawShip(ariaGame.getConditions(), forDraw.getX(),forDraw.getY(),forDraw.isaBoolean());

        Ship ship8 = new Ship(1);
        ShipPositionForDraw forDraw1 = ship8.setPosition(ariaGame.getConditions(), ship8.getSize());
        ship8.drawShip(ariaGame.getConditions(), forDraw1.getX(),forDraw1.getY(),forDraw1.isaBoolean());

        Ship ship9 = new Ship(1);
        ShipPositionForDraw forDraw2 = ship9.setPosition(ariaGame.getConditions(), ship9.getSize());
        ship9.drawShip(ariaGame.getConditions(), forDraw2.getX(),forDraw2.getY(),forDraw2.isaBoolean());

        Ship ship10 = new Ship(1);
        ShipPositionForDraw forDraw3 = ship10.setPosition(ariaGame.getConditions(), ship10.getSize());
        ship10.drawShip(ariaGame.getConditions(), forDraw3.getX(),forDraw3.getY(),forDraw3.isaBoolean());

        Ship ship11 = new Ship(2);
        ShipPositionForDraw forDraw4 = ship11.setPosition(ariaGame.getConditions(), ship11.getSize());
        ship11.drawShip(ariaGame.getConditions(), forDraw4.getX(),forDraw4.getY(),forDraw4.isaBoolean());

        Ship ship12 = new Ship(2);
        ShipPositionForDraw forDraw5 = ship12.setPosition(ariaGame.getConditions(), ship12.getSize());
        ship12.drawShip(ariaGame.getConditions(), forDraw5.getX(),forDraw5.getY(),forDraw5.isaBoolean());

        Ship ship13 = new Ship(2);
        ShipPositionForDraw forDraw6 = ship13.setPosition(ariaGame.getConditions(), ship13.getSize());
        ship13.drawShip(ariaGame.getConditions(), forDraw6.getX(),forDraw6.getY(),forDraw6.isaBoolean());




        ariaGame.drawSaeAria();

//        for (char[] character: ariaGame.getConditions()
//             ) {
//            System.out.println(character);
//        }
    }
}