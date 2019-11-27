//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import racetrack.CustomerHorseBets;
//import racetrack.*;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class HashMapTest {
//    private CustomerHorseBets testBets;
//    private Customer cust1;
//    private Customer cust2;
//    private Horse horse1;
//    private Horse horse2;
//    private Horse horse3;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        testBets = new CustomerHorseBets();
//        cust1 = new Customer("al");
//        horse1 = new StandardBred("test1");
//        horse2 = new StandardBred("test2");
//        horse3 = new StandardBred("test3");
//    }
//
//    @Test
//    public void testNoRecommendation() {
//        assertEquals(null, testBets.alreadyBetOn(cust1));
//    }
//
//    @Test
//    public void testCourseWithSingleRecommendation() {
//        testBets.addHorse(cust1, horse1);
//        Set<Horse> recommended = testBets.alreadyBetOn(cust1);
//        assertEquals(1, recommended.size());
//        assertTrue(recommended.contains(horse1));
//    }
//
//    @Test
//    public void testCourseWithMultipleRecommendations() {
//        testBets.addHorse(cust1, horse1);
//        testBets.addHorse(cust1, horse2);
//        Set<Horse> recommended = testBets.alreadyBetOn(cust1);
//        testBets.print();
//        assertEquals(2, recommended.size());
//        assertTrue(recommended.contains(horse1));
//        assertTrue(recommended.contains(horse2));
//    }
//
//    @Test
//    public void testMultipleCoursesWithRecommendations() {
//        testBets.addHorse(cust1, horse1);
//        testBets.addHorse(cust1, horse2);
//        testBets.addHorse(cust2, horse3);
//        Set<Horse> recommendedCust1 = testBets.alreadyBetOn(cust1);
//        assertEquals(2, recommendedCust1.size());
//        assertTrue(recommendedCust1.contains(horse1));
//        assertTrue(recommendedCust1.contains(horse2));
//        Set<Horse> recommendedCust2 = testBets.alreadyBetOn(cust2);
//        assertEquals(1, recommendedCust2.size());
//        assertTrue(recommendedCust2.contains(horse3));
//        //assertEquals(1, horse3.getSizeOfCustomersBetting());
//    }
//
//}