package racetrack;

import observer.SubjectBets;

import java.awt.print.Book;

public class Bets extends SubjectBets {

    int betAmount;
    Horse betHorse;
    double betMultiplier;
    Bookmaker betBookie;
    Customer betCustomer;

    // EFFECTS: Creates Bets object with associated bet amount, bookmaker, customer and horse
    public Bets(int bet, Bookmaker bookie, Customer cust, Horse horse) {
        betAmount = bet;
        betBookie = bookie;
        betCustomer = cust;
        betHorse = horse;
    }

    public MoneyHandler getCustomer() {
        return betCustomer;
    }

    public Bookmaker getBetBookie() {
        return betBookie;
    }

    public Horse getHorseBetOn() {
        return betHorse;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetMultiplier(double someBetMultiplier) {
        betMultiplier = someBetMultiplier;
    }

    public double getBetMultiplier() {
        return betMultiplier;
    }

//    public void payOutBet() {
//        //check bet amount
//        //subtract betamount from balance of customer and add to bookie if wrong
//        //add betamount*multiplier to balance of customer and subtract from bookie if winning horse = betHorse
//
//        //should this be in moneyhandlers, or bets?
//    }

}
