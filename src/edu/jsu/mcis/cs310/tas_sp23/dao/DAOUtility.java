package edu.jsu.mcis.cs310.tas_sp23.dao;

import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import com.github.cliftonlabs.json_simple.*;
import edu.jsu.mcis.cs310.tas_sp23.Badge;
import edu.jsu.mcis.cs310.tas_sp23.EventType;
import edu.jsu.mcis.cs310.tas_sp23.Punch;
import edu.jsu.mcis.cs310.tas_sp23.PunchAdjustmentType;

/**
 * 
 * Utility class for DAOs.  This is a final, non-constructable class containing
 * common DAO logic and other repeated and/or standardized code, refactored into
 * individual static methods.
 * 
 */
public final class DAOUtility {

    public static String getPunchListAsJSON(ArrayList<Punch> dailypunchlist){
        
        JsonArray jsonData = new JsonArray();  
        JsonObject jsonObject = new JsonObject();
        
        for (int x = 0; x < dailypunchlist.size(); x++){
            
            Punch punch = dailypunchlist.get(x);
            
            jsonObject.put("id", String.valueOf(punch.getId()));
            
            jsonObject.put("terminalid", String.valueOf(punch.getTerminalid()));
            
            jsonObject.put("badgeid", String.valueOf(punch.getBadgeid()));

            jsonObject.put("punchtype", String.valueOf(punch.getPunchtype()));
            
            jsonObject.put("originaltimestamp", String.valueOf(punch.getOriginaltimestamp()));
            
            jsonObject.put("adjustmenttype", String.valueOf(punch.getAdjustmenttype()));
            
            jsonObject.put("adjustedtimestamp", String.valueOf(punch.getAdjustedtimestamp()));
            
            jsonData.add(jsonObject);

        }
        
        String json = Jsoner.serialize(jsonData);
        
        return json;
    }
}