package ch.bbcag.cardgames.blackjack;

import ch.bbcag.cardgames.blackjack.players.Dealer;
import ch.bbcag.cardgames.blackjack.players.Player;
import ch.bbcag.cardgames.blackjack.players.RealPlayer;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    public static final int VALUE_TO_WIN = 21;
    public static final int NUMBER_OF_CARDS_TO_GET_AT_BEGIN = 2;
    private static final int NUMBER_OF_DECKS_USED = 6;
    private static final int INITIAL_PLAYER_MONEY = 1000;

    private static final List<Player> PLAYERS = new ArrayList<>();
    private final Stack MAIN_STACK = new Stack(NUMBER_OF_DECKS_USED);

    private int dealerHand;
    private int playerHand;
    private Player dealer;
    private RealPlayer realPlayer;
    private Player winner;


    public Blackjack() {
        setupGame();
    }

    public String dealersTurn() {
        String winnerString;

        realPlayer.setDone(false);
        while (!dealer.isDone()) {
            dealer.turn();
        }
        winnerString = drawOrWin(false);
        if (realPlayer.isSplitHappened()) {
            playerHand = realPlayer.getCount(Count.BEST, realPlayer.getSplitCards());
            winnerString = winnerString + "\nand for split\n" + drawOrWin(true).toLowerCase();
            realPlayer.setSplitHappened(false);
        }
        return winnerString;
    }

    private String drawOrWin(boolean ofSplit) {
        if (!isDraw(ofSplit)) winner = findWinner(ofSplit);
        else {
            realPlayer.setMoney(realPlayer.getMoney() + realPlayer.getBet());
            return "It's a draw";
        }
        if (winner == realPlayer) return "Player wins";
        else return "Dealer wins";
    }

    public void newGame() {
        setupNewGame();
    }

    public void startGame() {
        dealStartCards();
    }

    private Player findWinner(boolean ofSplit) {
        if (!ofSplit) {
            refreshCounters();
        }
        if (playerHand <= VALUE_TO_WIN) {
            if (dealerHand <= VALUE_TO_WIN) {
                if (dealerHand < playerHand) {
                    setRealPlayerAsWinner();
                } else {
                    setRealPlayerAsLooser();
                }
            } else {
                setRealPlayerAsWinner();
            }
        } else {
            setRealPlayerAsLooser();
        }
        return winner;
    }

    private void setRealPlayerAsWinner() {
        winner = realPlayer;
        realPlayer.setMoney(realPlayer.getMoney() + realPlayer.getBet() * 2);
        realPlayer.setBet(0);
    }

    private void setRealPlayerAsLooser() {
        winner = dealer;
        realPlayer.setBet(0);
    }

    private boolean isAmountTheSame(boolean ofSplit) {
        if (ofSplit) {
            return PLAYERS.get(PLAYERS.size() - 1).getCount(Count.BEST, dealer.getCards()) == playerHand;
        } else {
            return PLAYERS.get(PLAYERS.size() - 1).getCount(Count.BEST, dealer.getCards()) == realPlayer.getCount(Count.BEST, realPlayer.getCards());
        }
    }

    private boolean isDraw(boolean ofSplit) {
        if (ofSplit) {
            return isAmountTheSame(true) && playerHand < VALUE_TO_WIN + 1;
        } else {
            return isAmountTheSame(false) && realPlayer.getCount(Count.BEST, realPlayer.getCards()) < VALUE_TO_WIN + 1;
        }
    }

    private void setupVariables() {
        dealer = PLAYERS.get(PLAYERS.size() - 1);
        realPlayer = (RealPlayer) PLAYERS.get(0);
        refreshCounters();
    }

    private void refreshCounters() {
        dealerHand = dealer.getCount(Count.BEST, dealer.getCards());
        playerHand = realPlayer.getCount(Count.BEST, realPlayer.getCards());
    }

    private void dealStartCards() {
        for (int i = 0; i < NUMBER_OF_CARDS_TO_GET_AT_BEGIN; i++) {
            for (Player player : PLAYERS) {
                player.takeCard();
            }
        }
    }

    private void setupGame() {
        setupPlayers();
        setupVariables();
    }

    private void setupNewGame() {
        setupNewPlayers();
        setupVariables();
    }

    private void setupNewPlayers() {
        dealer = new Dealer(MAIN_STACK);
        realPlayer.clear();
        PLAYERS.add(new Dealer(MAIN_STACK));
    }

    private void setupPlayers() {
        PLAYERS.add(new RealPlayer(MAIN_STACK, INITIAL_PLAYER_MONEY));
        PLAYERS.add(new Dealer(MAIN_STACK));
    }

    public RealPlayer getPlayer() {
        return realPlayer;
    }

    public Dealer getDealer() {
        return (Dealer) PLAYERS.get(PLAYERS.size() - 1);
    }
}