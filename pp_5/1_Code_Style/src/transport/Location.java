package transport;

import java.util.Objects;
import transport.lines.*;

public class Location
{

    private final String name;

    /**
     * Creates a new location.
     *
     * @param name The name of the location
     */
    public Location (String name)
    {
        this.name = name;
    }

    /**
     * Gets the string representation of this location.
     *
     * @return The string representing this location
     */
    @Override public String toString ()
    {
        return name;
    }

    /**
     * Checks whether this location is equal to an object.
     *
     * @param other The object to check for equality
     * @return True iff other is a location with the same name
     */
    @Override public boolean equals (Object other)
    {
        return other != null && this.getClass() == other.getClass()
                && Objects.equals(((Location)other).name, name);
    }

}
