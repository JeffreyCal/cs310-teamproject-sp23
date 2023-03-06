package edu.jsu.mcis.cs310.tas_sp23.dao;

import edu.jsu.mcis.cs310.tas_sp23.Badge;
import edu.jsu.mcis.cs310.tas_sp23.EventType;
import edu.jsu.mcis.cs310.tas_sp23.Punch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PunchDAO {

    private static final String FIND_QUERY = "SELECT * FROM event WHERE id = ?";
    private final DAOFactory daoFactory;

    public PunchDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }
    public Punch find(int i) {
        Punch punch = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(FIND_QUERY);
                ps.setString(1, String.valueOf(i));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        int terminalid = rs.getInt("terminalid");
                        String badgeid = rs.getString("badgeid");
                        LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                        int eventtypeid = rs.getInt("eventtypeid");
                        BadgeDAO badgeDAO = new BadgeDAO(daoFactory);
                        Badge badge = badgeDAO.find(String.valueOf(badgeid));
                        punch = new Punch(id, terminalid, badge, timestamp, eventtypeid);
                    }
                }
            }
        } catch (SQLException e) {

            throw  new DAOException(e.getMessage());

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
        return punch;
    }
}
