package Scheduling;

import java.util.*;

class Process {
    int pid; // process ID
    int bt; // burst time
    int wt; // waiting time
    int tat; // turnaround time

    public Process(int pid, int bt) {
        this.pid = pid;
        this.bt = bt;
    }
}

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        int n = sc.nextInt();

        Process[] ps = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process [" + (i + 1) + "]: ");
            int bt = sc.nextInt();
            ps[i] = new Process(i + 1, bt);
        }

        // Sort by burst time for SJF
        Arrays.sort(ps, Comparator.comparingInt(p -> p.bt));

        System.out.println("\nScheduling Type: Shortest Job First (SJF)");

        int totalWT = 0, totalTAT = 0;

        ps[0].wt = 0;
        ps[0].tat = ps[0].bt;
        totalWT += ps[0].wt;
        totalTAT += ps[0].tat;

        for (int i = 1; i < n; i++) {
            ps[i].wt = ps[i - 1].wt + ps[i - 1].bt;
            ps[i].tat = ps[i].wt + ps[i].bt;

            totalWT += ps[i].wt;
            totalTAT += ps[i].tat;
        }

        System.out.println("\nProcess\tBurstTime\tWaitingTime\tTurnaroundTime");
        for (Process p : ps) {
            System.out.println("P" + p.pid + "\t\t" + p.bt + "\t\t" + p.wt + "\t\t" + p.tat);
        }

        System.out.printf("\nAverage Waiting Time: %.2f", (double) totalWT / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", (double) totalTAT / n);
    }
}
