package ch04;

// 시간 복잡도 : O(1)
public class IntersectRectangle {
    public static class Rectangle {
        private final int x, y, width, heigh;

        public Rectangle(int x, int y, int width, int heigh) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.heigh = heigh;
        }
    }

    public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
        if (!isIntersect(R1, R2)) {
            return new Rectangle(0, 0, -1, -1); // 겹치지 않는다
        }
        return new Rectangle(
                Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
                Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
                Math.min(R1.y + R1.heigh, R2.y + R2.heigh) - Math.max(R1.y, R2.y));
    }

    public static boolean isIntersect(Rectangle R1, Rectangle R2) {
        return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x
                && R1.y <= R2.y + R2.heigh && R1.y + R1.heigh >= R2.y;
    }

    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(1, 2, 3, 4);
        Rectangle R2 = new Rectangle(5, 3, 2, 4);
        System.out.println(intersectRectangle(R1, R2));
    }
}
