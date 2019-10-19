package ru.idcore.guessnumber;

public class Player {
    //Вариант числа
    private String name;
    private int number = 0;

    public void guess(){
        number = (int) (Math.random() * 10);
        System.out.println(name + ". Я думаю, что это число " + number);
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }
}
