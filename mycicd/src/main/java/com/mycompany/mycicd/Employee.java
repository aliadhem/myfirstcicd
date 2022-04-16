/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mycicd;

/**
 *
 * @author Owner
 */
public class Employee {
    private int id;
    private String first;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Employee(int id, String first) {
        this.id = id;
        this.first = first;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", first=" + first + '}';
    }
    
    
    
}
