package com.weightTracker.weightTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

@SpringBootApplication
@EnableMongoRepositories
public class CommandLineVersion implements CommandLineRunner {

    @Autowired
    WeightRepository weightRepository;

    @Override
    public void run(String... args) throws Exception {

        LocalDate currentDate = LocalDate.now();
        System.out.println("The current date is: " + currentDate);
        // here you can handle command line arguments and interact with the user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean appActive = false;

        while (appActive) {
            boolean weightSetForCurrentDate = checkIfWeightSet(currentDate);
            System.out.println("Debug: weightSetForCurrentDate = " + weightSetForCurrentDate);
            System.out.println("Welcome!");
            System.out.println("1) Enter new weight");
            System.out.println("2) View data");
            System.out.println("3) Exit");

            try {
                String in = reader.readLine();

                if (in != null && !in.isEmpty()) {

                    int chosenOption = Integer.parseInt(in);

                    if (chosenOption == 1) {
                        if (!weightSetForCurrentDate) {
                            System.out.println("Please enter your weight: ");
                            in = reader.readLine();
                            try {
                                inputWeight(currentDate, in);
                                appActive = false;
                            } catch (NumberFormatException e) {
                                System.out.println("bad input!");
                                System.out.println("Please enter your weight: ");
                            } catch (NullPointerException e) {
                                new NullPointerException();
                            }
                        } else {
                            System.out.println("Weight already set for today!");
                            System.out.println("Would you like to override?");
                            System.out.println("(Y)es (N)o");
                            // TODO: override option here
                        }
                    } else if (chosenOption == 2) {
                        // show the data here
                        System.out.println("data: ");
                    } else if (chosenOption == 3) {
                        appActive = false;
                    }
                } else {
                    System.out.println("No weight entered, please try again.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from the list below: ");
                System.out.println("1) Enter new weight");
                System.out.println("2) View data");
                System.out.println("3) Exit");
            }

        }

       // if (!appActive) System.exit(0);

    }

    private void inputWeight(LocalDate currentDate, String in) {
        double weight = Double.parseDouble(in);
        weightRepository.save(new Weight("D" + currentDate, currentDate, weight));
        System.out.println("weight: " + weight + " entered on date: " + currentDate);
        System.out.println("Goodbye");
    }

    private boolean checkIfWeightSet(LocalDate currentDate) {
        return weightRepository.existsByLocalDate(currentDate);
    }

    public static void main(String[] args) {
        SpringApplication.run(CommandLineVersion.class, args);
    }

}

