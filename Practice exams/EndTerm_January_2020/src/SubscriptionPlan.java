
import java.util.OptionalInt;
import java.util.Scanner;

public class SubscriptionPlan extends PhonePlan{

    /**
     * Instantiates a new object subscription plan
     * @param provider rthe name of the provider
     * @param name the name pf the plan
     * @param details phone plan details
     * @param studentOnly if plan is only for students
     * @param discount discount for students
     */
    public SubscriptionPlan(String provider, String name,
                            PhonePlanDetails details, boolean studentOnly, OptionalInt discount) {
        super(provider, name, details, studentOnly, discount);
    }


    /**
     * tostriubg of this
     * @return the string bla bla
     */
    @Override
    public String toString() {
        return "\tSubscription " + super.toString();
    }

    /**
     * Reads a new subscriptionplan from a string
     * @param subscritpionString the string
     * @return the subscription
     */
    public static PhonePlan read(String subscritpionString) {
        Scanner scanner = new Scanner(subscritpionString);
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

        boolean studentOnly = false;
        OptionalInt discount = OptionalInt.empty();

        if (scanner.hasNext()) {
            studentOnly = true;
            scanner.next();
            discount = OptionalInt.of(Integer.parseInt(
                    scanner.next().split("%")[0]
            ));
        }

        return new SubscriptionPlan(provider, name, details, studentOnly, discount);
    }

    /**
     * souvgawoeufbqb
     * @param o the object to be compared.
     * @return weufhwf
     */
    @Override
    public int compareTo(PhonePlan o) {
        return Double.compare(this.getDetails().price(), o.getDetails().price());
    }

    /**
     * foahgwrihjg
     * @return wroaughir
     */
    @Override
    public String toFile() {
        String s = super.toFile();

        if (super.isStudentOnly()) {
            s += ", Student, " + super.getDiscount().getAsInt() + "%";
        }
        return s;
    }
}
