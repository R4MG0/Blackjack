package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import javafx.event.ActionEvent;

public class HitButtonHandler extends MainButtonHandler {
    public HitButtonHandler(RealPlayer player) {
        super(player);
    }

    @Override
    public void handle(ActionEvent event) {

        player.setHit(true);
        player.turn();
    }
}