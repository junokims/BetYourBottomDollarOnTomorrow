import racetrack.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


public class ObserverTest {
    private Horse horsie;
    private Customer custy;
    private Bookmaker bookie;
    private Statistician statty;
    private Bets someBet;

    @BeforeEach
    public void runBefore() {
        horsie = new ThoroughBred("Hellraiser");
        custy = new Customer("Charlie");
        bookie = new Bookmaker("Bob");
        statty = new Statistician("Steve");
        someBet = new Bets(500, bookie, custy, horsie);
    }

    @Test
    public void testAddBet() {
        bookie.addObserver(statty);
        bookie.addBets(someBet);
        assertTrue(bookie.getBets().contains(someBet));
        assertTrue(Statistician.getBets().contains(someBet));

    }
}
