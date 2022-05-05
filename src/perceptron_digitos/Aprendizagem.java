package perceptron_digitos;

/**
 *
 * @author Clarimundo
 */
public class Aprendizagem {

    private double x[][] = {
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
        {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}
    };

    private double weight[][] = new double[16][4];
    private double target[][] = {
        {-1, -1, -1, -1},
        {-1, 1, -1, -1},
        {-1, -1, 1, -1},
        {-1, 1, 1, -1},
        {-1, 1, 1, 1},
        {1, -1, -1, -1},
        {1, 1, -1, -1},
        {1, -1, 1, -1},
        {1, 1, 1, -1},
        {1, 1, 1, 1}
    };
    
    private int epocas;

    public Aprendizagem() {
        epocas = 0;
    }

    public double[][] getw() {
        return weight;
    }

    public double[][] gett() {
        return target;
    }

    public int getepocas() {
        return epocas;
    }

    public double somatorio(int line, int perceptron) {
        double yent = 0;
        
        for (int column = 0; column < 16; column++) {
            yent = yent + (x[line][column] * weight[column][perceptron]);
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

    public void atualiza(double alfa, double fyent[][], int perceptron) {
        for (int line = 0; line < 10; line++) {
            for (int column = 0; column < 16; column++) {
                weight[column][perceptron] = weight[column][perceptron] + alfa * (target[line][perceptron] - fyent[line][perceptron]) * x[line][column];
            }
        }
    }

    public void algoritmo(double alfa, double limiar) {
        double yent;
        double fyent[][] = new double[10][4];
        boolean mudou;

        for (int line = 0; line < 16; line++) {
            for (int column = 0; column < 4; column++) {
                weight[line][column] = 0;
            }
        }
        
        for (int perceptron = 0; perceptron < 4; perceptron++) {
            do {
                mudou = false;

                for (int line = 0; line < 10; line++) {
                    yent = somatorio(line, perceptron);
                    
                    fyent[line][perceptron] = saida(yent, limiar);

                    if (fyent[line][perceptron] != target[line][perceptron]) {
                        mudou = true;
                    }
                }
                
                if (mudou == true) {
                    atualiza(alfa, fyent, perceptron);
                }
                epocas++;
            } while (mudou == true);
        }
    }
}
