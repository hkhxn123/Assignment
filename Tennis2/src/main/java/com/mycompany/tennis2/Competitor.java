/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

/**
 *
 * @author CW
 */
abstract class Competitor {
        public abstract int[] getScores();
    public abstract void setScores(int[] scores);
    private int cNo;
    private CompetitorName cName;
    private String lvl;
    private int age;
    private String country;

    public Competitor(int cNo, CompetitorName Name, String lvl, int age, String country) {
        this.cNo = cNo;
        this.cName = Name;
        this.lvl = lvl;
        this.age = age;
        this.country = country;
    }

    public int getCompetitorNumber() {
        return cNo;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.cNo = competitorNumber;
    }

    public CompetitorName getCompetitorName() {
        return cName;
    }

    public void setCompetitorName(CompetitorName competitorName) {
        this.cName = competitorName;
    }

    public String getLevel() {
        return lvl;
    }

    public void setLevel(String lvl) {
        this.lvl = lvl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public abstract double getOverallScore();

    public abstract String getShortDetails();

    public abstract String getFullDetails();
}