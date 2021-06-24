package com.example.demo.wissen;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {
    public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
        static class AppRating {
            String app;
            int rating;
        }

        Map<String, Integer> ratingCount = new HashMap<>();
        List<AppRating> appRatings = new ArrayList<>();

        @Override
        public void putNewRating(String app, int rating) {
            // YOUR CODE HERE
            AppRating appRating = new AppRating();
            appRating.app = app;
            appRating.rating = rating;
            appRatings.add(appRating);
        }

        @Override
        public double getAverageRating(String app) {
            // YOUR CODE HERE
            double averageRating = 0.0;
            int count = 0;

            Predicate<? super AppRating> predicate = ((appRating) -> appRating.app.equalsIgnoreCase(app));
            averageRating = appRatings.stream().filter(predicate)
                    .mapToInt(appRating -> appRating.rating)
                    .summaryStatistics()
                    .getAverage();

            averageRating = averageRating / count;
            ratingCount.put(app, count);
            return averageRating;
        }

        @Override
        public int getRatingsCount(String app) {
            return ratingCount.get(app);
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingStatisticsCollector {
        // Ratings feed will call this method when new app rating information is received. This is input to your class. ratings is a non negative integer between 0 to 10.
        public void putNewRating(String app, int rating);

        // Report the average rating of the app. 
        public double getAverageRating(String app);

        // Report the total number of rating for an app.
        public int getRatingsCount(String app);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
            final Set<String> apps = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String app = tokens[0];
                apps.add(app);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewRating(app, runs);

            }

            for (String app : apps) {
                System.out.println(
                        String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
            }

        }
        scanner.close();

    }
}