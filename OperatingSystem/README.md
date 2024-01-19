# Operating Systems (CS 4310)
## Project  Abstract
<br>
Simulating Job Scheduler of the Operating Systems by programming the following four scheduling algorithms that we covered in the class:

* First-Come-First-Serve (FCFS)
* Shortest-Job-First (SJF)
* Round-Robin with Time Slice = 2 (RR-2)
* nd-Robin with Time Slice = 5 (PR-5)

The project generates multiple testing cases with inputs of 5 jobs, 10 jobs, and 15 jobs, 20 cases each, for 60 files. The program will read process burst times from a file, job.txt, and execute the four algorithms above. A sample input file of five jobs is given as follows (burst time in ms). The program displays four algorithms job processes in a table format and calculates the average turnover time(ATT). It compares the mean of ATT for each job group.


[Implementation detailed in Java](https://github.com/keiakihito/PersonalProjects/tree/main/OperatingSystem/ProgramingProject/src)<br>

[Project report](https://github.com/keiakihito/PersonalProjects/blob/main/OperatingSystem/ProgramingProject/ProjectReport.pdf)

<br><br>

## Term Paper
<br> Proposal: 
<br> 
* Comparative Analysis of Process Scheduling Algorithms in Leading Operating Systems This paper investigates the distinct process scheduling algorithms implemented in major operating systems: Windows, macOS, Linux, and Android. Process scheduling is a fundamental aspect of operating systems to maximize CPU performance and efEiciency. The evolution of process scheduling algorithms is a response to changes in hardware and the diversifying operating system. 

* This research aims to clarify how distinct process scheduling algorithms, such as preemptive multitasking, cooperative multitasking, and the Completely Fair Scheduler. Each scheduling algorithm has unique characteristics which represent a different approach to managing CPU resources and process execution to optimize CPU performance. The paper describes how they are adapted to each operating system and why these algorithms suit operating systems.

* The research will mainly include authoritative books and technical journals to contextualize the topic. After completing this research project, students understand the importance of scheduling algorithms with hands-on experience from another programming project. This coordination of theoretical and practical elements encourages students to conduct more detailed research about designing future scheduling algorithms. Considering the current trend, the data sets have massively increased, known as big data. The schedule algorithms will need to handle enormous datasets efEiciently, ensuring that data processing tasks are managed effectively across potentially thousands of processors.

[Full tech paper with reference page, MLA style format](https://github.com/keiakihito/PersonalProjects/blob/main/OperatingSystem/TermPaper/KatsumiTechpaper.pdf)
