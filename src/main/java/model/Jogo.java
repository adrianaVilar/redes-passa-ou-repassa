package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import enums.Resultado;
import enums.Status;

public class Jogo {
    private final int[] placar = { 0, 0 };
    private final int PLACAR_MAX = 30;
    private Status status = Status.INICIO;
    private Resultado resultado = Resultado.NAO_INICIADO;
    private int jogadorSorteado = 0;
    private List<String> nicknames;
    private List<Pergunta> perguntas;
    private Pergunta perguntaAtual;
    private Random random;

    public Jogo(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
        this.random = new Random();
        this.nicknames = new ArrayList<>();
    }

    public Pergunta getPerguntaAtual() {
        return perguntaAtual;
    }

    public void sortearPergunta() {
        int indice = random.nextInt(perguntas.size());
        perguntaAtual = perguntas.get(indice);
    }

    public void setNickname(String nickname) {
        this.nicknames.add(nickname);
    }

    public String getNickname(int index) {
        return nicknames.get(index);
    }

    public synchronized Status getStatus() {
        return status;
    }

    public synchronized void setStatus(Status status) {
        this.status = status;
    }

    public synchronized int getJogadorSorteado() {
        return jogadorSorteado;
    }

    public synchronized void sortearProximoJogador() {
        jogadorSorteado = random.nextInt(2);
    }

    public synchronized int getPontuacao(int jogadorId) {
        return placar[jogadorId];
    }

    public synchronized Resultado getResultado() {
        return resultado;
    }

    public synchronized void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public synchronized void somarPontos(int jogadorId, int pontos) {
        placar[jogadorId] += pontos;
    }

    public synchronized void imprimirPlacar() {
        System.out.println("******************************\n" 
                        + "********** " + Arrays.toString(placar) + " **********\n"
                        + "******************************");
    }

    public synchronized boolean jogoFinalizado() {
        return placar[0] >= PLACAR_MAX || placar[1] >= PLACAR_MAX;
    }

    public void trocarJogador() {
        jogadorSorteado = jogadorSorteado == 0 ? 1 : 0;
    }

    public void novaPartida() {
        placar[0] = 0;
        placar[1] = 0;
        status = Status.INICIO;
        resultado = Resultado.NAO_INICIADO;
        perguntaAtual = null;
    }
}
