/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis2;

/**
 *
 * @author CW
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author CW
 */
public class Gui extends javax.swing.JFrame {

    private CompetitorList competitorList;

    // Components for the GUI
    private JButton viewScoresButton;
    private JButton viewTableButton;
    private JButton viewDetailsButton;
    private JButton removeCompetitorButton;
    private JButton closeButton;

    /**
     * Creates new form CompetitorGUI
     */
    public Gui() {
        initComponents();
    }

    public Gui(CompetitorList competitorList) {
        this.competitorList = competitorList;
        initializeComponents();
        createGUI();
    }

    private void initializeComponents() {
        viewScoresButton = new JButton("View Scores");
        viewTableButton = new JButton("View Table");
        viewDetailsButton = new JButton("View Details");
        removeCompetitorButton = new JButton("Remove Competitor");
        closeButton = new JButton("Close");

        viewScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number:");

                // Validate the input (ensure it's a valid integer)
                try {
                    int competitorNumber = Integer.parseInt(competitorNumberInput);

                    // Find the competitor with the specified number
                    Competitor athleteCompetitor = findCompetitorByNumber(competitorNumber);

                    // Display the details of the competitor in a dialog box
                    if (athleteCompetitor != null) {
                        JOptionPane.showMessageDialog(null, athleteCompetitor.getFullDetails(), "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumber + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid competitor number. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

   viewTableButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Use similar object style
        Competitor competitor = new AthleteCompetitor(
                789,
                new CompetitorName("Clark", "Kent", ""),
                "Athlete",
                25,
                "USA",
                new int[]{70, 90, 88}
        );

        // Create a JTable
        JFrame frame = new JFrame("Competitor Details");
        String[] columnNames = {"Attribute", "Value"};

        // Modify the data array to display each attribute and its value in separate rows
        Object[][] data = {
            {"Competitor Number", competitor.getCompetitorNumber()},
            {"Name", ((AthleteCompetitor) competitor).getCompetitorName().getFullName()},
            {"Level", competitor.getLevel()},
            {"Age", competitor.getAge()},
            {"Country", competitor.getCountry()}
        };

        // Add rows for performance scores
        int[] performanceScores = ((AthleteCompetitor) competitor).getPerformanceScores();
        for (int i = 0; i < performanceScores.length; i++) {
            data = Arrays.copyOf(data, data.length + 1);
            data[data.length - 1] = new Object[]{"Score " + (i + 1), performanceScores[i]};
        }

        JTable table = new JTable(data, columnNames);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Set up the frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
});


        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number to see details:");

                // Validate the input (ensure it's a valid integer)
                try {
                    int competitorNumber = Integer.parseInt(competitorNumberInput);

                    // Find the competitor with the specified number
                    Competitor athleteCompetitor = findCompetitorByNumber(competitorNumber);

                    // Display the details of the competitor in a dialog box
                    if (athleteCompetitor != null) {
                        JOptionPane.showMessageDialog(null, athleteCompetitor.getFullDetails(), "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumber + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid competitor number. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number to remove:");

                JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumberInput + " is removed");

            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call a method to handle the close action
                System.exit(0);

            }
        });
    }

    private static Competitor findCompetitorByNumber(int competitorNumber) {

        Competitor c1 = new AthleteCompetitor(
                1,
                new CompetitorName("Mark", "X", "Johnson"),
                "Athleste",
                25,
                "USA",
                new int[]{90, 85, 88}
        );

        Competitor c2 = new AthleteCompetitor(
                2,
                new CompetitorName("Eva", "Y", "Williams"),
                "Gamer",
                22,
                "Canada",
                new int[]{85, 78, 92}
        );

        Competitor c3 = new AthleteCompetitor(
                3,
                new CompetitorName("Sam", "Z", "Brown"),
                "Athleste",
                30,
                "UK",
                new int[]{95, 88, 91}
        );

        Competitor c4 = new Gamers(
                4,
                new CompetitorName("Lily", "W", "Smith"),
                "Gamer",
                30,
                "UK",
                new int[]{95, 92, 89}
        );

        Competitor c5 = new AthleteCompetitor(
                5,
                new CompetitorName("Max", "V", "Taylor"),
                "Athleste",
                27,
                "France",
                new int[]{92, 89, 90}
        );

        Competitor c6 = new Gamers(
                6,
                new CompetitorName("Sophie", "U", "Johnson"),
                "Gamer",
                24,
                "Italy",
                new int[]{94, 91, 93}
        );

        Competitor c7 = new AthleteCompetitor(
                7,
                new CompetitorName("Daniel", "T", "Smith"),
                "Athleste",
                28,
                "Spain",
                new int[]{89, 87, 82}
        );

        Competitor c8 = new Gamers(
                8,
                new CompetitorName("Grace", "S", "Davis"),
                "Gamer",
                29,
                "Japan",
                new int[]{91, 90, 95}
        );

        Competitor c9 = new AthleteCompetitor(
                9,
                new CompetitorName("Peter", "R", "White"),
                "Athleste",
                23,
                "Australia",
                new int[]{87, 88, 91}
        );

        Competitor c10 = new Gamers(
                10,
                new CompetitorName("Chloe", "Q", "Johnson"),
                "Gamer",
                31,
                "South Korea",
                new int[]{93, 92, 96}
        );

        Competitor c11 = new AthleteCompetitor(
                11,
                new CompetitorName("Andrew", "P", "Smith"),
                "Athleste",
                29,
                "Brazil",
                new int[]{85, 86, 89}
        );

        Competitor c12 = new Gamers(
                12,
                new CompetitorName("Zoe", "O", "Brown"),
                "Gamer",
                26,
                "China",
                new int[]{88, 87, 91}
        );

        Competitor c13 = new AthleteCompetitor(
                13,
                new CompetitorName("George", "N", "Miller"),
                "Athleste",
                24,
                "India",
                new int[]{94, 93, 95}
        );

        Competitor c14 = new Gamers(
                14,
                new CompetitorName("Mia", "M", "Jones"),
                "Gamer",
                27,
                "Russia",
                new int[]{89, 90, 88}
        );

        Competitor c15 = new AthleteCompetitor(
                15,
                new CompetitorName("Lucas", "L", "Anderson"),
                "Athleste",
                28,
                "Mexico",
                new int[]{92, 98, 92}
        );

        if (c1.getCompetitorNumber() == competitorNumber) {
            return c1;
        } else if (c2.getCompetitorNumber() == competitorNumber) {
            return c2;
        } else if (c3.getCompetitorNumber() == competitorNumber) {
            return c3;
        } else if (c4.getCompetitorNumber() == competitorNumber) {
            return c4;
        } else if (c5.getCompetitorNumber() == competitorNumber) {
            return c5;
        } else if (c6.getCompetitorNumber() == competitorNumber) {
            return c6;
        } else if (c7.getCompetitorNumber() == competitorNumber) {
            return c7;
        } else if (c8.getCompetitorNumber() == competitorNumber) {
            return c8;
        } else if (c9.getCompetitorNumber() == competitorNumber) {
            return c9;
        } else if (c10.getCompetitorNumber() == competitorNumber) {
            return c10;
        } else if (c11.getCompetitorNumber() == competitorNumber) {
            return c11;
        } else if (c12.getCompetitorNumber() == competitorNumber) {
            return c12;
        } else if (c13.getCompetitorNumber() == competitorNumber) {
            return c13;
        } else if (c14.getCompetitorNumber() == competitorNumber) {
            return c14;
        } else if (c15.getCompetitorNumber() == competitorNumber) {
            return c15;
        } else {
            return null; // Return null if no match is found
        }
    }

  private void createGUI() {
    // Create the main frame
    setTitle("Competitor Management System");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel to hold the buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 5));

 

    buttonPanel.add(viewScoresButton);
    buttonPanel.add(viewTableButton);
    buttonPanel.add(viewDetailsButton);
    buttonPanel.add(removeCompetitorButton);
    buttonPanel.add(closeButton);

    // Add the panel to the frame
    add(buttonPanel);

    // Set the frame to be visible
    setVisible(true);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void writeCompetitorReportToFile() {
        String report = competitorList.generateCompetitorReport();
        try (PrintWriter writer = new PrintWriter(new FileWriter("CompetitorReport.txt"))) {
            writer.println(report);
            JOptionPane.showMessageDialog(null, "Competitor report written to CompetitorReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCompetitorsFromFile(CompetitorList competitorList, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Integer.parseInt(line.split(",")[0]);
                } catch (NumberFormatException e) {
                    continue;
                }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CompetitorList competitorList = new CompetitorList();

                Gui gui = new Gui(competitorList);
            }
        });

        // Variables declaration - do not modify                     
        // End of variables declaration                   
    }
}
