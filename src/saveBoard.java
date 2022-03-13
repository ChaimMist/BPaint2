import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class saveBoard {
    BufferedImage bufferedImage;
    static ArrayList<String> savedNotes = new ArrayList<>();
    static ArrayList<String> savedGrid = new ArrayList<>();
    static File saveDataFile = new File("saveData/saves.txt");
    public saveBoard() {
    }

    public void saveBoardData(Component component) {
        Menu.allComponentsNotVisible();
        File file = new File("savedBoards/"+Menu.boardName + ".jpeg");
        bufferedImage = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_BGR);
        component.paint(bufferedImage.getGraphics());
        System.out.println("Image Captured");
        try {
            ImageIO.write(bufferedImage, "jpeg", file);
        } catch (IOException e) {
            System.err.println("Something went wrong while saving");
        }
    }

    public void addSave() {
        try {
            FileWriter fw = new FileWriter(saveDataFile, true);
            Writer output = new BufferedWriter(fw);

            if (!contains(Menu.boardName)) {
                System.out.println(Menu.boardName);
                output.write(Menu.boardName + " " + Menu.mathGrid + "\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String s) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("saveData/saves.txt"));
            for (String p : lines) {
                String[] t = p.split(" ");
                if (s.equals(t[0])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String> saveGetAll() {
        savedNotes.clear();
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(saveDataFile));
            while ((line = input.readLine()) != null) {
                String[] ls = line.split(" ");
                savedNotes.add(ls[0]);
                savedGrid.add(ls[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("problem file not found ");
        } catch (IOException ignored) {
        }
        System.out.println("Returned GetAll");
        return savedNotes;
    }
}


//    public static String saveGetOne(int index){
//        String s = saveGetAll().get(index);
//        String[] t = s.split(" ");
//        s = t[0];
//        return s;
//    }
//
//}
