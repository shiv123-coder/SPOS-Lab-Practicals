package Scheduling;

import java.util.*;

public class RR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];   // Burst Time
        int[] rem = new int[n];  // Remaining Time
        int[] ct = new int[n];   // Completion Time

        // Step 2: Input burst times
        System.out.println("Enter burst times:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            rem[i] = bt[i];
        }

        // Step 3: Input time quantum
        System.out.print("Enter time quantum: ");
        int q = sc.nextInt();

        int t = 0;       // Current time
        int done;        // Counter for completed processes

        System.out.print("\nGantt Chart:\n" + t);

        // Step 4: Round Robin logic
        do {
            done = 0;
            for (int i = 0; i < n; i++) {
                if (rem[i] > 0) {
                    int use;
                    if (rem[i] > q)
                        use = q;
                    else
                        use = rem[i];

                    rem[i] -= use;   // Process executes
                    t += use;        // Time passes
                    System.out.print(" | P" + (i + 1) + " | " + t);

                    if (rem[i] == 0)
                        ct[i] = t;   // Completion time when done
                } else {
                    done++;
                }
            }
        } while (done < n);

        // Step 5: Calculate and print results
        System.out.println("\n\nPID\tBT\tCT\tTAT\tWT");

        int totalWT = 0, totalTAT = 0;

        for (int i = 0; i < n; i++) {
            int tat = ct[i];        // Turnaround Time = CT - AT (AT=0)
            int wt = tat - bt[i];   // Waiting Time = TAT - BT
            totalTAT += tat;
            totalWT += wt;

            System.out.println("P" + (i + 1) + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat + "\t" + wt);
        }

        // Step 6: Average calculations
        System.out.printf("\nAverage Turnaround Time = %.2f", totalTAT / (float) n);
        System.out.printf("\nAverage Waiting Time = %.2f\n", totalWT / (float) n);

        sc.close();
    }
}
