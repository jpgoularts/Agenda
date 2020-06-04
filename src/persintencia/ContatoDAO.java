package persintencia;

import negocio.Contato;

import java.io.*;
import java.util.Arrays;

public class ContatoDAO implements IContatoDAO {

    @Override
    public void salvar(Contato c) {
        File arquivo = new File("C:/Users/joaop/OneDrive/Área de Trabalho/Java/Agenda/dados.txt");
        try {
            if(!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(c.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception error) {

        }
    }

    @Override
    public void atualizar(Contato c) throws FileNotFoundException {
        File arquivo = new File("C:/Users/joaop/OneDrive/Área de Trabalho/Java/Agenda/dados.txt");
        File arquivoTemp = new File("C:/Users/joaop/OneDrive/Área de Trabalho/Java/Agenda/dados-temp.txt");

        String linha;
        String[] newlinha;

        String alvo = c.toString();
        String[] alvoFormated = alvo.split(",");

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemp, true));

            while((linha = br.readLine()) != null) {
                newlinha = linha.split(",");

                if(newlinha[0].equals(alvoFormated[0])) {

                    if( !(newlinha[1].equals(alvoFormated[1])) ) {

                        

                    }


                    //linha = linha.replace(alvo, "Teste");
                }

                bw.write(linha+"\n");
            }

            bw.close();
            br.close();

            new File(String.valueOf(arquivo)).delete();
            new File(String.valueOf(arquivoTemp)).renameTo(new File(String.valueOf(arquivo)));


        } catch(Exception error) {

        }



    }
}
