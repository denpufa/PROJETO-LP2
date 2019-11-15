import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {

    public String binaryFileReader(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String text = "";

        int input;

        while((input = reader.read()) != -1) {
            text += (char) input;
        }
        return text ;
    }

    public static void escritor(String path, String text) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
           buffWrite.append(text + "\n");
        buffWrite.close();
    }

}
