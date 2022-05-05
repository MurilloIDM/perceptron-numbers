package perceptron_digitos;

import java.util.Arrays;

/**
 *
 * @author Clarimundo
 */
public class Validacao {

    public Validacao() {

    }

    public double somatorio(int mat[][], double w[][], int perceptron) {

        double yent = 0;
        double entrada[] = new double[16];
        int l = 1;
        entrada[0] = 1;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                entrada[l] = mat[i][j];
                l++;
            }
        }
        
        for (int j = 1; j < 16; j++) {
            yent = yent + entrada[j] * w[j][perceptron];
        }
        
        return yent;
    }

    public double saida(double yent, double limiar) {
        double f;

        if (yent > limiar) {
            f = 1;
        } else if (yent < -limiar) {
            f = -1;
        } else {
            f = 0;
        }
        return f;
    }

    public String teste(int mat[][], double w[][], double t[][], double limiar) {
        double fyent[] = new double[4];
        
        for (int perceptron = 0; perceptron < 4; perceptron++) {
            double yent = somatorio(mat, w, perceptron);
            fyent[perceptron] = saida(yent, limiar);
        }
        
        for (double f : fyent) {
            System.out.println(f);
        }
        
        if (Arrays.equals(fyent, t[0])) {
            return "0";
        } else if (Arrays.equals(fyent, t[1])) {
            return "1";
        } else {
            return "?";
        }

    }
    
}