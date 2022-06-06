package ch.bbcag.cardgames.blackjack.buttonhandler;

import ch.bbcag.cardgames.blackjack.players.RealPlayer;
import ch.bbcag.cardgames.gui.scenes.BlackjackScene;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class BetButtonHandler extends MainButtonHandler {

    private final TextField AMOUNT_FIELD;
    private final BlackjackScene BLACKJACK_SCENE;

    public BetButtonHandler(RealPlayer player, TextField amountField, BlackjackScene blackjackScene) {
        super(player);
        this.AMOUNT_FIELD = amountField;
        this.BLACKJACK_SCENE = blackjackScene;
    }

    @Override
    public void handle(ActionEvent event) {
        int bet;
        try {
            bet = Integer.parseInt(AMOUNT_FIELD.getText());
        } catch (NumberFormatException nfe) {
            return;
        }
        if (bet >= 0 && bet <= player.getMoney()) {
            setBetAndStartNewGame(bet);
        }
    }

    private void setBetAndStartNewGame(int bet) {
        player.setBet(bet);
        player.setMoney(player.getMoney() - player.getBet());
        BLACKJACK_SCENE.startGame();
        BLACKJACK_SCENE.setWaitingForMoneySet(false);
    }
}