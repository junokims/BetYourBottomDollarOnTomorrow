package racetrack;

import racetrack.exceptions.NegativeAmountException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Observer;
import java.util.Set;

public class Bookmaker extends MoneyHandler {
    private int bookieBalance;

    //EFFECTS: Constructor for Bookmaker object with name
    public Bookmaker(String someName) {
        super(someName);
    }

    //MODIFIES: this
    //EFFECTS: adds someBet to the bookmaker's list of Bets for the purpose of paying out wins
    public void addBets(Bets someBet) {
        if (!getBets().contains(someBet)) {
            betsMade.add(someBet);

            setChanged();
            notifyObservers(someBet);

            for (Observer o : observerList) {
                o.update(someBet, null);
            }
        }
    }
}
