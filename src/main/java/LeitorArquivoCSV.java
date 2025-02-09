import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class LeitorArquivoCSV {
    JFileChooser seletor;

    public LeitorArquivoCSV() {
        this.seletor = new JFileChooser();
        this.seletor.setCurrentDirectory(new File(System.getProperty("user.dir")));
        this.seletor.setFileFilter(new FileNameExtensionFilter("Selecione apenas arquivos CSV", "csv"));
    }

    public File lerPlanilha(){
        int retorno = this.seletor.showOpenDialog(null);
        if(retorno != JFileChooser.APPROVE_OPTION || !this.seletor.getSelectedFile().getName().contains("csv")){
            System.out.println("O arquivo é inválido ou não foi carregado corretamente");
            System.exit(1);
        }
        return this.seletor.getSelectedFile();
    }
}
