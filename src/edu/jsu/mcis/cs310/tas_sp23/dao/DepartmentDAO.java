package edu.jsu.mcis.cs310.tas_sp23.dao;

import edu.jsu.mcis.cs310.tas_sp23.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The DepartmentDAO class works with the data in
 * each record in the database by retrieving
 * the record and instantiating it as an individual
 * model object.
 * 
 * @author Jeffrey Patterson
 */

public class DepartmentDAO {

    private final DAOFactory daoFactory;

    private static final String QUERY_FIND = "SELECT * FROM department WHERE id = ?";

    public DepartmentDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Department find(int id) {
        Department department = null;

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

                        int terminalid = rs.getInt("terminalid");
                        int departmentid = rs.getInt("id");
                        String description = rs.getString("description");

                        department = new Department(departmentid, terminalid, description);
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
        return department;
    }
}