package A4;

import java.io.*;
import java.util.*;

public class LRU {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input for number of frames
        System.out.print("Enter the number of frames: ");
        int frames = Integer.parseInt(br.readLine());

        // Input for reference string length
        System.out.print("Enter the length of the reference string: ");
        int ref_len = Integer.parseInt(br.readLine());

        // Input reference string
        int[] reference = new int[ref_len];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }

        int[] buffer = new int[frames];
        Arrays.fill(buffer, -1);  // Initialize all frames to -1
        ArrayList<Integer> stack = new ArrayList<>();

        int hit = 0, fault = 0;

        // Process each page reference
        for (int i = 0; i < ref_len; i++) {
            int currentPage = reference[i];

            // If page is already in stack, remove and reinsert (most recently used)
            if (stack.contains(currentPage)) {
                stack.remove((Integer) currentPage);
                stack.add(currentPage);
                hit++;
            } else {
                // Page Fault occurs
                if (stack.size() < frames) {
                    stack.add(currentPage);
                    buffer[stack.size() - 1] = currentPage;
                } else {
                    // Replace least recently used page
                    int lruPage = stack.remove(0);
                    stack.add(currentPage);

                    // Replace in buffer
                    for (int j = 0; j < frames; j++) {
                        if (buffer[j] == lruPage) {
                            buffer[j] = currentPage;
                            break;
                        }
                    }
                }
                fault++;
            }

            // Display memory layout after each reference
            System.out.print("Memory Layout after reference " + currentPage + ": ");
            for (int j = 0; j < frames; j++) {
                if (buffer[j] != -1)
                    System.out.print(buffer[j] + " ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }

        // Final statistics
        System.out.println("\nTotal Page Hits: " + hit);
        System.out.println("Total Page Faults: " + fault);
        System.out.printf("Hit Ratio: %.2f\n", (float) hit / ref_len);
    }
}
