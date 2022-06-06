package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class MainButtonHandler implements EventHandler<ActionEvent> {

    protected RealPlayer player;

    public MainButtonHandler(RealPlayer player) {
        this.player = player;
    }

    public abstract void handle(ActionEvent event);
}