package negocio;

public class Contato {
    public Integer id;
    public String nome;
    public String sobrenome;
    public String email;
    public String celular;
    public String tipo;

    public Contato(int id, String nome, String sobrenome, String email, String celular, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.celular = celular;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id+",\""+nome+"\""+",\""+sobrenome+"\""+",\""+email+"\""+",\""+celular+"\""+",\""+tipo+"\"";
    }
}
