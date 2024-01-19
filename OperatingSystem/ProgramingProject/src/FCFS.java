/**
 * Class name, FCFS.java
 * Author Keita Katsumi
 * CS 4310 Winter  2024
 * Simulating Job Scheduler programming project
 *
 * Description:
 * 1. First-Come-First-Serve(FCFS)
 *  It completes given tasks in the order of arrival time.
 * Calculate Average Time for 20 samples of 5, 10, and 15 Jobs files.
 *
 * Last modified Jan 4th, 2024
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FCFS
{
    /**
     * The method simulates Fist Come First Serve(FCFS) scheduling algorithm
     * It calculates the Average Turnover Time though the sample file
     * @Param String fileName,  file Path to extract text sample job files
     * @Return double attRslt, calculation result for Average Turnover Time
     */
    public static double makeTableWithATT(String fileName)
    {
        // Extract job data from the text files
        ArrayList<ArrayList<Integer>> jobData = readJobFile(fileName);
        // Create job record table with 2D ArrayList format
        ArrayList<ArrayList<Integer>> jobRrcd = createJobRecord(jobData);
        // Print the job record as a table format
        printJobRecord(jobRrcd);
        // Calculate Average Turnover Time
        double att = calculateATT(jobRrcd);

        return att;
    }

    /**
     * The method reads the text files and create 2D array
     * Corresponding column 1:JobID, column2: rmnOfTime
     * @Param String fileName,  file Path to extract text sample job files
     * @Return ArrayList<ArrayList<Integer>> jobList, simulate Table with 2 columns
     */
    public static ArrayList<ArrayList<Integer>> readJobFile(String fileName)
    {
        //Create empty 2D arrya to entry the JobID and JobTime 1d ArrayList.
        ArrayList<ArrayList<Integer>> jobData = new ArrayList<ArrayList<Integer>>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                String textLine = line; // Single line in the file
                Character firstCha = textLine.charAt(0); // Check the line is Job Time or not
                if(!Character.isDigit(firstCha)){
                    continue; // When the line is "Job1", it skips the line and read the next line.
                }
                //Create a single ArrayList and add it to the 2D ArryaList
                ArrayList<Integer> jobEntry = new ArrayList<>();
                jobEntry.add(counter);
                int intLine = Integer.parseInt(line);
                jobEntry.add(intLine);
                counter++;
                jobData.add(jobEntry);

            } // end of while
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobData;

    }

    /**
     * The method accepts 2D integer arraylist data Frame
     * It records the job process with another 2D array
     * Corresponding column 1:JobID, column 2: Start Time, column 3: End Time, column 4: complete job ID
     * @Param ArrayList<ArrayList<Integer>> jobList, simulate Table with 2 columns
     * @Return ArrayList<ArrayList<Integer>> jobRcrd,  job record which makes a work log until all the job is completed
     */
    public static ArrayList<ArrayList<Integer>> createJobRecord(ArrayList<ArrayList<Integer>> jobList)
    {

        int strtTime = 0;
        int endTime = 0;
        ArrayList<ArrayList<Integer>> jobRcrd = new ArrayList<ArrayList<Integer>>();

        for (int wk = 0; wk < jobList.size(); wk++) {

            ArrayList<Integer> jobRow = new ArrayList<Integer>();
            // Record jobID
            jobRow.add(jobList.get(wk).get(0));
            //Record Start Time
            jobRow.add(strtTime);
            //Calculate the end time as end time + job time
            endTime +=  jobList.get(wk).get(1);
            //Record End Time
            jobRow.add(endTime);
            //Record Completed JobID
            jobRow.add(jobList.get(wk).get(0));
            //Update start for the next record
            strtTime = endTime;
            // Store the job information row to the table
            jobRcrd.add(jobRow);

        } // end of for loop


      return jobRcrd;
    }

    /**
     * The method accepts 2D integer arraylist JobRcd
     * It prints the job process with another 2D array table format
     * Corresponding column 1:JobID, column 2: Start Time, column 3: End Time, column 4: complete Job ID
     * @Param ArrayList<ArrayList<Integer>> jobRcrd,  job record which has a work log
     * @Return void
     */
    public static void printJobRecord(ArrayList<ArrayList<Integer>> jobRcrd)
    {

        System.out.printf("%-10s %-14s %-14s %-10s%n", "Job ID", "Start Time", "End Time", "Job Completion");
        for (ArrayList<Integer> job : jobRcrd) {
            String label = "Job " + job.get(3) + "completed @ " + job.get(2);
            System.out.printf("%-13d %-21d %-20d %-20s %n", job.get(0), job.get(1), job.get(2), label);
        }

    }

    /**
     * The method reads jobRcd and calculates the Average Turnover Time
     * @Param ArrayList<ArrayList<Integer>> jobRcrd,  job record which has a work log
     * @Return double att, average turn over time.
     */
    public static double calculateATT(ArrayList<ArrayList<Integer>> jobRcrd)
    {

        double sum = 0.0;
        double att = 0.0;
        // The loop find when jobs were completed.
        // Sum total completed time to calculate Average Turnover Time
        for (ArrayList<Integer> job: jobRcrd){
            if (job.get(3) != 0){
                sum += job.get(2);
            }
        } // end of loop

        //Calculate Average Turnover Time
        att = sum / jobRcrd.size();

        return att;
    }


} // end of FCFS
