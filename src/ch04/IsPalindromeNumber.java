package ch04;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(1)
public class IsPalindromeNumber {
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        int msdMask = (int) Math.pow(10, numDigits - 1);
        for (int i = 0; i < (numDigits / 2); i++) {
            if (x / msdMask != x % 10) {
                return false;
            }
            x %= msdMask; // x의 최상위 숫자를 삭제한다.
            x /= 10; // x의 최하위 숫자를 삭제한다.
            msdMask /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(2147447412));
    }
}
