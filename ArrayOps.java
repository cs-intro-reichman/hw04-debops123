public class ArrayOps {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int[] array2 = {1, 3, 5, 7, 9};
        
        System.out.println("Missing Int: " + findMissingInt(array));
        System.out.println("Second Max Value: " + secondMaxValue(array));
        System.out.println("Contains The Same Elements: " + containsTheSameElements(array, array2));
        System.out.println("Is Sorted: " + isSorted(array));
    }

    public static int findMissingInt(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int n = array.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = sumArray(array);

        return expectedSum - actualSum;
    }

    public static int secondMaxValue(int[] array) {
        if (array == null || array.length < 2) {
            return 0; 
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    // Check if two arrays contain the same elements
    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }

        if (array1.length != array2.length) {
            return false;
        }

        int[] sortedArray1 = copyAndSort(array1);
        int[] sortedArray2 = copyAndSort(array2);

        for (int i = 0; i < sortedArray1.length; i++) {
            if (sortedArray1[i] != sortedArray2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSorted(int[] array) {
        if (array == null || array.length < 2) {
            return true; 
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    private static int[] copyAndSort(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        bubbleSort(copy);
        return copy;
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}