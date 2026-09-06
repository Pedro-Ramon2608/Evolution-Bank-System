public abstract class Usuario {
    private String nome;
    private String cpf;
    private String cidade;

    public Usuario(String nome, String cpf, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
