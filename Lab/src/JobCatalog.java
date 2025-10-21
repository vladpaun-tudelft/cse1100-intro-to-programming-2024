import java.util.*;

/**
 * The type Job catalog.
 */
public class JobCatalog {


    private List<Job> jobs;

    /**
     * Instantiates a new Job catalog.
     */
    public JobCatalog() {
        jobs = new ArrayList<>();
    }

    /**
     * Instantiates a new Job catalog.
     *
     * @param list the list
     */
    public JobCatalog(List<Job> list) {
        jobs = list;
    }


    /**
     * Gets jobs.
     *
     * @return the jobs
     */
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * Gets job by number.
     *
     * @param jobNumber the job number
     * @return the job by number
     */
    public Job getJobByNumber(int jobNumber) {
        for (Job job : jobs) {
            if (job.getJobNumber() == jobNumber) {
                return job;
            }
        }
        return null;
    }

    /**
     * Select user job job.
     *
     * @param userInput the user input
     * @return the job
     */
    public Job selectUserJob(Scanner userInput) {

        Job job;
        do {
            this.printSelectMenu();
            job = this.getJobByNumber(userInput.nextInt());
            if (job == null) {
                System.out.println("Invalid job number.");
            }
        } while (job == null);
        return job;
    }

    private  void printSelectMenu() {
        System.out.println("Select a job:");
        for (Job job : this.getJobs()) {
            System.out.println("\t" + job.getJobNumber() + ". "+ job.getDescription());
        }

    }

    /**
     * Delete job.
     *
     * @param job the job
     */
    public void deleteJob(Job job) {
        jobs.remove(job);
//        for (Job job2 : jobs) {
//            if (job2.getJobNumber() > job.getJobNumber()) {
//                job2.setJobNumber(job2.getJobNumber() - 1);
//                Job.decrementJobTotal();
//            }
//        }
    }

    /**
     * Add.
     *
     * @param job the job
     */
    public void add(Job job) {
        jobs.add(job);
    }

    /**
     * String representation of jobCatalog in a nice format
     * @return string of jobCatalog
     */
    public String toString() {
        StringBuilder s = new StringBuilder("We have " + jobs.size() + " job(s) in the catalog.\n");
        for (int i = 0; i < jobs.size(); i++) {
            s.append((i + 1)).append(". ").append(jobs.get(i).toString()).append("\n");
        }
        return s.toString();
    }

    /**
     * Equals method of JobCatalog
     * @param o JobCatalog Object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobCatalog that = (JobCatalog) o;
        return Objects.equals(jobs, that.jobs);
    }

    /**
     * hashcode method of JobCatalog
     * @return hashcode of JobCatalog
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(jobs);
    }

    /**
     * Filter by date job catalog.
     *
     * @param date the date
     * @return the job catalog
     */
    public JobCatalog filterByDate(Date date) {
        return new JobCatalog(
                this.jobs.stream()
                        .filter(job2 -> job2.getPlannedDate().equals(date))
                        .toList());
    }

    /**
     * Sorts the jobs list by the date
     */
    public void sortByDate() {
        jobs.sort(Comparator.comparing(Job::getPlannedDate));
    }

}
