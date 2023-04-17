package edu.jsu.mcis.cs310.tas_sp23;

import java.time.*;
import java.time.format.*;


public class Punch {

    private Integer id, terminalid;
    private String badgeid;
    private EventType punchtype;
    private LocalDateTime timestamp, originaltimestamp, adjustedtimestamp;
    private PunchAdjustmentType adjustmenttype;
    private Badge badge;
    private LunchStatus adjustedlunchstatus;
    
    public enum LunchStatus {
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
        this.badgeid = badge.getId();
        this.originaltimestamp = originaltimestamp;
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
    
    public LunchStatus getAdjustedLunchStatus(){
        return adjustedlunchstatus;
    }

    public String printOriginal() {
        
        StringBuilder s = new StringBuilder();

         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        String formatted = timestamp.format(formatter);
        
        s.append("#").append(badgeid).append(" ").append(punchtype).append(": ").append(formatted);
        
        return s.toString().toUpperCase();

    }
    public void adjust(Shift s) {

        int shiftStart = s.getShiftstart().toSecondOfDay();
        int shiftStop = s.getShiftstop().toSecondOfDay();
        int lunchStart = s.getLunchstart().toSecondOfDay();
        int lunchStop = s.getLunchstop().toSecondOfDay();
        int gracePeriod = s.getGraceperiod() * 60;
        int dockPen = s.getDockpenalty() * 60;
        int roundInt = s.getRoundinterval() * 60;
        int originalTimeSec = originaltimestamp.toLocalTime().toSecondOfDay();

        if (originaltimestamp.getDayOfWeek() == DayOfWeek.SATURDAY || originaltimestamp.getDayOfWeek() == DayOfWeek.SUNDAY) {
            adjustmenttype = PunchAdjustmentType.INTERVAL_ROUND;
            int remainderSec = originalTimeSec % roundInt;
            if (remainderSec < roundInt / 2) {
                int roundedTime = originalTimeSec - remainderSec;
                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
            } else {
                int roundedTime = originalTimeSec + remainderSec;
                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
            }
            adjustedlunchstatus = LunchStatus.INAPPLICABLE;
        } else {
            switch (punchtype) {
                case CLOCK_IN:

                    if (originalTimeSec < shiftStart) {
                        if (roundInt >= shiftStart - originalTimeSec) {
                            adjustmenttype = PunchAdjustmentType.SHIFT_START;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(shiftStart).atDate(originaltimestamp.toLocalDate());
                        } else if (roundInt < shiftStart - originalTimeSec) {
                            adjustmenttype = PunchAdjustmentType.INTERVAL_ROUND;
                            int remainderSec = originalTimeSec % roundInt;
                            if (remainderSec < roundInt / 2) {
                                int roundedTime = originalTimeSec - remainderSec;
                                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
                            } else {
                                int roundedTime = originalTimeSec + remainderSec;
                                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
                            }
                            
                        } else {
                            adjustmenttype = PunchAdjustmentType.NONE;
                            adjustedtimestamp = originaltimestamp;
                        }
                    } else if (originalTimeSec < lunchStart) {
                        if (shiftStart + gracePeriod < originalTimeSec) {
                            adjustmenttype = PunchAdjustmentType.SHIFT_DOCK;
                            int dock = shiftStart + dockPen;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(dock).atDate(originaltimestamp.toLocalDate());
                        } else {
                            adjustmenttype = PunchAdjustmentType.SHIFT_START;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(shiftStart).atDate(originaltimestamp.toLocalDate());
                        }
                    } else if (originalTimeSec > lunchStart) {
                        adjustmenttype = PunchAdjustmentType.LUNCH_STOP;
                        adjustedtimestamp = LocalTime.ofSecondOfDay(lunchStop).atDate(originaltimestamp.toLocalDate());
                    }
                    break;
                case CLOCK_OUT:
                    if (originalTimeSec > shiftStop) {
                        if (originalTimeSec - shiftStop > roundInt) {
                            adjustmenttype = PunchAdjustmentType.INTERVAL_ROUND;
                            int remainderSec = originalTimeSec % roundInt;
                            if (remainderSec < roundInt / 2) {
                                int roundedTime = originalTimeSec - remainderSec;
                                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
                            } else {
                                int roundedTime = originalTimeSec + remainderSec;
                                adjustedtimestamp = LocalTime.ofSecondOfDay(roundedTime).atDate(originaltimestamp.toLocalDate());
                            }
                        } else {
                            adjustmenttype = PunchAdjustmentType.SHIFT_STOP;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(shiftStop).atDate(originaltimestamp.toLocalDate());
                        }
                    } else if (originalTimeSec > lunchStart && originalTimeSec < lunchStop) {
                        adjustmenttype = PunchAdjustmentType.LUNCH_START;
                        adjustedtimestamp = LocalTime.ofSecondOfDay(lunchStart).atDate(originaltimestamp.toLocalDate());
                    } else if (originalTimeSec < shiftStop) {
                        if (shiftStop - gracePeriod <= originalTimeSec) {
                            adjustmenttype = PunchAdjustmentType.SHIFT_STOP;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(shiftStop).atDate(originaltimestamp.toLocalDate());
                        }else {
                            adjustmenttype = PunchAdjustmentType.SHIFT_DOCK;
                            int dock = shiftStart - dockPen;
                            adjustedtimestamp = LocalTime.ofSecondOfDay(dock).atDate(originaltimestamp.toLocalDate());
                        }
                    }
                    break;
            }
        }
    }
    
    public String printAdjusted() {
        
        StringBuilder s = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        String formatted = adjustedtimestamp.format(formatter);
        String atype = adjustmenttype.toString();
       
        s.append("#").append(badgeid).append(" ").append(punchtype).append(": ").append(formatted).append(" (").append(atype).append(")");
        
        return s.toString().toUpperCase();

    }
}
