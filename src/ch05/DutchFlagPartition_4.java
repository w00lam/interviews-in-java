package ch05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 전체 키가 3개일 때, 키값이 같은 객체를 함께 등장하도록 재배치하라.
 * 부분 배열의 순서는 중요하지 않다.
 * 시간 복잡도는 O(n), 공간 복잡도는 O(1)이 되어야 한다.
 */
public class DutchFlagPartition_4 {
    public enum Color {RED, WHITE, BLUE}

    public static void dutchFlagPartition(List<Color> A) {
        Color pivot = A.getFirst();
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

    public static void main(String[] args) {
        List<Color> colors = new ArrayList<>() {{
            add(Color.WHITE);
            add(Color.RED);
            add(Color.RED);
            add(Color.WHITE);
            add(Color.WHITE);
            add(Color.BLUE);
            add(Color.BLUE);
            add(Color.RED);
            add(Color.BLUE);
        }};

        dutchFlagPartition(colors);
        System.out.println(colors);
    }
}
