/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

import java.util.Arrays;


/**
 *
 * @author CW
 */
class AthleteCompetitor extends Competitor {
    private int[] performanceScores;

 public AthleteCompetitor(int cNo, CompetitorName cName, String lvl, int age, String country, int[] performanceScores) {
        super(cNo, cName, lvl, age, country);
        this.performanceScores = performanceScores;
    }

    public int[] getPerformanceScores() {
        return performanceScores;
    }

    public void setPerformanceScores(int[] performanceScores) {
        this.performanceScores = performanceScores;
    }

    @Override
    public double getOverallScore() {
        // Calculate average performance score
        return Arrays.stream(performanceScores).average().orElse(0);
    }

    @Override
    public String getShortDetails() {
        // Return short details for athlete competitor
        return "CN " + getCompetitorNumber() + " (" + getCompetitorName().getInitials() + ") has overall score " + String.format("%.1f", getOverallScore()) + ".";
    }

     @Override
    public int[] getScores() {
        return getPerformanceScores();
    }
    
    @Override
    public void setScores(int[] scores) {
        setPerformanceScores(scores);
    }
   @Override
 
public String getFullDetails() {
    // Format the details vertically with HTML line breaks
    return "<html>Competitor number: " + getCompetitorNumber() + "<br>" +
           "Name: " + getCompetitorName().getFullName() + "<br>" +
           "Country: " + getCountry() + "<br>" +
           "Age: " + getAge() + "<br>" +
           "Overall Score: " + String.format("%.1f", getOverallScore()) + "<br>" +
           "Performance Scores: " + Arrays.toString(performanceScores) + "</html>";
}

}