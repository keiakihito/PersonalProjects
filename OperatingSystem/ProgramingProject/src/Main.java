

import java.io.IOException;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class name, main.java
 * Author Keita Katsumi
 * CS 4310 Winter  2024
 * Simulating Job Scheduler programming project
 *
 * Description:
 * The main executes these 4 algorithms
 * 1. First-Come-First-Serve(FCFS)
 * 2. Shortest-Job-First(SJF)
 * 3. Round-Robin with Time slice = 2 (RR-2)
 * 4. Round-Robin with Time slice = 5 (RR-5)
 * Calculate Average Turnover Time for 20 samples of 5, 10, and 15 Jobs files.
 * The methods create CSV files in the AttCSVFiles Directory
 *
 * Last modified Jan 4th, 2024
 */

public class Main {
    public static void main(String[] args) throws IOException
    {
        //Executing 4 algorithms 5Jobs file 20 samples
        excute5jobsAlgorithms();

        // //Executing 4 algorithms 10Jobs file 20 samples
        excute10jobsAlgorithms();

        // //Executing 4 algorithms 15Jobs file 20 samples
        excute15jobsAlgorithms();

    } // end of main

    /**
     * The method reads 5 jobs files #1 though #20
     * Record each Average Turnover Time on the CSV files
     * Calculate Average time of ATT
     * @Param void
     * @Return void
     */
    public static void excute5jobsAlgorithms() 
    {
        final int NUM_OF_FILES = 20;
        final int  NUM_OF_JOBS = 5;
        ArrayList<Double> attListFCFS = new ArrayList<Double>();
        ArrayList<Double> attListSJF = new ArrayList<Double>();
        ArrayList<Double> attListRR2 = new ArrayList<Double>();
        ArrayList<Double> attListRR5 = new ArrayList<Double>();

        //The inner loop iterates the example number 1 though the 20
        System.out.println("\n\n~~~" + NUM_OF_JOBS +"Jobs ~~~");
        for(int in_wk = 1; in_wk <= NUM_OF_FILES; in_wk++){
            String fileName = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2024/Winer/CS4310/ProgramingProject/DataFiles/JobFiles/";
            fileName = fileName + NUM_OF_JOBS +"Jobs/" + NUM_OF_JOBS +"Jobs_No" + in_wk + ".txt";

            System.out.println("\n\n\n\n~~~~~~~~~ File "+ in_wk+  "~~~~~~~~~\n");

            //FCFS algorithm Average Turnover Time
            System.out.println("\n - - - FCFS - - - - ");
            double attFCFS = FCFS.makeTableWithATT(fileName);
            attListFCFS.add(attFCFS);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attFCFS);

            //SJF algorithm Average Turnover Time
            System.out.println("\n\n - - - SJF - - - - ");
            double attSJF = SJF.makeTableWithATT(fileName);
            attListSJF.add(attSJF);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attSJF);

            //RR2 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR2 - - - - ");
            double attRR2 = RR2.makeTableWithATT(fileName);
            attListRR2.add(attRR2);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR2);

            //RR5 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR5 - - - - ");
            double attRR5 = RR5.makeTableWithATT(fileName);
            attListRR5.add(attRR5);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR5);

        }// enf of  loop
    } // end of excute5jobsAlgorithms


    /**
     * The method reads 10 jobs files #1 though #20
     * Record each Average Turnover Time on the CSV files
     * Calculate Average time of ATT
     * @Param void
     * @Return void
     */
    public static void excute10jobsAlgorithms() throws IOException
    {
        final int NUM_OF_FILES = 20;
        final int  NUM_OF_JOBS = 10;
        ArrayList<Double> attListFCFS = new ArrayList<Double>();
        ArrayList<Double> attListSJF = new ArrayList<Double>();
        ArrayList<Double> attListRR2 = new ArrayList<Double>();
        ArrayList<Double> attListRR5 = new ArrayList<Double>();

        //The inner loop iterates the example number 1 though the 20
        System.out.println("\n\n~~~" + NUM_OF_JOBS +"Jobs ~~~");
        for(int in_wk = 1; in_wk <= NUM_OF_FILES; in_wk++){
            String fileName = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2024/Winer/CS4310/ProgramingProject/DataFiles/JobFiles/";
            fileName = fileName + NUM_OF_JOBS +"Jobs/" + NUM_OF_JOBS +"Jobs_No" + in_wk + ".txt";

            System.out.println("\n\n\n\n~~~~~~~~~ File "+ in_wk+  "~~~~~~~~~\n");

            //FCFS algorithm Average Turnover Time
            System.out.println("\n - - - FCFS - - - - ");
            double attFCFS = FCFS.makeTableWithATT(fileName);
            attListFCFS.add(attFCFS);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attFCFS);

            //SJF algorithm Average Turnover Time
            System.out.println("\n\n - - - SJF - - - - ");
            double attSJF = SJF.makeTableWithATT(fileName);
            attListSJF.add(attSJF);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attSJF);

            //RR2 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR2 - - - - ");
            double attRR2 = RR2.makeTableWithATT(fileName);
            attListRR2.add(attRR2);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR2);

            //RR5 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR5 - - - - ");
            double attRR5 = RR5.makeTableWithATT(fileName);
            attListRR5.add(attRR5);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR5);

        }// enf of inner loop
    } // end of write10JobsAlgorithms

    /**
     * The method reads 15 jobs files #1 though #20
     * Record each Average Turnover Time on the CSV files
     * Calculate Average time of ATT
     * @Param void
     * @Return void
     */
    public static void excute15jobsAlgorithms() throws IOException
    {
        final int NUM_OF_FILES = 20;
        final int  NUM_OF_JOBS = 15;
        ArrayList<Double> attListFCFS = new ArrayList<Double>();
        ArrayList<Double> attListSJF = new ArrayList<Double>();
        ArrayList<Double> attListRR2 = new ArrayList<Double>();
        ArrayList<Double> attListRR5 = new ArrayList<Double>();

        //The inner loop iterates the example number 1 though the 20
        System.out.println("\n\n~~~" + NUM_OF_JOBS +"Jobs ~~~");
        for(int in_wk = 1; in_wk <= NUM_OF_FILES; in_wk++){
            String fileName = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2024/Winer/CS4310/ProgramingProject/DataFiles/JobFiles/";
            fileName = fileName + NUM_OF_JOBS +"Jobs/" + NUM_OF_JOBS +"Jobs_No" + in_wk + ".txt";

            System.out.println("\n\n\n\n~~~~~~~~~ File "+ in_wk+  "~~~~~~~~~\n");

            //FCFS algorithm Average Turnover Time
            System.out.println("\n - - - FCFS - - - - ");
            double attFCFS = FCFS.makeTableWithATT(fileName);
            attListFCFS.add(attFCFS);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attFCFS);

            //SJF algorithm Average Turnover Time
            System.out.println("\n\n - - - SJF - - - - ");
            double attSJF = SJF.makeTableWithATT(fileName);
            attListSJF.add(attSJF);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attSJF);

            //RR2 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR2 - - - - ");
            double attRR2 = RR2.makeTableWithATT(fileName);
            attListRR2.add(attRR2);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR2);

            //RR5 algorithm Average Turnover Time
            System.out.println("\n\n - - - RR5 - - - - ");
            double attRR5 = RR5.makeTableWithATT(fileName);
            attListRR5.add(attRR5);
            System.out.printf("\nAverage Turnover Time: %.4f %n",  attRR5);

        }// enf of loop

    } // end of write15JobsAlgorithms


} // end of Main



/*Sample Run */
/*


~~~15Jobs ~~~




~~~~~~~~~ File 1~~~~~~~~~


 - - - FCFS - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     16                   Job 1completed @ 16
2             16                    45                   Job 2completed @ 45
3             45                    54                   Job 3completed @ 54
4             54                    69                   Job 4completed @ 69
5             69                    82                   Job 5completed @ 82
6             82                    90                   Job 6completed @ 90
7             90                    103                  Job 7completed @ 103
8             103                   104                  Job 8completed @ 104
9             104                   107                  Job 9completed @ 107
10            107                   108                  Job 10completed @ 108
11            108                   120                  Job 11completed @ 120
12            120                   124                  Job 12completed @ 124
13            124                   133                  Job 13completed @ 133
14            133                   134                  Job 14completed @ 134
15            134                   156                  Job 15completed @ 156

Average Turnover Time: 96.3333


 - - - SJF - - - -
Job ID     Start Time     End Time       Job Completion
8             0                     1                    Job 8completed @ 1
10            1                     2                    Job 10completed @ 2
14            2                     3                    Job 14completed @ 3
9             3                     6                    Job 9completed @ 6
12            6                     10                   Job 12completed @ 10
6             10                    18                   Job 6completed @ 18
3             18                    27                   Job 3completed @ 27
13            27                    36                   Job 13completed @ 36
11            36                    48                   Job 11completed @ 48
5             48                    61                   Job 5completed @ 61
7             61                    74                   Job 7completed @ 74
4             74                    89                   Job 4completed @ 89
1             89                    105                  Job 1completed @ 105
15            105                   127                  Job 15completed @ 127
2             127                   156                  Job 2completed @ 156

Average Turnover Time: 50.8667


 - - - RR2 - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     2
2             2                     4
3             4                     6
4             6                     8
5             8                     10
6             10                    12
7             12                    14
8             14                    15                   Job 8completed @ 15
9             15                    17
10            17                    18                   Job 10completed @ 18
11            18                    20
12            20                    22
13            22                    24
14            24                    25                   Job 14completed @ 25
15            25                    27
1             27                    29
2             29                    31
3             31                    33
4             33                    35
5             35                    37
6             37                    39
7             39                    41
9             41                    42                   Job 9completed @ 42
11            42                    44
12            44                    46                   Job 12completed @ 46
13            46                    48
15            48                    50
1             50                    52
2             52                    54
3             54                    56
4             56                    58
5             58                    60
6             60                    62
7             62                    64
11            64                    66
13            66                    68
15            68                    70
1             70                    72
2             72                    74
3             74                    76
4             76                    78
5             78                    80
6             80                    82                   Job 6completed @ 82
7             82                    84
11            84                    86
13            86                    88
15            88                    90
1             90                    92
2             92                    94
3             94                    95                   Job 3completed @ 95
4             95                    97
5             97                    99
7             99                    101
11            101                   103
13            103                   104                  Job 13completed @ 104
15            104                   106
1             106                   108
2             108                   110
4             110                   112
5             112                   114
7             114                   116
11            116                   118                  Job 11completed @ 118
15            118                   120
1             120                   122
2             122                   124
4             124                   126
5             126                   127                  Job 5completed @ 127
7             127                   128                  Job 7completed @ 128
15            128                   130
1             130                   132                  Job 1completed @ 132
2             132                   134
4             134                   135                  Job 4completed @ 135
15            135                   137
2             137                   139
15            139                   141
2             141                   143
15            143                   145
2             145                   147
15            147                   149                  Job 15completed @ 149
2             149                   151
2             151                   153
2             153                   155
2             155                   156                  Job 2completed @ 156

Average Turnover Time: 91.4667


 - - - RR5 - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     5
2             5                     10
3             10                    15
4             15                    20
5             20                    25
6             25                    30
7             30                    35
8             35                    36                   Job 8completed @ 36
9             36                    39                   Job 9completed @ 39
10            39                    40                   Job 10completed @ 40
11            40                    45
12            45                    49                   Job 12completed @ 49
13            49                    54
14            54                    55                   Job 14completed @ 55
15            55                    60
1             60                    65
2             65                    70
3             70                    74                   Job 3completed @ 74
4             74                    79
5             79                    84
6             84                    87                   Job 6completed @ 87
7             87                    92
11            92                    97
13            97                    101                  Job 13completed @ 101
15            101                   106
1             106                   111
2             111                   116
4             116                   121                  Job 4completed @ 121
5             121                   124                  Job 5completed @ 124
7             124                   127                  Job 7completed @ 127
11            127                   129                  Job 11completed @ 129
15            129                   134
1             134                   135                  Job 1completed @ 135
2             135                   140
15            140                   145
2             145                   150
15            150                   152                  Job 15completed @ 152
2             152                   156                  Job 2completed @ 156

Average Turnover Time: 95.0000




~~~~~~~~~ File 2~~~~~~~~~


 - - - FCFS - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     14                   Job 1completed @ 14
2             14                    15                   Job 2completed @ 15
3             15                    22                   Job 3completed @ 22
4             22                    24                   Job 4completed @ 24
5             24                    44                   Job 5completed @ 44
6             44                    49                   Job 6completed @ 49
7             49                    71                   Job 7completed @ 71
8             71                    73                   Job 8completed @ 73
9             73                    96                   Job 9completed @ 96
10            96                    102                  Job 10completed @ 102
11            102                   132                  Job 11completed @ 132
12            132                   135                  Job 12completed @ 135
13            135                   141                  Job 13completed @ 141
14            141                   165                  Job 14completed @ 165
15            165                   183                  Job 15completed @ 183

Average Turnover Time: 84.4000


 - - - SJF - - - -
Job ID     Start Time     End Time       Job Completion
2             0                     1                    Job 2completed @ 1
4             1                     3                    Job 4completed @ 3
8             3                     5                    Job 8completed @ 5
12            5                     8                    Job 12completed @ 8
6             8                     13                   Job 6completed @ 13
10            13                    19                   Job 10completed @ 19
13            19                    25                   Job 13completed @ 25
3             25                    32                   Job 3completed @ 32
1             32                    46                   Job 1completed @ 46
15            46                    64                   Job 15completed @ 64
5             64                    84                   Job 5completed @ 84
7             84                    106                  Job 7completed @ 106
9             106                   129                  Job 9completed @ 129
14            129                   153                  Job 14completed @ 153
11            153                   183                  Job 11completed @ 183

Average Turnover Time: 58.0667


 - - - RR2 - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     2
2             2                     3                    Job 2completed @ 3
3             3                     5
4             5                     7                    Job 4completed @ 7
5             7                     9
6             9                     11
7             11                    13
8             13                    15                   Job 8completed @ 15
9             15                    17
10            17                    19
11            19                    21
12            21                    23
13            23                    25
14            25                    27
15            27                    29
1             29                    31
3             31                    33
5             33                    35
6             35                    37
7             37                    39
9             39                    41
10            41                    43
11            43                    45
12            45                    46                   Job 12completed @ 46
13            46                    48
14            48                    50
15            50                    52
1             52                    54
3             54                    56
5             56                    58
6             58                    59                   Job 6completed @ 59
7             59                    61
9             61                    63
10            63                    65                   Job 10completed @ 65
11            65                    67
13            67                    69                   Job 13completed @ 69
14            69                    71
15            71                    73
1             73                    75
3             75                    76                   Job 3completed @ 76
5             76                    78
7             78                    80
9             80                    82
11            82                    84
14            84                    86
15            86                    88
1             88                    90
5             90                    92
7             92                    94
9             94                    96
11            96                    98
14            98                    100
15            100                   102
1             102                   104
5             104                   106
7             106                   108
9             108                   110
11            110                   112
14            112                   114
15            114                   116
1             116                   118                  Job 1completed @ 118
5             118                   120
7             120                   122
9             122                   124
11            124                   126
14            126                   128
15            128                   130
5             130                   132
7             132                   134
9             134                   136
11            136                   138
14            138                   140
15            140                   142
5             142                   144
7             144                   146
9             146                   148
11            148                   150
14            150                   152
15            152                   154                  Job 15completed @ 154
5             154                   156                  Job 5completed @ 156
7             156                   158
9             158                   160
11            160                   162
14            162                   164
7             164                   166                  Job 7completed @ 166
9             166                   168
11            168                   170
14            170                   172
9             172                   173                  Job 9completed @ 173
11            173                   175
14            175                   177                  Job 14completed @ 177
11            177                   179
11            179                   181
11            181                   183                  Job 11completed @ 183

Average Turnover Time: 97.8000


 - - - RR5 - - - -
Job ID     Start Time     End Time       Job Completion
1             0                     5
2             5                     6                    Job 2completed @ 6
3             6                     11
4             11                    13                   Job 4completed @ 13
5             13                    18
6             18                    23                   Job 6completed @ 23
7             23                    28
8             28                    30                   Job 8completed @ 30
9             30                    35
10            35                    40
11            40                    45
12            45                    48                   Job 12completed @ 48
13            48                    53
14            53                    58
15            58                    63
1             63                    68
3             68                    70                   Job 3completed @ 70
5             70                    75
7             75                    80
9             80                    85
10            85                    86                   Job 10completed @ 86
11            86                    91
13            91                    92                   Job 13completed @ 92
14            92                    97
15            97                    102
1             102                   106                  Job 1completed @ 106
5             106                   111
7             111                   116
9             116                   121
11            121                   126
14            126                   131
15            131                   136
5             136                   141                  Job 5completed @ 141
7             141                   146
9             146                   151
11            151                   156
14            156                   161
15            161                   164                  Job 15completed @ 164
7             164                   166                  Job 7completed @ 166
9             166                   169                  Job 9completed @ 169
11            169                   174
14            174                   178                  Job 14completed @ 178
11            178                   183                  Job 11completed @ 183

Average Turnover Time: 98.3333


 */