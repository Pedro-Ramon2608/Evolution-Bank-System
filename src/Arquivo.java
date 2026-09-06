import java.io.*;

public class Arquivo {
    public static Corrente criarConta(String caminhoArquivo, String nome, String cpf, String cidade, String email, String senha) {
        try (FileWriter arquivo = new FileWriter(caminhoArquivo, true)) {

            arquivo.write(nome + "," +
                    cpf + "," +
                    cidade + "," +
                    email + "," +
                    senha + "\n"
            );

            return new Corrente(nome, cpf, cidade, email, senha);

        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo para criar a conta.");
        }
        return null;
    } // Fim do criarConta

    public static Corrente loginConta(String caminhoArquivo, String email, String senha) {

        try (BufferedReader arquivo = new BufferedReader(new FileReader(caminhoArquivo))){

            String linha;

            while ((linha = arquivo.readLine()) != null) {
                // [nome, cpf, cidade, email, senha]
                //   0     1      2      3       4
                String[] dados =  linha.split(",");

                String emailDados = dados[3];
                String senhaDados = dados[4];

                if (email.equals(emailDados) && senha.equals(senhaDados)) {
                    String nome = dados[0];
                    String cpf = dados[1];
                    String cidade = dados[2];

                    System.out.println("Login realizado com sucesso!");

                    return new Corrente(nome, cpf, cidade, emailDados, senhaDados);
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
