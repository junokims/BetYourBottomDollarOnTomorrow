package racetrack;

public class OvalRace extends Races {
    private String location;

    public OvalRace(String someName, int someLength) {
        super(someName, someLength);
    }

    public void addLocation(String someLocation) {
        this.location = someLocation;
    }

    public String getLocation() {
        return this.location;
    }

}
