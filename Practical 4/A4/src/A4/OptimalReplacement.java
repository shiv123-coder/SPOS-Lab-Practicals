package A4;

import java.io.*;

public class OptimalReplacement {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input number of frames
        System.out.print("Enter the number of frames: ");
        int frames = Integer.parseInt(br.readLine());

        // Input length of reference string
        System.out.print("Enter the length of the reference string: ");
        int ref_len = Integer.parseInt(br.readLine());

        // Input reference string
        int[] reference = new int[ref_len];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }

        int[] buffer = new int[frames];
        for (int i = 0; i < frames; i++)
            buffer[i] = -1; // Initialize frames as empty

        int hit = 0, fault = 0;
        boolean isFull = false;

        System.out.println("\nReplacement Table:");
        System.out.println("------------------");

        // Process each page reference
        for (int i = 0; i < ref_len; i++) {
            int currentPage = reference[i];
            boolean isHit = false;

            // Check if current page is already in memory
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == currentPage) {
                    hit++;
                    isHit = true;
                    break;
                }
            }

            // If not found → Page Fault
            if (!isHit) {
                if (!isFull) {
                    buffer[fault] = currentPage;
                    fault++;
                    if (fault == frames) isFull = true;
                } else {
                    // Find page to replace using Optimal strategy
                    int[] nextUse = new int[frames];
                    for (int j = 0; j < frames; j++) {
                        nextUse[j] = Integer.MAX_VALUE;
                        for (int k = i + 1; k < ref_len; k++) {
                            if (buffer[j] == reference[k]) {
                                nextUse[j] = k;
                                break;
                            }
                        }
                    }

                    // Find the page with the farthest next use
                    int replaceIndex = 0, farthest = -1;
                    for (int j = 0; j < frames; j++) {
                        if (nextUse[j] > farthest) {
                            farthest = nextUse[j];
                            replaceIndex = j;
                        }
                    }

                    buffer[replaceIndex] = currentPage;
                    fault++;
                }
            }

            // Print current frame status (Replacement Table)
            System.out.printf("After reference %2d: ", currentPage);
            for (int j = 0; j < frames; j++) {
                if (buffer[j] != -1)
                    System.out.printf("%3d ", buffer[j]);
                else
                    System.out.print("  - ");
            }
            System.out.println();
        }

        // Final summary
        System.out.println("\n--------------------------------");
        System.out.println("Total Page Hits   : " + hit);
        System.out.println("Total Page Faults : " + fault);
        System.out.printf("Hit Ratio         : %.2f\n", (float) hit / ref_len);
    }
}
