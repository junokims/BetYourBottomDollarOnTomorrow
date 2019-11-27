import racetrack.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import racetrack.Horse;
import racetrack.HorseSet;
import racetrack.exceptions.NegativeAmountException;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementTest {
    private Customer al;
    private Bookmaker ben;
    private Jockey steve;
    private ThoroughBred seabiscuit;
    private ThoroughBred secretariat;
    private ThoroughBred greatdame;
    private ThoroughBred testHorse1;
    private ThoroughBred testHorse2;
    private ThoroughBred testHorse3;
    private ThoroughBred testHorse4;
    private ThoroughBred testHorse5;
    private ThoroughBred testHorse6;

    private OvalRace melbourneCup;

    private HorseSet set;

    @BeforeEach
    public void runBefore() {
        al = new Customer("Al");
        ben = new Bookmaker("Ben");
        steve = new Jockey("Steve");
        seabiscuit = new ThoroughBred("Seabiscuit");
        secretariat = new ThoroughBred("Secretariat");
        greatdame = new ThoroughBred("Greatdame");
        testHorse1 = new ThoroughBred("test1");
        testHorse2 = new ThoroughBred("test2");
        testHorse3 = new ThoroughBred("test3");
        testHorse4 = new ThoroughBred("test4");
        testHorse5 = new ThoroughBred("test5");
        testHorse6 = new ThoroughBred("test6");

        melbourneCup = new OvalRace("Melbourne Cup", 3200);

        set = new HorseSet();
    }

    @Test
    public void testNames() {
        assertTrue(seabiscuit.getName() == "Seabiscuit");
        assertTrue(steve.getName() == "Steve");
        assertTrue(ben.getName() == "Ben");
        assertTrue(al.getName() == "Al");
        assertTrue(secretariat.getName() == "Secretariat");
    }

    @Test
    public void testBalanceExpectFail() throws NegativeAmountException {
        al.addMoney(500);
        ben.addMoney(200);
        assertEquals(500, al.getBalance());
        assertEquals(200, ben.getBalance());
        try {
            al.addMoney(-12);
            System.out.println("Passed");
        } catch (NegativeAmountException e) {
            System.out.println("Negative amount add exception thrown");
        }
    }

    @Test
    public void testBalanceExpectPass() throws NegativeAmountException {
        try {
            al.addMoney(500);
            System.out.println("Passed");
        } catch (NegativeAmountException e) {
            System.out.println("Negative amount add exception thrown");
        }
    }

    @Test
    public void testWeightSet() {
        seabiscuit.setWeight(600);
        steve.setWeight(75);
        assertEquals(600, seabiscuit.getWeight());
        assertEquals(75, steve.getWeight());
    }

    boolean rightHorse(Horse h, String s) {
        if (h.getName() == s) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void testHorse() {
        Horse testHorse5 = new ThoroughBred("Testy5");
        assertTrue(rightHorse(testHorse5, "Testy5"));
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());

        for (int i = 0; i < 1; i++) {
            set.insert(seabiscuit);
        }
        assertEquals(1, set.size());
    }

    @Test
    public void testContainsSeabiscuitExpectPass() {
        assertFalse(set.contains(seabiscuit));
        try {
            set.insert(seabiscuit);
            System.out.println("Passed");
        } catch (Exception e) {
            System.out.println("Full race exception thrown");
        }
        assertTrue(set.contains(seabiscuit));
    }

    @Test
    public void testContainsLotsExpectFail() {
        set.insert(testHorse1);
        set.insert(testHorse2);
        set.insert(testHorse3);
        set.insert(testHorse4);
        set.insert(seabiscuit);
        assertTrue(set.get(0).getName() == "test1");

        assertTrue(set.contains(testHorse1));
        assertTrue(set.contains(testHorse2));
        assertTrue(set.contains(testHorse3));
        assertTrue(set.contains(testHorse4));
        assertTrue(set.getRaceHorses().get(4).getName() == "Seabiscuit");

    }

    @Test
    public void testInsert() {
        set.insert(testHorse1);
        assertTrue(set.contains(testHorse1));
        assertEquals(1, set.size());
    }

    @Test
    public void testDuplicate() {
        set.insert(testHorse1);
        set.insert(testHorse1);

        assertTrue(set.contains(testHorse1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsertLots() {
        set.insert(testHorse1);
        set.insert(testHorse2);
        set.insert(testHorse3);
        set.insert(testHorse4);

        assertTrue(set.contains(testHorse1));
        assertTrue(set.contains(testHorse3));
        assertTrue(set.contains(testHorse4));
        assertEquals(4, set.getMaxSize());
        assertEquals(4, set.size());
    }

    @Test
    public void testRemove() {
        set.insert(testHorse1);
        set.remove(testHorse1);
        assertFalse(set.contains(testHorse1));
        assertEquals(0, set.size());
    }

    @Test
    public void testRemoveLots() {
        set.insert(testHorse1);
        set.insert(testHorse2);
        set.insert(testHorse3);
        set.insert(testHorse4);

        set.remove(testHorse1);
        set.remove(testHorse2);
        set.remove(testHorse3);
        set.remove(testHorse4);

        assertFalse(set.contains(testHorse1));
        assertFalse(set.contains(testHorse3));
        assertFalse(set.contains(testHorse4));
        assertEquals(0, set.size());
    }

    @Test
    public void testRaceInfo() {
        melbourneCup.addLocation("Australia");
        assertEquals(3200, melbourneCup.getRaceLength());
        assertTrue(melbourneCup.getRaceName().equals("Melbourne Cup"));
        assertTrue(melbourneCup.getLocation().equals("Australia"));
    }

    @Test
    public void testLoad() throws IOException {
        set = set.load();
        assertTrue(set.testLoad().equals("StevieWonder 2100 Seabiscuit 2500 " +
                "Dangerous 2800 Prestige 2750 BlackBeauty 2600 " +
                "Lucky 2900 Cleveland 2850 " +
                "Blondie 2825 "));
        assertTrue(set.size() == 1);
    }

    @Test
    public void testSave() throws IOException {
        set.insert(testHorse1);
        testHorse1.setWeight(100);
        set.insert(testHorse2);
        testHorse2.setWeight(200);
        set.insert(testHorse3);
        testHorse3.setWeight(300);
        set.insert(testHorse4);
        testHorse4.setWeight(400);
        set.save();
        assertTrue(set.testSaveLoad().equals("Testy1 100 Testy2 200 Testy3 300 Testy4 400 "));
    }

    @Test
    public void testBet() {
        Bets alsBet = al.generateBet(500, ben, seabiscuit);
        assertEquals(alsBet.getBetAmount(), 500);
        assertEquals(alsBet.getBetBookie(), ben);
        assertEquals(alsBet.getCustomer(), al);
        assertEquals(alsBet.getHorseBetOn(), seabiscuit);
        alsBet.setBetMultiplier(1.5);
        assertEquals(alsBet.getBetMultiplier(), 1.5);

        al.addBets(alsBet);
        assertTrue(al.getBets().contains(alsBet));
        Bets alsBet2 = al.generateBet(1000, ben, secretariat);
        al.addBets(alsBet2);
        assertTrue(al.getBets().contains(alsBet2));
        assertTrue(ben.getBets().contains(alsBet));
        al.addBets(alsBet2);
        assertTrue(ben.getBets().size() == 2);

    }
//
//    @Test
//    public void testLoad() throws IOException {
//        set = set.load();
//        set.
//    }

}

