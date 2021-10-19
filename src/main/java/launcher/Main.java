package launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import service.DemoQuizProviderService;
import service.QuizProviderService;
import service.ServiceManager;
import view.SceneManager;

//JavaFX -> extends Application
//
// Starting point for boot-strapping application.
// all mentioned layers are based on the domain-centric architecture
// see: https://matthewrenze.com/wp-content/uploads/2019/04/slides4.pdf, page 63
//

public class Main extends Application {
    // Presentation layer initialisation
    private static SceneManager sceneManager = null;
    private static Stage primaryStage = null;
    private static ServiceManager serviceManager = new ServiceManager(); // second way to create a singleton object.

    // Persistence layer initialisation
    // TODO

    // Application layer
    // is handled by ServiceManager object.

    // Infrastructure layer initialisation
    // not needed, since we use a simple stand-alone application.

    // Domain layer initialisation
    // not directly shown in this demo code, but 'hidden' in QuizProviderService.
    // You might want to initialize or load your domain objects yourself when needed.


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Make IT Work - Project 1");
        getSceneManager().showStartScene();
        primaryStage.show();
    }

    public static SceneManager getSceneManager() {
        //Singleton class (max. 1 object van deze class!)
        if (sceneManager == null) {
            sceneManager = new SceneManager(primaryStage);
        }
        return sceneManager;
    }

    public static ServiceManager getServiceManager(){
        // uses second way to create a singleton class (prefered)
        return serviceManager;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}