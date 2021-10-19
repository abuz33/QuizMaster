package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import launcher.Main;
import service.QuizProviderService;
import service.ServiceManager;
import view.SceneManager;

import java.io.File;

public class StartSceneController {

    private SceneManager sceneManager = Main.getSceneManager();
    private ServiceManager serviceManager = Main.getServiceManager();
    private QuizProviderService quizProviderService = serviceManager.getQuizProviderService();

    @FXML
    private Button buttonLogin; //zorg dat fx:id gevuld is!!

    @FXML
    private MenuButton menuButtonScenes;

    //dit methode/event wordt automatisch aangeroepen door JavaFX zodra je de scene/controller laad
    public void initialize() {
        populateMenuButtonScenes();
    }

    public void loginClick() {
        sceneManager.showLoginScene();
    }

    //dynamisch
    public void populateMenuButtonScenes() {
        String userDirectory = System.getProperty("user.dir");
        File fxmlDirectory = new File(userDirectory + "/src/main/java/view/fxml");
        if (fxmlDirectory.isDirectory()) {
            String[] files = fxmlDirectory.list();
            if (files != null) {
                for (String filename : files) {
                    if (!filename.equals("startScene.fxml")) {
                        MenuItem menuItem = new MenuItem(); //kan ook met de hand in Scenebuilders
                        menuItem.setText(filename);
                        menuItem.setOnAction(event -> sceneManager.getScene("/view/fxml/" + filename));
                        menuButtonScenes.getItems().add(menuItem);
                    }
                }
            }
        }
    }

    public void buttonMouseEntered(MouseEvent mouseEvent) {
        // ask service to do something
        String naam = quizProviderService.getARandomQuizName();
        // use service result
        buttonLogin.setText("I received a name: "+naam);
    }
}