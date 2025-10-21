import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PhonePlanCollection {
    private List<PhonePlan> phonePlans;

    /**
     * Cinstructor eith list
     * @param phonePlans bc i can
     */
    public PhonePlanCollection(List<PhonePlan> phonePlans) {
        this.phonePlans = phonePlans;
    }

    /**
     * Instantiates a new PhonePlanCollection object
     */
    public PhonePlanCollection() {
        this.phonePlans = new ArrayList<>();
    }

    /**
     * Gets the list of phoneplans
     * @return rhe list of phoneplans
     */
    public List<PhonePlan> getPhonePlans() {
        return phonePlans;
    }

    /**
     * ToString methd for sucha a collectio n
     * @return tehs tring of such an objecyt
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                "There are " + phonePlans.size() + " phone plans in the collection:\n"
        );

        for (PhonePlan p : phonePlans) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    /**
     * Method to read a phone plan collection from 2 files
     * @param subscriptionFilePath the filepath 1
     * @param prepaidFilePath second filepath
     * @return the phoneplancollection object
     */
    public static PhonePlanCollection read(String subscriptionFilePath, String prepaidFilePath) {
        PhonePlanCollection phonePlanCollection = new PhonePlanCollection();
        try {
            Scanner subscriptionScanner = new Scanner(new File(subscriptionFilePath));
            Scanner prepaidScanner = new Scanner(new File(prepaidFilePath));

            while (subscriptionScanner.hasNextLine()) {
                phonePlanCollection.addPhonePlan(SubscriptionPlan.read(
                        subscriptionScanner.nextLine()
                ));
            }

            while (prepaidScanner.hasNextLine()) {
                phonePlanCollection.addPhonePlan(PrePaidPlan.read(
                        prepaidScanner.nextLine()
                ));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return phonePlanCollection;
    }

    /**
     * Adds a new phoneplan to the collection
     * @param p phoneplan to be added
     */
    public void addPhonePlan(PhonePlan p) {
        phonePlans.add(p);
    }

    /**
     * Equals meythod for objects from this class
     * @param o other objet to be compared with
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhonePlanCollection that = (PhonePlanCollection) o;
        return Objects.equals(phonePlans, that.phonePlans);
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode for such object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(phonePlans);
    }
}
