package ch05;

import java.util.Collections;
import java.util.List;

/**
 * 시간 복잡도: O(n^2)
 * 공간 복잡도: O(1)
 */
public class DutchFlagPartition_1 {
    public static enum Color {RED, WHITE, BLUE}

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        // 첫 번째 단계: 피벗보다 작은 원소의 그룹을 구한다.
        for (int i = 0; i < A.size(); i++) {
            //작은 원소를 찾는다.
            for (int j = i + 1; j < A.size(); ++j) {
                if (A.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
        // 두 번째 단계 피벗보다 큰 원소의 그룹을 구한다.
        for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
            // 큰 원소를 찾는다. 피벗보다 작은 원소에 맞닥뜨리게 되면 즉시 멈춘다.
            // 왜냐하면 윗 단계에서 피벗보다 작은 원소들은 이미 A의 앞쪽으로 옮겨졌기 때문이다.
            for (int j = i - 1; j >= 0 && A.get(j).ordinal() >= pivot.ordinal(); --j) {
                if (A.get(i).ordinal() > pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
    }
}
