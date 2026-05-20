package sapxep;

public class myQuicksort {


    public static void swap(int a[],int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    public static int index(int a[], int left, int right){
        int poison  = a[left];
        int i =left; int j =right;
        while (i < j) { 
            while( i <= right && a[i] <= poison){
                i++;
            }
            while(j >= left && a[j] > poison){
                j--;
            }

            if(i > j){
                break;
            }
            swap(a,i,j);
        }
        swap(a, j, left);

        return j;
    }
    public static void quickSort(int a[], int left, int right){
       if(left < right){
            int p = index(a, left, right);
            
            quickSort(a, left, p-1);
            quickSort(a, p+1, right);

       }
    }
    public static void main(String[] agrs){
        int arr[] = new int[]{3,2,1};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
