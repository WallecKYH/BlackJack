import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;

public class PictureShow extends Applet{

    Image Picture;

    public void init(){
        Picture = getImage(getCodeBase(),"E:\\BlackJack\\Bilder\\RuterDam.jpg");
        System.out.println(getCodeBase());
    }
    public void paint(Graphics g){
        g.drawImage(Picture,10,10,this);
    }

}
