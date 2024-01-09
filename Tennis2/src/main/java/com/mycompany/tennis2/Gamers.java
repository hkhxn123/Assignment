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
class Gamers extends Competitor {
    private int[] gamingScores;

    public Gamers(int competitorNumber, CompetitorName cName, String lvl, int age, String country, int[] gamingScores) {
        super(competitorNumber, cName, lvl, age, country);
        this.gamingScores = gamingScores;
    }

    public int[] getGamingScores() {
        return gamingScores;
    }

    public void setGamingScores(int[] gamingScores) {
        this.gamingScores = gamingScores;
    }

    @Override
    public double getOverallScore() {
        // Calculate average gaming score
        return Arrays.stream(gamingScores).average().orElse(0);
    }

    @Override
    public String getShortDetails() {
        // Return short details for gamer competitor
        return "CN " + getCompetitorNumber() + " (" + getCompetitorName().getInitials() + ") has overall score " + String.format("%.1f", getOverallScore()) + ".";
    }
 @Override
    public int[] getScores() {
        return getGamingScores();
    }
    
    @Override
    public void setScores(int[] scores) {
        setGamingScores(scores);
    }
    @Override
    public String getFullDetails() {
        // Return full details for gamer competitor
        return "Competitor number " + getCompetitorNumber() + ", name " + getCompetitorName().getFullName() +
                ", country " + getCountry() + ".\n" +
                getCompetitorName().getFirstName() + " is a Gamer aged " + getAge() +
                " and has an overall score of " + String.format("%.1f", getOverallScore()) +
                " with gaming scores: " + Arrays.toString(gamingScores);
    }
}