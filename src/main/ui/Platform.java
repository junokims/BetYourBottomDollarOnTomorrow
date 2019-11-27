package ui;

import racetrack.*;

import java.util.*;

public class Platform {
    private static HorseSet thisRace;
    private static List<Customer> customerList;
    private static Bookmaker bcLotto;

    public static void platformInit() {
        customerList = new ArrayList<Customer>();
        thisRace = new HorseSet();
        bcLotto = new Bookmaker("BC Lottery");
        try {
            bcLotto.addMoney(500000);
        } catch (Exception e) {
            System.out.println("Incorrect money amount added");
        }
    }

    public static void loadRace() {
        try {
            thisRace = thisRace.load();
        } catch (Exception e) {
            System.out.println("Race error");
        }
    }

    public static void addCustomer(Customer someCust) {
        customerList.add(someCust);
    }

    public static void getNumCustomers() {
        System.out.println("How many customers are betting today?");
        Scanner mainScan = new Scanner(System.in);
        int numCustomers = mainScan.nextInt();
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("Please enter customer's name");
            Scanner mainScan2 = new Scanner(System.in);
            String custName = mainScan2.nextLine();
            customerList.add(new Customer(custName));
        }
    }

    public String getHorsesInRace() {
        String toReturn = "Horses in Race: ";
        int counter = 0;
        for (Horse h : thisRace.getRaceHorses()) {
            counter = counter + 1;
            toReturn = toReturn + h.getName();
            if (counter < 8) {
                toReturn = toReturn + ", ";
            }
        }
        return toReturn;
    }

    public Bookmaker getBookmaker() {
        return bcLotto;
    }

    public List getCustomers() {
        return customerList;
    }

}
