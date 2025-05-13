package ch04;

// x가 2의 거듭제곱인지 검사하라.
// 예를 들어, x = 1, 2, 4, 8, ...일 때는 true,
// 그 외의 값은 false로 평가한다.
public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }
}
