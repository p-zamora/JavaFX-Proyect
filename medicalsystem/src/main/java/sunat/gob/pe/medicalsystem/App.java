package sunat.gob.pe.medicalsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            //almalaver@gmail.com
            scene = new Scene(loadFXML("login"));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.getIcons().add(new Image(getClass().getResource("/sunat/gob/pe/medicalsystem/images/icono.png").toExternalForm()));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader getFXMLLoader(String fxml) throws IOException{
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }

}