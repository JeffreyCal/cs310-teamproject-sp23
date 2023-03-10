package edu.jsu.mcis.cs310.tas_sp23.dao;

import edu.jsu.mcis.cs310.tas_sp23.Badge;
import edu.jsu.mcis.cs310.tas_sp23.Department;
import edu.jsu.mcis.cs310.tas_sp23.Employee;
import edu.jsu.mcis.cs310.tas_sp23.EmployeeType;
import edu.jsu.mcis.cs310.tas_sp23.Shift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class EmployeeDAO {


    private final DAOFactory daoFactory;

    private static final String QUERY_FIND_BY_ID = "SELECT * FROM employee WHERE id = ?";
    private static final String QUERY_FIND_BY_EMPLOYEE_ID = "SELECT * FROM employee WHERE badgeid = ?";

    public EmployeeDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Employee find(int id) {
        Employee employee = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND_BY_ID);
                ps.setString(1, String.valueOf(id));

                boolean hasresult = ps.execute();

                if (hasresult) {

                    rs = ps.getResultSet();

                    while (rs.next()) {

                        //code goes here to get the info out
                        int idnum = id;
                        EmployeeType type = EmployeeType.values()[rs.getInt("employeetypeid")];
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        String badgeid = rs.getString("badgeid");
                        Badge badge = badgeDAO.find(badgeid);
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
                        int departmentid = rs.getInt("departmentid");
                        Department department = departmentDAO.find(departmentid);
                        ShiftDAO shiftDAO = daoFactory.getShiftDAO();
                        int shiftid = rs.getInt("shiftid");
                        Shift shift = shiftDAO.find(shiftid);
                        employee = new Employee(idnum, active, firstname, middlename, lastname, badge, department, shift, type);
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
        return employee;
    }
    
     public Employee find(Badge badge) {

        Employee employee = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND_BY_EMPLOYEE_ID);
                ps.setString(1, String.valueOf(badge.getId()));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        int idnum = rs.getInt("id");
                        EmployeeType type = EmployeeType.values()[rs.getInt("employeetypeid")];
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        Badge badgenum = badge;
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        DepartmentDAO departmentDAO = daoFactory.getDepartmentDAO();
                        int departmentid = rs.getInt("departmentid");
                        Department department = departmentDAO.find(departmentid);
                        ShiftDAO shiftDAO = daoFactory.getShiftDAO();
                        int shiftid = rs.getInt("shiftid");
                        Shift shift = shiftDAO.find(shiftid);
                        employee = new Employee(idnum, active, firstname, middlename, lastname, badgenum, department, shift, type);
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
        return employee;
    }
}

