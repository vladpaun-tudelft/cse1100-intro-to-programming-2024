import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.function.*;

public final class Functions {

    public static IntSupplier randomNumberSupplier() {
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return (int) (Math.random() * 10);
            }
        };
    }

    public static Consumer<String> stringWriter(final Writer writer) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                try {
                    writer.write(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static BiFunction<String, Integer, String> stringRepeater() {
        return new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < integer; i++) {
                    sb.append(s);
                }
                return sb.toString();
            }
        };
    }

    public static BiPredicate<Double, Double> isPassing() {
        return new BiPredicate<Double, Double>() {
            @Override
            public boolean test(Double aDouble, Double aDouble2) {
                return (aDouble >= 5 && aDouble2 >= 5 && (aDouble + aDouble2) / 2 >=5.8);
            }
        };
    }

}
