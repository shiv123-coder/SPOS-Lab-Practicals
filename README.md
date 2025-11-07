# 🧩 System Programming & Operating Systems — Lab Practicals (SPOS)

**Prepared by:** Shivshankar Dhareppa Mali  
**Subject:** System Programming and Operating Systems — Lab Practicals  
**Environment Used:** *Eclipse IDE*  

> ⚙️ **Note:**  
> All SPOS practical assignments are **implemented and executed in Eclipse IDE**.  
> For each practical, open the respective project folder in Eclipse and navigate to the **`src`** directory to view or run the code files.  
> The `src` folder contains all Java source files, each with the main class highlighted in Eclipse.

---

## 📘 Table of Contents

| Sr.No | Title | Date | Page No | Sign | Remark |
|---:|---|---:|---:|---|---|
| 1 | Design suitable data structures & implement Pass-I & Pass-II of a two-pass assembler for a pseudo machine. The output of Pass I should be input of Pass II. | 30/07/2025 | | | |
| 2 | Design suitable data structures & implement Pass-I & Pass-II of a two-pass macro processor. The output of Pass I should be input for Pass II. | 23/08/2025 | | | |
| 3 | Write a Java program to implement the following scheduling algorithms: FCFS, SJF, Priority & Round Robin. | 10/09/2025 | | | |
| 4 | Write a program to simulate page replacement algorithms (e.g., FIFO, LRU, Optimal). | 19/09/2025 | | | |

---

## 🧠 Practical 1 — Two-pass Assembler (Pass I & Pass II)

**Objective:**  
Design appropriate data structures and implement Pass-I and Pass-II of a two-pass assembler for a pseudo machine.  
The output of Pass I should serve as input for Pass II.

**Project Folder Location:**  
`D:\3rd Year\System Programming and Operating System\Lab\Practical 1\A1\src\assembler`

**Files to include:**
- `Pass1.java`
- `Pass2.java`
- `input.asm`
- `intermediate.txt`
- `output.obj`
- `README_assembler.md`

**Short notes:**  
Document symbol table, literal table, intermediate file, and final object code output.

---

## 🧩 Practical 2 — Two-pass Macro Processor (Pass I & Pass II)

**Objective:**  
Design data structures and implement Pass-I and Pass-II of a two-pass macro processor.  
Demonstrate macro expansion using MDT, MNT, and ALA tables.

**Project Folder Location:**  
`D:\3rd Year\System Programming and Operating System\Lab\Practical 2\A2\src\Macroprocessor`

**Files to include:**
- `MacroPass1.java`
- `MacroPass2.java`
- `macros_sample.asm`
- `README_macro.md`

**Short notes:**  
Show creation of macro tables and expansion process with sample input/output.

---

## ⚙️ Practical 3 — Scheduling Algorithms

**Objective:**  
Implement the following CPU scheduling algorithms in Java:  
- FCFS (First Come First Serve)  
- SJF (Shortest Job First)  
- Priority Scheduling  
- Round Robin Scheduling  

**Project Folder Location:**  
`D:\3rd Year\System Programming and Operating System\Lab\Practical 3\A3\src\Scheduling`

**Files to include:**
- `Scheduling.java`
- `Process.java` (if separate)
- `README_scheduling.md`
- `input_examples.txt`

**Short notes:**  
Include execution screenshots, Gantt charts, average waiting and turnaround time calculations.

---

## 💾 Practical 4 — Page Replacement Algorithms

**Objective:**  
Simulate page replacement algorithms using Java.  
Demonstrate FIFO, LRU, and Optimal page replacement, displaying page fault counts.

**Project Folder Location:**  
`D:\3rd Year\System Programming and Operating System\Lab\Practical 4\A4\src\A4`

**Files to include:**
- `PageReplacement.java`
- `FIFO.java`
- `LRU.java`
- `Optimal.java`
- `README_page_replacement.md`

**Short notes:**  
Include reference string examples and page fault comparisons for each algorithm.

---

## 📂 Repository Structure (Recommended on GitHub)

```
SPOS-Lab/
├─ redmi.md
├─ README.md
├─ Practical 1/
│  └─ A1/
│     └─ src/
│        └─ assembler/
│           ├─ Pass1.java
│           ├─ Pass2.java
│           ├─ input.asm
│           └─ output.obj
├─ Practical 2/
│  └─ A2/
│     └─ src/
│        └─ Macroprocessor/
│           ├─ MacroPass1.java
│           ├─ MacroPass2.java
│           └─ macros_sample.asm
├─ Practical 3/
│  └─ A3/
│     └─ src/
│        └─ Scheduling/
│           ├─ Scheduling.java
│           └─ input_examples.txt
└─ Practical 4/
   └─ A4/
      └─ src/
         └─ A4/
            ├─ PageReplacement.java
            ├─ FIFO.java
            ├─ LRU.java
            └─ Optimal.java
```

---

## 📝 Notes

- All practicals are developed and tested using **Eclipse IDE**.  
- Open each project folder in Eclipse and check the **`src`** directory for code files.  
- The main class in each practical is already marked (highlighted) within Eclipse.  
- College name intentionally omitted for privacy.  
- This `redmi.md` serves as the official record and reference index for all SPOS practical submissions.

---

**End of File**
