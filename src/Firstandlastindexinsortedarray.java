import java.util.Scanner;

public class Firstandlastindexinsortedarray {
    public static Scanner sc = new Scanner(System.in);
    public static int n, target;
    public static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        target = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n == 0||arr[0]>target||arr[n-1]<target) {
            System.out.println("Khong co");
        }else{
            if (arr[0] == target) {
                System.out.println("First element is 0");
            } else {
                System.out.println(binarySearchLeft(0, n - 1));
            }
            if (arr[n - 1] == target) {
                System.out.println("Last element is " + (n - 1));
            } else {
                System.out.println(binarySearchRight(0, n - 1));
            }
        }

    }

    public static int binarySearchLeft(int left, int right) {
        if (left == right) {
            if (arr[left] == target && arr[left - 1] < target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            if (arr[mid - 1] < target) {
                return mid;
            } else {
                return binarySearchLeft(left, mid - 1);
            }
        } else if (arr[mid] > target) {
            return binarySearchLeft(left, mid-1);
        } else if (arr[mid] < target) {
            return binarySearchLeft(mid + 1, right);
        }
        return -1;
    }

    public static int binarySearchRight(int left, int right) {
        if (left == right) {
            if (arr[left] == target && arr[left + 1] > target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            if (arr[mid + 1] > target) {
                return mid;
            } else {
                return binarySearchRight(mid + 1, right);
            }
        } else if (arr[mid] > target) {
            return binarySearchRight(left, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearchRight(mid + 1, right);
        }
        return -1;
    }
}
