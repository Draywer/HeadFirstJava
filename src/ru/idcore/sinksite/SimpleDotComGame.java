package ru.idcore.sinksite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleDotComGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //объявляем переменную для хранения количества ходов пользователя
        int numOfGuesses = 0;
        //создаем новый экземпляр класса SimpleDotCom
        SimpleDotCom dotCom = new SimpleDotCom();
        //вычисляем начальное местоположение ячейки
        int startPoint = (int) (Math.random() * 4);
        //создаем целочисленный массив
        int[] location = {startPoint, startPoint + 1, startPoint + 2};
        dotCom.setLocationCells(location);

        //объявляем переменную для хранения состояния игры
        boolean isAlive = true;
        //пока сайт не потоплен
        while (isAlive) {
            System.out.print("Целься!");
            System.out.print("\t");
            String guess = reader.readLine();
            System.out.println("Выстрел!");
            String check = dotCom.checkYourself(guess);
            numOfGuesses++;
            if (check.equals("Потопил")) {
                isAlive = false;
                System.out.println("Количество попыток: " + numOfGuesses);
            }
        }

    }
}
