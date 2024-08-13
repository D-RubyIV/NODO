package org.example.part5.fileio.by_byte;

import org.example.part5.fileio.StaticFile;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByByte {
    public static void main(String[] args) {
        String content = "Phạm Hà Anh.";

        try (FileOutputStream fos = new FileOutputStream(StaticFile.pathFile)) {
            // Convert the string content to bytes
            byte[] contentBytes = content.getBytes();

            // Write the bytes to the file
            fos.write(contentBytes);

            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
