package Core.Utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static ArrayList<String> readDir(String dirPath) throws IOException {
        ArrayList<String> filesContent = new ArrayList<>();
        List<Path> paths;

        try(Stream<Path> stream = Files.walk(Paths.get(dirPath))) {
            paths = stream.filter(Files::isRegularFile)
                    // .map(Path::toFile)
                    .collect(Collectors.toList());
        }

        for (Path p : paths) {
            filesContent.add(new String(Files.readAllBytes(p), Charset.defaultCharset()));
        }
        return filesContent;
    }

    private static String readFile(File file) throws IOException {

        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }
}
