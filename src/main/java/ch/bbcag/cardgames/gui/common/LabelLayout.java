package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.Label;

public class LabelLayout extends Label {
    public LabelLayout(String text) {
        super(text);
        this.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 25; -fx-font-family: Arial");
    }
}