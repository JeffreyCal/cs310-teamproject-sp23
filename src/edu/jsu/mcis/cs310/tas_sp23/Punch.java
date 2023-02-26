package edu.jsu.mcis.cs310.tas_sp23;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Punch {

    int id, terminalid, badgeid, eventtypeid;
    EventType punchtype;
    LocalDateTime timestamp, adjustedtimestamp;
    PunchAdjustmentType adjustmenttype;
    Badge badge;


    Punch(int terminalid, Badge badge, EventType punchtype) {

    }

    Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype) {

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

    public int getBadgeid() {
        return badgeid;
    }

    public void setBadgeid(int badgeid) {
        this.badgeid = badgeid;
    }

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
}
