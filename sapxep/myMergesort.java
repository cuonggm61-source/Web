package sapxep;

public class myMergesort {


    public static  void merge(int a[], int first, int mid, int last){
        int n1 = mid - first + 1;
        int n2 = last - mid;

        int AL[] = new int[n1];
        int AR[] = new int[n2];

        for(int i =0; i < n1;++i){
            AL[i] = a[first + i];
        }

        for(int i =0; i < n2;++i){
            AR[i] = a[mid + i + 1];
        }

        int i =0; int j =0;
        int k = first;

        while( i < n1 && j < n2){
            if(AL[i] < AR[j]){
                a[k] = AL[i];i++;
            }else{
                a[k] = AR[j];j++;
            }
            k++;
        }
        while(i < n1){
            a[k] = AL[i];
            i++;
            k++;

        }
         while(j < n2){
            a[k] = AR[j];
            j++;
            k++;
        }
    }

    public static  void merge_sort(int a[], int first, int last){
        if(first < last){
            int mid = (last + first)/2;
            merge_sort(a, first, mid);
            merge_sort(a, mid + 1, last);
            merge(a, first,mid,last);
        }
    }
    public static void main(String[] agrs){
        int arr[] = new int[]{3,2,1,0,0,9,0,0,0};
        merge_sort(arr, 0, arr.length-1);
        for (int i  = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


}
