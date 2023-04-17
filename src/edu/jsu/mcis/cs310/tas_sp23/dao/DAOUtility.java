package edu.jsu.mcis.cs310.tas_sp23.dao;

import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import com.github.cliftonlabs.json_simple.*;
import edu.jsu.mcis.cs310.tas_sp23.Punch;

/**
 * 
 * Utility class for DAOs.  This is a final, non-constructable class containing
 * common DAO logic and other repeated and/or standardized code, refactored into
 * individual static methods.
 * 
 */
public final class DAOUtility {

    public static String getPunchListAsJSON(ArrayList<Punch> dailypunchlist) {
        
        JsonArray jsonArr = new JsonArray();
        
        for (int x = 0; x < dailypunchlist.size(); x++){
            
            Punch punch = dailypunchlist.get(x);
            
            JsonObject obj = new JsonObject();

            obj.put("id", String.valueOf(punch.getId()));
            obj.put("badgeid", String.valueOf(punch.getBadgeid()));
            obj.put("punchtype", String.valueOf(punch.getPunchtype()));
            obj.put("adjustmenttype", String.valueOf(punch.getAdjustmenttype()));
            obj.put("originaltimestamp", String.valueOf(punch.getOriginaltimestamp()));
            obj.put("adjustedtimestamp", String.valueOf(punch.getAdjustedtimestamp()));
            
            jsonArr.add(obj);
        }

        String json = Jsoner.serialize(jsonArr);
        
        return json;
    }

}
