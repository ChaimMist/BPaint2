import java.io.File;
import java.io.IOException;

public class deleteSaves {
    File file = new File(Menu.boardName+".jpeg");
    public deleteSaves(){
        file.delete();

    }
}
