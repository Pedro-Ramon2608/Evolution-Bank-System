import java.io.*;

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
}
