import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArquivoCSV {
    private JFileChooser seletor;
    private File arquivo;
    private String caminhoArquivo;

    public JFileChooser getSeletor() {
        return seletor;
    }

    public File getArquivo() {
        return arquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public ArquivoCSV() {
        this.seletor = new JFileChooser();
        this.seletor.setCurrentDirectory(new File(System.getProperty("user.dir")));
        this.seletor.setFileFilter(new FileNameExtensionFilter("Selecione apenas arquivos CSV", "csv"));
        int retorno = this.seletor.showOpenDialog(null);
        if(retorno != JFileChooser.APPROVE_OPTION || !this.seletor.getSelectedFile().getName().contains("csv")) {
            System.out.println("O arquivo é inválido ou não foi carregado corretamente");
        }
        try{
            this.arquivo = this.seletor.getSelectedFile();
            this.caminhoArquivo = this.arquivo.getPath();
            FileReader fileReader = new FileReader(this.arquivo.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
