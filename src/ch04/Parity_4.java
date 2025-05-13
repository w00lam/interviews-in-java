package ch04;

public class Parity_4 {
    public static short parity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }

    public static void main(String[] args) {
        System.out.println(parity(0x1234));
    }
}
