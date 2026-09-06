public class Conta extends Usuario {
    private double saldoConta;
    private String email;
    private String senha;

    public Conta(String nome, String cpf, String cidade, String email, String senha) {
        super(nome, cpf, cidade);
        this.email = email;
        this.senha = senha;
        this.saldoConta = 0;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getBanco() {
        final String banco = "Banco RHV";
        return banco;
    }

    public int getAgencia() {
        final int agencia = 122;
        return agencia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void depositar(String senha, double valor) {
        if (this.getSenha().equals(senha)) {
            if (valor >= 0.01) {
                this.saldoConta = this.getSaldoConta() + valor;

            } else {
                System.out.println("Valor inálido. Digite um valor positivo");
            }

        } else {
            System.out.println("Senha inválida.");
        }
    }
}
