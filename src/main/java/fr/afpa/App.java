package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Binding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 * JavaFX App
 */
public class App extends Application {

    static Integer total = 0;
    static boolean isFirst = true;
    static boolean isCalculable= false;

    public static final Integer PADDING = 40;
    public static final double SPACING = 10.0;

    private double xOffset = 0;
    private double yOffset = 0;




    @Override
    public void start(Stage stage) {
        // graphic vars
        stage.initStyle(StageStyle.TRANSPARENT);


       

        String headerLiearGradient = "-fx-background-color: linear-gradient(to right,#165d82 20%, #0a79b3 50%, #165d82 80%); -fx-background-radius: 10 10 0 0;";

        // create panes
        VBox globalPane = new VBox();

        globalPane.setOnMousePressed(event-> {
            xOffset = event.getSceneX(); yOffset = event.getSceneY();
        });
        globalPane.setOnMouseDragged(event-> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
    
        });


        globalPane.setStyle("-fx-background-radius: 10;");
        AnchorPane header = new AnchorPane();
        HBox titleBox = new HBox();
        titleBox.prefWidthProperty().bind(header.widthProperty());
        titleBox.setAlignment(Pos.CENTER);

        TextArea calcArea = new TextArea();
        calcArea.setDisable(true);
        calcArea.setStyle("-fx-background-color: white;-fx-color: black");
        calcArea.setStyle("-fx-padding: 10px;-fx-border-insets: 10px;-fx-background-insets: 10px;");
        NumberBtns numberBtns = new NumberBtns(calcArea);
        
        HBox clearCalcBtns = new HBox();
        clearCalcBtns.setAlignment(Pos.CENTER);
        clearCalcBtns.setPadding(new Insets(0, PADDING, PADDING/2, PADDING));

        // add GUI components to each pane
        // Header
        
        Label title = new Label("Calculator");
        titleBox.getChildren().add(title);
        header.setStyle(headerLiearGradient);
        header.getChildren().add(titleBox);
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        title.setPadding(new Insets(PADDING/3, PADDING/3, PADDING/3, PADDING/3));
        Button quitBtn = new Button("x");
        quitBtn.setStyle("-fx-font-weight: bold; -fx-text-fill: white;-fx-background-color: transparent; -fx-font-size: 15px; ");
        quitBtn.setCursor(Cursor.HAND);
        header.getChildren().add(quitBtn);
        AnchorPane.setTopAnchor(quitBtn, 0.0); 
        AnchorPane.setRightAnchor(quitBtn, 0.0); 
        
        
        // quitbtn
        quitBtn.setOnAction(event -> Platform.exit());

        // clear & calc btn
        Button clearBtn = new Button("Calculate");
        // Calculate and diplay on textArea
        clearBtn.setOnAction(event -> calc(calcArea));
        clearCalcBtns.getChildren().add(clearBtn);

        // add GUI elements to the global pane
        globalPane.getChildren().add(header);
        globalPane.getChildren().add(calcArea);
        globalPane.getChildren().add(numberBtns);
        globalPane.getChildren().add(clearCalcBtns);

        Scene scene = new Scene(globalPane);

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public boolean calc(TextArea calcArea){
        calcArea.setText(calcArea.getText()+" = "+App.total);
        App.isCalculable = false;
        return true;
    }

    public static void main(String[] args) {
        launch();
    }

}