package ch.bbcag.cardgames.gui.common;

import javafx.scene.control.Label;

public class TitleLayout extends Label {
    public TitleLayout(String text) {
        super(text);
        this.setStyle("-fx-text-fill: #000000; -fx-font-size: 100; -fx-font-family: 'Perpetua Titling MT'; ");
    }
}