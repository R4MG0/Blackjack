package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import javafx.event.ActionEvent;

public class SplitButtonHandler extends MainButtonHandler {
    public SplitButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(ActionEvent event) {
        player.split();
    }
}