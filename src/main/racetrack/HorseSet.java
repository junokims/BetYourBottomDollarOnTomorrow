package racetrack;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorseSet implements Loadable, Saveable {
    protected List<Horse> raceHorses;
    protected static int maxSize = 4;

    // EFFECTS: set is empty
    public HorseSet() {
        raceHorses = new ArrayList<>();
    }

    public List<Horse> getRaceHorses() {
        List<Horse> listToReturn = new ArrayList<Horse>();
        for (Horse h : raceHorses) {
            listToReturn.add(h);
        }
        return listToReturn;
    }

    // MODIFIES: this
    // EFFECTS: Horse h is added to the HorseSet if it's not
    // already in the HorseSet
    public void insert(Horse h) {
        raceHorses.add(h);
    }

    // REQUIRES: Horse h is an element of the HorseSet
    // MODIFIES: this
    // EFFECTS: Horse h is removed from the HorseSet
    public void remove(Horse h) {
        raceHorses.remove(h);
    }

    // Print horses in set at index i
    public Horse get(int i) {
        return raceHorses.get(i);
    }

    public int getMaxSize() {
        return maxSize;
    }

    // EFFECTS: Returns true if Horse h is in the HorseSet
    // and false otherwise
    public boolean contains(Horse h) {
        if (raceHorses.contains(h)) {
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Returns the number of Horse in the HorseSet
    public int size() {
        return raceHorses.size();
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/outputFile.txt","UTF-8");
        for (Horse h : raceHorses) {
            String someLine = h.getName() + " " + h.getWeight();
            writer.println(someLine);
        }
        writer.close();
    }

    public HorseSet load() throws IOException {
        HorseSet setToReturn = new HorseSet();
        ThoroughBred horseToAdd;
        List<String> lines = Files.readAllLines(Paths.get("./data/inputList.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
//            System.out.print("Name: " + partsOfLine.get(0) + " ");
//            System.out.println("Weight: " + partsOfLine.get(1));
            int weightToAdd = Integer.parseInt(partsOfLine.get(1));
            horseToAdd = new ThoroughBred(partsOfLine.get(0));
            horseToAdd.setWeight(weightToAdd);
            setToReturn.insert(horseToAdd);
        }
        return setToReturn;
    }

    public String testLoad() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/inputList.txt"));
        String loadTestString = "";
        for (String line : lines) {
            loadTestString = loadTestString + line + " ";
        }
        return loadTestString;
    }

    public String testSaveLoad() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/outputFile.txt"));
        String loadTestString = "";
        for (String line : lines) {
            loadTestString = loadTestString + line + " ";
        }
        return loadTestString;
    }
}
