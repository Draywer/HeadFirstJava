package ru.idcore.guessnumber;

public class GuessGame {
    //Объявляем игроков
    Player player1 = new Player("Игрок1");
    Player player2 = new Player("Игрок2");
    Player player3 = new Player("Игрок3");

    //начало игры
    public void startGame(){
        //варианты ответов игроков
        int guessPlayer1 = 0;
        int guessPlayer2 = 0;
        int guessPlayer3 = 0;

        //переменые для хранения правильности ответов
        boolean player1Right = false;
        boolean player2Right = false;
        boolean player3Right = false;



        while (true){
            //число, которое должны угадать
            int targetNumber = (int) (Math.random() * 10);
            System.out.println("Я загадываю число от 0 до 9...");

            System.out.println("Число, которое нужно угадать, - " + targetNumber);

            //вызываем методы guess каждого игрока
            player1.guess();
            player2.guess();
            player3.guess();

            //извлекаем ответы каждого игрока
            guessPlayer1 = player1.getNumber();
            guessPlayer2 = player2.getNumber();
            guessPlayer3 = player3.getNumber();

            //проверяем ответы игроков
            if (guessPlayer1 == targetNumber) {
                player1Right = true;
            }
            if (guessPlayer2 == targetNumber) {
                player2Right = true;
            }
            if (guessPlayer3 == targetNumber) {
                player3Right = true;
            }

            if (player1Right || player2Right || player3Right) {
                System.out.println("У нас есть победитель!");
                System.out.println(player1.getName() + " угадал? - " + player1Right);
                System.out.println(player2.getName() + " угадал? - " + player2Right);
                System.out.println(player3.getName() + " угадал? - " + player3Right);
                System.out.println("Конец игры");
                break;
            }else {
                System.out.println("Игроки должны попробовать еще раз.");
                System.out.println("");
            }
        }
    }

}
