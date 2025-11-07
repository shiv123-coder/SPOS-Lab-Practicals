package Macroprocessor;

import java.io.*;
import java.util.*;

public class Pass1 {
    public static void main(String[] args) throws IOException {

        String[] code = {
            "MACRO",
            "INCR &ARG1",
            "A 1,&ARG1",
            "MEND",
            "START 101",
            "INCR TERM",
            "MOVEM AREG,TERM",
            "END"
        };

        List<String[]> MNT = new ArrayList<>();
        List<String> MDT = new ArrayList<>();

        BufferedWriter inter = new BufferedWriter(new FileWriter("intermediate.txt"));
        BufferedWriter mntFile = new BufferedWriter(new FileWriter("MNT.txt"));
        BufferedWriter mdtFile = new BufferedWriter(new FileWriter("MDT.txt"));

        boolean isMacro = false;
        int mdtIndex = 0;

        for (int i = 0; i < code.length; i++) {
            String line = code[i].trim();
            String[] parts = line.split(" ");

            if (parts[0].equalsIgnoreCase("MACRO")) {
                isMacro = true;
                String[] def = code[++i].trim().split(" ");
                MNT.add(new String[]{def[0], String.valueOf(mdtIndex)});
                continue;
            }

            if (parts[0].equalsIgnoreCase("MEND")) {
                MDT.add("MEND");
                mdtIndex++;
                isMacro = false;
                continue;
            }

            if (isMacro) MDT.add(line);
            else inter.write(line + "\n");
        }

        for (String[] m : MNT) mntFile.write(m[0] + "\t" + m[1] + "\n");
        for (int i = 0; i < MDT.size(); i++) mdtFile.write(i + "\t" + MDT.get(i) + "\n");

        inter.close();
        mntFile.close();
        mdtFile.close();

        System.out.println("Pass-I complete. MNT, MDT & Intermediate Code generated.");
    }
}
