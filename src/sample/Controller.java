package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField path;


    @FXML
    void bstart(){

        File filmsFolder = new File(path.getText());

        for (File file: filmsFolder.listFiles()) {


            Image image = new Image(file.toURI().toString() + "image.png");
            File oldFile = new File(file.getAbsolutePath() + "\\image.png");
            if(!oldFile.exists()) continue;
            File newFile = new File(file.getAbsolutePath() + "\\image.jpg");
            BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);

            try {
                ImageIO.write(bImage, "jpg", newFile);

                if(!oldFile.delete()) System.out.println("не удалось удалить: " + oldFile.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("не удалось ОБРАБОТАТЬ: " + oldFile.getAbsolutePath());
                e.printStackTrace();


            }



        }

        System.out.println("FIN!!!");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        path.setText("E:\\films");
    }
}
