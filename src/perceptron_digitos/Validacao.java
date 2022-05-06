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
        
        for (int j = 0; j < 16; j++) {
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
    
    public boolean compareArray(double[] arrayOne, double[] arrayTwo) {
        boolean result = true;
        for (int x = 0; x < 4; x++) {
            if (arrayOne[x] != arrayTwo[x]) {
                result = false;
                break;
            }
        }
        
        return result;
    }

    public String teste(int mat[][], double w[][], double t[][], double limiar) {
        double fyent[] = new double[4];
        
        for (int perceptron = 0; perceptron < 4; perceptron++) {
            double yent = somatorio(mat, w, perceptron);
            fyent[perceptron] = saida(yent, limiar);
        }
        
        
        if (compareArray(fyent, t[0])) {
            print(fyent, t[0]);
            return "0";
        } else if (compareArray(fyent, t[1])) {
            print(fyent, t[1]);
            return "1";
        } else if (compareArray(fyent, t[2])) {
            print(fyent, t[2]);
            return "2";
        } else if (compareArray(fyent, t[3])) {
            print(fyent, t[3]);
            return "3";
        } else if (compareArray(fyent, t[4])) {
            print(fyent, t[4]);
            return "4";
        } else if (compareArray(fyent, t[5])) {
            print(fyent, t[5]);
            return "5";
        } else if (compareArray(fyent, t[6])) {
            print(fyent, t[6]);
            return "6";            
        } else if (compareArray(fyent, t[7])) {
            print(fyent, t[7]);
            return "7";
        } else if (compareArray(fyent, t[8])) {
            print(fyent, t[8]);
            return "8";
        } else if (compareArray(fyent, t[9])) {
            print(fyent, t[9]);
            return "9";
        }else {
            return "?";
        }

    }
    
    public void print(double[] fyent, double[] t) {
        for (double f : fyent) {
            System.out.println("F -> " + f);
        }
        
        System.out.println("======");
        
            for (double value : t) {
                System.out.println("T -> " + value);   
            }
        
        
        System.out.println("======");
    }
    
}