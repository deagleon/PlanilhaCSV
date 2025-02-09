import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        LeitorArquivoCSV leitorArquivoCSV = new LeitorArquivoCSV();
        File arquivo = leitorArquivoCSV.lerPlanilha();
        LeitorCSV plBling = new LeitorCSV(arquivo.getPath());
        arquivo = leitorArquivoCSV.lerPlanilha();
        LeitorCSV plCplug = new LeitorCSV(arquivo.getPath());
        boolean stop = false;
        //TODO Verificar uma maneira de preencher os dados necessarios na Planilha CPLUG
        while(!stop){
            Map<String, String> valorBling = plBling.proximaLinha();
            Map<String, String> valorCplug = plCplug.proximaLinha();
            if(valorBling == null){
                System.out.println("A planilha chegou ao fim!");
                //stop = true;
                break;
            }
            System.out.println("Valor Bling: " + valorBling);
            System.out.println("Valor CPLUG: " + valorCplug.keySet());
        }

    }
    }

