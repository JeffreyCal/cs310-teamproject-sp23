package edu.jsu.mcis.cs310.tas_sp23;

import java.time.LocalDateTime;

public class Employee {
    
    private int id;
    private LocalDateTime active;
    private String firstname, middlename, lastname;
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
        this.badge = badge;
        this.department = department;
        this.shift = shift;
        this.type = type;
    }

    //Create setters and getters

    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();

        return s.toString();
    }
}