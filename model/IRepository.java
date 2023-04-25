package model;

import java.util.List;

public interface IRepository {
    List<Toy> getAllPrizes();

    void addPrize(Toy toy);

    void saveAllLines(List<Toy> toys);
}
