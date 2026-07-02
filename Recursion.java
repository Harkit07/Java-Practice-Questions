public class Recursion {

    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int printFact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * printFact(n - 1);
    }

    public static int calSum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + calSum(n - 1);
    }

    public static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fab(n - 1) + fab(n - 2);
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurance(arr, key, i + 1);
    }

    public static int lastOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static int optimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPow = optimizedPower(x, n / 2);
        int halfPowSq = halfPow * 2;

        if (n % 2 == 0) {
            halfPowSq *= x;
        }

        return halfPowSq;
    }

    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }

    public static void removeDupilate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDupilate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDupilate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }

    public static void printBinaryStr(int n, int lastdigit, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinaryStr(n - 1, 0, str + "0");
        if (lastdigit == 0) {
            printBinaryStr(n - 1, 1, str + "1");

        }
    }

    // Merge sort
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    // Quick sort using Pivot
    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int Idx = partition(arr, si, ei);

        quickSort(arr, si, Idx - 1);
        quickSort(arr, Idx + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    // Search in Rotated and sorted array
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == tar) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                return search(arr, tar, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {

        // System.out.println("hello");
        // printDec(5);

        // System.out.println();
        // printInc(5);

        // System.out.println();
        // System.out.println(printFact(5));

        // System.out.println(calSum(5));

        // System.out.println(fab(5));

        // int arr[] = { 1, 2, 3, 4, 3 };
        // System.out.println(isSorted(arr, 0));

        // System.out.println(firstOccurance(arr, 3, 0));

        // System.out.println(lastOccurance(arr, 3, 0));

        // System.out.println(power(3, 3));

        // System.out.println(power(2, 5));

        // System.out.println(tilingProblem(5));

        // String str = "apnacollege";
        // removeDupilate(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(3));

        // printBinaryStr(3, 0, "");

        // int arr[] = { 6, 3, 9, 5, 2, 8 };
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        int arr[] = { 4, 5, 6, 7, 1, 2, 3 };
        System.out.println(search(arr, 3, 0, arr.length - 1));

    }
}