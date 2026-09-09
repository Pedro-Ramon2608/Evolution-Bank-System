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
                "\n-------------------------------" +
                "\nSaldo: " + this.getSaldoConta() +
                "\nLimite: " + this.getLimite() +
                "\n-------------------------------\n";
    }

    public void sacar(String senha, double valor) {
        if (this.getSenha().equals(senha)) {

            if (valor > this.getSaldoConta()) {

                if (valor > this.getLimite()) {
                    System.out.println("Saldo e Limite insuficiente.");

                } else {
                    this.setLimite(this.getLimite() - valor);

                    System.out.println("Saque realizado com sucesso, usando o limite da conta." +
                            "\nLimite restante: " + this.getLimite());

                    boolean limiteAtualizado = Arquivo.atualizarLimite(this.getCpf(), this.getLimite());

                    if (limiteAtualizado) {
                        System.out.println("Limite atualizado com sucesso.");
                    } else {
                        System.out.println("Erro ao gravar a alteração no arquivo.txt");
                    }
                }

            } else {
                this.setSaldoConta(this.getSaldoConta() - valor);

                System.out.println("Saque realizado com sucesso." +
                        "\nSaldo atual: " + this.getSaldoConta());

                boolean saldoAtualizado = Arquivo.atualizarSaldo(this.getCpf(), this.getSaldoConta());

                if (saldoAtualizado) {
                    System.out.println("Saldo atualizado com sucesso.");
                } else {
                    System.out.println("Erro ao gravar a alteração no arquivo.txt");
                }
            }

        } else {
            System.out.println("Senha inválida");
        }
    }
}
