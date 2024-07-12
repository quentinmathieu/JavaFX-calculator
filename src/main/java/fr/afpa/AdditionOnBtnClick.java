package fr.afpa;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class AdditionOnBtnClick implements EventHandler<ActionEvent> {
    private Integer number;
    private TextArea calcArea;


    public AdditionOnBtnClick(Integer number, TextArea calcArea) {
        
        this.number = number;
        this.calcArea = calcArea;
    }


    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TextArea getCalcArea() {
        return this.calcArea;
    }

    public void setCalcArea(TextArea calcArea) {
        this.calcArea = calcArea;
    }

    // add numbers to the textArea
    public void handle(ActionEvent event) {
        String plusOrNot = (App.isFirst) ? "" : " + ";
        App.isFirst = false;
        App.total += this.number;
        this.calcArea.setText(this.calcArea.getText()+plusOrNot+this.number);
        App.isCalculable = true;
    }
    
}