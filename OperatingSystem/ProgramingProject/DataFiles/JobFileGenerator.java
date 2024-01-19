import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.File;

public class JobFileGenerator {


    public static void main(String[] args) {
        String basePath = "/Users/keita-katsumi/Library/CloudStorage/Dropbox/Academic/CalPolyPomona/2024/Winer/CS4310/ProgramingProject/DataFiles/JobFiles"; 
        File directory = new File(basePath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        int[] jobCounts = {5, 10, 15};
        int filesPerJobCount = 20;

        for (int jobCount : jobCounts) {
            for (int i = 0; i < filesPerJobCount; i++) {
                String fileName =  jobCount + "Jobs_" + "No"+(i + 1) + ".txt";
                generateJobFile(fileName, jobCount);
            }
        }
    } // end of mail

    public static void generateJobFile(String fileName, int numberOfJobs) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 1; i <= numberOfJobs; i++) {
                int jobLength = 1 + random.nextInt(30); // Random number between 1 and 30
                writer.write("Job" + i + "\n" + jobLength + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}// end of JobFileGenerator
