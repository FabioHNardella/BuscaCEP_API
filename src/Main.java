import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int busca = 0;
        int contador = 0;
        do {
            contador++;

            System.out.print("Digite o CEP que deseja pesquisar EX:(01001000): ");
            try{
                String pesquisaCep = sc.next();
                while(pesquisaCep.length() > 8){
                    System.out.println("CEP inválido pois há mais do que 8 números, tente novamente EX:(01001000): ");
                    pesquisaCep = sc.next();
                }
                Busca b = new Busca();
                RecordCep recCep = b.buscarCep(pesquisaCep);
                Cep cep = new Cep(recCep);
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                        .create();

                System.out.println(cep);

                FileWriter fl = new FileWriter("cep_" + contador + ".json");
                fl.write(gson.toJson(cep));
                fl.close();

                System.out.println("CEP encontrado! Foi criado um arquivo JSON para guardá-lo!");
            } catch(IllegalStateException e){
                System.out.print("Opa! Você digitou algo além de números! Tente novamente: ");
                String pesquisaCep = sc.next();
                pesquisaCep = pesquisaCep.replace("-", "");
                while(pesquisaCep.length() > 8){
                    System.out.println("CEP inválido pois há mais do que 8 números, tente novamente: ");
                    pesquisaCep = sc.next();
            }
        }
    }while (busca != -1);
    }

}
