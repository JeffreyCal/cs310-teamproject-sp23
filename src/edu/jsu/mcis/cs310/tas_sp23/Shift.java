package edu.jsu.mcis.cs310.tas_sp23;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * The Shift model class contains information about 
 * a shift rule set given in the database as well as
 * the durations of a shift and lunch.
 * 
 * @author Christopher Adkins
 * @author Raelee Shuler
 */

public class Shift {
    private int id;
    private String description;
    private LocalTime shiftstart, shiftstop, lunchstart, lunchstop;
    private int graceperiod, dockpenalty, roundinterval, lunchthreshold;
    private long lunchduration, shiftduration;
    
    
    public Shift(HashMap<String, String> shiftrules) {
        this.id = Integer.parseInt(shiftrules.get("id"));
        this.description = (shiftrules.get("description"));
        this.shiftstart = LocalTime.parse(shiftrules.get("shiftstart"));
        this.shiftstop = LocalTime.parse(shiftrules.get("shiftstop"));
        this.lunchstart = LocalTime.parse(shiftrules.get("lunchstart"));
        this.lunchstop = LocalTime.parse(shiftrules.get("lunchstop"));
        this.roundinterval = Integer.parseInt(shiftrules.get("roundinterval"));
        this.graceperiod = Integer.parseInt(shiftrules.get("graceperiod"));
        this.dockpenalty = Integer.parseInt(shiftrules.get("dockpenalty"));
        this.lunchthreshold = Integer.parseInt(shiftrules.get("lunchthreshold"));

        Duration shiftDur = Duration.between(shiftstart, shiftstop);
        if (shiftDur.isNegative()) {
            shiftDur = shiftDur.plusDays(1);
        }
        this.shiftduration = shiftDur.toMinutes();
        
        Duration lunchDur = Duration.between(lunchstart, lunchstop);
        if (lunchDur.isNegative()) {
            lunchDur = lunchDur.plusDays(1);
        }
        this.lunchduration = lunchDur.toMinutes();
        
    }


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

    public long getLunchduration() {
        return lunchduration;
    }

    public void setLunchduration(long lunchduration) {
        this.lunchduration = lunchduration;
    }

    public long getShiftduration() {
        return shiftduration;
    }

    public void setShiftduration(long shiftduration) {
        this.shiftduration = shiftduration;
    }

    public int getLunchthreshold() {
        return lunchthreshold;
    }

    public void setLunchthreshold(int lunchthreshold) {
        this.lunchthreshold = lunchthreshold;
    }
    
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        
        // "Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)"
        
        s.append(description).append(": ").append(shiftstart).append(" - ");
        s.append(shiftstop).append(" (").append(shiftduration).append(" minutes); ");
        s.append("Lunch: ").append(lunchstart).append(" - ").append(lunchstop).append(" (");
        s.append(lunchduration).append(" minutes)");
        
        return s.toString();
        
    }
}