package Scheduling;
import java.util.*;

// Non-Preemptive Priority Scheduling Algorithm
public class Priority_ALGO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n];   // Process IDs
        int[] bt = new int[n];    // Burst Times
        int[] pr = new int[n];    // Priorities
        int[] wt = new int[n];    // Waiting Times
        int[] tat = new int[n];   // Turnaround Times

        // Step 2: Input burst time and priority for each process
        System.out.println("\nEnter Burst Time and Priority for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + " (BT Priority): ");
            bt[i] = sc.nextInt();
            pr[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        // Step 3: Sort processes by Priority (Higher number = Higher priority)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pr[i] < pr[j]) {
                    // Swap priorities
                    int temp = pr[i]; pr[i] = pr[j]; pr[j] = temp;
                    // Swap burst times
                    temp = bt[i]; bt[i] = bt[j]; bt[j] = temp;
                    // Swap process IDs
                    temp = pid[i]; pid[i] = pid[j]; pid[j] = temp;
                }
            }
        }

        // Step 4: Calculate Waiting Time & Turnaround Time
        wt[0] = 0;            // First process has 0 waiting time
        tat[0] = bt[0];       // TAT = BT for first process
        int totalWT = wt[0];
        int totalTAT = tat[0];

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];   // Waiting time = previous TAT
            tat[i] = wt[i] + bt[i];          // Turnaround = waiting + burst
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        // Step 5: Display results
        System.out.println("\nProcess\tBT\tWT\tTAT\tPriority");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i] + "\t" + pr[i]);
        }

        // Step 6: Display averages
        double avgWT = (double) totalWT / n;
        double avgTAT = (double) totalTAT / n;

        System.out.printf("\nAverage Waiting Time: %.2f", avgWT);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTAT);

        sc.close();
    }
}