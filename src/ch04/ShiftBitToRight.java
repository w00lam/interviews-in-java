package ch04;

// x에서 가장 오른쪽에 설정된 비트를 오른쪽으로 전달하라.
// 예를 들면, 01010000은 01011111이 된다.
public class ShiftBitToRight {
    public static String moveRight(long x) {
        return Integer.toBinaryString((int) (x | (x ^ (x - 1))));
    }

    public static void main(String[] args) {
        System.out.println(moveRight(0b01010000));
    }
}
