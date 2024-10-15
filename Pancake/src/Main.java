import java.io.File;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        File file = new File("/workspaces/Java-Labs/Pancake/src/commands.txt");
        Robot robot = new Robot();
        robot.run(file);
    }
}