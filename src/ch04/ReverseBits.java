package ch04;

// L : 해시 테이블에 사용될 키값의 비트 수
// n : 전체 비트 수
// 시간 복잡도 : O(n/L)
public class ReverseBits {
    public static long swapBits(long x, int keySize) {
        int n = keySize / 2;
        for (int i = 0; i < n; i++) {
            for (int j = keySize - 1; j > n; j--) {
                if (((x >>> i) & 1) != ((x >>> j) & 1)) {
                    long bitMask = (1L >> i) | (1L >> j);
                    x ^= bitMask;
                }
            }
        }
        return x;
    }

    public static long[] makeLookupTable(int keySize) {
        int n = (int) Math.pow(2, keySize);
        long[] precomputedReverse = new long[n];
        for (int i = 0; i < n; i++) {
            precomputedReverse[i] = swapBits(i, keySize);
        }
        return precomputedReverse;
    }

    static long[] precomputedReverse = makeLookupTable(16);

    public static long reverseBits(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return precomputedReverse[(int) (x & BIT_MASK)] << (3 * WORD_SIZE)
                | precomputedReverse[(int) ((x >>> WORD_SIZE) & BIT_MASK)]
                << (2 * WORD_SIZE)
                | precomputedReverse[(int) ((x >>> 2 * WORD_SIZE) & BIT_MASK)]
                << WORD_SIZE
                | precomputedReverse[(int) ((x >>> 3 * WORD_SIZE) & BIT_MASK)];
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(0x1234));
    }
}
