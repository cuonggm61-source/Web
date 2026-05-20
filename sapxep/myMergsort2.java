package sapxep;
public class myMergsort2 {
    public static void merge(int[]a, int first, int mid, int last){
        int n1 = mid - first + 1; 
        int n2= last - mid;

        int al[] = new int[n1];
        int ar[] = new int[n2];

        for(int i =0; i< n1; ++i){
            al[i] = a[first + i];
        }
        for(int i =0; i < n2; ++i){
            ar[i] = a[mid + 1 + i];
        }
        int i =0; int j =0;
        int k =0;
        while(i < n1 && j < n2){
            if(al[i] < ar[j]){
                a[k] = al[i]; i++;
            }else{
                a[k] = ar[j];j++;
            }
            k++;
        }
        if(i < n1){
            a[k] = al[i];
            i++;
            k++;

        }
         if(j < n2){
            a[k] = ar[j];
            j++;
            k++;
        }
    }
    public static void merge_sort(int [] a,int first, int last){
        if(first < last){
            int mid = (first+ last)/2;
            merge_sort(a, first, mid);
            merge_sort(a, mid +1, last);
            merge(a, first, mid, last);
        }


    }

    public static void main(String[] agrs){
        int []arr  = new int[]{ 3,1,2,3,5,6};
        merge_sort(arr, 0, arr.length-1);
        for(int i =0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }


}
