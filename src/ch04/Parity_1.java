package ch04;

public class Parity_1 {
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (short) (x & 1);
            x >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parity(0b10001000));
    }
}
