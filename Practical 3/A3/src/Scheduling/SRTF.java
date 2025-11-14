package Scheduling;
import java.util.*;

public class SRTF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int at[] = new int[n];  // Arrival Time
        int bt[] = new int[n];  // Burst Time
        int rt[] = new int[n];  // Remaining Time
        int wt[] = new int[n];  // Waiting Time
        int tat[] = new int[n]; // Turnaround Time
        int pid[] = new int[n]; // Process IDs

        // Input Arrival and Burst times
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Enter Arrival Time for P" + pid[i] + ": ");
            at[i] = sc.nextInt();
            System.out.print("Enter Burst Time for P" + pid[i] + ": ");
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        int complete = 0, time = 0;

        while (complete < n) {
            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            // Find process with shortest remaining time at current time
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < minRT) {
                    minRT = rt[i];
                    idx = i;
                }
            }

            if (idx == -1) { // No process ready, increment time
                time++;
                continue;
            }

            // Execute process for 1 unit
            rt[idx]--;
            time++;

            if (rt[idx] == 0) { // Process finished
                complete++;
                tat[idx] = time - at[idx];
                wt[idx] = tat[idx] - bt[idx];
            }
        }

        // Display results
        System.out.println("\nPID\tAT\tBT\tWT\tTAT");
        float totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        System.out.println("\nAverage Waiting Time: " + (totalWT / n));
        System.out.println("Average Turnaround Time: " + (totalTAT / n));

        sc.close();
    }
}
