package ch.bbcag.cardgames.gui.common;

import javafx.scene.text.Text;

public class TextLayout extends Text {
    public TextLayout(String text) {
        super(text);
        this.setStyle("-fx-text-fill: #000000; -fx-font-size: 50; -fx-font-family: 'Perpetua Titling MT'; -fx-stroke-width: 20");
    }
}