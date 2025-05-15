package ch04;

// n : 입력 비트의 길이
// 시간 복잡도 : O(n)
public class ClosestIntSameBitCount_1 {
    public static long closestIntSameBitCount(long x) {
        final int NUM_UNSIGNED_BITS = 63;
        // x를 음이 아닌 정수라고 가정했으므로 맨 앞 비트는 0이라는 사실을 알 수 있다.
        // 그러니 63의 최하위 비트에만 집중하도록 하자.
        for (int i = 0; i < NUM_UNSIGNED_BITS - 1; i++) {
            if (((x >>> i) & 1) != ((x >>> (i + 1)) & 1)) {
                x ^= (1L << i) | (1L << (i + 1)); // i번째 비트와 (i + 1)번째 비트를 스왑한다.
                return x;
            }
        }

        // x의 모든 비트가 0이거나 1이면 오류룰 반환한다.
        throw new IllegalArgumentException("All bits are 0 or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestIntSameBitCount(0x1234));
    }
}
