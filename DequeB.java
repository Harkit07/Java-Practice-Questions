import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DequeB {

    // static class Stack {
    // static Deque<Integer> deque = new LinkedList<>();

    // public static boolean isEmpty() {
    // return deque.isEmpty();
    // }

    // public static void push(int data) {
    // deque.addLast(data);
    // }

    // public static int pop() {
    // return deque.removeLast();
    // }

    // public static int peek() {
    // return deque.getLast();
    // }

    // }

    static class Queue {
        static Deque<Integer> deque = new LinkedList<>();

        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        public static void add(int data) {
            deque.addLast(data);
        }

        public static int pop() {
            return deque.removeFirst();
        }

        public static int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue s = new Queue();
        s.add(1);
        s.add(2);
        s.add(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }

    }
}
