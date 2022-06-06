package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.common.cards.Card;
import ch.bbcag.cardgames.common.cards.Deck;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stack extends CopyOnWriteArrayList<Card> implements List<Card> {

    private final List<Card> DRAWN_CARDS = new CopyOnWriteArrayList<>();

    private final int NUMBER_OF_DECKS;

    public Stack(int numberOfDecks) {
        this.NUMBER_OF_DECKS = numberOfDecks;
        createStack();
        shuffle();
    }

    private void createStack() {
        List<Deck> decks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < NUMBER_OF_DECKS; i++) {
            decks.add(new Deck());
        }
        for (Deck deck : decks) {
            this.addAll(deck);
        }
    }

    public Card drawCard() {
        throwErrorIfEmpty();
        Card card = get(size() - 1);
        DRAWN_CARDS.add(card);
        remove(size() - 1);
        return card;
    }

    public void renewStack() {
        this.addAll(DRAWN_CARDS);
        this.shuffle();
    }

    private void throwErrorIfEmpty() {
        if (isEmpty()) {
            throw new NullPointerException("For this operation deck cannot be empty!");
        }
    }

    private void shuffle() {
        Collections.shuffle(this);
    }
}