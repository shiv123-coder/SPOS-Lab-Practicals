package Scheduling;

import java.util.*;

class Process {
    int pid;       // Process ID
    int burst;     // Burst Time
    int waiting;   // Waiting Time
    int tat;       // Turnaround Time

    Process(int pid, int burst) {
        this.pid = pid;
        this.burst = burst;
    }
}

public class SJF_ALGO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] proc = new Process[n];

        // Step 2: Input burst times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst Time for Process[" + (i + 1) + "]: ");
            int burst = sc.nextInt();
            proc[i] = new Process(i + 1, burst);
        }

        // Step 3: Sort processes by burst time (Shortest Job First)
        Arrays.sort(proc, Comparator.comparingInt(p -> p.burst));

        // Step 4: Calculate Waiting Time and Turnaround Time
        int totalWT = 0, totalTAT = 0;

        proc[0].waiting = 0; // First process has 0 waiting time
        proc[0].tat = proc[0].burst; // Turnaround = Burst for first process

        for (int i = 1; i < n; i++) {
            proc[i].waiting = proc[i - 1].waiting + proc[i - 1].burst;
            proc[i].tat = proc[i].waiting + proc[i].burst;
        }

        // Step 5: Display Process Table
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Process p : proc) {
            System.out.println("P" + p.pid + "\t\t" + p.burst + "\t\t" + p.waiting + "\t\t" + p.tat);
            totalWT += p.waiting;
            totalTAT += p.tat;
        }

        // Step 6: Print Averages
        double avgWT = (double) totalWT / n;
        double avgTAT = (double) totalTAT / n;

        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);

        sc.close();
    }
}
