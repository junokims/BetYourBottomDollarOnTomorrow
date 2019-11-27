package racetrack;

public class Jockey {
    private String jockeyName;
    private int jockeyWeight;

    //Constructor with name
    public Jockey(String name) {
        jockeyName = name;
    }

    //EFFECTS: Returns jockey name
    public String getName() {
        return jockeyName;
    }

    //EFFECTS: Returns jockey weight
    public int getWeight() {
        return jockeyWeight;
    }

    //MODIFIES: this
    //EFFECTS: Adds weights associated with horse
    public void setWeight(int someWeight) {
        this.jockeyWeight = someWeight;
    }

}
