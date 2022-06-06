package ch.bbcag.cardgames.common.cards;

import ch.bbcag.cardgames.common.cards.enums.Face;

import javafx.scene.image.Image;

import java.util.Objects;

public class Card {

    private static final String POKER_IMAGE_PATH = "/pokerdeck/";

    private int value;
    private Face face;
    private final Image image;
    private final String imagePath;

    public Card(String imagePath) {
        this.imagePath = POKER_IMAGE_PATH + imagePath;
        image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(this.imagePath)));
        setValue();
        setFace();
    }

    private void setValue() {
        char val = imagePath.charAt(POKER_IMAGE_PATH.length());
        switch (val) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> value = Character.getNumericValue(val);
            case 'T', 'J', 'K', 'Q' -> value = 10;
            case 'A' -> value = 11;
        }
    }

    private void setFace() {
        char fac = imagePath.charAt(POKER_IMAGE_PATH.length());
        switch (fac) {
            case '1' -> face = Face.ONE;
            case '2' -> face = Face.TWO;
            case '3' -> face = Face.THREE;
            case '4' -> face = Face.FOUR;
            case '5' -> face = Face.FIVE;
            case '6' -> face = Face.SIX;
            case '7' -> face = Face.SEVEN;
            case '8' -> face = Face.EIGHT;
            case '9' -> face = Face.NINE;
            case 'T' -> face = Face.TEN;
            case 'J' -> face = Face.JACK;
            case 'Q' -> face = Face.QUEEN;
            case 'K' -> face = Face.KING;
            case 'A' -> face = Face.ASS;
        }
    }

    public Face getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    public Image getImage() {
        return image;
    }
}