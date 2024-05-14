package makarova.dz.integral;

public class SumPart extends Thread {
    private final double a;
    private final double b;
    public static double sum;
    public static final int N = 100;

    public SumPart(double a, double b) {
        this.a = a;
        this.b = b;
    }

    private Double func(Double x) {
        return Math.sin(x * x);
    }

    @Override
    public void run() {
        double h = (b - a) / N;
        double localSum = 0;
        for (int i = 0; i < N; i++) {
            localSum += h * func(a + i * h + h / 2);
        }
       // sum += localSum;

        synchronized (this) {
            sum += localSum;
        }
    }
}
