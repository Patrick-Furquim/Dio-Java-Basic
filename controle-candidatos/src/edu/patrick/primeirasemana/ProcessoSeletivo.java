package edu.patrick.primeirasemana;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
       
        IntAux codigoParticipante = new IntAux(); //Criar int que possa ser modificado dentro da função        codigoParticipante.inteiro = 0;

        codigoParticipante.inteiro = 0;

        Pessoa participantes[] = new Pessoa[20]; //Array para colocar todos os participantes

        participantes[codigoParticipante.inteiro] = criarCandidato("Felipe", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Marcia", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Julia", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Paulo", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Augusto", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Monica", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Fabricio", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Mirela", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Daniela", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Jose", codigoParticipante);
        participantes[codigoParticipante.inteiro] = criarCandidato("Patrick", codigoParticipante);

        Pessoa selecionados[] = new Pessoa[5];
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;
        int i = 0;
        while(candidatosSelecionados < 5 && codigoParticipante.inteiro > i){
            if(salarioBase>= participantes[i].salario){
                System.out.println("O candidato " + participantes[i].nome + " foi selecionado para a vaga");
                selecionados[candidatosSelecionados] = participantes[i];
                candidatosSelecionados++;
            }
            i++;
        }
        mostrarSelecionados(selecionados, candidatosSelecionados);
        entrarEmContato(selecionados, candidatosSelecionados);
    }
//=============================================================
//-----MÉTODOS-------------

    static void entrarEmContato(Pessoa []selecionados, int aprovados)
    {
        //tentar ligar
        int tentativas;
        boolean atendeu;
        for(int j = 0;j<aprovados;j++)
        {
            tentativas = 0;
            atendeu = false;
            while(atendeu!=true && tentativas <3)
            {
                atendeu = ligar(selecionados[j]);
                tentativas++;
            }
            if(atendeu)
            {
                System.out.println("O candidato: " + selecionados[j].nome +" atendeu com " + tentativas + " tentativas");
            }
            else
            {
                System.out.println("O candidato: " + selecionados[j].nome +" não atendeu!!");
            }
        }
        
    }

    static boolean ligar(Pessoa selecionados)
    {
        return new Random().nextInt(3)==1;
    }

    static void mostrarSelecionados(Pessoa []selecionados, int aprovados){
        System.out.println("Esses foram os candidatos selecionados: ");
        for(int i = 0; i<aprovados; i++)
        {
            System.out.println(i+1 +": "+ selecionados[i].nome);
        }
    }


    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static Pessoa criarCandidato(String nome, IntAux codigo){
        Pessoa pessoa = new Pessoa();
        pessoa.salario = valorPretendido();
        codigo.inteiro++;
        pessoa.codigo = codigo.inteiro; 
        pessoa.nome = nome;
        return pessoa;
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
