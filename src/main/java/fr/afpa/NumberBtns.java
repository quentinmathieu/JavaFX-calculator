package fr.afpa;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class NumberBtns extends GridPane {

    public NumberBtns(TextArea calcArea){
        this.setVgap(App.SPACING);
        this.setHgap(App.SPACING);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, App.SPACING, App.SPACING, App.SPACING));

        // number btns pane
        Integer j = 1;
        for(Integer i = 0; i < 10; i++){
            // for define elemnts by line
            j = (i%5 == 0) ? j+1 : j;

            // create & add the numer btn to the grid
            Button btn = new Button(i.toString());
            this.add(btn, i%5 , j ,1, 1);
            // add number to the textArea
            final Integer number = i;
            btn.setOnAction(event -> this.additionOnBtnClick(number, calcArea));
        }
    }
    public boolean additionOnBtnClick(Integer number, TextArea calcArea){

        String plusOrNot = (App.isFirst) ? "" : " + ";
        App.isFirst = false;
        App.total += number;
        calcArea.setText(calcArea.getText()+plusOrNot+number);
        App.isCalculable = true;

        return true;
    }
}
