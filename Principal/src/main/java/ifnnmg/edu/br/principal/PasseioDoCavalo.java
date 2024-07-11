package ifnnmg.edu.br.principal;

/**
 *
 * @author annekarolinneds
 */
public class PasseioDoCavalo {
    private static final int TAMANHO_TABULEIRO = 8;
    private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] tabuleiro = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        int linhaAtual = 0;
        int colunaAtual = 0;
        int numeroMovimento = 1;

        tabuleiro[linhaAtual][colunaAtual] = numeroMovimento;

        for (numeroMovimento = 2; numeroMovimento <= TAMANHO_TABULEIRO * TAMANHO_TABULEIRO; numeroMovimento++) {
            int proximoMovimento = -1;
            int minAcessos = 9;

            for (int i = 0; i < 8; i++) {
                int novaLinha = linhaAtual + VERTICAL[i];
                int novaColuna = colunaAtual + HORIZONTAL[i];

                if (movimentoValido(novaLinha, novaColuna, tabuleiro)) {
                    int acessos = contarAcessos(novaLinha, novaColuna, tabuleiro);
                    if (acessos < minAcessos) {
                        minAcessos = acessos;
                        proximoMovimento = i;
                    }
                }
            }

            if (proximoMovimento == -1) {
                System.out.println("Não foi possível completar o passeio do cavalo.");
                break;
            } else {
                linhaAtual += VERTICAL[proximoMovimento];
                colunaAtual += HORIZONTAL[proximoMovimento];
                tabuleiro[linhaAtual][colunaAtual] = numeroMovimento;
            }
        }

        Tabuleiro.imprimirTabuleiro(tabuleiro);
        System.out.println("O cavalo fez " + (numeroMovimento - 1) + " movimentos.");
    }

    private static boolean movimentoValido(int linha, int coluna, int[][] tabuleiro) {
        return linha >= 0 && linha < TAMANHO_TABULEIRO && coluna >= 0 && coluna < TAMANHO_TABULEIRO && tabuleiro[linha][coluna] == 0;
    }

    private static int contarAcessos(int linha, int coluna, int[][] tabuleiro) {
        int acessos = 0;
        for (int i = 0; i < 8; i++) {
            int novaLinha = linha + VERTICAL[i];
            int novaColuna = coluna + HORIZONTAL[i];
            if (movimentoValido(novaLinha, novaColuna, tabuleiro)) {
                acessos++;
            }
        }
        return acessos;
    }
}

