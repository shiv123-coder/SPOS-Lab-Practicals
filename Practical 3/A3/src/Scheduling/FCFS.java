package Scheduling;

import java.util.*;

class Process {
    int pid; // Process ID
    int at; // Arrival Time
    int bt; // Burst Time
    int wt; // Waiting Time
    int tat; // Turnaround Time
    int ct; // Completion Time

    public Process(int pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
    }
}

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        int n = sc.nextInt();

        Process[] ps = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1) + ":");
            System.out.print("Enter Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            int bt = sc.nextInt();
            ps[i] = new Process(i + 1, at, bt);
        }

        // Sort processes based on Arrival Time
        Arrays.sort(ps, Comparator.comparingInt(p -> p.at));

        System.out.println("\nScheduling Type: First Come First Serve (FCFS)\n");

        int currentTime = 0;
        int totalWT = 0, totalTAT = 0;

        for (int i = 0; i < n; i++) {
            // If CPU is idle and next process hasn't arrived yet
            if (currentTime < ps[i].at) {
                currentTime = ps[i].at;
            }

            ps[i].wt = currentTime - ps[i].at; // Waiting Time
            currentTime += ps[i].bt; // CPU executes the process
            ps[i].ct = currentTime; // Completion Time
            ps[i].tat = ps[i].wt + ps[i].bt;

            totalWT += ps[i].wt;
            totalTAT += ps[i].tat;
        }

        System.out.println("Process\tArrival\tBurst\tWaiting\tTurnaround\tCompletion");
        for (Process p : ps) {
            System.out.println(
                    "P" + p.pid + "\t\t" + p.at + "\t\t" + p.bt + "\t\t" + p.wt + "\t\t" + p.tat + "\t\t" + p.ct);
        }

        System.out.printf("\nAverage Waiting Time: %.2f", (double) totalWT / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", (double) totalTAT / n);
    }
}
