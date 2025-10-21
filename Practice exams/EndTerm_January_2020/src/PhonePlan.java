import java.util.Objects;
import java.util.OptionalInt;

public abstract class PhonePlan implements Comparable<PhonePlan> {
    private String provider;
    private String name;
    private PhonePlanDetails details;
    private boolean studentOnly;
    private OptionalInt discount;

    /**
     * Instantiates a new phoneplan object
     * @param provider rthe name of the provider
     * @param name the name pf the plan
     * @param details phone plan details
     * @param studentOnly if plan is only for students
     * @param discount discount for students
     */
    public PhonePlan(String provider, String name, PhonePlanDetails details,
                     boolean studentOnly, OptionalInt discount) {
        this.provider = provider;
        this.name = name;
        this.details = details;
        this.studentOnly = studentOnly;
        this.discount = discount;
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
        PhonePlan phonePlan = (PhonePlan) o;
        return studentOnly == phonePlan.studentOnly &&
                Objects.equals(provider, phonePlan.provider) &&
                Objects.equals(name, phonePlan.name) &&
                Objects.equals(details, phonePlan.details) &&
                Objects.equals(discount, phonePlan.discount);
    }

    /**
     * Method to see if it is a student only plan
     * @return true if it is
     */
    public boolean isStudentOnly() {
        return studentOnly;
    }

    /**
     * gets the phone plan details
     * @return the phone plan details
     */
    public PhonePlanDetails getDetails() {
        return details;
    }

    /**
     * tostriubg of this
     * @return the string bla bla
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("plan");
        if (this.studentOnly) sb.append(" for students");
        sb.append(": ").append(provider);
        sb.append(" ").append(name);
        sb.append(", costs ");
        double finalPrice = !this.studentOnly? this.details.price()
                : this.details.price() * (100.0-this.discount.getAsInt()) / 100.0;
        sb.append(finalPrice).append(" euro\n");
        sb.append("\t\tincludes ");
        sb.append(
                details.callMins()==Integer.MAX_VALUE?
                        "unlimited" :
                        details.callMins()
        ).append(" calling minutes, ");
        sb.append(
                details.texts()==Integer.MAX_VALUE?
                        "unlimited" :
                        details.texts()
        ).append(" texts and ");
        sb.append(
                details.data()==Integer.MAX_VALUE?
                        "unlimited" :
                        details.data() + "GB of"
        ).append(" data.\n");

        return sb.toString();
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode for such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(provider, name, details, studentOnly, discount);
    }

    /**
     * oudhoa
     * @return argr
     */
    public OptionalInt getDiscount() {
        return discount;
    }

    /**
     * Method to give the file rep
     * @return b;a sdubvo
     */
    public String toFile() {
        String s = String.join(", "
                ,provider, name,
                (details.price() + " euro"),
                (details.callMins()!=Integer.MAX_VALUE?
                        String.valueOf(details.callMins()): "unlimited"),
                (details.texts()!=Integer.MAX_VALUE?String.valueOf(details.texts()): "unlimited"),
                (details.data()!=Integer.MAX_VALUE?String.valueOf(details.data()): "unlimited")
        );
        return s;
    }
}
