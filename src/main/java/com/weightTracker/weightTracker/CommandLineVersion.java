package com.weightTracker.weightTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
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
        System.out.println("Please enter your weight: ");
        String in = reader.readLine();
        if (in != null && !in.isEmpty()) {
            try {
                double weight = Double.parseDouble(in);
                weightRepository.save(new Weight("D" + currentDate, currentDate, weight));
            } catch (NullPointerException e) {
                System.out.println("bad input!");
            }
        } else {
            System.out.println("No weight entered, please try again.");
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(CommandLineVersion.class, args);
    }

}

