package ch.bbcag.cardgames.blackjack.players;

import ch.bbcag.cardgames.blackjack.Count;
import ch.bbcag.cardgames.blackjack.Stack;
import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.enums.Face;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ch.bbcag.cardgames.blackjack.Blackjack.NUMBER_OF_CARDS_TO_GET_AT_BEGIN;
import static ch.bbcag.cardgames.blackjack.Blackjack.VALUE_TO_WIN;

public abstract class Player {

    private static final int RESHUFFLE_STACK_ON = 60;
    private final Stack stack;

    private List<Card> beforeSplitCards = new CopyOnWriteArrayList<>();
    private List<Card> splitCards = new CopyOnWriteArrayList<>();

    private List<Card> activeCards = new CopyOnWriteArrayList<>();

    protected int bet;
    private boolean splitHappened = false;
    protected boolean done = false;
    protected boolean isSplit = false;

    protected int money;

    public Player(Stack stack) {
        this.stack = stack;
    }

    public boolean isSplitPossible() {
        return activeCards.get(0).getFace() == activeCards.get(1).getFace() && isAtFirstTurn() && !isSplit;
    }

    public boolean isDoubleDownPossible() {
        return money >= bet && isAtFirstTurn();
    }

    public abstract void turn();

    public abstract void split();

    public void doDoubleDown() {
        bet = bet * 2;
        money -= bet;
        takeCard();
        pass();
    }

    public void takeCard() {
        if (stack.size() <= RESHUFFLE_STACK_ON) {
            stack.renewStack();
        }
        activeCards.add(stack.drawCard());
    }

    public void pass() {
        if (isSplit) {
            beforeSplitCards = activeCards;
            isSplit = false;
            activeCards = splitCards;
        } else {
            splitCards = activeCards;
            done = true;
        }
    }

    public int getCount(Count highOrLowValue, List<Card> cards) {
        switch (highOrLowValue) {
            case HIGH -> {
                return getHighCount(cards);
            }
            case BEST -> {
                return getBestCount(cards);
            }
            case LOW -> {
                return getLowCount(cards);
            }
            default -> throw new IllegalStateException("highOrLowValue is not part of the Card enum");
        }
    }

    public void clear() {
        splitHappened = false;
        done = false;
        bet = 0;
        beforeSplitCards = new CopyOnWriteArrayList<>();
        splitCards = new CopyOnWriteArrayList<>();
        activeCards = new CopyOnWriteArrayList<>();
    }

    protected void doSplit() {
        isSplit = true;
        splitCards.add(activeCards.get(1));

        beforeSplitCards.add(activeCards.get(0));

        splitCards.add(stack.drawCard());
        beforeSplitCards.add(stack.drawCard());

        activeCards.clear();
        activeCards = beforeSplitCards;
        splitHappened = true;
    }

    private int getHighCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
            count += card.getValue();
        }
        return count;
    }

    private int getBestCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
            if (card.getFace() != Face.ASS) {
                count += card.getValue();
            }
        }
        for (Card card : cards) {
            if (card.getFace() == Face.ASS) {
                if (count > VALUE_TO_WIN - card.getValue()) {
                    count++;
                } else {
                    count += card.getValue();
                }
            }
        }
        return count;
    }

    private int getLowCount(List<Card> cards) {
        int count = 0;
        for (Card card : cards) {
            if (card.getFace() == Face.ASS) {
                count++;
            } else {
                count += card.getValue();
            }
        }
        return count;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public void setBet(int value) {
        bet = value;
    }

    public int getBet() {
        return bet;
    }

    public List<Card> getCards() {
        return activeCards;
    }

    public List<Card> getSplitCards() {
        return splitCards;
    }

    public void setSplitHappened(boolean splitHappened) {
        this.splitHappened = splitHappened;
    }

    public boolean isSplitHappened() {
        return splitHappened;
    }

    private boolean isAtFirstTurn() {
        return (activeCards.size() == NUMBER_OF_CARDS_TO_GET_AT_BEGIN && beforeSplitCards.isEmpty() && splitCards.isEmpty());
    }

}