package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import javafx.event.ActionEvent;

public class HoldButtonHandler extends MainButtonHandler {
    public HoldButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(ActionEvent event) {
        player.setHit(false);
        player.turn();
    }
}