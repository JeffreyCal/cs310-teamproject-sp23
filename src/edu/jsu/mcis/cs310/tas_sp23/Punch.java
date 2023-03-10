package edu.jsu.mcis.cs310.tas_sp23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Punch {

    private int id, terminalid;
    private String badgeid;
    private EventType punchtype;
    private LocalDateTime timestamp, adjustedtimestamp;
    private PunchAdjustmentType adjustmenttype;
    private Badge badge;


    public Punch(int terminalid, Badge badge, EventType punchtype) {

    }

    public Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype) {
        this.id = id;
        this.terminalid = terminalid;
        this.badgeid = badge.getId();
        this.timestamp = originaltimestamp;
        this.punchtype = punchtype;
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

     public String getBadgeid() { 
         return badgeid; 
     }

     public void setBadgeid(String badgeid) {
         this.badgeid = badgeid; 
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
        
        StringBuilder s = new StringBuilder();

         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        String formatted = timestamp.format(formatter);
        
        s.append("#").append(badgeid).append(" ").append(punchtype).append(": ").append(formatted);
        
        return s.toString().toUpperCase();

    }
}
