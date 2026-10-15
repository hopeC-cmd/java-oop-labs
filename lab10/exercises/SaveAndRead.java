import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveAndRead {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }

        Path path = Path.of("notes.txt");

        try {
            Files.write(path, lines);                       // save all lines
            System.out.println("Saved to " + path.toAbsolutePath());

            List<String> back = Files.readAllLines(path);          // read all lines back
            System.out.println("--- read back ---");
            for (String line : back) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }

        in.close();
    }
}