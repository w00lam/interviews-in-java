package ch04;

import java.util.Random;

// 시간 복잡도 : O(log(b-a+1))
// 단, 0/1 숫자 생성기의 시간 복잡도를 O(1)로 가정한다.
public class UniformRandom {
    public static int zeroOneRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1, result;
        do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
                // zeroOneRandom()은 임의의 숫자를 생성하는 함수다.
                result = (result << 1) | zeroOneRandom();
            }
        } while (result > numberOfOutcomes);
        return result + lowerBound;
    }

    public static void main(String[] args) {
        System.out.println(uniformRandom(1, 6));
    }
}
