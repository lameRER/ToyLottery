package model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements IRepository {

    private final Mapper mapper = new Mapper();
    private final FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Toy> getAllPrizes() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }
        return toys;
    }

    @Override
    public void addPrize(Toy toy) {
        List<Toy> toys = getAllPrizes();
        toys.add(toy);
        List<String> lines = new ArrayList<>();
        for (Toy item : toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public void saveAllLines(List<Toy> toys) {
        List<String> lines = new ArrayList<>();
        for (Toy item : toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
