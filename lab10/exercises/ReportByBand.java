import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {

    // parse one CSV line into a Learner
    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2]));
    }
}

public class ReportByBand {

    // my grade bands: change the cut-offs if your lecturer gave a scale
    static String band(double gpa) {
        if (gpa >= 3.5) {
            return "A";
        } else if (gpa >= 3.0) {
            return "B";
        }
        return "C";
    }

    public static void main(String[] args) {
        Path input = Path.of("learners.csv");

        try {
            List<Learner> learners = Files.readAllLines(input).stream()
                .filter(line -> !line.isBlank())
                .map(Learner::fromCsv)
                .collect(Collectors.toList());

            // group: band letter -> list of learners (TreeMap keeps A, B, C in order)
            Map<String, List<Learner>> byBand = learners.stream()
                .collect(Collectors.groupingBy(l -> band(l.gpa()), TreeMap::new, Collectors.toList()));

            for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
                List<String> lines = new ArrayList<>();
                lines.add("Band " + entry.getKey() + " report (" + entry.getValue().size() + " learners)");
                for (Learner l : entry.getValue()) {
                    lines.add(l.name() + ", roll " + l.roll() + ", GPA " + l.gpa());
                }

                Path out = Path.of("report-" + entry.getKey() + ".txt");
                Files.write(out, lines);
                System.out.println("Wrote " + out + ": " + entry.getValue().size() + " learners");
            }

        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }
}
