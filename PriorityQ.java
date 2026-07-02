import java.util.*;

public class PriorityQ {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            // return this.rank - s2.rank;
            return s2.rank - this.rank;
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int dist, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void nearByCars(int pts[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];

            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }

    // adding ropes
    public static void addingRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += (min1 + min2);
            pq.add(min1 + min2);
        }
        System.out.println("Total Cost =" + cost);
    }

    // Soliders
    static class Row implements Comparable<Row> {
        int sol;
        int i;

        public Row(int sol, int i) {
            this.sol = sol;
            this.i = i;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.sol == r2.sol) {
                return this.i - r2.i;
            } else {
                return this.sol - r2.sol;
            }
        }
    }

    public static void soliders(int rows[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < rows.length; i++) {
            int count = 0;
            for (int j = 0; j < rows[0].length; j++) {
                count += rows[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().i);
        }
    }

    // K windows
    static class Pair implements Comparable<Pair> {
        int val;
        int i;

        public Pair(int val, int i) {
            this.val = val;
            this.i = i;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void maxWindows(int arr[], int k) {
        int res[] = new int[arr.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().i <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // pq.add(new Student("a", 2));
        // pq.add(new Student("b", 6));
        // pq.add(new Student("c", 7));
        // pq.add(new Student("d", 32));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.remove().name);
        // }

        // int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        // nearByCars(pts, 2);

        // int ropes[] = { 2, 3, 3, 4, 6 };
        // int ropes[] = { 4, 3, 2, 6 };
        // addingRopes(ropes);

        // int rows[][] = { { 1, 0, 0, 0 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 } };

        // soliders(rows, 2);

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        maxWindows(arr, 3);

    }
}
