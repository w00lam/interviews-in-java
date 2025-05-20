package ch04;

import java.util.Arrays;

public class IsRectangle {
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isRectangle(Point p1, Point p2, Point p3, Point p4) {
        int[] x = {p1.x, p2.x, p3.x, p4.x};
        int[] y = {p1.y, p2.y, p3.y, p4.y};

        Arrays.sort(x);
        Arrays.sort(y);

        if (x[0] != x[1] || y[0] != y[1]) {
            return false;
        } else {
            return x[3] - x[0] == x[2] - x[1] && y[3] - y[0] == y[2] - y[1];
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(3, 4);

        System.out.println(isRectangle(p1, p2, p3, p4));
    }
}
