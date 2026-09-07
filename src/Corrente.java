public class Corrente extends Conta {
    private double limite;

    public Corrente(String nome, String cpf, String cidade, String email, String senha, double saldoConta, double limite) {
        super(nome, cpf, cidade, email, senha, saldoConta);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String status() {
        return "\n---> Status <---" +
                "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() +
                "\nCidade: " + this.getCidade() +
                "\nEmail: " + this.getEmail() +
                "-------------------------------" +
                "\nSaldo: " + this.getSaldoConta() +
                "\nLimite: " + this.getLimite() +
                "-------------------------------\n";
    }

    public void sacar(String senha, double valor) {
        if (this.getSenha().equals(senha)) {

            if (valor > this.getSaldoConta()) {

                if (valor > this.getLimite()) {
                    System.out.println("Saldo insuficiente.");

                } else {
                    System.out.println("Saque realizado com sucesso, usando o limite da conta." +
                            "\nLimite restante: " + this.getLimite());
                }

            } else {
                this.setSaldoConta(this.getSaldoConta() - valor);
                System.out.println("Saque realizado com sucesso." +
                        "\nSaldo atual: " + this.getSaldoConta());
            }

        } else {
            System.out.println("Senha inválida");
        }
    }
}
