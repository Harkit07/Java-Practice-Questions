public class Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // public static void insert(String str) {
    // Node curr = root;
    // for (int i = 0; i < str.length(); i++) {
    // int idx = str.charAt(i) - 'a';
    // if (curr.children[idx] == null) {
    // curr.children[idx] = new Node();
    // } else {
    // curr.children[idx].freq++;
    // }
    // curr = curr.children[idx];
    // }
    // curr.eow = true;
    // }

    public static boolean search(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String str) {
        if (str.length() == 0) {
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            if (search(str.substring(0, i)) && wordBreak(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void findPrefix(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static boolean startsWith(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // String str[] = { "the", "a", "there", "their", "any", "thee" };
        // for (int i = 0; i < str.length; i++) {
        // insert(str[i]);
        // }
        // System.out.println(search("the"));
        // System.out.println(search("th"));

        // String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }
        // String key = "ilikesamsung";

        // System.out.println(wordBreak(key));

        // String arr[] = { "zebra", "dog", "duck", "dove" };
        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }

        // root.freq = -1;
        // findPrefix(root, "");

        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // String prefix1 = "app";
        // String prefix2 = "moon";

        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }
        // System.out.println(search(prefix1));
        // System.out.println(search(prefix2));

        // String str = "ababa";

        // for (int i = 0; i < str.length(); i++) {
        // String suffix = str.substring(i);
        // insert(suffix);
        // }
        // System.out.println(countNodes(root));

        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
