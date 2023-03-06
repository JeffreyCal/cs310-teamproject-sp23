package edu.jsu.mcis.cs310.tas_sp23;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Punch {

    int id, terminalid, eventtypeid;
    String badgeid;
    EventType punchtype;
    LocalDateTime timestamp, adjustedtimestamp;
    PunchAdjustmentType adjustmenttype;
    Badge badge;


    Punch(int terminalid, Badge badge, int punchtype) {

    }

    public Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, int punchtype) {
        this.id = id;
        this.terminalid = terminalid;
        this.badgeid = badge.getId();
        this.timestamp = originaltimestamp;
        this.eventtypeid = punchtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(int terminalid) {
        this.terminalid = terminalid;
    }

    public String getBadgeid() { return badgeid; }

    public void setBadgeid(String badgeid) {this.badgeid = badgeid; }

    public int getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public void setPunchtype(EventType punchtype) {
        this.punchtype = punchtype;
    }

    public LocalDateTime getOriginaltimestamp() {
        return timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getAdjustedtimestamp() {
        return adjustedtimestamp;
    }

    public void setAdjustedtimestamp(LocalDateTime adjustedtimestamp) {
        this.adjustedtimestamp = adjustedtimestamp;
    }

    public PunchAdjustmentType getAdjustmenttype() {
        return adjustmenttype;
    }

    public void setAdjustmenttype(PunchAdjustmentType adjustmenttype) {
        this.adjustmenttype = adjustmenttype;
    }

    public Badge getBadge() {
        return badge;
    }

    public String printOriginal() {

        //StringBuilder s = new StringBuilder();
        int x = eventtypeid;
        String eventType = new String();
         if (x == 0){
            eventType = "#CLOCK OUT:";
        } else if (x == 1) {
            eventType = "#CLOCK IN:";
        } else {
            eventType = "#TIME OUT:";
        }

        return badgeid  + " " + eventType + adjustedtimestamp;

    }
}
