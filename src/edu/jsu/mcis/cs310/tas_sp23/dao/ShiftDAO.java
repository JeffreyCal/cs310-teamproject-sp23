package edu.jsu.mcis.cs310.tas_sp23.dao;

import edu.jsu.mcis.cs310.tas_sp23.Badge;
import edu.jsu.mcis.cs310.tas_sp23.Shift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ShiftDAO {

    private static final String QUERY_FIND = "SELECT * FROM shift WHERE id = ?";

    private final DAOFactory daoFactory;

    public ShiftDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }


    public Shift find(int id) {
        Shift shift = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, String.valueOf(id));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        String starttime = rs.getString("starttime");
                        String stoptime = rs.getString("stoptime");
                        String lunchduration = rs.getString("lunchduration");
                        String shiftduration = rs.getString("shiftduraction");


                        HashMap<String, String> shiftrules;
                        shiftrules = new HashMap<>();
                        shiftrules.put("starttime", starttime);
                        shiftrules.put("stoptime", stoptime);
                        shiftrules.put("lunchduration", lunchduration);
                        shiftrules.put("shiftduration", shiftduration);

                        shift = new Shift(shiftrules);
                    }
                }
            }
        } catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw  new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }

        return shift;
    }

    public Shift find(Badge badge) {

        Shift shift = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, String.valueOf(badge));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    while (rs.next()) {

                        String starttime = rs.getString("starttime");
                        String stoptime = rs.getString("stoptime");
                        String lunchduration = rs.getString("lunchduration");
                        String shiftduration = rs.getString("shiftduraction");

                        HashMap<String, String> shiftrules;
                        shiftrules = new HashMap<>();
                        shiftrules.put("starttime", starttime);
                        shiftrules.put("stoptime", stoptime);
                        shiftrules.put("lunchduration", lunchduration);
                        shiftrules.put("shiftduration", shiftduration);

                        shift = new Shift(shiftrules);
                    }
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw  new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }
        return shift;
    }
}