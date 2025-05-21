package ch05;

import java.util.Collections;
import java.util.List;

/**
  * 시간 복잡도: O(n)
  * 공간 복잡도: O(1)
  */
public class DutchFlagPartition_2 {
    public static enum Color {RED, WHITE, BLUE}

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        // 첫 번째 단계: 피벗보다 작은 원소의 그룹을 구한다.
        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, i);
            }
        }
        // 두 번째 단계 피벗보다 큰 원소의 그룹을 구한다.
        int larger = A.size() - 1;
        for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
            if (A.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(A, larger--, i);
            }
        }
    }
}
