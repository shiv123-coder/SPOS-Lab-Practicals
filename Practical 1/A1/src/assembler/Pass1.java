package assembler;

import java.io.*;

public class Pass1 {
    public static void main(String[] args) throws IOException {

        // Sample Assembly Program
        String[][] code = {
            {"", "START", "100"},
            {"LOOP", "MOVER", "AREG,DATA"},
            {"", "ADD", "AREG,ONE"},
            {"", "MOVEM", "AREG,RESULT"},
            {"", "END", ""}
        };

        int lc = 0;

        // Symbol table
        String[][] symtab = new String[10][2];
        int symCnt = 0;

        BufferedWriter symTable = new BufferedWriter(new FileWriter("symtab.txt"));
        BufferedWriter inter = new BufferedWriter(new FileWriter("intermediate.txt"));

        for (int i = 0; i < code.length; i++) {
            String label = code[i][0];
            String opcode = code[i][1];
            String operand = code[i][2];

            if (opcode.equalsIgnoreCase("START")) {
                lc = Integer.parseInt(operand);
                inter.write(lc + "\t" + opcode + "\t" + operand + "\n");
                continue;
            }

            if (!label.equals("")) {
                symtab[symCnt][0] = label;
                symtab[symCnt][1] = Integer.toString(lc);
                symCnt++;
            }

            inter.write(lc + "\t" + opcode + "\t" + operand + "\n");

            if (opcode.equalsIgnoreCase("DS"))
                lc += Integer.parseInt(operand);
            else if (opcode.equalsIgnoreCase("DC"))
                lc += 1;
            else
                lc += 1;
        }

        // Write Symbol Table
        for (int i = 0; i < symCnt; i++) {
            symTable.write(symtab[i][0] + "\t" + symtab[i][1] + "\n");
        }

        inter.close();
        symTable.close();

        System.out.println("Pass-I complete. Intermediate code and Symbol Table generated.");
    }
}
