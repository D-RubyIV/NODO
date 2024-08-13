package org.example.part5.fileio.by_byte;


import org.example.part5.fileio.StaticFile;

import java.io.FileInputStream;
import java.io.IOException;

class ReadByByte {
    public static void main(String args[]) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(StaticFile.pathFile);
            System.out.println("FileContents :");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            for (byte b : bytes)
                System.out.print((char) b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null)
                    fin.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}