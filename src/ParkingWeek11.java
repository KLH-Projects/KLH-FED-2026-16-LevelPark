import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Week 11: save and load only synthetic classroom allocation records. */
public class ParkingWeek11 {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("simulator-state.csv");
        List<String> records = List.of(
                "token,cell",
                "ORBIT-07,A-02",
                "NOVA-12,A-03");
        Files.write(file, records, StandardCharsets.UTF_8);
        List<String> loaded = Files.readAllLines(file, StandardCharsets.UTF_8);

        System.out.println("Saved 2 fictional allocations to simulator-state.csv");
        System.out.println("Loaded allocations: " + (loaded.size() - 1));
        System.out.println("First record: " + loaded.get(1));
    }
}
