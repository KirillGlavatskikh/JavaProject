package com.company.WorkFile;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("D:/Java Project/src/com/company/WorkFile/NewFile.txt");
        creatNewFile(file);

        try (InputStream inputStream = new FileInputStream("D:/Java Project/src/com/company/WorkFile/exampleFile.txt");
        OutputStream outputStream = new FileOutputStream("D:/Java Project/src/com/company/WorkFile/NewFile.txt")){
            byte [] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            System.out.println(new String(buffer));
            outputStream.write(buffer);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private static void creatNewFile(File file) {
        try{
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
