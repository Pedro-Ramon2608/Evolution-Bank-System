public class Corrente extends Conta {
    private double limite = 0;

    public Corrente(String nome, String cpf, String cidade, String email, String senha) {
        super(nome, cpf, cidade, email, senha);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
