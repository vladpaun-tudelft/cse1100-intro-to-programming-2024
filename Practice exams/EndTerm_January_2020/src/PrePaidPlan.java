import java.util.Objects;
import java.util.OptionalInt;
import java.util.Scanner;

public class PrePaidPlan extends PhonePlan{
    private PrePaidDetails prePaidDetails;

    /**
     * Instantiates a new object [prepaid]n plan
     * @param provider rthe name of the provider
     * @param name the name pf the plan
     * @param details phone plan details
     * @param studentOnly if plan is only for students
     * @param discount discount for students
     * @param prePaidDetails details of the prepaid
     */
    public PrePaidPlan(String provider, String name, PhonePlanDetails details,
                       boolean studentOnly, OptionalInt discount,
                       PrePaidDetails prePaidDetails) {
        super(provider, name, details, studentOnly, discount);
        this.prePaidDetails = prePaidDetails;
    }

    /**
     * reads a new prepaid from a string
     * @param s the string
     * @return the prepaid
     */
    public static PhonePlan read(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter(", ");
        String provider = scanner.next();
        String name = scanner.next();

        int price = Integer.parseInt(scanner.next().split(" ")[0]);
        int callMins = 0, texts = 0, data = 0;

        if (scanner.hasNextInt()) {
            callMins = scanner.nextInt();
        } else  {
            callMins = Integer.MAX_VALUE;
            scanner.next();
        }
        if (scanner.hasNextInt()) {
            texts = scanner.nextInt();
        } else {
            texts = Integer.MAX_VALUE;
            scanner.next();
        }
        if (scanner.hasNextInt()) {
            data = scanner.nextInt();
        } else {
            data = Integer.MAX_VALUE;
            scanner.next();
        }
        PhonePlanDetails details = new PhonePlanDetails(price, callMins, texts, data);

        boolean minutesTransfer = scanner.nextBoolean();
        boolean textsTransfer = scanner.nextBoolean();
        boolean dataTransfer = scanner.nextBoolean();

        PrePaidDetails prepaidDetails = new PrePaidDetails(
                minutesTransfer, textsTransfer, dataTransfer
        );

        boolean studentOnly = false;
        OptionalInt discount = OptionalInt.empty();

        if (scanner.hasNext()) {
            studentOnly = true;
            scanner.next();
            discount = OptionalInt.of(Integer.parseInt(
                    scanner.next().split("%")[0]
            ));
        }

        return new PrePaidPlan(provider, name, details, studentOnly, discount, prepaidDetails);
    }

    /**
     * tostriubg of this
     * @return the string bla bla
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\tPrepaid " + super.toString());

        sb.append("\t\tcalling minutes carry over: ");
        sb.append(prePaidDetails.minutesTransfer()?"yes.\n":"no.\n");
        sb.append("\t\ttexts carry over: ");
        sb.append(prePaidDetails.textsTransfer()?"yes.\n":"no.\n");
        sb.append("\t\tinternet data carry over: ");
        sb.append(prePaidDetails.dataTransfer()?"yes.\n":"no.\n");


        return sb.toString();
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
        if (!super.equals(o)) return false;
        PrePaidPlan that = (PrePaidPlan) o;
        return Objects.equals(prePaidDetails, that.prePaidDetails);
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode for such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prePaidDetails);
    }

    /**
     * sfgwa
     * @param o the object to be compared.
     * @return wragwg
     */
    @Override
    public int compareTo(PhonePlan o) {
        return Double.compare(this.getDetails().price(), o.getDetails().price());
    }

    /**
     * safawf
     * @return rwagae
     */
    @Override
    public String toFile() {
        String s = String.join(", ",
                super.toFile(),
                String.valueOf(prePaidDetails.minutesTransfer()),
                String.valueOf(prePaidDetails.textsTransfer()),
                String.valueOf(prePaidDetails.dataTransfer())

        );

        if (super.isStudentOnly()) {
            s += ", Student, " + super.getDiscount().getAsInt() + "%";
        }
        return s;
    }
}
