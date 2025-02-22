package it.polito.tdp.alien;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.alien.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {
	

    @Override
    public void start(Stage stage) throws Exception {
    	
    	Model model=new Model();
    	FXMLController controller; //creo oggetto controller
    	
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/Scene.fxml")); //oggetto loader a cui passa identificativo 
    	
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        controller= loader.getController();
        controller.setModel(model); //metto in comunicazione control., loader e Model
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
