package edu.jsu.mcis.cs310.tas_sp23;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;

public class Shift {

    public Shift(HashMap<String, String> shiftrules) {
        this.id = Integer.parseInt(shiftrules.get(id));
        this.starttime = LocalTime.parse(shiftrules.get(starttime));
        this.stoptime = LocalTime.parse(shiftrules.get(stoptime));
        this.lunchduration = Duration.parse(shiftrules.get(lunchduration));
        this.shiftduration = Duration.parse(shiftrules.get(shiftduration));
    }

    int id;
    LocalTime starttime;
    LocalTime stoptime;

    Duration lunchduration;
    Duration shiftduration;

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getStoptime() {
        return stoptime;
    }

    public void setStoptime(LocalTime stoptime) {
        this.stoptime = stoptime;
    }

    public Duration getLunchduration() {
        return lunchduration;
    }

    public void setLunchduration(Duration lunchduration) {
        this.lunchduration = lunchduration;
    }

    public Duration getShiftduration() {
        return shiftduration;
    }

    public void setShiftduration(Duration shiftduration) {
        this.shiftduration = shiftduration;
    }

}