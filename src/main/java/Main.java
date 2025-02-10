import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        //1 - Abrir planilha BLING
        ArquivoCSV arqBling = new ArquivoCSV();
        LeitorCSV leitBling = new LeitorCSV(arqBling.getCaminhoArquivo());
        //2 - Pegar o cabeçalho Bling
        String[] blingCabecalho = leitBling.getCabecalho();
        System.out.println(Arrays.toString(blingCabecalho));
        //3 - Abrir planilha CPLUG
        ArquivoCSV arqCplug = new ArquivoCSV();
        LeitorCSV leitCplug = new LeitorCSV(arqCplug.getCaminhoArquivo());
        //4 - Pegar o cabeçalho CPLUG
        String[] cplugCabecalho = leitCplug.getCabecalho();
        System.out.println(Arrays.toString(cplugCabecalho));
        //5 - Definir as colunas equivalentes em cada planilha
        Map<String, String> colunasEquivalentes = new HashMap<>();
        colunasEquivalentes.put("Bairro", "Bairro");
        colunasEquivalentes.put("CEP", "CEP");
        colunasEquivalentes.put("Cidade", "Cidade");
        colunasEquivalentes.put("Celular", "Celular");
        colunasEquivalentes.put("CNPJ / CPF", "CNPJ"); // Priorizando CNPJ, CPF pode ser implícito ou tratado separadamente
        colunasEquivalentes.put("Complemento", "Complemento");
        colunasEquivalentes.put("Data nascimento", "Aniversário");
        colunasEquivalentes.put("E-mail", "Email");
        colunasEquivalentes.put("Fone", "Telefone");
        colunasEquivalentes.put("ID", "Identificador");
        colunasEquivalentes.put("Limite de crédito", "Crédito R$");
        colunasEquivalentes.put("Nome", "Nome do Contato");
        colunasEquivalentes.put("Número", "Número");
        colunasEquivalentes.put("Observações do contato", "Observações");
        colunasEquivalentes.put("Profissão", "Cargo");
        colunasEquivalentes.put("Razão Social", "Razão Social");
        colunasEquivalentes.put("Estado", "UF");
        colunasEquivalentes.put("IE / RG", "Inscrição Estadual"); // Priorizando Inscrição Estadual, RG pode ser implícito ou tratado separadamente

        //Preencher a planilha CPLUG com os dados do Bling
        Iterator<String[]> it = leitBling.getLeitorCSV().iterator();
        while(it.hasNext()){
            it.next();
            Map<String, String> cplug = HashMap.newHashMap(10);
            for (String coluna: blingCabecalho){
//                cplug.put(coluna, leitBling.proximaLinha());
                System.out.println(cplug.toString());
            }

        }

    }
}