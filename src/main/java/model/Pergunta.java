package model;

public class Pergunta {
    String pergunta;
    String[] alternativas;
    char respostaCorreta;

    public Pergunta(String pergunta, String[] alternativas, char respostaCorreta) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pergunta).append("\n");
        char opcao = 'a';
        for (String alt : alternativas) {
            if (alt != null && !alt.isEmpty()) {
                sb.append(opcao).append(") ").append(alt).append("\n");
            }
            opcao++;
        }
        return sb.toString();
    }
}
