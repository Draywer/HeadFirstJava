package ru.idcore.sinksite;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDotComTest {
    public static void main(String[] args) {
        //создаем экземпляр класса SimpleDotCom
        SimpleDotCom dot = new SimpleDotCom();
        //Создаем массив для местоположения сайта (три последовательные числа из 7)
        int[] location = {2, 3, 4};
        //вызываем setter сайта
        dot.setLocationCells(location);
        //делаем ход от имени пользователя
        String userGuess = "2";
        //вызываем метод checkYourself объекта SimpleDotCom
        String result = dot.checkYourself(userGuess);

        String testResult = "Неудача";

        if (result.equals("Попал")) {
            testResult = "Пройден";
        }
        System.out.println(testResult);
    }
}