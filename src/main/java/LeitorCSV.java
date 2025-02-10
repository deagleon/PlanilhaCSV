import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LeitorCSV {
    private final String file_path;
    private final CSVReaderHeaderAware leitorCSV;
    private Map<String, String> valores;

    public LeitorCSV(String file_path) throws IOException {
        this.file_path = file_path;
        try{
            this.leitorCSV = new CSVReaderHeaderAware(new FileReader(this.file_path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Map<String, String> proximaLinha() throws CsvValidationException, IOException {
       this.valores = this.leitorCSV.readMap();
        return this.valores;
    }

    @Override
    public String toString() {
        return "LeitorCSV{" +
                "file_path='" + file_path + '\'' +
                ", leitorCSV=" + leitorCSV +
                ", valores=" + valores +
                '}';
    }

    public String getFile_path() {
        return file_path;
    }

    public CSVReaderHeaderAware getLeitorCSV() {
        return leitorCSV;
    }

    public Map<String, String> getValores() {
        return valores;
    }

}
