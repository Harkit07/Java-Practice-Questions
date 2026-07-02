import java.util.HashMap;
import java.util.HashSet;

public class MapandSet {

    public static void majorityElement(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static int distinctElement(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        return hs.size();
    }

    public static void unionAndIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }

        System.out.println("Union elements =" + hs.size());

        hs.clear();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                count++;
                hs.remove(arr2[i]);
            }
        }
        System.out.println("Intersection elements =" + count);
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static int larSubarray0Sum(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {
                len = Math.max(len, j - hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        return len;
    }

    public static int subarraySumEqualK(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum - k)) {
                ans += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // majorityElement(arr);
        // String s = "rade";
        // String t = "care";
        // System.out.println(isAnagram(s, t));

        // int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // System.out.println(distinctElement(nums));

        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 6, 2, 4 };
        // unionAndIntersection(arr1, arr2);

        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("chennai", "bangluru");
        // tickets.put("mumbai", "delhi");
        // tickets.put("goa", "chennai");
        // tickets.put("delhi", "goa");

        // String start = getStart(tickets);
        // System.out.print(start);
        // for (String key : tickets.keySet()) {
        // System.out.print("-->" + tickets.get(start));
        // start = tickets.get(start);
        // }

        // int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        // int arr2[] = { 3, 4, 5 };
        // System.out.println(larSubarray0Sum(arr2));

        int arr[] = { 10, 2, -2, -20, 10 };
        System.out.println(subarraySumEqualK(arr, -10));
    }
}
