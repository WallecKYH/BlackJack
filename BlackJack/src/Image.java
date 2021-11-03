import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Image {

    public static void picture() {
        File f = new File("./RuterDam.jpg");
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
