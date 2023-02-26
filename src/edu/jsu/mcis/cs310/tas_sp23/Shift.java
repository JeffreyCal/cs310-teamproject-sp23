package edu.jsu.mcis.cs310.tas_sp23;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;

public class Shift {

    public Shift(HashMap<String, String> shiftrules) {
        this.id = Integer.parseInt(shiftrules.get(id));
        this.description = (shiftrules.get(description));
        this.shiftstart = LocalTime.parse(shiftrules.get(shiftstart));
        this.shiftstop = LocalTime.parse(shiftrules.get(shiftstop));
        this.lunchstart = LocalTime.parse(shiftrules.get(lunchstart));
        this.lunchstop = LocalTime.parse(shiftrules.get(lunchstop));
        this.roundinterval = Integer.parseInt(shiftrules.get(roundinterval));
        this.graceperiod = Integer.parseInt(shiftrules.get(graceperiod));
        this.dockpenalty = Integer.parseInt(shiftrules.get(dockpenalty));
        this.lunchthreshhold = Integer.parseInt(String.valueOf(lunchthreshhold));
    }


    private int id;
    private String description;
    private LocalTime shiftstart;
    private LocalTime shiftstop;
    private LocalTime lunchstart;
    private LocalTime lunchstop;
    private int roundinterval;
    private int graceperiod;
    private int dockpenalty;
    private Duration lunchduration;
    private Duration shiftduration;
    private int lunchthreshhold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getShiftstart() {
        return shiftstart;
    }

    public void setShiftstart(LocalTime shiftstart) {
        this.shiftstart = shiftstart;
    }

    public LocalTime getShiftstop() {
        return shiftstop;
    }

    public void setShiftstop(LocalTime shiftstop) {
        this.shiftstop = shiftstop;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public void setLunchstart(LocalTime lunchstart) {
        this.lunchstart = lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }

    public void setLunchstop(LocalTime lunchstop) {
        this.lunchstop = lunchstop;
    }

    public int getRoundinterval() {
        return roundinterval;
    }

    public void setRoundinterval(int roundinterval) {
        this.roundinterval = roundinterval;
    }

    public int getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(int graceperiod) {
        this.graceperiod = graceperiod;
    }

    public int getDockpenalty() {
        return dockpenalty;
    }

    public void setDockpenalty(int dockpenalty) {
        this.dockpenalty = dockpenalty;
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

    public int getLunchthreshhold() {
        return lunchthreshhold;
    }

    public void setLunchthreshhold(int lunchthreshhold) {
        this.lunchthreshhold = lunchthreshhold;
    }
}