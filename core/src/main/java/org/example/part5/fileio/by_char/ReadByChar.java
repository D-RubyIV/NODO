package org.example.part5.fileio.by_char;


import org.example.part5.fileio.StaticFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class ReadByChar {
    public static void main(String args[]) {

        FileInputStream fin = null;
        try {
            fin = new FileInputStream(StaticFile.pathFile);
            BufferedInputStream bis = new BufferedInputStream(fin);
            System.out.println("FileContents :");
            byte[] bytes = new byte[5];
            int bytesReaded = bis.read(bytes);
            while (bytesReaded != -1) {
                for (int i = 0; i < bytesReaded; i++) {
                    System.out.print((char) bytes[i]);
                }
                bytesReaded = bis.read(bytes);
            }

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