package ch04;

public class Parity_3 {
    public static int[] makeLookuptable(int keySize) {
        int n = (int) Math.pow(2, keySize);
        int[] precomputedParity = new int[n];
        for (int i = 0; i < n; i++) {
            short result = 0;
            int tmp = i;
            while (i != 0) {
                result ^= 1;
                i &= (i - 1);
            }
            i = tmp;
            precomputedParity[i] = result;
        }
        return precomputedParity;
    }

    static int[] precomputedParity = makeLookuptable(16);

    public static short parity(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return (short) (
                precomputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
                        ^ precomputedParity[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)]
                        ^ precomputedParity[(int) ((x >>> WORD_SIZE) & BIT_MASK)]
                        ^ precomputedParity[(int) (x & BIT_MASK)]);
    }

    public static void main(String[] args) {
        System.out.println(parity(0x2121));
    }
}
