package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;

public class RealPlayer extends Player {

    private static final int MAX_CARD_VALUE = 21;
    private boolean hit;


    public RealPlayer(Stack stack, int money) {
        super(stack);
        this.money = money;
    }

    @Override
    public void turn() {
        if (hit) {
            if (canTakeACard()) takeCard();
        } else {
            pass();
        }
    }

    public boolean canTakeACard() {
        return getCount(Count.LOW, getCards()) < MAX_CARD_VALUE;
    }

    @Override
    public void split() {
        doSplit();
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}