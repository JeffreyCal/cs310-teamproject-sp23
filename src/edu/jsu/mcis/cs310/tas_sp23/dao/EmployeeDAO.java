package edu.jsu.mcis.cs310.tas_sp23.dao;

import edu.jsu.mcis.cs310.tas_sp23.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {


    private final DAOFactory daoFactory;

    private static final String QUERY_FIND = "SELECT * FROM employee WHERE id = ?";

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

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, String.valueOf(id));

                boolean hasresult = ps.execute();

                if (hasresult) {

                    rs = ps.getResultSet();

                    while (rs.next()) {

                        //code goes here to get the info out
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

