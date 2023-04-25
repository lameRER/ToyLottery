import controller.UserController;
import model.FileOperationImp;
import model.RepositoryFile;
import view.ViewConsole;

public class Main {
    public static void main(String[] args) {
        var fileOperation = new FileOperationImp("priz.txt");
        var repository = new RepositoryFile(fileOperation);
        var controller = new UserController(repository);
        var view = new ViewConsole(controller);
        view.run();
    }
}
