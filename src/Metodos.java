import java.util.Scanner;

public class Metodos {
    public static void iniciar(String caminhoArquivo) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Digite a opção desejada: " +
                    "\n 1 - Login" +
                    "\n 2 - Criar conta" +
                    "\n 0 - Sair" +
                    "\nOpção: ");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    criar(sc, caminhoArquivo);
                    break;
                case 2:
                    logar(sc, caminhoArquivo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            }
        }
    } // Fim iniciar

    public static void criar(Scanner sc, String caminhoArquivo) {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = sc.next();

        System.out.print("Digite sua cidade: ");
        String cidade = sc.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = sc.next().trim();

        System.out.print("Digite seu senha: ");
        String senha = sc.next().trim();

        Corrente conta = Arquivo.criarConta(caminhoArquivo, nome, cpf, cidade, email, senha);
    }

    public static void  logar(Scanner sc, String caminhoArquivo) {

    }
} // Fim classe
