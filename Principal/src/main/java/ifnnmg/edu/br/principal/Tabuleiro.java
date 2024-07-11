package ifnnmg.edu.br.principal;

/**
 *
 * @author annekarolinneds
 */
public class Tabuleiro {
    public static void imprimirTabuleiro(int[][] tabuleiro) {
        for (int[] linha : tabuleiro) {
            for (int celula : linha) {
                System.out.printf("%2d ", celula);
            }
            System.out.println();
        }
    }
}
