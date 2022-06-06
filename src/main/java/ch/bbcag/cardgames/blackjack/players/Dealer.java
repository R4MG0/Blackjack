package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

public class Dealer extends Player {
    private static final int DEALER_MUST_STAY = 17;
    private boolean dealersTurn = false;

    public Dealer(Stack stack) {
        super(stack);
    }

    @Override
    public void turn() {
        dealersTurn = true;
        if (hasToTakeCard()) {
            takeCard();
        } else {
            pass();
        }
    }

    public boolean hasToTakeCard() {
        return getCount(Count.BEST, getCards()) < DEALER_MUST_STAY;
    }

    @Override
    public void split() {
    }

    public boolean isDealersTurn() {
        return dealersTurn;
    }
}