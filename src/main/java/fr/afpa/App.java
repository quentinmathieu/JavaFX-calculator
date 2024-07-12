package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

         // graphic vars
        double spacing = 10.0;
        String headerLiearGradient = "-fx-background-color: linear-gradient(to right,#165d82 20%, #0a79b3 50%, #165d82 80%)";
        Integer padding = 40;

        // create panes
        VBox globalPane = new VBox();
        VBox header = new VBox();
        GridPane numberBtns = new GridPane();
        numberBtns.setVgap(spacing);
        numberBtns.setHgap(spacing);
        numberBtns.setPadding(new Insets(padding, padding, padding, padding));

        // add GUI components to each pane
        // Header
        Label title = new Label("Calculator");
        header.getChildren().add(title);
        header.setAlignment(Pos.CENTER);
        header.setStyle(headerLiearGradient);
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        title.setPadding(new Insets(padding/3, padding/3, padding/3, padding/3));

        Integer j = 1;
        // add components to the gridPane
        for(Integer i = 0; i < 10; i++){
            // for define elemnts by line
            j = (i%5 == 0) ? j+1 : j;

            // create & add the numer btn to the grid
            Button btn = new Button(i.toString());
            numberBtns.add(btn, i%5 , j ,1, 1);
        }
        
        // copy 1st field content in 2nd field content on 1st field value change
        

        // add btn actions
        // delBtn.setOnAction(event -> firstField.setText(""));
        // exitBtn.setOnAction(event ->  Platform.exit());

        // add GUI elements to the global pane
        globalPane.getChildren().add(header);
        globalPane.getChildren().add(numberBtns);

        stage.setScene(new Scene(globalPane));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}