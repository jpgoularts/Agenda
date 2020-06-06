package persintencia;

import negocio.Contato;

import java.io.FileNotFoundException;
import java.util.List;

public interface IContatoDAO {
    public void salvar(Contato c);
    public void atualizar(Contato c) throws FileNotFoundException;
    public void deletar(int id);
    public void getById(int id);
    public List<Contato> getAll();
}
