package Scheduling;

import java.util.Scanner;

public class RoundR {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Maximum number of processes allowed
        final int MAX = 10;

        // Arrays to store burst time, waiting time, and remaining time
        int[] btime = new int[MAX];
        int[] wtime = new int[MAX];
        int[] rtime = new int[MAX];

        int num, quantum;

        // Step 1: Input number of processes
        System.out.print("Enter number of processes (max 10): ");
        num = s.nextInt();

        if (num > MAX) {
            System.out.println("Error: Maximum number of processes is 10.");
            s.close();
            return;
        }

        // Step 2: Input burst times
        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < num; i++) {
            System.out.print("P" + (i + 1) + ": ");
            btime[i] = s.nextInt();
            rtime[i] = btime[i]; // Remaining time initially = burst time
            wtime[i] = 0;        // Initialize waiting time to 0
        }

        // Step 3: Input time quantum
        System.out.print("Enter time quantum: ");
        quantum = s.nextInt();

        // Step 4: Round Robin Scheduling logic
        int remaining = num; // Remaining processes
        int time = 0;        // Current time counter
        int i = 0;           // Process index

        System.out.print("\nGantt Chart:\n" + time);

        while (remaining > 0) {
            if (rtime[i] > quantum) {
                // Process executes for full quantum
                rtime[i] -= quantum;
                time += quantum;
                System.out.print(" | P" + (i + 1) + " | " + time);
            } else if (rtime[i] > 0) {
                // Process executes for remaining time and completes
                time += rtime[i];
                rtime[i] = 0;
                remaining--;
                System.out.print(" | P" + (i + 1) + " | " + time);
            }

            // Move to next process in round-robin order
            i++;
            if (i == num) {
                i = 0; // Restart from first process
            }
        }

        s.close();
        System.out.println("\n\nAll processes completed.");
    }
}
