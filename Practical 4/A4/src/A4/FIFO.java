package A4;

import java.io.*;

public class FIFO {
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
            buffer[i] = -1; // Initialize all frames to empty (-1)

        int pointer = 0, hit = 0, fault = 0;

        // Process each page reference
        for (int i = 0; i < ref_len; i++) {
            int currentPage = reference[i];
            boolean isHit = false;

            // Check if page already exists (hit)
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == currentPage) {
                    hit++;
                    isHit = true;
                    break;
                }
            }

            // If not hit, replace oldest (FIFO)
            if (!isHit) {
                buffer[pointer] = currentPage;
                pointer = (pointer + 1) % frames;
                fault++;
            }

            // Display current memory layout
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
        System.out.printf("Hit Ratio:"+((float) hit / ref_len));
    }
}
