package assembler;

import java.io.*;
import java.util.*;

public class Pass2 {
    public static void main(String[] args) throws IOException {

        BufferedReader inter = new BufferedReader(new FileReader("intermediate.txt"));
        BufferedReader symtab = new BufferedReader(new FileReader("symtab.txt"));
        BufferedWriter target = new BufferedWriter(new FileWriter("target.txt"));

        // Load symbol table into HashMap
        Map<String, String> symTable = new HashMap<>();
        String line;

        while ((line = symtab.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 2)
                symTable.put(parts[0], parts[1]);
        }

        // Instruction codes and registers
        List<String> inst = Arrays.asList("ADD", "SUB", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT");
        List<String> reg = Arrays.asList("AREG", "BREG", "CREG", "DREG");

        while ((line = inter.readLine()) != null) {
            String[] parts = line.split("\t");
            String lc = parts[0];
            String opcode = parts[1];
            String operand = parts.length > 2 ? parts[2] : "";

            if (opcode.equals("START") || opcode.equals("END") || opcode.equals("DS"))
                continue;

            if (opcode.equals("DC")) {
                target.write(lc + "\t" + operand + "\n");
                continue;
            }

            int opCodeVal = inst.indexOf(opcode) + 1;

            String regName = "";
            String symName = "";

            if (operand.contains(",")) {
                parts = operand.split(",");
                regName = parts[0];
                symName = parts[1];
            } else {
                symName = operand;
            }

            int regCodeVal = reg.indexOf(regName) + 1;
            String address = symTable.getOrDefault(symName, "000");

            target.write(lc + "\t" + opCodeVal + "\t" + regCodeVal + "\t" + address + "\n");
        }

        inter.close();
        symtab.close();
        target.close();

        System.out.println("Pass-II complete. Target code generated in target.txt.");
    }
}
