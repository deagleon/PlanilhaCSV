import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV {
    public static void main(String[] args) throws IOException, CsvValidationException {
        String file_path = "planilha_clientes_Cplug.csv";
        LeitorCSV csv = new LeitorCSV(file_path);
        boolean stop = false;
        while(!stop){
            Map<String, String> valor = csv.proximaLinha();
            if(valor == null){
                System.out.println("A planilha chegou ao fim!");
                //stop = true;
                break;
            }
            System.out.println(valor);
        }
        }
    }

