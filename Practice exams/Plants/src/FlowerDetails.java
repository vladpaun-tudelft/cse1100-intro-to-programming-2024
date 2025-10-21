import java.util.Optional;
import java.util.OptionalInt;

public record FlowerDetails(boolean hasFlowers,
                            Optional<String> color,
                            Optional<String> size,
                            OptionalInt petals) {
}
