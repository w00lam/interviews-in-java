package ch04;

// 시간 복잡도 : O(n)
// 단, 시프트 연산과 덧셈 연산의 시간 복잡도는 O(1)이라고 가정
public class Divide {
    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }

            result += 1 << power;
            x -= yPower;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(0b1111, 0b0101));
    }
}
