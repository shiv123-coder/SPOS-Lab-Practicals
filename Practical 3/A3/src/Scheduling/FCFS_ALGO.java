package Scheduling;
import java.util.*;

// Represents a process with essential scheduling attributes
class FCFSProcess {
    String id;          // Process ID
    int arrival;        // Arrival Time
    int burst;          // Burst Time
    int waiting;        // Waiting Time
    int turnaround;     // Turnaround Time

    // Constructor
    FCFSProcess(String id, int arrival, int burst) {
        this.id = id;
        this.arrival = arrival;
        this.burst = burst;
    }
}

// Main class implementing the FCFS scheduling algorithm
public class FCFS_ALGO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FCFSProcess> list = new ArrayList<>();

        // Step 1: Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Step 2: Input details for each process
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Process ID: ");
            String id = sc.next();
            System.out.print("Enter Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            int bt = sc.nextInt();
            list.add(new FCFSProcess(id, at, bt));
        }

        // Step 3: Sort by Arrival Time (FCFS Rule)
        list.sort(Comparator.comparingInt(p -> p.arrival));

        int currentTime = 0, totalWT = 0, totalTAT = 0;

        // Step 4: Calculate Waiting and Turnaround Times
        for (FCFSProcess p : list) {
            if (currentTime < p.arrival)
                currentTime = p.arrival; // Handle CPU idle time

            p.waiting = currentTime - p.arrival;   // Waiting Time
            p.turnaround = p.waiting + p.burst;    // Turnaround Time
            currentTime += p.burst;                // Advance time after execution

            totalWT += p.waiting;
            totalTAT += p.turnaround;
        }

        // Step 5: Display Result Table
        System.out.println("\nProcess\tAT\tBT\tWT\tTAT");
        for (FCFSProcess p : list)
            System.out.println(p.id + "\t" + p.arrival + "\t" + p.burst + "\t" + p.waiting + "\t" + p.turnaround);

        // Step 6: Display Averages
        System.out.printf("\nAverage Waiting Time: %.2f", (double) totalWT / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", (double) totalTAT / n);

        sc.close();
    }
}
