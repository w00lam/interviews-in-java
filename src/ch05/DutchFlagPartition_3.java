package ch05;

import java.util.Collections;
import java.util.List;

/**
  * 시간 복잡도: O(n)
  * 공간 복잡도: O(1)
  */
public class DutchFlagPartition_3 {
    public static enum Color {RED, WHITE, BLUE}

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        /**
         * 분류할 때마다 다음 불변식을 만족해야 한다.
         * 피벗보다 작은 원소 그룹: A.subList(0, smaller)
         * 피벗과 같은 원소 그룹: A.subList(smaller, equal)
         * 미분류 원소 그룹: A.subList(equal, larger)
         * 피벗보다 큰 원소 그룹: A.subList(lager, A.size())
         */
        int smaller = 0, equal = 0, larger = A.size();
        // 분류되지 않은 원소가 있는 동안 계속 순회한다.
        while (equal < larger) {
            // A.get(equal)는 분류되지 않은 원소를 가르킨다.
            if (A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else { // A.get(equal) > pivot
                Collections.swap(A, equal, --larger);
            }
        }
    }
}