package edu.jsu.mcis.cs310.tas_sp23;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    
    private int id;
    private LocalDateTime active;
    private String firstname, middlename, lastname, badgeid, workstation, shiftType;
    private Badge badge;
    private Department department;
    private Shift shift;
    private EmployeeType type;

    public Employee(int id, LocalDateTime active, String firstname, String middlename, String lastname, Badge badge, Department department, Shift shift, EmployeeType type) {
        this.id = id;
        this.active = active;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.badgeid = badge.getId();
        this.department = department;
        this.workstation = department.getDescription();
        this.shiftType = shift.getDescription();
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDateTime getActive() {
        return active;
    }

    public Badge getBadge() {
        return badge;
    }

    public Department getDepartment() {
        return department;
    }

    public Shift getShift() {
        return shift;
    }

    public EmployeeType getEmployeeType() {
        return type;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // "ID #82: Taylor, Jennifer T (#ADD650A8), Type: Full-Time, Department: Office, Active: 02/13/2016"
        s
            .append("ID #")
            .append(id)
            .append(": ")
            .append(lastname)
            .append(", ")
            .append(firstname)
            .append(" ")
            .append(middlename)
            .append(" (#")
            .append(badge.getId())
            .append("), Type: ")
            .append(type)
            .append(", Department: ")
            .append(department.getDescription())
            .append(", Active: ")
            .append(active.format(format));

        return s.toString();
    }
}