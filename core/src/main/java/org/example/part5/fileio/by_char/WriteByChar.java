package org.example.part5.fileio.by_char;
import org.example.part5.fileio.StaticFile;

import java.io.FileWriter;
import java.io.IOException;


public class WriteByChar {
    public static void main(String[] args) {
        String content = "Phạm Hoài Nam";

        try (FileWriter writer = new FileWriter(StaticFile.pathFile)) {
            writer.write(content);

            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
