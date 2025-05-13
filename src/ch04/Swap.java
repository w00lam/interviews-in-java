package ch04;

// 시간 복잡도 : O(1)
public class Swap {
    public static long swapBits(long x, int i, int j) {
        // i번째 비트와 j번째 비트가 다른지 확인한다.
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // i번째 비트와 j번째 비트가 다르다면, 각 비트를 뒤집어서 스왑을 구현한다.
            // bitMask를 사용해서 뒤집을 비트를 선택한다. x = 1일 때 x^1 = 0을 만족하고,
            // x = 0일 때 x^1 = 1을 만족하므로, XOR을 사용해서 비트를 뒤집을 수 있다.
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(swapBits(0b10101010111, 3, 6));
    }
}
