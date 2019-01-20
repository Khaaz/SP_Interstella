package Core.utility;

import Constants.PATH;

import java.io.File;
import java.io.IOException;
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
    /**
     * Read all files in a directory
     * Sends back an array with the files content
     * @param dirPath directory path
     * @return ArrayList of files content
     * @throws IOException error when reading directory
     */
    public static ArrayList<String> readDir(String dirPath) throws IOException {
        ArrayList<String> filesContent = new ArrayList<>();
        List<Path> paths;

        try(Stream<Path> stream = Files.walk(Paths.get(PATH.SCENARIOS))) {
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
