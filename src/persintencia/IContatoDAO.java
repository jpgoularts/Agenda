package persintencia;

import negocio.Contato;

import java.io.FileNotFoundException;

public interface IContatoDAO {
    public void salvar(Contato c);
    public void atualizar(Contato c) throws FileNotFoundException;
}
