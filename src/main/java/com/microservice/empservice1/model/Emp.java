package com.microservice.empservice1.model;


import jakarta.persistence.*;

import java.util.Objects;

//@Table(name="employee")
@Entity
public class Emp {


    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="empid")
    private int empId;

    @Column(name="empname")
    private String empName;

    @Column(name="empsal")
    private double empSal;


   // @OneToOne
   // private Dept dept;

    public Emp() {
    }

    public Emp(int empId, String empName, double empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empId == emp.empId;
    }

    //it is not efficient change it later on hash on something else
    @Override
    public int hashCode() {
        return Objects.hashCode(empId);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSal=" + empSal +
                '}';
    }
}
