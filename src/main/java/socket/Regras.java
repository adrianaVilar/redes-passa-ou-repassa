package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import enums.Pontos;
import enums.Status;
import model.Jogo;
import model.Pergunta;

public class Regras extends Thread {
    private final Socket socket;
    private final int id;
    private final Jogo jogo;
    private List<Pergunta> perguntasSorteadas = new ArrayList<>();
    private BufferedReader entrada;
    private PrintWriter saida;
    private PrintWriter saidaSegundoJogador;

    private static int QTD_JOGADORES = 2;
    private static final AtomicBoolean deveMostrarPergunta = new AtomicBoolean(true);
    private static final AtomicInteger nicknamesRecebidos = new AtomicInteger(0);
    private static final AtomicInteger reiniciosConfirmados = new AtomicInteger(0);

    public Regras(Socket socket, int id, Jogo jogo) {
        this.socket = socket;
        this.id = id;
        this.jogo = jogo;
    }

    @Override
    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream(), true);

            // Cadastro do nickname para todos os jogadores
            saida.println("Digite seu nickname:");
            String nickname = entrada.readLine();
            jogo.setNickname(nickname);
            System.out.println("Nickname do(a) jogador(a) " + (id + 1) + ": " + nickname);
            int recebidos = nicknamesRecebidos.incrementAndGet();

            // Espera até que todos cadastrem o nickname
            while (recebidos < QTD_JOGADORES) {
                Thread.sleep(100);
                recebidos = nicknamesRecebidos.get();
            }

            while (true) {
            // Inicio do jogo
            while (!jogo.jogoFinalizado()) {

                if (id != jogo.getJogadorSorteado()) {
                    saidaSegundoJogador = new PrintWriter(socket.getOutputStream(), true);
                    if (deveMostrarPergunta.get()) {
                        if (Status.INICIO.equals(jogo.getStatus())) {
                            saidaSegundoJogador.println(jogo.getPerguntaAtual());
                        }
                        saidaSegundoJogador.println("Aguarde a resposta do(a) adversario(a)");
                        deveMostrarPergunta.set(false);
                    }
                    Thread.sleep(100);
                    continue;
                }
                             
                String msg = "";
                char resposta = ' ';
                Status status = jogo.getStatus();

                System.out.println("\n== Vez do(a) jogador(a) " + jogo.getNickname(jogo.getJogadorSorteado())+ " ==");

                switch (status) {
                    case INICIO:
                        perguntasSorteadas.add(jogo.getPerguntaAtual());

                        System.out.println(jogo.getPerguntaAtual());
                        saida.println(jogo.getPerguntaAtual());
                        saida.println("Sua vez de jogar. Escreva: RESPONDER - X ou PASSA.");

                        msg = entrada.readLine().trim().toUpperCase();

                        if (msg.contains("RESPONDE")) {
                            resposta = msg.trim().toLowerCase().charAt(msg.length() - 1);

                            if (respostaCorreta(resposta)) {
                                jogo.somarPontos(id, Pontos.ACERTA_PRIMEIRA.getPontos());
                                saida.println("Parabéns! +" + Pontos.ACERTA_PRIMEIRA.getPontos() + " pontos\n\n");
                            } else {
                                jogo.somarPontos(id, Pontos.ERRA_PRIMEIRA.getPontos());
                                saida.println("Incorreto! " + Pontos.ERRA_PRIMEIRA.getPontos() + " pontos\n\n");
                            }

                            jogo.trocarJogador();
                            jogo.imprimirPlacar();
                            jogo.setStatus(Status.INICIO);
                            deveMostrarPergunta.set(true);
                            sortearNovaPergunta();
                        } else if (msg.contains("PASSA")) {
                            jogo.setStatus(Status.PASSA);
                            System.out.println("\n== " + nickname + " PASSOU ==");
                            jogo.trocarJogador();
                        } else {
                            System.out.println("Resposta inválida.");
                        }
                    break;
                    case PASSA:
                        saida.println("\n== Adversario(a) PASSOU a pergunta. Voce deve RESPONDER ou REPASSAR ==\nPara responder digite 'RESPONDER - X'");

                        msg = entrada.readLine().toUpperCase();

                        if (msg.contains("RESPONDE")) {
                            resposta = msg.trim().toLowerCase().charAt(msg.length() - 1);
                            if (respostaCorreta(resposta)) {
                                jogo.somarPontos(id, Pontos.ACERTA_PASSA.getPontos());
                                saida.println("Correto! +" + Pontos.ACERTA_PASSA.getPontos() + " pontos\n\n");
                            } else {
                                jogo.somarPontos(id, Pontos.ERRA_PASSA.getPontos());
                                saida.println("Incorreto! " + Pontos.ERRA_PASSA.getPontos() + " pontos\n\n");
                            }
                            jogo.imprimirPlacar();
                            jogo.setStatus(Status.INICIO);
                            deveMostrarPergunta.set(true);
                            sortearNovaPergunta();
                        } else if (msg.contains("REPASSA")) {
                            jogo.setStatus(Status.REPASSA);
                            System.out.println("\n== " + nickname + " REPASSOU ==");
                            jogo.trocarJogador();
                        } else {
                            saida.println("Resposta inválida. Digite RESPONDER ou REPASSA.");
                        }
                        break;
                    case REPASSA:
                        saida.println("== Adversario(a) REPASSOU a pergunta. Voce deve RESPONDER ==\nPara responder digite 'RESPONDER - X'");

                        msg = entrada.readLine().toUpperCase();

                        resposta = msg.trim().toLowerCase().charAt(msg.length() - 1);
                        if (respostaCorreta(resposta)) {
                            jogo.somarPontos(id, Pontos.ACERTA_REPASSA.getPontos());
                            saida.println("Correto! +" + Pontos.ACERTA_REPASSA.getPontos() + " pontos\n\n");
                        } else {
                            jogo.somarPontos(id, Pontos.ERRA_REPASSA.getPontos());
                            saida.println("Incorreto! " + Pontos.ERRA_REPASSA.getPontos() + " pontos\n\n");
                        }
                        jogo.imprimirPlacar();
                        jogo.trocarJogador();
                        jogo.setStatus(Status.INICIO);
                        deveMostrarPergunta.set(true);
                        sortearNovaPergunta();
                    break;
                    default:
                        System.out.println("Erro no status. Reiniciando");
                        jogo.setStatus(Status.INICIO);
                        deveMostrarPergunta.set(true);
                    break;
                }
            }

            saida.println("Fim de jogo! Seu placar: " + jogo.getPontuacao(id));

            saida.println("\n\nDeseja jogar novamente? S/N\n");
            String resposta = entrada.readLine().toUpperCase();

            if ("S".equals(resposta)) {
                int confirmados = reiniciosConfirmados.incrementAndGet();

                // Espera até que os dois jogadores digam "S"
                while (confirmados < QTD_JOGADORES) {
                    Thread.sleep(100); // aguarda o outro jogador responder
                    confirmados = reiniciosConfirmados.get();
                }

                // Só um deles deve reiniciar o jogo (evita conflitos)
                synchronized (jogo) {
                    if (id == 0) { // Só o jogador 0 reinicia os dados do jogo
                        jogo.novaPartida();
                        jogo.sortearPergunta();
                        jogo.sortearProximoJogador();
                    }
                }

                // Reset para próxima rodada
                perguntasSorteadas.clear();
                deveMostrarPergunta.set(true);
                nicknamesRecebidos.set(0);
                // e volta para o loop externo (while true)
            } else {
                saida.println("Obrigado por jogar!");
                break;
            }
            
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sortearNovaPergunta() {
        jogo.sortearPergunta();
        if (!perguntasSorteadas.contains(jogo.getPerguntaAtual())) {
            perguntasSorteadas.add(jogo.getPerguntaAtual());
        }
    }

    private boolean respostaCorreta(char resposta) {
        return jogo.getPerguntaAtual().getRespostaCorreta() == resposta;
    }
}