public class Strings {

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static String toUpperCase(String str) {
        StringBuilder st = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        st.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                st.append(str.charAt(i));
                i++;
                st.append(Character.toUpperCase(str.charAt(i)));
            } else {
                st.append(str.charAt(i));
            }
        }

        return st.toString();
    }

    public static String compressString(String str) {
        StringBuilder st = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            st.append(str.charAt(i));
            if (count > 1) {
                st.append(count);
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {

        // String str = "racear";
        // String path = "WNEENESENNN";
        String fruits[] = { "apple", "mango", "banana" };
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }

        }
        System.out.println(largest);

        // String str2 = "hi, i am shardha";
        String compress = "aaabbcccdd";

        System.out.println(compressString(compress));

    }
}
