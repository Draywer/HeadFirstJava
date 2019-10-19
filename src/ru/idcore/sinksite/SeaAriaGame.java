package ru.idcore.sinksite;

public class SeaAriaGame {
    private char[][] conditions = new char[10][10];

    public char getConditionPartOfShip(int i, int j) {
        return conditions[i][j];
    }

    public char[][] getConditions() {
        return conditions;
    }

    public void setConditionPartOfShip(int i, int j, char c) {
        conditions[i][j] = c;
    }

    public void setConditions(char[][] conditions) {
        this.conditions = conditions;
    }

    public void drawSaeAria(){
        char[] chars = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К'};
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 10;
        //Отрисовываем горизонтальные координаты
        System.out.print("    ");
        for (int i = 0; i <= ints.length - 1; i ++) {
            System.out.print(ints[i] + "   ");
        }
        System.out.println("");
        //Отрисовываем горизонтальную черту
        System.out.print("\u001B[31m" + "  - - -" + "\u001B[0m");
        for (int i = 0; i <= k -2; i ++) {
            System.out.print("\u001B[31m" + " - -" + "\u001B[0m");
        }
        System.out.println("");

        //Заполняем горизонтальный ряд: Буква ряда и часть корабля
        //цикл по строкам
        for (int n = 0; n <= k - 1; n++) {
            //Выводим букву ряда
            System.out.print(chars[n]);
            System.out.print("\u001B[31m" + " |"+ "\u001B[0m");
            //Состояние части корабля
            //цикл по столбцам
            for (int j = 0; j <= k - 1; j++) {
                if (getConditionPartOfShip(n, j) == ' ') {
                    System.out.print(" " + getConditionPartOfShip(n, j) +   " " + "\u001B[31m" + "|" + "\u001B[0m");
                } else if (getConditionPartOfShip(n, j) != ' ') {
                    System.out.print("\u001b[41m" + " " +  getConditionPartOfShip(n, j) + " " + "\u001b[0m" + "\u001B[31m" + "|" + "\u001B[0m");
                }
            }
            System.out.println("");
            //Отрисовываем нижнюю черту ряда
            System.out.print("\u001B[31m" + "  - - -" + "\u001B[0m");
            for (int m = 0; m <= k - 2; m++) {
                System.out.print("\u001B[31m" + " - -" + "\u001B[0m");
            }
            System.out.println("");
        }
    }
}
