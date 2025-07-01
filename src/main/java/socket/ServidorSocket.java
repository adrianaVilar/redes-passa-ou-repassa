package socket;

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

import model.Jogo;
import repository.Perguntas;

public class ServidorSocket {
    private static final int PORTA = 10000;
    private static final int MAX_CLIENTES = 2;
    private static AtomicInteger contadorClientes = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(PORTA)) {
            Jogo jogo = new Jogo(Perguntas.getPerguntas());
            
            System.out.println("== Aguardando 2 jogadores ==");

            Regras[] clientes = new Regras[MAX_CLIENTES];

            while (contadorClientes.get() < MAX_CLIENTES) {
                Socket socketCliente = servidor.accept();
                int id = contadorClientes.getAndIncrement();
                Regras handler = new Regras(socketCliente, id, jogo);
                clientes[id] = handler;              
                handler.start();
                System.out.println("Jogador " + (id + 1) + " conectado.");
            }

            jogo.sortearProximoJogador();
            jogo.sortearPergunta();
            System.out.println("== 2 jogadores conectados. Aguardando o cadastro dos nicknames. ==");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

