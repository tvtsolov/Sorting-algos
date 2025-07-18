public class Main {

    public static void main(String[] args) {
        // Quick sort
        // Average O(n log(n))
        // Worst case O{n^2} if already sorted
        // space complexity O(log(n)) due to the recursion

        int[] array = {3,5,6,7,1,2,5,2};

        //quickSort(array, 0, array.length - 1);
        insertionSort(array);

        for(int i : array){
            System.out.println(i + "");
        }


    }

    private static void quickSort(int[] array, int start, int end){

        if(end <= start){
            return ;                //base case
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);

    }

    private static int partition(int[] array, int start, int end){

        int pivot = array[end];  // this can be improved by selecting another value to reduce the change of worst case scenario
        int i = start - 1;

        for (int j = start; j <= end -1; j++){
          if (array[j] < pivot){
              i++;
              int temp = array[i];
              array[i] = array[j];
              array[j] = temp;
          }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    private static void insertionSort(int[] arr) {
        // Mutates elements in arr by inserting out of place elements into appropriate
        // index repeatedly until arr is sorted
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                // Swap elements that are out of order
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex -= 1;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        // Mutates arr so that it is sorted via selecting the minimum element and
        // swapping it with the corresponding index
        int min_index;
        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap current index with minimum element in rest of list
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

}
