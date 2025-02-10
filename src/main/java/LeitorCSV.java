import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LeitorCSV {
    private final String file_path;
    private final CSVReader leitorCSV;
    private final String[] cabecalho;

    public LeitorCSV(String file_path) throws IOException {
        this.file_path = file_path;
        try{
            this.leitorCSV = new CSVReader(new FileReader(this.file_path));
            this.cabecalho = this.leitorCSV.readNext();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public String[] proximaLinha() throws CsvValidationException, IOException {
        return this.leitorCSV.readNext();
    }

    @Override
    public String toString() {
        return "LeitorCSV{" +
                "file_path='" + file_path + '\'' +
                ", leitorCSV=" + leitorCSV.toString() +
                '}';
    }

    public String getFile_path() {
        return file_path;
    }

    public CSVReader getLeitorCSV() {
        return leitorCSV;
    }

    public String[] getCabecalho() {
        return cabecalho;
    }

}
