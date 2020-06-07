package apresentacao;

import negocio.Contato;
import persintencia.ContatoDAO;
import persintencia.IContatoDAO;

import java.io.FileNotFoundException;

public class AppCliente {
    public static void main(String[] args) throws FileNotFoundException {
        Contato c = new Contato(1, "João","da Silva","joao@email.com","(21) 98765-4321","Família");
        Contato d = new Contato(2, "Laryssa","Oliveira","lary@email.com","(21) 98765-4321","Família");
        Contato e = new Contato(3, "Marcondes","Ferreira","teste@email.com","(21) 98765-4321","Família");
        Contato f = new Contato(4, "Otavio","Ferreira","teste@email.com","(21) 98765-4321","Família");

        IContatoDAO dao = new ContatoDAO();
        //dao.salvar(c);
        //dao.salvar(d);
        //dao.salvar(e);


        //e.nome = "Felipe";
        //d.nome = "Aldo";
        //dao.atualizar(d);

        //dao.getById(3);

        dao.getAll();

        //dao.deletar(2);

        //dao.salvar(f);

    }
}
