package ch04;

// 시간 복잡도 : O(1)
// 더 고민해보기
public class ClosestIntSameBitCount_2 {
    /*public static long closestIntSameBitCount(long x) {
        final int NUM_UNSIGNED_BITS = 63;
        for (int i = 0; i < NUM_UNSIGNED_BITS - 1; i++) {
            if (((x >>> i) & 1) != ((x >>> (i + 1)) & 1)) {
                x ^= (1L << i) | (1L << (i + 1)); // i번째 비트와 (i + 1)번째 비트를 스왑한다.
                return x;
            }
        }
        
        throw new IllegalArgumentException("All bits are 0 or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestIntSameBitCount(0x1234));
    }*/
}
