package socket;

import java.io.*;
import java.net.*;

public class ClienteSocket {
    private static final int PORTA = 10000;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", PORTA);
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)
        ) {

            // Thread para escutar mensagens do servidor
            Thread escutaServidor = new Thread(() -> {
                String msg;
                try {
                    while ((msg = entrada.readLine()) != null) {
                        System.out.println("Servidor: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Conexao encerrada pelo servidor.");
                }
            });

            escutaServidor.start();

            // Thread principal: envia mensagens digitadas
            String texto;
            while ((texto = teclado.readLine()) != null) {
                saida.println(texto);
            }

        } catch (IOException e) {
            System.out.println("Erro ao conectar ao servidor:");
            e.printStackTrace();
        }
    }
}
