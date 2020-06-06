package persintencia;

import negocio.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements IContatoDAO {

    static String url = "C:/Users/joaop/OneDrive/Área de Trabalho/Java/Agenda2/dados.txt";
    static String urltemp = "C:/Users/joaop/OneDrive/Área de Trabalho/Java/Agenda2/dados-temp.txt";

    @Override
    public void salvar(Contato c) {
        File arquivo = new File(url);
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
        File arquivo = new File(url);
        File arquivoTemp = new File(urltemp);

        String linha;
        String[] newlinha;

        String alvo = c.toString();
        String[] alvoFormated = alvo.split(",");

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemp));

            while((linha = br.readLine()) != null) {
                newlinha = linha.split(",");

                if(newlinha[0].equals(alvoFormated[0])) {
                    String dados = c.toString();
                    linha = dados;
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

    @Override
    public void deletar(int id) {
        File arquivo = new File(url);
        File arquivoTemp = new File(urltemp);

        String linha;
        String[] newlinha;

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemp, true));

            while((linha = br.readLine()) != null) {
                newlinha = linha.split(",");

                if(!(newlinha[0].equals(Integer.toString(id)))) {
                    bw.write(linha+"\n");
                }
            }

            bw.close();
            br.close();

            new File(String.valueOf(arquivo)).delete();
            new File(String.valueOf(arquivoTemp)).renameTo(new File(String.valueOf(arquivo)));


        } catch(Exception error) {

        }
    }

    @Override
    public void getById(int id) {
        File arquivo = new File(url);
        File arquivoTemp = new File(urltemp);

        String linha;
        String[] newlinha;

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));


            while((linha = br.readLine()) != null) {
                newlinha = linha.split(",");

                if(newlinha[0].equals(Integer.toString(id))) {
                    System.out.println(" ----- O CONTATO PROCURADO É ------");
                    System.out.println(linha);
                }
            }

            br.close();


        } catch(Exception error) {

        }
    }

    @Override
    public List<Contato> getAll() {
        File arquivo = new File(url);
        String linha;

        ArrayList<String> agenda = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));


            while((linha = br.readLine()) != null) {
                agenda.add(linha);
            }

            br.close();

            int i;
            int n = agenda.size();

            System.out.println("-------  CONTATOS DA AGENDA  ------- \n");
            for (i=0; i<n; i++) {
                System.out.println(agenda.get(i));
            }
            System.out.println("\n -------  FIM DOS CONTATOS DA AGENDA  -------");

        } catch(Exception error) {
            System.out.println(error);
        }

        return null;
    }
}
