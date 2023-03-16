package edu.jsu.mcis.cs310.tas_sp23;

import java.time.*;


public class Punch {

    private Integer id, terminalid;
    private String badgeid;
    private EventType punchtype;
    private LocalDateTime timestamp, originaltimestamp, adjustedtimestamp;
    private PunchAdjustmentType adjustmenttype;
    private Badge badge;
    
    enum LunchStatus {
        HAPPENING,
        HAPPENED,
        NOT_HAPPENING,
        INAPPLICABLE
    };


    public Punch(int terminalid, Badge badge, EventType punchtype) {
        this.id = null;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.originaltimestamp = LocalDateTime.now();
    }

    public Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype) {
        this.id = id;
        this.terminalid = terminalid;
        this.badge = badge;
        //this.badgeid = badge.getId();
        this.originaltimestamp = LocalDateTime.now();
        //this.timestamp = timestamp;
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
        return originaltimestamp;
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

    public void adjust(Shift s) {
        
    }

}
