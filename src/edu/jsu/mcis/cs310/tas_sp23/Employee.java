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
        this.workstation = department.getDescription();
        this.shiftType = shift.getDescription();
        this.type = type;
    }

    public int getId(int id){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public LocalDateTime getActive(LocalDateTime active){
        return active;
    }
    
    public void setActive (LocalDateTime active){
        this.active = active;
    }
    
    public String getFirstName (String firstname){
        return firstname;
    }
    
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    
    public String getMiddleName(String middlename){
        return middlename;
    }
    
    public void setMiddleName(String middlename){
        this.middlename = middlename;
    }
    
    public String getLastName(String lastname){
        return lastname;
    }
    
    public void setBadge(Badge badge){
        this.badge = badge;
    }
    
    public Badge getBadge(Badge badge){
        return badge;
    }
    
    public void setDeparment (Department department){
        this.department = department;
    }
    
    public Department getDepartment(Department department){
        return department;
    }
    
    public void setShift(Shift shift){
        this.shift = shift ;
    }
    
    public Shift getShift(Shift shift){
        return shift;
    }
    
    public void setType(EmployeeType type){
        this.type = type ;
    }
    
    public EmployeeType getType(EmployeeType type){
        return type;
    }

    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatted = active.format(formatter);
        
        s.append("ID #").append(id).append(": ").append(lastname).append(", ").append(firstname).append(" ").append(middlename).append(" (#").append(badgeid).append("), Type: ").append(type).append(", Department: ").append(workstation).append(", Active: ").append(formatted);

        return s.toString();
    }
}