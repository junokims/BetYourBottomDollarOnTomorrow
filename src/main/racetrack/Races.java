package racetrack;

public abstract class Races {
    protected String raceName;
    protected int length;

    Races(String someName, int someLength) {
        this.raceName = someName;
        this.length = someLength;
    }

    public String getRaceName() {
        return this.raceName;
    }

    public int getRaceLength() {
        return this.length;
    }
}
