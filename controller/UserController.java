package controller;

import model.IRepository;
import model.Lottery;
import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserController {
    private final IRepository repository;

    public UserController(IRepository repository) {
        this.repository = repository;
    }

    public Lottery generate(Lottery lottery, int size) {
        ArrayList<String> colours = new ArrayList<>(List.of("blue", "green", "yellow", "oringe"));
        ArrayList<String> names = new ArrayList<>(List.of("Doll", "Boll", "Car", "puzzles"));

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            lottery.getToysList().add(new Toy(names.get(random.nextInt(names.size())), random.nextInt(10), colours.get(random.nextInt(colours.size()))));
        }

        return lottery;
    }

    public Toy showPrize(Lottery lottery) {

        Random random = new Random();
        Toy prize = lottery.getToysList().get(random.nextInt(lottery.getToysList().size()));
        repository.addPrize(prize);
        return prize;

    }

    public List<Toy> showAll() {
        return repository.getAllPrizes();
    }

    public Lottery addToys(Lottery lottery, int size) {
        return generate(lottery, size);
    }
}
