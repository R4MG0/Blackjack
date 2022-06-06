package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.gui.scenes.BlackjackScene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ReplayButtonHandler implements EventHandler<ActionEvent> {

    private final BlackjackScene BLACKJACK_SCENE;

    public ReplayButtonHandler(BlackjackScene blackjackScene) {
        this.BLACKJACK_SCENE = blackjackScene;
    }

    @Override
    public void handle(ActionEvent event) {
        BLACKJACK_SCENE.newGame();
    }
}