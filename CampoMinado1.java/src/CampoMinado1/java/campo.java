package CampoMinado1.java;
import java.util.Random;

//LÓGICA DO CÓDIGO

//adicionar os imports da interface grafica.
//primeira parte do código, deve ser dividida da interface.


public class campo1 {
    private int tamanhoTabuleiro;
    private int[][] tabuleiro;
    private boolean[][] tabuleiroVisivel;
    private int numeroMinas;
    private boolean jogoTerminado;

    public campo1(int tamanhoTabuleiro, int numeroMinas) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.numeroMinas = numeroMinas;
        this.tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        this.tabuleiroVisivel = new boolean[tamanhoTabuleiro][tamanhoTabuleiro];
        inicializarTabuleiro1();
        distribuirMinas1();
        jogoTerminado = false;
    }

    private void inicializarTabuleiro1() {
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                tabuleiro[i][j] = 0;
                tabuleiroVisivel[i][j] = false;
            }
        }
    }

    private void distribuirMinas1() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < numeroMinas) {
            int linha = random.nextInt(tamanhoTabuleiro);
            int coluna = random.nextInt(tamanhoTabuleiro);

            if (tabuleiro[linha][coluna] != -1) {
                tabuleiro[linha][coluna] = -1;
                minasColocadas++;
            }
        }
    }

    public void revelarCelula1(int linha, int coluna) {
        if (!jogoTerminado) {
            if (linha >= 0 && linha < tamanhoTabuleiro && coluna >= 0 && coluna < tamanhoTabuleiro && !tabuleiroVisivel[linha][coluna]) {
                tabuleiroVisivel[linha][coluna] = true;

                if (tabuleiro[linha][coluna] == -1) {
                    jogoTerminado = true;
                    System.out.println("Você perdeu! Havia uma mina nessa célula.");
                    // Aqui você pode implementar o que acontece quando o jogador perde
                } else if (tabuleiro[linha][coluna] == 0) {
                    // Se a célula estiver vazia, revelar células vizinhas recursivamente
                    for (int i = linha - 1; i <= linha + 1; i++) {
                        for (int j = coluna - 1; j <= coluna + 1; j++) {
                            revelarCelula1(i, j);
                        }
                    }
                }
            }
        }
    }

    public void imprimirTabuleiro1() {
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                if (tabuleiroVisivel[i][j]) {
                    if (tabuleiro[i][j] == -1) {
                        System.out.print("* "); // Representação visual da mina
                    } else {
                        System.out.print(tabuleiro[i][j] + " ");
                    }
                } else {
                    System.out.print("- "); // Representação visual de célula não revelada
                }
            }
            System.out.println();
        }
    }

    public boolean isJogoTerminado1() {
        return jogoTerminado;
    }

    public static void main1(String[] args) {
        int tamanhoTabuleiro = 5;
        int numeroMinas = 5;
        campo1 campoMinado = new campo1(tamanhoTabuleiro, numeroMinas);

        // Aqui você pode implementar a lógica para interagir com o jogo pelo console
        // Por exemplo:
        campoMinado.imprimirTabuleiro1();
        campoMinado.revelarCelula1(0, 0);
        campoMinado.imprimirTabuleiro1();
        // Continue interagindo até o jogo terminar
    }
    

 //FIM PRIMEIRA PARTE DA LÓGICA.
    
//////////////////////////////////////////////////////

    //SEGUNDA PARTE: Interface Gráfica do Jogo
    //REMOVER PARTES DUPLICADAS DA LOGICA.

public void campo(int tamanhoTabuleiro, int numeroMinas) {
    this.tamanhoTabuleiro = tamanhoTabuleiro;
    this.numeroMinas = numeroMinas;
    this.tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
    this.tabuleiroVisivel = new boolean[tamanhoTabuleiro][tamanhoTabuleiro];
    inicializarTabuleiro1();
    distribuirMinas1();
    jogoTerminado = false;
}

private void inicializarTabuleiro() {
    for (int i = 0; i < tamanhoTabuleiro; i++) {
        for (int j = 0; j < tamanhoTabuleiro; j++) {
            tabuleiro[i][j] = 0;
            tabuleiroVisivel[i][j] = false;
        }
    }
}

private void distribuirMinas() {
    Random random = new Random();
    int minasColocadas = 0;

    while (minasColocadas < numeroMinas) {
        int linha = random.nextInt(tamanhoTabuleiro);
        int coluna = random.nextInt(tamanhoTabuleiro);

        if (tabuleiro[linha][coluna] != -1) {
            tabuleiro[linha][coluna] = -1;
            minasColocadas++;
        }
    }
}

public void revelarCelula(int linha, int coluna) {
    if (!jogoTerminado) {
        if (linha >= 0 && linha < tamanhoTabuleiro && coluna >= 0 && coluna < tamanhoTabuleiro && !tabuleiroVisivel[linha][coluna]) {
            tabuleiroVisivel[linha][coluna] = true;

            if (tabuleiro[linha][coluna] == -1) {
                jogoTerminado = true;
                System.out.println("Você perdeu! Havia uma mina nessa célula.");
                // Aqui você pode implementar o que acontece quando o jogador perde
            } else if (tabuleiro[linha][coluna] == 0) {
                // Se a célula estiver vazia, revelar células vizinhas recursivamente
                for (int i = linha - 1; i <= linha + 1; i++) {
                    for (int j = coluna - 1; j <= coluna + 1; j++) {
                        revelarCelula1(i, j);
                    }
                }
            }
        }
    }
}

public void imprimirTabuleiro() {
    for (int i = 0; i < tamanhoTabuleiro; i++) {
        for (int j = 0; j < tamanhoTabuleiro; j++) {
            if (tabuleiroVisivel[i][j]) {
                if (tabuleiro[i][j] == -1) {
                    System.out.print("* "); // Representação visual da mina
                } else {
                    System.out.print(tabuleiro[i][j] + " ");
                }
            } else {
                System.out.print("- "); // Representação visual de célula não revelada
            }
        }
        System.out.println();
    }
}

public boolean isJogoTerminado() {
    return jogoTerminado;
}

public static void main(String[] args) {
    int tamanhoTabuleiro = 5;
    int numeroMinas = 5;
    CampoMinado campoMinado = new CampoMinado(tamanhoTabuleiro, numeroMinas);

    // Aqui você pode implementar a lógica para interagir com o jogo pelo console
    // Por exemplo:
    campoMinado.imprimirTabuleiro();
    campoMinado.revelarCelula(0, 0);
    campoMinado.imprimirTabuleiro();
    // Continue interagindo até o jogo terminar
}
}

//CLASSE PARA O JOGADOR, IMPLEMENTAR A PARTE GRAFICA COM JSWING


// CAMPO MINADO MALUCO.
public class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void aumentarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }
}
private double nivelMaluquice;

public CampoMinado(int tamanhoTabuleiro, int numeroMinas, double nivelMaluquice, Jogador jogador) {
    // ... (restante do código)
    this.nivelMaluquice = nivelMaluquice;
}

// ... (restante do código)

public void marcarCelula(int linha, int coluna) {
    if (jogoAtivo) {
        if (!tabuleiroVisivel[linha][coluna]) {
            marcacoes[linha][coluna] = !marcacoes[linha][coluna];
            if (marcacoes[linha][coluna] && tabuleiro[linha][coluna] != -1) {
                alterarStatusMaluco(linha, coluna);
            }
        }
    }
}

private void alterarStatusMaluco(int linha, int coluna) {
    double probabilidade = Math.random(); // Gera um número aleatório entre 0 e 1
    if (probabilidade < nivelMaluquice) {
        tabuleiro[linha][coluna] = (tabuleiro[linha][coluna] == -1) ? 0 : -1; // Inverte o status da célula maluca
        System.out.println("Célula maluca mudou seu status!");
    }
}