package ch04;

// k : 1로 세팅된 비트의 개수
// 시간 복잡도 : O(k)
public class Parity_2 {
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1); // x의 하위 비트를 지운다.
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parity(0b10001010));
    }
}
