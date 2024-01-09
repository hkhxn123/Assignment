/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

/**
 *
 * @author CW
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CompetitorList {

    private ArrayList<Competitor> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public String getCompetitorsDetailsTable() {
        StringBuilder table = new StringBuilder();
        for (Competitor competitor : competitors) {
            table.append(competitor.getFullDetails()).append("\n");
        }
        return table.toString();
    }

    public String getCompetitorWithHighestScore() {
        Competitor highestScoreCompetitor = Collections.max(competitors, Comparator.comparing(Competitor::getOverallScore));
        return highestScoreCompetitor.getFullDetails();
    }

    public int getTotalCompetitors() {
        return competitors.size();
    }

    public double getAverageOverallScore() {
        double sum = 0;
        for (Competitor competitor : competitors) {
            sum += competitor.getOverallScore();
        }
        return sum / getTotalCompetitors();
    }

    public double getMaxOverallScore() {
        return Collections.max(competitors, Comparator.comparing(Competitor::getOverallScore)).getOverallScore();
    }

    public double getMinOverallScore() {
        return Collections.min(competitors, Comparator.comparing(Competitor::getOverallScore)).getOverallScore();
    }

    // Add this method to your CompetitorList class
    public Competitor getCompetitorByNumber(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null; // Return null if the competitor with the specified number is not found
    }

    public String getSortedTableByCriteria(String sortBy) {

        switch (sortBy.toLowerCase()) {
            case "overallscore":
                competitors.sort(Comparator.comparing(Competitor::getOverallScore));
                break;
            case "competitornumber":
                competitors.sort(Comparator.comparing(Competitor::getCompetitorNumber));
                break;

            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + sortBy);
        }

        // Build the sorted table
        StringBuilder table = new StringBuilder();
        for (Competitor competitor : competitors) {
            table.append(competitor.getFullDetails()).append("\n");
        }
        return table.toString();
    }

    public String getDetailsByAttribute(String attribute, String value) {
        // Implement filtering logic based on the provided attribute and value
        // You may need to adjust this based on your specific requirements

        // Convert attribute to lowercase for case-insensitive comparison
        String lowercaseAttribute = attribute.toLowerCase();

        switch (lowercaseAttribute) {
            case "level":
                return filterByLevel(value);
            case "age":
                return filterByAge(value);
            case "country":
                return filterByCountry(value);
            default:
                throw new IllegalArgumentException("Invalid attribute for filtering: " + attribute);
        }
    }

    private String filterByLevel(String value) {
        return competitors.stream()
                .filter(competitor -> competitor.getLevel().equalsIgnoreCase(value))
                .map(Competitor::getFullDetails)
                .collect(Collectors.joining("\n"));
    }

    private String filterByAge(String value) {
        try {
            int age = Integer.parseInt(value);
            return competitors.stream()
                    .filter(competitor -> competitor.getAge() == age)
                    .map(Competitor::getFullDetails)
                    .collect(Collectors.joining("\n"));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value for filtering by age: " + value);
        }
    }

    private String filterByCountry(String value) {
        return competitors.stream()
                .filter(competitor -> competitor.getCountry().equalsIgnoreCase(value))
                .map(Competitor::getFullDetails)
                .collect(Collectors.joining("\n"));
    }

    
    
    public String getScoreFrequencyReport() {
        Map<Integer, Integer> scoreFrequencyMap = new HashMap<>();

        // Count the frequency of each score
        for (Competitor competitor : competitors) {
            int[] scores = competitor instanceof AthleteCompetitor
                    ? ((AthleteCompetitor) competitor).getPerformanceScores()
                    : ((Gamers) competitor).getGamingScores();

            for (int score : scores) {
                scoreFrequencyMap.put(score, scoreFrequencyMap.getOrDefault(score, 0) + 1);
            }
        }

        // Generate the frequency report
        StringBuilder report = new StringBuilder("Score Frequency Report:\n");
        for (Map.Entry<Integer, Integer> entry : scoreFrequencyMap.entrySet()) {
            report.append("Score ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" times\n");
        }

        return report.toString();
    }

    public String getShortDetailsForCompetitor(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor.getShortDetails();
            }
        }
        return "Competitor with number " + competitorNumber + " not found.";
    }

    public String generateCompetitorReport() {
        StringBuilder report = new StringBuilder("Competitor Report:\n");
        for (Competitor competitor : competitors) {
            report.append(competitor.getFullDetails()).append("\n");
        }
        return report.toString();
    }

    public void writeCompetitorReportToFile() {
        String report = generateCompetitorReport();
        try (PrintWriter writer = new PrintWriter(new FileWriter("CompetitorReport.txt"))) {
            writer.println(report);
            System.out.println("Competitor report written to CompetitorReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
