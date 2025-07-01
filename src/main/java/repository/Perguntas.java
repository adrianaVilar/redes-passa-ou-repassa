package repository;

import java.util.ArrayList;
import java.util.List;

import model.Pergunta;

public class Perguntas {

        public static List<Pergunta> getPerguntas() {

                List<Pergunta> perguntas = new ArrayList<>();

                perguntas.add(new Pergunta("Quem é conhecido como o 'Rei do Pop'?",
                                new String[] { "Michael Jackson", "Elvis Presley", "Prince", "Justin Timberlake" },
                                'a'));
                perguntas.add(new Pergunta("A banda 'The Beatles' é originária de qual país?",
                                new String[] { "Estados Unidos", "Inglaterra", "Austrália", "Canadá" }, 'b'));
                perguntas.add(new Pergunta("Quais são os três principais elementos da música?",
                                new String[] { "Melodia, Harmonia e Ritmo", "Timbre, Escala e Solo",
                                                "Compasso, Partitura e Letra", "Nota, Voz e Silêncio" },
                                'a'));
                perguntas.add(new Pergunta("Qual desses instrumentos é de corda?",
                                new String[] { "Flauta", "Violino", "Trompete", "Bateria" }, 'b'));
                perguntas.add(new Pergunta("Qual compositor famoso ficou surdo durante sua carreira?",
                                new String[] { "Chopin", "Mozart", "Beethoven", "Bach" }, 'c'));
                perguntas.add(new Pergunta("O que significa 'BPM' na música?",
                                new String[] { "Beats Por Minuto", "Baixos Para Música", "Banda Para Marcha",
                                                "Balanço Por Medida" },
                                'a'));
                perguntas.add(new Pergunta(
                                "Qual é o nome do festival musical realizado anualmente em São Paulo e no Rio?",
                                new String[] { "Lollapalooza", "Rock in Rio", "Planeta Atlântida", "Tomorrowland" },
                                'b'));
                perguntas.add(new Pergunta("Qual cantora é conhecida pelo hit 'Rolling in the Deep'?",
                                new String[] { "Adele", "Beyoncé", "Rihanna", "Lady Gaga" }, 'a'));
                perguntas.add(new Pergunta("O que a clave de sol indica na partitura musical?",
                                new String[] { "Notas em tom grave", "Ritmo acelerado", "Notas em tom agudo",
                                                "Pausa longa" },
                                'c'));
                perguntas.add(new Pergunta("Quantas cordas tem um violão padrão?",
                                new String[] { "4", "5", "6", "7" }, 'c'));
                perguntas.add(new Pergunta("A escala musical tem quantas notas naturais?",
                                new String[] { "5", "6", "7", "8" }, 'c'));
                perguntas.add(new Pergunta("Freddie Mercury foi vocalista de qual banda?",
                                new String[] { "Queen", "Kiss", "The Rolling Stones", "U2" }, 'a'));
                perguntas.add(new Pergunta("Quando surgiu a música eletrônica?",
                                new String[] { "No século XXI", "No século XX", "No século XIX", "No século XVIII" },
                                'b'));
                perguntas.add(new Pergunta("Qual é o estilo musical de João Gilberto?",
                                new String[] { "Samba", "MPB", "Bossa Nova", "Forró" }, 'c'));
                perguntas.add(new Pergunta("Chico Buarque é conhecido principalmente por:",
                                new String[] { "Canções instrumentais", "Composição e letras", "Regência de orquestras",
                                                "Tocar guitarra elétrica" },
                                'b'));
                perguntas.add(new Pergunta("Qual desses músicos é conhecido como maestro?",
                                new String[] { "Heitor Villa-Lobos", "Caetano Veloso", "Gilberto Gil",
                                                "Milton Nascimento" },
                                'a'));
                perguntas.add(new Pergunta("O que significa cantar 'a capella'?",
                                new String[] { "Com bateria", "Com guitarra", "Sem acompanhamento instrumental",
                                                "Com playback" },
                                'c'));
                perguntas.add(new Pergunta("O que é um compasso na música?",
                                new String[] { "Um tipo de instrumento", "Um agrupamento de tempos", "Uma nota longa",
                                                "Uma pausa entre acordes" },
                                'b'));
                perguntas.add(new Pergunta("A flauta pertence a qual família de instrumentos?",
                                new String[] { "Corda", "Sopro", "Percussão", "Tecla" }, 'b'));
                perguntas.add(new Pergunta("Qual desses é um estilo musical brasileiro?",
                                new String[] { "Jazz", "Sertanejo", "Blues", "Reggae" }, 'b'));
                perguntas.add(new Pergunta("Qual dessas notas é a mais aguda na escala padrão?",
                                new String[] { "Fá", "Ré", "Sol", "Depende do contexto" }, 'd'));
                perguntas.add(new Pergunta("O instrumento típico da música caipira é:",
                                new String[] { "Guitarra", "Viola", "Piano", "Flauta" }, 'b'));
                perguntas.add(new Pergunta("O heavy metal é um subgênero de qual estilo musical?",
                                new String[] { "Jazz", "Blues", "Rock", "Pop" }, 'c'));
                perguntas.add(new Pergunta(
                                "Qual cantora ficou famosa com a música 'Shallow' ao lado de Bradley Cooper?",
                                new String[] { "Dua Lipa", "Lady Gaga", "Katy Perry", "Adele" }, 'b'));
                perguntas.add(new Pergunta("Qual característica define o ritmo do reggae?",
                                new String[] { "Tempo acelerado", "Uso intenso de metais",
                                                "Batida cadenciada e marcada", "Vocais agudos" },
                                'c'));
                perguntas.add(new Pergunta("O termo 'falsete' se refere a:",
                                new String[] { "Um tipo de guitarra", "Uma técnica vocal", "Um ritmo",
                                                "Um compositor" },
                                'b'));
                perguntas.add(new Pergunta("Para que tipo de voz/instrumento geralmente se usa a clave de fá?",
                                new String[] { "Notas agudas", "Vozes graves", "Violino", "Flauta" }, 'b'));
                perguntas.add(new Pergunta("Qual desses é um compositor da era clássica?",
                                new String[] { "Mozart", "Chico Buarque", "Bob Marley", "Tom Jobim" }, 'a'));
                perguntas.add(new Pergunta("Qual desses instrumentos pertence à percussão?",
                                new String[] { "Violino", "Pandeiro", "Clarinete", "Harpa" }, 'b'));
                perguntas.add(new Pergunta("A Bossa Nova tem influência de qual estilo musical?",
                                new String[] { "Forró", "Rock", "Jazz", "Axé" }, 'c'));
                perguntas.add(new Pergunta("Qual desses artistas é do gênero sertanejo?",
                                new String[] { "Anitta", "Luan Santana", "Pabllo Vittar", "Zeca Pagodinho" }, 'b'));
                perguntas.add(new Pergunta("Onde estão localizadas as notas mais agudas no teclado de um piano?",
                                new String[] { "Centro", "Direita", "Esquerda", "Parte de baixo" }, 'b'));
                perguntas.add(new Pergunta("Quantas teclas tem um piano padrão?",
                                new String[] { "66", "72", "76", "88" }, 'd'));
                perguntas.add(new Pergunta("O canto gregoriano é um estilo de música:",
                                new String[] { "Pop", "Sacra medieval", "Romântica", "Eletrônica" }, 'b'));
                perguntas.add(new Pergunta("Qual desses é um estilo musical africano?",
                                new String[] { "Afrobeat", "Ska", "Techno", "Fado" }, 'a'));
                perguntas.add(new Pergunta("Para que serve o autotune?",
                                new String[] { "Aumentar o volume", "Corrigir a afinação da voz", "Dar efeito de eco",
                                                "Alterar a velocidade da música" },
                                'b'));
                perguntas.add(new Pergunta("Qual é a principal função de um maestro?",
                                new String[] { "Tocar piano", "Cantar em coral", "Compor músicas",
                                                "Conduzir a orquestra" },
                                'd'));
                perguntas.add(new Pergunta("Quantas notas tem a escala cromática?",
                                new String[] { "7", "12", "6", "8" }, 'b'));
                perguntas.add(new Pergunta("Qual desses músicos é brasileiro?",
                                new String[] { "Bob Dylan", "Caetano Veloso", "John Lennon", "Elton John" }, 'b'));
                perguntas.add(new Pergunta("Tom Jobim é conhecido por ter contribuído para qual gênero?",
                                new String[] { "Samba", "Bossa Nova", "Forró", "MPB" }, 'b'));
                perguntas.add(new Pergunta("A harpa pertence a qual família de instrumentos?",
                                new String[] { "Sopro", "Corda", "Percussão", "Tecla" }, 'b'));
                perguntas.add(new Pergunta("Qual estilo musical é característico do carnaval do Rio?",
                                new String[] { "Axé", "Samba", "Forró", "Maracatu" }, 'b'));
                perguntas.add(new Pergunta("Quem escreveu a música 'Imagine'?",
                                new String[] { "Paul McCartney", "John Lennon", "George Harrison", "Ringo Starr" },
                                'b'));
                perguntas.add(new Pergunta("Quantas notas tem uma oitava musical?",
                                new String[] { "5", "7", "8", "10" }, 'c'));
                perguntas.add(new Pergunta("A música pode influenciar o quê nas pessoas?",
                                new String[] { "Apenas a concentração", "O humor", "O sono apenas", "Nada" }, 'b'));
                perguntas.add(new Pergunta("Qual desses gêneros nasceu nos Estados Unidos?",
                                new String[] { "Sertanejo", "Samba", "Blues", "Bossa Nova" }, 'c'));
                perguntas.add(new Pergunta("O órgão é um instrumento:",
                                new String[] { "Antigo e acústico", "Eletrônico moderno", "De percussão", "De sopro" },
                                'a'));
                perguntas.add(new Pergunta("Qual desses termos se refere a um conjunto de vozes diferentes?",
                                new String[] { "Coral", "Ritmo", "Trio", "Banda" }, 'a'));
                perguntas.add(new Pergunta("Qual foi a importância de Chiquinha Gonzaga para a música brasileira?",
                                new String[] { "Foi a primeira mulher a reger uma orquestra no Brasil",
                                                "Criou o gênero sertanejo", "Foi a fundadora do samba-enredo",
                                                "Inventou o piano elétrico" },
                                'a'));
                    
                return perguntas;
        }
}    
