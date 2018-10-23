package domain.raj.user.com.flagtest;

public class MainActivity {
    /*Pick start one element from array and compare with whole array
     * after compare move smallest element to position
     *
     * */
    private void sortSelection(int[] aarr) {
        int n = aarr.length;
        for (int i = 0; i < n - 1; i++) {
            int minitem = i;//choose element from outer array n compare with other element of array
            for (int j = 1; j < n; j++) {
                if (aarr[j] < aarr[minitem]) {
                    minitem = j;
                }
            }
            if (minitem != i) {
                int temp = aarr[i];
                aarr[i] = aarr[minitem];
                aarr[minitem] = temp;
            }
        }
    }

    /*Compare near two element*/
    private void sortBubble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // n - i - 1=stop iteration when cursor move to second last element other wise it will go
                // out of array
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void sortinsertion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int sec = i - 1;
            int key = arr[i];
            /*Sorting start from 0 to compare all other item so All data will arrange in sort */
            while (sec >= 0 && arr[sec] > key) {

                arr[sec + 1] = arr[sec];
                sec--;
            }
            arr[sec + 1] = arr[i];
        }
    }

    /*
     * Comparision between two branch of array
     * */
    private void sortmerge(int[] arr, int l, int m, int r) {
        int[] temp = new int[arr.length];
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[m + 1 + i];
        }


        int j = 0, k = 0, tempcount = l;
        /*
        Two halves are already sorted so when compare item
        between them just compare and put small element in temp array
        * */
        while (j < n1 && k < n2) {
            if (arr1[j] < arr2[k]) {
                temp[tempcount] = arr1[j];
                j++;

            } else {
                temp[tempcount] = arr2[k];
                k++;
            }
            tempcount++;

        }
        /*One small value list will reach to end so other item list will left to fill
           *
            *
            * */
        while (j < n1) {
            temp[tempcount] = arr1[j];
            j++;
            tempcount++;
        }
        while (k < n2) {
            temp[tempcount] = arr2[k];
            k++;
            tempcount++;
        }

    }

    private void branching(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            branching(arr, l, m);
            branching(arr, m + 1, r);
            sortmerge(arr, l, m, r);
        }
    }

    private int partitionquick(int arr[], int low, int high) {
        int n = arr.length;
        int highpo = arr[arr.length - 1];//last element as pivot
        int swapincreas = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[high]) {
                swapincreas++;
                ///swap item arr[swapincreas]  and arr[i]
            }
        }
        int temp = arr[swapincreas + 1];
        arr[swapincreas + 1] = arr[high];
        arr[high] = temp;
        return 1;//1/i+1
    }
}
