/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

/**
 *
 * @author CW
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        readCompetitorsFromFile(competitorList, "C:\\Users\\CW\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\RunCompetitor.csv");

        // Display full details table
        System.out.println("Competitors Details Table:");
        System.out.println(competitorList.getCompetitorsDetailsTable());

        // Display details of the competitor with the highest overall score
        System.out.println("\nCompetitor with the highest overall score:");
        System.out.println(competitorList.getCompetitorWithHighestScore());

        // Display other summary statistics
        System.out.println("\nSummary Statistics:");
        System.out.println("Total Competitors: " + competitorList.getTotalCompetitors());
        System.out.println("Average Overall Score: " + competitorList.getAverageOverallScore());
        System.out.println("Maximum Overall Score: " + competitorList.getMaxOverallScore());
        System.out.println("Minimum Overall Score: " + competitorList.getMinOverallScore());

        // Display frequency report
        System.out.println("\nFrequency Report:");
        System.out.println(competitorList.getScoreFrequencyReport());

        // Allow the user to enter a competitor number and display short details if valid
        int competitorNumberToCheck = 100; // Replace with user input
        System.out.println("\nChecking details for competitor number " + competitorNumberToCheck + ":");
        System.out.println(competitorList.getShortDetailsForCompetitor(competitorNumberToCheck));

        // Write final report to a text file
        writeFinalReportToFile(competitorList, "FinalReport.txt");
    }

    private static void readCompetitorsFromFile(CompetitorList competitorList, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 8) {
                    System.out.println("Invalid data format. Skipping the line: " + line);
                    continue;
                }

                int competitorNumber = Integer.parseInt(data[0]);
                CompetitorName competitorName = new CompetitorName(data[1], data[2], data[3]);
                String type = data[4];
                int age;
                try {
                    age = Integer.parseInt(data[5]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age format. Skipping the line: " + line);
                    continue;
                }

                String country = data[6];
                String[] scoreStr = data[7].split("\\s+");
                int[] scores = new int[scoreStr.length];
                for (int i = 0; i < scoreStr.length; i++) {
                    try {
                        scores[i] = Integer.parseInt(scoreStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score format. Skipping the line: " + line);
                        continue;
                    }
                }

                // Check the type and create the appropriate Competitor subclass
                Competitor competitor = null;
                switch (type.toLowerCase()) {
                    case "athlete":
                        competitor = new AthleteCompetitor(competitorNumber, competitorName, "", age, country, scores);
                        break;
                    case "gamer":
                        competitor = new Gamers(competitorNumber, competitorName, "", age, country, scores);
                        break;
                    default:
                        System.out.println("Unrecognized competitor type: " + type + ". Skipping the line: " + line);
                }

                if (competitor != null) {
                    competitorList.addCompetitor(competitor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFinalReportToFile(CompetitorList competitorList, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write competitors details table
            writer.println("Competitors Details Table:");
            writer.println(competitorList.getCompetitorsDetailsTable());

            // Write details of the competitor with the highest overall score
            writer.println("\nCompetitor with the highest overall score:");
            writer.println(competitorList.getCompetitorWithHighestScore());

            // Write other summary statistics
            writer.println("\nSummary Statistics:");
            writer.println("Total Competitors: " + competitorList.getTotalCompetitors());
            writer.println("Average Overall Score: " + competitorList.getAverageOverallScore());
            writer.println("Maximum Overall Score: " + competitorList.getMaxOverallScore());
            writer.println("Minimum Overall Score: " + competitorList.getMinOverallScore());

            // Write frequency report
            writer.println("\nFrequency Report:");
            writer.println(competitorList.getScoreFrequencyReport());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}