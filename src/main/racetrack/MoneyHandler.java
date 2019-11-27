package racetrack;

import observer.SubjectBets;
import racetrack.exceptions.NegativeAmountException;
import java.util.*;

public abstract class MoneyHandler extends SubjectBets {
    protected String name;
    int balance;

    protected Set<Bets> betsMade;
    protected List<Observer> observerList;

    MoneyHandler(String someName) {
        this.name = someName;
        balance = 0;

        betsMade = new HashSet<Bets>();
        observerList = new ArrayList<Observer>();
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        } else {
            balance += amount;
        }
    }

    protected abstract void addBets(Bets someBet);

    public Set<Bets> getBets() {
        Set<Bets> setOfBetsToReturn;
        setOfBetsToReturn = new HashSet<>();
        for (Bets b : betsMade) {
            setOfBetsToReturn.add(b);
        }
        return Collections.unmodifiableSet(setOfBetsToReturn);
    }

    public void addObserver(Statistician someStatistician) {
        if (!observerList.contains(someStatistician)) {
            observerList.add(someStatistician);
        }
    }
}
