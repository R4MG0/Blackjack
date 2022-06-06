package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import javafx.event.ActionEvent;

public class DoubleButtonHandler extends MainButtonHandler {
    public DoubleButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(ActionEvent event) {
        player.doDoubleDown();
    }
}