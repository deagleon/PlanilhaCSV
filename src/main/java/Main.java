import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        ArquivoCSV teste = new ArquivoCSV();
        LeitorCSV testeLeitor = new LeitorCSV(teste.getCaminhoArquivo());
        boolean stop = false;
        int counter = 0;
        while(!stop){
            Map<String, String> nextLine = testeLeitor.proximaLinha();
            if (nextLine == null){
                stop = true;
                break;
            }
            System.out.println(nextLine);
            counter++;

        }
        System.out.println(counter);



    }
}