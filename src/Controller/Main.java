package Controller;

import Model.Image;
import View.Persistence.FileImageLoader;
import java.io.File;


public class Main {
    
    public static void main(String[] args) {
        File files = new File ("C:\\Users\\Jorge\\Documents\\NetBeansProjects\\ImageViewer\\SplashArt"); // CAMBIAR LA RUTA 
        FileImageLoader imageLoader = new FileImageLoader(files);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
