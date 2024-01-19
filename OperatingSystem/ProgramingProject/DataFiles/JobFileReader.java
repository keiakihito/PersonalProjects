import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JobFileReader {

    private static ArrayList<ArrayList<Integer>> readJobFile(String fileName) {
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
                int intChar = firstCha - '0';
                jobEntry.add(intChar);
                counter++;
                jobData.add(jobEntry);

            } // end of while
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobData;
    }

    public static void main(String[] args) {
        
        final int NUM_OF_FILES = 20;
        int[] numOfJobs = new int[] {5, 10, 15};

        //The outer loop iterates the number of job groups, 5, 10, and 15.
        //The inner loop iterates the example number 1 though the 20
        for(int out_wk = 0; out_wk < numOfJobs.length ; out_wk++){
            System.out.println("\n\n~~~" + numOfJobs[out_wk] +"Jobs ~~~");
            for(int in_wk = 1; in_wk <= NUM_OF_FILES; in_wk++){
                String fileName = "/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2024/Winer/CS4310/ProgramingProject/DataFiles/JobFiles/"; 
                fileName = fileName + numOfJobs[out_wk] +"Jobs/" + numOfJobs[out_wk] +"Jobs_No" + in_wk + ".txt";
                ArrayList<ArrayList<Integer>> jobList = readJobFile(fileName);
                System.out.println("\n\nJobs_No"+ in_wk);
                System.out.printf("%-10s %-10s %n", "Job ID", "Job Time");
                for (ArrayList<Integer> job : jobList) {
                    System.out.printf("%-13d %-10d %n", job.get(0), job.get(1));
                }

            }// enf of inner loop
        } // end of outer loop

    } // end of main

} // end of JobFileReader