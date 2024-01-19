/**
 * Class name, RR2.java
 * Author Keita Katsumi
 * CS 4310 Winter  2024
 * Simulating Job Scheduler programming project
 *
 * Description:
 * 3. Round-Robin with Time slice = 2 (RR-2)
 * It completes given tasks rounding each task 2 clock times.
 * Keep working on each tasks until all the tasks are completed.
 * Calculate Average Time for 20 samples of 5, 10, and 15 Jobs files.
 *
 * Last modified Jan 4th, 2024
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RR2
{
    /**
     * The method simulates Round Robin Slice Time 2 (RR2) scheduling algorithm
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
        double att = calculateATT(jobRrcd, jobData.size());

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
        //Create empty 2D array to entry the JobID and JobTime 1d ArrayList.
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
        //Round Robin Time Slice set 2 clock cycles
        final int RR_SLICE_TIME = 2;
        int strtTime = 0;
        int endTime = 0;
        //Extract data from the job list text files
        ArrayList<ArrayList<Integer>> jobRcrd = new ArrayList<ArrayList<Integer>>();

        int counter = 1;
        while(!isCompleted(jobList)){
            ArrayList<Integer> jobRow = new ArrayList<Integer>();
            //Calculate current job ID index
            // ex 6th iteration (6 %  5) - 1 = 0, back to the first jobID
            int crrntJobIDIdx = (counter -1) % jobList.size();

            //When current job is completed, skip this row.
            if (jobList.get(crrntJobIDIdx).get(1) == 0){
                counter++;
                continue;
            }

            // Record jobID
            jobRow.add(jobList.get(crrntJobIDIdx).get(0));
            //Record Start Time
            jobRow.add(strtTime);

            int crrntJobTime = jobList.get(crrntJobIDIdx).get(1);
            if(crrntJobTime > RR_SLICE_TIME){
                endTime = strtTime + RR_SLICE_TIME;
                int remaingTime = crrntJobTime - RR_SLICE_TIME;
                jobList.get(crrntJobIDIdx).set(1, remaingTime);
            }else{ // Case of current job time < RR_SLICE_TIME
                endTime = strtTime + crrntJobTime;
                jobList.get(crrntJobIDIdx).set(1, 0); // Job is completed
            }

            //Record End Time
            jobRow.add(endTime);

            // When job is completed, record the job ID on the column 4
            if (jobList.get(crrntJobIDIdx).get(1) == 0) {
                //Record Completed JobID
                jobRow.add(jobList.get(crrntJobIDIdx).get(0));
            }else{
                //The job is not completed yet marked as 0
                jobRow.add(0);
            }

            //Update start for the next record
            strtTime = endTime;
            // Store the job information row to the table
            jobRcrd.add(jobRow);

            counter++;
        }

        return jobRcrd;
    }

    /**
     * The method checks 2D array list data frame whether all the jobs are completed or not.
     * It iterates the job data frame. When all the job time are 0, it returns true.
     * @Param ArrayList<ArrayList<Integer>> jobData,  job record which has a work log
     * @Return boolean
     */
    public static boolean isCompleted (ArrayList<ArrayList<Integer>>jobData)
    {
        for (ArrayList<Integer> jobRow: jobData){
            if (jobRow.get(1) != 0){
                return false;
            }
        } // end of for loop

      return true;
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
            boolean isCompleted = false;
            String label = "";

            // Check the job was done in this row
            if(job.get(3) != 0 ){
                isCompleted = true;
            }
            // When the job is done, it displays when the job was done.
            if(isCompleted){
                label = "Job " + job.get(3) + "completed @ " + job.get(2);
            }

            // Diplay Job ID, Start Time, End Time, Job Completeion
            System.out.printf("%-13d %-21d %-20d %-20s %n", job.get(0), job.get(1), job.get(2), label);
        } // end of for loop


    }

    /**
     * The method reads jobRcd and calculates the Average Turnover Time
     * @Param ArrayList<ArrayList<Integer>> jobRcrd,  job record which has a work log
     * @Param int numOfJobs, the number of jobs in the file to calculate ATT.
     * @Return double att, average turn over time.
     */
    public static double calculateATT(ArrayList<ArrayList<Integer>> jobRcrd, int numOfJobs)
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
        att = sum / numOfJobs;

        return att;
    }


}// end of RR2
