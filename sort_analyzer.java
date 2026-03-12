import java.util.Random;
import java.util.Scanner;

public class sort_analyzer {

        public static int[] generateRandomArray(int size) {
            Random rand = new Random();
            int[] array = new int[size];

            for(int i = 0; i < size; ++i) {
                array[i] = rand.nextInt(10000);
            }

            return array;
        }

        public static void bubbleSort(int[] array) {
            for(int i = 0; i < array.length - 1; ++i) {
                for(int j = 0; j < array.length - i - 1; ++j) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }

        }

        public static void selectionSort(int[] array) {
            for(int i = 0; i < array.length - 1; ++i) {
                int minIndex = i;

                int j;
                for(j = i + 1; j < array.length; ++j) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }

                j = array[minIndex];
                array[minIndex] = array[i];
                array[i] = j;
            }

        }

        public static void printArray(int[] array) {
            for(int i = 0; i < array.length; ++i) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }

        public static double measureSortTime(int size, boolean useBubbleSort) {
            long totalTime = 0L;

            for(int i = 0; i < 1000; ++i) {
                int[] array = generateRandomArray(size);
                long startTime = System.nanoTime();
                if (useBubbleSort) {
                    bubbleSort(array);
                } else {
                    selectionSort(array);
                }

                long endTime = System.nanoTime();
                totalTime += endTime - startTime;
            }

            return (double)totalTime / 1000.0;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of elements (500, 2500, 5000): ");
            int n = scanner.nextInt();
            double avgBubbleSortTime = measureSortTime(n, true);
            double avgSelectionSortTime = measureSortTime(n, false);
            System.out.println("Average Bubble Sort Time for " + n + " elements: " + avgBubbleSortTime + " ns");
            System.out.println("Average Selection Sort Time for " + n + " elements: " + avgSelectionSortTime + " ns");
        }
    }



