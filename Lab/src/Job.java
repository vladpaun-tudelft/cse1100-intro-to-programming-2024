import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * The type Job.
 */
public class Job {

    /**
     * Read job.
     *
     * @param jobScanner the job scanner
     * @return the job
     */
    public static Job readJob(Scanner jobScanner) {
        return new Job(
            Address.readAddress(jobScanner.nextLine()),
            jobScanner.nextLine(),
            Equipment.readEquipmentList(jobScanner.nextLine()),
            Date.readDate(jobScanner.nextLine())
        );
    }

    /**
     * Gets user job.
     *
     * @param userInput the user input
     * @return the user job
     */
    public static Job getUserJob(Scanner userInput) {
        return new Job(
                Address.getUserAddress(userInput),
                getUserDescription(userInput),
                Equipment.getUserEquipmentList(userInput),
                Date.getUserDate(userInput)
        );
    }

    /**
     * Gets user description.
     *
     * @param userInput the user input
     * @return the user description
     */
    static String getUserDescription(Scanner userInput) {
        System.out.print("Job description: ");
        return userInput.next();
    }

    /**
     * Write job.
     *
     * @param job    the job
     * @param writer the writer
     */
    public static void writeJob(Job job, PrintWriter writer) {
        writer.println(job.getLocation().toString());
        writer.println(job.getDescription());
        Equipment.writeEquipmentList(job.getRequiredEquipment(), writer);
        writer.println(job.getPlannedDate().toString());
    }

    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private Date plannedDate;

    private static int jobTotal = 0;

    /**
     * Instantiates a new Job.
     *
     * @param location          the location
     * @param description       the description
     * @param requiredEquipment the required equipment
     * @param plannedDate       the planned date
     */
    public Job(Address location, String description,
               List<Equipment> requiredEquipment, Date plannedDate) {
        this.jobNumber = ++jobTotal;
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;

    }

    /**
     * Edit job.
     *
     * @param userInput the user input
     * @param job       the job
     */
    public static void editJob(Scanner userInput, Job job) {
        int choice;
        do {
            printEditMenu();
            choice = userInput.nextInt();
        } while (choice < 1 || choice > 4);
        executeEditOption(choice, job, userInput);
    }

    private static void executeEditOption(int choice, Job job, Scanner userInput) {
        switch (choice) {
            case 1:
                System.out.println("To be implemented.");
                break;
            case 2:
                System.out.println("To be implemented.");
                break;
            case 3:
                System.out.println("To be implemented.");
                break;
            case 4:
                System.out.println("Current planned date: " + job.getPlannedDate());
                System.out.println("Enter a new date.");
                job.setPlannedDate(Date.getUserDate(userInput));
                break;
        }
    }

    /**
     * Print edit menu.
     */
    public static void printEditMenu() {
        System.out.println("What field would you like to edit?");
        System.out.println("  1 - Job location.");
        System.out.println("  2 - Job Description.");
        System.out.println("  3 - Job Equipment.");
        System.out.println("  4 - Job Date.");
    }


    /**
     * Gets job number.
     *
     * @return the job number
     */
    public int getJobNumber() { return jobNumber; }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Address getLocation() { return location; }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Gets required equipment.
     *
     * @return the required equipment
     */
    public List<Equipment> getRequiredEquipment() { return requiredEquipment; }

    /**
     * Gets planned date.
     *
     * @return the planned date
     */
    public Date getPlannedDate() { return plannedDate; }

    /**
     * Gets job total.
     *
     * @return the job total
     */
    public static int getJobTotal() { return jobTotal; }

    /**
     * Sets job number.
     *
     * @param jobNumber the job number
     */
    public void setJobNumber(int jobNumber) { this.jobNumber = jobNumber; }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Address location) { this.location = location; }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Sets required equipment.
     *
     * @param requiredEquipment the required equipment
     */
    public void setRequiredEquipment(List<Equipment> requiredEquipment) {
        this.requiredEquipment = requiredEquipment; }

    /**
     * Sets planned date.
     *
     * @param plannedDate the planned date
     */
    public void setPlannedDate(Date plannedDate) { this.plannedDate = plannedDate; }

    /**
     * To string method of Job
     * @return a string of Job, listing everything nicely
     */
    @Override
    public String toString() {
        String s = "Job " + jobNumber + ": " + description
                    + "\n\tAddress: " + location
                    + "\n\tDate: " + plannedDate;
        if (requiredEquipment.isEmpty()) {
            s+= "\n\tNo equipment required.\n";
        }
        else {
            s += "\n\tRequired Equipment:\n";
            for(int i = 0; i < requiredEquipment.size(); i++) {
                s += "\t\t" + (i + 1) + ". " + requiredEquipment.get(i).toString() + "\n";
            }
        }

        return s;
    }

    /**
     * Equals method for job
     * @param o Job Object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(location, job.location) &&
                Objects.equals(description, job.description) &&
                Objects.equals(requiredEquipment, job.requiredEquipment) &&
                Objects.equals(plannedDate, job.plannedDate);
    }

    /**
     * Hash code for job
     * @return hash code of job
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobNumber, location, description, requiredEquipment, plannedDate);
    }
}
