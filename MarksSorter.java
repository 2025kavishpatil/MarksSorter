import java.util.Arrays;
import java.util.Scanner;

public class MarksSorter {

    // Selection Sort: repeatedly pick the minimum of the unsorted part
    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
    }

    // Insertion Sort: insert each element into its place in the sorted part
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void display(String label, int[] a) {
        System.out.println(label + Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = null;
        int choice;

        do {
            System.out.println("\n===== STUDENT MARKS SORTER =====");
            System.out.println("1. Enter marks");
            System.out.println("2. Sort using Selection Sort");
            System.out.println("3. Sort using Insertion Sort");
            System.out.println("4. Display original marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Number of students: ");
                    int n = sc.nextInt();
                    if (n <= 0) {
                        System.out.println("Number must be positive.");
                        break;
                    }
                    marks = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Marks of student " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }
                    System.out.println("Marks stored.");
                    break;

                case 2:
                case 3:
                    if (marks == null) {
                        System.out.println("Please enter marks first (option 1).");
                        break;
                    }
                    int[] copy = marks.clone();   // keep the original unchanged
                    if (choice == 2) {
                        selectionSort(copy);
                        System.out.println("Sorted using Selection Sort:");
                    } else {
                        insertionSort(copy);
                        System.out.println("Sorted using Insertion Sort:");
                    }
                    display("Ascending order: ", copy);
                    break;

                case 4:
                    if (marks == null) System.out.println("No marks entered yet.");
                    else display("Original marks: ", marks);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
