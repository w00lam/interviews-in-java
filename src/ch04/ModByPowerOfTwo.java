package ch04;

// x mod '2의 거듭제곱'을 계산하라.
// 예를 들어, 77 mod 64는 13을 반환한다.
public class ModByPowerOfTwo {
    public static int modByPowerOfTwo(int x, int n) {
        return x & (n - 1);
    }

    public static void main(String[] args) {
        System.out.println(modByPowerOfTwo(77, 64));
    }
}
