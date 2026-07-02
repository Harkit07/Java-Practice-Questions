public class Pattern {

  public static void hollowRec(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print(" *");
        } else {
          System.out.print("  ");

        }
      }
      System.out.println();

    }
  }

  public static void halfPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (n - i); j++) {
        System.out.print("  ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
  }

  public static void halfPyramidPattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (n - i + 1); j++) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

  public static void floidTraPattern(int n) {
    int num = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(num + " ");
        num++;
      }
      System.out.println();
    }
  }

  public static void zeroOneTriangle(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print(" 1");
        } else {
          System.out.print(" 0");

        }
      }
      System.out.println();
    }
  }

  public static void solidRombus(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print("  ");
      }
      for (int j = 1; j <= n; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
  }

  public static void hollowRombus(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print("  ");
      }
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print(" *");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void butterflyPattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");
      }
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print("  ");

      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }

    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");

      }
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print("  ");

      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" *");
      }
      System.out.println();

    }
  }

  public static void daimondPattern(int n) {
    for (int i = 1; i <= n; i++) {
      // Spaces
      for (int j = 1; j <= n - i; j++) {
        System.out.print("  ");
      }
      // Stars
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print("  ");
      }
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
  }

  public static void main(Strings[] args) {

    daimondPattern(4);
  }
}
