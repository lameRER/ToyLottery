package view;

import controller.UserController;
import model.Commands;
import model.Lottery;
import model.Toy;

import java.util.Scanner;

public class ViewConsole {
    private final UserController controller;

    public ViewConsole(UserController controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String command = prompt("Введите команду: ", in).toUpperCase();
            Commands com = Commands.valueOf(command);
            Lottery lottery = new Lottery();
            controller.addToys(lottery, 30);
            switch (com) {
                case ADD:
                    int size = Integer.valueOf(prompt("Сколько игрушек разыгрываем?: ", in));
                    controller.addToys(lottery, size);
                    for (Toy toy : lottery.getToysList()) {
                        System.out.println(toy);
                    }
                    break;
                case LOTTERY:
                    Toy prize = controller.showPrize(lottery);
                    System.out.println(prize);
                    break;
                case PRIZES:
                    controller.showAll().forEach(System.out::println);
                    break;
                case EXIT:
                    in.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private String prompt(String message, Scanner in) {
        System.out.print(message);
        return in.nextLine();
    }
}
