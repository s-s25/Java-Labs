import java.io.File;
import java.util.Stack;
import java.util.Scanner;

public class Robot {
    private final Stack<VERT> verts;
    private final Stack<VERT> inuse;

    public Robot() {
        verts = new Stack<>();
        inuse = new Stack<>();
        verts.push(new VERT("E",5,"0"));
        verts.push(new VERT("D",4,"0"));
        verts.push(new VERT("C",3,"0"));
        verts.push(new VERT("B",2,"0"));
        verts.push(new VERT("A",1,"0"));
    }

    public void run(File file) {

        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()) {
            String command = scan.nextLine();
            char operation = command.charAt(0);
            String job = command.substring(1);
            VERT vert;

            if (operation == 'J') {
                vert = assignJob(job);
                if (vert != null )
                    System.out.println("VERT " + vert.getName() + " assigned job #" + job);
            } else if (operation == 'F') {
                vert = finishJob(job);
                if (vert != null)
                    System.out.println("Job #" + job + " finished by VERT " + vert.getName());
            }
        }

        scan.close();
    }

    private VERT assignJob(String job) {
        if (!verts.isEmpty()) {
            VERT vert = verts.pop();
            vert.setJob(job);
            inuse.push(vert);
            return vert;
        } else {
            System.out.println("No available VERT for job #" + job);
            return null;
        }
    }

    private VERT finishJob(String job) {
        VERT vert = findVertByJob(job);
        if (vert != null) {
            inuse.remove(vert);
            assignVertToStack(vert);
            return vert;
        } else {
            System.out.println("No VERT is currently assigned to job #" + job);
            return null;
        }
    }

    private void assignVertToStack(VERT vert) {
        Stack<VERT> tempStack = new Stack<>();
        while (!verts.isEmpty() && verts.peek().getLevel() < vert.getLevel()) {
            tempStack.push(verts.pop());
        }
        verts.push(vert);
        while (!tempStack.isEmpty()) {
            verts.push(tempStack.pop());
        }
    }

    private VERT findVertByJob(String job) {
        for (VERT vert : inuse) {
            if (vert.getJob().equals(job))
                return vert;
        }
        return null;
    }
}