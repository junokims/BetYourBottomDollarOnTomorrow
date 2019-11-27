package racetrack;

import observer.BetObserver;

import java.util.*;

public class Statistician implements BetObserver {
    private String name;
    private static Set<Bets> setBets;

    public Statistician(String someName) {
        name = someName;
        setBets = new HashSet<Bets>();
    }

    @Override
    public void update(Observable o, Object arg) {
        Bets someBet = (Bets) o;
        setBets.add(someBet);
        System.out.println("Bet added: " + someBet.getBetAmount());
    }

    public static Set<Bets> getBets() {
        Set<Bets> setOfBetsToReturn;
        setOfBetsToReturn = new HashSet<>();
        for (Bets b : setBets) {
            setOfBetsToReturn.add(b);
        }
        return Collections.unmodifiableSet(setOfBetsToReturn);
    }
}