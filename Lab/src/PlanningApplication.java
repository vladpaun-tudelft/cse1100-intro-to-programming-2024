import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * The type Planning application.
 */
public class PlanningApplication {
    private static Scanner userInput;
    private static final JobCatalog jobs = new JobCatalog();

    /**
     * Application to handle construction jobs.
     * Reads the jobs from a file when app is started,
     * The user can choose an option from a menu:
     * 1. Display all jobs;
     * 2. Add a new job;
     * 3. Delete existing job;
     * 4. Change date of existing job;
     * 5. ...;
     * 6. ...;
     * 7. Close application;
     * Writes the jobs to a file when app is closed.
     *
     * @param args no CLI arguments expected
     */
    public static void main(String[] args) {

        userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");

        try {
            readJobsFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int option;
        do {
            showMenu();
            option = userInput.nextInt();
            executeOption(option);
        } while (option != 7);

        userInput.close();

        try {
            writeJobsFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readJobsFile() throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("resources/joblist.txt"));
        while (fileInput.hasNextLine()) {
            jobs.add(Job.readJob(fileInput));
        }
        fileInput.close();
    }

    private static void writeJobsFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("resources/joblist.txt");

        for (Job job : jobs.getJobs()) {
            Job.writeJob(job, writer);
        }

        writer.close();
    }

    private static void executeOption(int option) {
        switch (option) {
            case 1 -> {
                jobs.sortByDate();
                System.out.println(jobs);
            }
            case 2 -> {
                jobs.add(Job.getUserJob(userInput));
                System.out.println("Job added.\n");
            }
            case 3 -> {
                Job job = jobs.selectUserJob(userInput);
                System.out.println("Are you sure you want to delete:" +
                        "\nJob " +
                        job.getJobNumber() + ": " + job.getDescription() +
                        "\n(y/n)?");
                if (userInput.next().equalsIgnoreCase("y")) {
                    jobs.deleteJob(job);
                    System.out.println("Job deleted.");
                } else {
                    System.out.println("Delete aborted.");
                }
            }
            case 4 -> {
                Job.editJob(userInput, jobs.selectUserJob(userInput));
                System.out.println("Job edited.\n");
            }
            case 5 -> {
                JobCatalog filteredJobs = getJobsByUserDate();
                for (int i = 0; i < filteredJobs.getJobs().size(); i++) {
                    System.out.println((i + 1) + ". " + filteredJobs.getJobs().get(i).toString());
                }
            }
            case 6 -> {
                List<Equipment> equipmentList = getEquipmentListByJobCatalog(getJobsByUserDate());

                System.out.println("\nRequired equipment on selected date:");
                for (Equipment equipment : equipmentList) {
                    System.out.println("\t" + equipment.toString());
                }
                System.out.println();
            }

        }
    }

    private static List<Equipment> getEquipmentListByJobCatalog(JobCatalog filteredJobs) {
        return filteredJobs.getJobs().stream()
                .flatMap(job2 ->
                        job2.getRequiredEquipment()
                                .stream()
                                .distinct()
                )
                .sorted()
                .toList();
    }

    /**
     * Gets jobs by user date.
     *
     * @return the jobs by user date
     */
    public static JobCatalog getJobsByUserDate() {
        System.out.println("Enter a date:");
        Date date = Date.getUserDate(userInput);
        JobCatalog filteredJobs = jobs.filterByDate(date);
        System.out.println("\nWe have " + filteredJobs.getJobs().size() +
                " job(s) planned on " + date + ".");
        return filteredJobs;
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        System.out.println("  1 - Show all jobs in the catalog.");
        System.out.println("  2 - Add a new job.");
        System.out.println("  3 - Delete existing job.");
        System.out.println("  4 - Edit a job.");
        System.out.println("  5 - Print jobs by date.");
        System.out.println("  6 - Print required materials by date.");
        System.out.println("  7 - Quit application.");
    }
}
