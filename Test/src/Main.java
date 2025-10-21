import java.util.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <Disk> List<String> getMovieTitlesByGenre(List<Disk> disks, String genre) {
        return disks.stream()
                .filter(x -> (boolean) x in DVD)
                .filter(dvd -> dvd.getGenre().equals(genre))
                .map(Disk::getTitle)
                .toList();
    }

}