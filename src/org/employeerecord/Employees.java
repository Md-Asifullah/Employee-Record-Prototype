/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.employeerecord;

/**
 *
 * @author DELL
 */
public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String designation;
    private String nationality;
    private String address;

    public Employees(int id, String firstName, String lastName, int age, String designation, String nationality, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.designation = designation;
        this.nationality = nationality;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNationality() {
        return nationality;
    }

    public String getAddress() {
        return address;
    }
    
}
