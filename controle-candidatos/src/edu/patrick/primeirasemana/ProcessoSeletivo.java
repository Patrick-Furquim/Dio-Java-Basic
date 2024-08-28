package edu.patrick.primeirasemana;

import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        int codigoParticipante = 0;
        analisarCandidato(1900);
        analisarCandidato(2000);
        analisarCandidato(2200);
        Pessoa pessoa1 = new Pessoa();
        criarCandidato(pessoa1, "Patrick", codigoParticipante);
        System.out.println(pessoa1.nome + pessoa1.codigo + pessoa1.salario + codigoParticipante);
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void criarCandidato(Pessoa pessoa, String nome, int codigo){
        pessoa.salario = valorPretendido();
        codigo++;
        pessoa.codigo = codigo; 
        pessoa.nome = nome;
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }
        else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else{
            System.out.println("Aguardar resultados dos demais candidatos");
        }
    }
}
