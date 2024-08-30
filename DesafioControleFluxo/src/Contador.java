
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner terminal = new Scanner(System.in);
        try{
            System.out.println("Digite o primeiro numero...: ");
            int numero1 = Integer.parseInt(terminal.nextLine());
            System.out.println("Digite o segundo numero...: ");
            int numero2 = Integer.parseInt(terminal.nextLine());
            contar(numero1, numero2);
        }
        catch(NumeroMaiorQuePermitidoException e){
            System.out.println("Exceção capturada: " + e.getMessage());
        }
      }

    static void contar(int numero1, int numero2) throws NumeroMaiorQuePermitidoException{
        if(numero1 <= numero2){
            throw new NumeroMaiorQuePermitidoException("Erro: O número " + numero1 + " é maior que " + numero2);
        }
        int quantidade = numero1 - numero2;
        for(int i = 1; i<=quantidade; i++){
            System.out.println("Imprimindo o numero " + i);
        }
    }
}
