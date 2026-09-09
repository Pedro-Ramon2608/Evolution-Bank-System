import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

public class Arquivo {
    public static Corrente criarConta(String caminhoArquivo, String nome, String cpf, String cidade, String email, String senha) {
        try (FileWriter arquivo = new FileWriter(caminhoArquivo, true)) {
            double saldoConta = 0;
            double limite = 200;

            arquivo.write(nome + ";" +
                    cpf + ";" +
                    cidade + ";" +
                    email + ";" +
                    senha + ";" +
                    saldoConta + ";" +
                    limite + "\n"
            );

            return new Corrente(nome, cpf, cidade, email, senha, saldoConta, limite);

        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo para criar a conta.");
        }
        return null;
    } // Fim do criarConta


    public static Corrente loginConta(String caminhoArquivo, String email, String senha) {

        try (BufferedReader arquivo = new BufferedReader(new FileReader(caminhoArquivo))){

            String linha;

            while ((linha = arquivo.readLine()) != null) {
                // [nome, cpf, cidade, email, senha, saldoConta, limite]
                //   0     1      2      3       4        5         6
                String[] dados =  linha.split(";");

                String emailDados = dados[3];
                String senhaDados = dados[4];

                if (email.equals(emailDados) && senha.equals(senhaDados)) {
                    String nome = dados[0];
                    String cpf = dados[1];
                    String cidade = dados[2];
                    double saldoConta = Double.parseDouble(dados[5]);
                    double limite = Double.parseDouble(dados[6]);

                    System.out.println("Login realizado com sucesso!");

                    return new Corrente(nome, cpf, cidade, emailDados, senhaDados, saldoConta, limite);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");

        } catch (IOException e) {
            System.out.println("Erro ao carregar a conta.");
        }

        return null;
    } // Fim do entrarConta


    public static boolean atualizarSaldo(String cpf, double novoSaldo) {
        boolean saldoAtualizado = false;

        File arquivoOriginal = new File("C:/Users/ADMIN/OneDrive/Documentos/Meus_Projetos/SistemaBancarioEvolucao/Evolution-Bank-System/contas.txt");
        File arquivoTemporario = new File("C:/Users/ADMIN/OneDrive/Documentos/Meus_Projetos/SistemaBancarioEvolucao/Evolution-Bank-System/contas_temporarias.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                // [nome, cpf, cidade, email, senha, saldoConta, limite]
                //   0     1      2      3       4        5         6
                String[] dados =  linha.split(";");

                // Pegar o CPF cadastrado para comparar com o enviado da conta do Usuário
                String cpfDados = dados[1];

                if (cpfDados.equals(cpf)) {
                    // Atualizar apenas a posição do saldo e já formatar para duas casas decimais
                    dados[5] = String.format(Locale.US, "%.2f", novoSaldo);

                    // Refazer a linha
                    linha = String.join(";", dados);
                    saldoAtualizado = true;
                }

                // Escrever as linhas no arquivo temporário e já com o saldo atualizado da linha específica
                // alterada, de acordo com o cpf da conta do cliente
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException erro) {
            erro.printStackTrace();
            return false;
        }

        // Verifica se o saldo foi atualizado para realizar a substituição do arquivoOriginal pelo Temporario
        if (saldoAtualizado) {
            try {

                /*
                 * O primeiro arquivo de parâmetro é o arquivo original que eu quero usar para mover para
                 * outro lugar, o segundo parâmetro é o meu destino de arquivo
                 * então:
                 * arquivo que eu quero mover -> local de destino
                 *
                 * O .toPath() transforma o File em um objeto Path
                 *
                 * O terceiro parâmetro já serve para dizer:
                 * Se já existir um arquivo, substitua ele.
                 * com isso, evita que o java dispare uma exceção falando que você está
                 * tentando substituir um arquivo que já existe
                 *
                 * Ao final de tudo, ele apaga o arquivo temporário sozinho
                 */
                Files.move(arquivoTemporario.toPath(),
                        arquivoOriginal.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException erro) {
                erro.printStackTrace();
            }

        } else {
            // Se a conta não tiver atualização do saldo, ele deleta o arquivo temporario
            arquivoTemporario.delete();
        }

        return saldoAtualizado;
    } // Fim do atualizarSaldo


    public static boolean atualizarLimite(String cpf, double novoLimite) {
        boolean limiteAtualizado = false;

        File arquivoOriginal = new File("C:/Users/ADMIN/OneDrive/Documentos/Meus_Projetos/SistemaBancarioEvolucao/Evolution-Bank-System/contas.txt");
        File arquivoTemporario = new File("C:/Users/ADMIN/OneDrive/Documentos/Meus_Projetos/SistemaBancarioEvolucao/Evolution-Bank-System/contas_temporarias.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                // [nome, cpf, cidade, email, senha, saldoConta, limite]
                //   0     1      2      3       4        5         6
                String[] dados =  linha.split(";");

                // Pegar o CPF cadastrado para comparar com o enviado da conta do Usuário
                String cpfDados = dados[1];

                if (cpfDados.equals(cpf)) {
                    // Atualizar apenas a posição do saldo e já formatar para duas casas decimais
                    dados[5] = String.format(Locale.US, "%.2f", novoLimite);

                    // Refazer a linha
                    linha = String.join(";", dados);
                    limiteAtualizado = true;
                }

                // Escrever as linhas no arquivo temporário e já com o saldo atualizado da linha específica
                // alterada, de acordo com o cpf da conta do cliente
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException erro) {
            erro.printStackTrace();
            return false;
        }

        // Verifica se o saldo foi atualizado para realizar a substituição do arquivoOriginal pelo Temporario
        if (limiteAtualizado) {
            try {

                /*
                 * O primeiro arquivo de parâmetro é o arquivo original que eu quero usar para mover para
                 * outro lugar, o segundo parâmetro é o meu destino de arquivo
                 * então:
                 * arquivo que eu quero mover -> local de destino
                 *
                 * O .toPath() transforma o File em um objeto Path
                 *
                 * O terceiro parâmetro já serve para dizer:
                 * Se já existir um arquivo, substitua ele.
                 * com isso, evita que o java dispare uma exceção falando que você está
                 * tentando substituir um arquivo que já existe
                 *
                 * Ao final de tudo, ele apaga o arquivo temporário sozinho
                 */
                Files.move(arquivoTemporario.toPath(),
                        arquivoOriginal.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException erro) {
                erro.printStackTrace();
            }

        } else {
            // Se a conta não tiver atualização do saldo, ele deleta o arquivo temporario
            arquivoTemporario.delete();
        }

        return limiteAtualizado;
    } // Fim do atualizarLimite
}
