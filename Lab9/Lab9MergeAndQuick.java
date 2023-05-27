package Lab202;

public class Lab9MergeAndQuick {

	public static void main(String[] args) {
		int arr[] = {5, 8, 1, 3, 9, 4, 2};
		
		mergeSort(arr, 0, arr.length-1);
		System.out.print("Merge sorted array: ");
        printArray(arr);
        
        System.out.println();
        
        int arr1[] = {5, 8, 1, 3, 9, 4, 2};
        
        quickSort(arr1, 0, arr1.length-1);
        System.out.print("Quick sorted array: ");
        printArray(arr1);
        
        
	}
	//O(n log n)
	public static void mergeSort(int arr[], int left, int right)
    {
        if (left < right) {
            int m = left + (right - left)/2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }
	
	public static void merge(int arr[], int left, int m, int right){
        
        int n1 = m-left+1;
        int n2 = right-m;
        int arrL[] = new int[n1];
        int arrR[] = new int[n2];
        
        for (int i = 0; i < n1; ++i) {
            arrL[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            arrR[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (arrL[i] <= arrR[j]) {
                arr[k] = arrL[i];
                i++;
            }
            else {
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = arrL[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }
	
	//O(n log n)
	public static void quickSort(int arr[], int low, int high){
        if (low < high) {
            int i = partition(arr, low, high);
 
            quickSort(arr, low, i-1);
            quickSort(arr, i+1, high);
        }
    }
    
	
    public static int partition(int arr[], int low, int high){
        int p = arr[high];
        int i = low-1;
        
        for (int j=low; j<high; j++){
            if (arr[j] <= p){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
 
	

}
