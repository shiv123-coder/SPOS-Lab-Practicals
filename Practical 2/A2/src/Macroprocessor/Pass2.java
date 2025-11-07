package Macroprocessor;

import java.io.*;
import java.util.*;

public class Pass2 {
    private final Map<String, Integer> MNT = new HashMap<>();
    private final List<String> MDT = new ArrayList<>();
    private final List<String> inter = new ArrayList<>();
    private final List<String> output = new ArrayList<>();

    public Pass2() {
        MNT.put("INCR", 0);
        MDT.add("INCR &ARG");
        MDT.add("A 1,&ARG");
        MDT.add("MEND");

        inter.add("START");
        inter.add("MOV A,10");
        inter.add("INCR TERM");
        inter.add("END");
    }

    public void expand() {
        for (String line : inter) {
            String[] t = line.split(" ");
            if (t.length == 0) continue;
            if (MNT.containsKey(t[0])) {
                int i = MNT.get(t[0]) + 1;
                String arg = t.length > 1 ? t[1] : "";
                while (!MDT.get(i).equalsIgnoreCase("MEND")) {
                    output.add(MDT.get(i).replace("&ARG", arg));
                    i++;
                }
            } else output.add(line);
        }
    }

    public void show() {
        System.out.println("Final Output Code:\n");
        try (BufferedWriter w = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String l : output) {
                System.out.println(l);
                w.write(l + "\n");
            }
            System.out.println("\nOutput written to output.txt");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Pass2 p = new Pass2();
        p.expand();
        p.show();
    }
}
