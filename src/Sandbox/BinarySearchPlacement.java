package Sandbox;

/**
 * Within a given array find the index where a binary value should be inserted.
 * Used on 4/23/18 for CSE 306 Project 3: Devices - Shortest Seek Time First
 * to dequeue IORB(I/O request buffer) object that is closest to where the head
 * pointing to cylinders is at the time.
 * */
public class BinarySearchPlacement {
    private static int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    public static void main(String[] args)
    {
        int index = binarySearchSort(array, 65, 0, array.length);
        System.out.println("Inserted index is at " + index);
    }

    private static int binarySearchSort(int array[], int value, int left, int right)
    {
        if(right > left)
        {
            int mid = (left + right - 1) / 2;
            if(array[mid] == value) return mid;
            if(array[mid] > value) return binarySearchSort(array, value, left, mid - 1);
            else return binarySearchSort(array, value, mid + 1, right);
        }
        return left;
    }


}
