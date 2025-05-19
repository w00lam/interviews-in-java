package ch04;

// 시간 복잡도 : O(n)
public class Power {
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(3.0, 4));
    }
}
