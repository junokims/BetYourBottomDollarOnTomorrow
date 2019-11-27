package racetrack;

import racetrack.exceptions.NegativeAmountException;

import java.awt.print.Book;
import java.util.*;

public class Customer extends MoneyHandler {
    private int custBalance;
    int maxBets = 3;

    //EFFECTS: Constructor for Customer object with name
    public Customer(String someName) {
        super(someName);
    }

    public Bets generateBet(int someBet, Bookmaker someBookie, Horse someHorse) {
        Bets betToAdd = new Bets(someBet, someBookie, this, someHorse);
        return betToAdd;
    }

    public void addBets(Bets someBet) {
        if (betsMade.size() < maxBets) {
            betsMade.add(someBet);
            if (!getBets().contains(someBet)) {
                addBets(someBet);
                addObserver((Observer) someBet);
            }
            if (!someBet.getBetBookie().getBets().contains(someBet)) {
                someBet.getBetBookie().addBets(someBet);
            }
        }

    }

}
