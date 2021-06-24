package com.example.demo.wissen;

import java.io.*;
import java.util.*;

public class TestClass {
    static class Reservation {
        Map<Integer, List<int[]>> tableTiming = new HashMap<>();

        void addReservation(int[] timing) {
            List<int[]> reservedTimings = new ArrayList<>();
            if (tableTiming.isEmpty()) {
                reservedTimings.add(timing);
                tableTiming.put(tableTiming.size() + 1, reservedTimings);
                return;
            }

            int count = 0;
            for (Map.Entry<Integer, List<int[]>> table : tableTiming.entrySet()) {
                List<int[]> reservedTiming = table.getValue();
                boolean currentTableAvailability = true;
                for (int[] startEndTiming : reservedTiming) {
                    if ((timing[0] >= startEndTiming[0] && timing[0] <= startEndTiming[1])
                            || (timing[1] >= startEndTiming[0] && timing[1] <= startEndTiming[1])
                            || (startEndTiming[0] >= timing[0] && startEndTiming[0] <= timing[1])
                            || (startEndTiming[1] >= timing[0] && startEndTiming[1] <= timing[1])
                    ) {
                        currentTableAvailability = false;
                        break;
                    }
                }

                if (currentTableAvailability) {
                    reservedTiming.add(timing);
                    tableTiming.put(table.getKey(), reservedTiming);
                    break;
                } else {
                    count++;
                }
            }

            if (count == tableTiming.size()) {
                reservedTimings.add(timing);
                tableTiming.put(tableTiming.size() + 1, reservedTimings);
            }
        }
    }

    static int minReservationTables(int[][] reservationStartEndTimes) {
        // YOUR CODE HERE
        int noOfTables = 0;
        Reservation reservation = new Reservation();

        for (int i = 0; i < reservationStartEndTimes.length; i++) {
            int[] timing = reservationStartEndTimes[i];
            Arrays.sort(timing);
            reservation.addReservation(timing);
        }

        return reservation.tableTiming.size();
    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] reservationStartEndTimeList = new int[n][2];
        String[] reservationStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
            for (int j = 0; j < reservationStartEndTime.length; j++) {
                reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
            }
        }

        int out = minReservationTables(reservationStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}