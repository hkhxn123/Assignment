/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

/**
 *
 * @author CW
 */
class CompetitorName {
    private String firstName;
    private String lastName;

    public CompetitorName(String firstName, String lastName, String par2) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getInitials() {
        return Character.toString(firstName.charAt(0))  + Character.toString(lastName.charAt(0));
    }
}