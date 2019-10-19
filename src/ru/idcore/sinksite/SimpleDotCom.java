package ru.idcore.sinksite;

public class SimpleDotCom {
    private int[] locationCells;
    private int numOfHits;

    public String checkYourself(String stringGuess) {
        //преобразуем в String
        int guess = Integer.parseInt(stringGuess);
        //переменная для хранения результата, который будем возвращать
        String result = "Мимо";
        //подторяем для каждой ячейки массива
        for (int cell: locationCells
             ) {
            if (guess == cell) {
                result = "Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "Потопил";
        }
        System.out.println(result);
        return result;
    }

    public int[] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits(int numOfHits) {
        this.numOfHits = numOfHits;
    }
}
