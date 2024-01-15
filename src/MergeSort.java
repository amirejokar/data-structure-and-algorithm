public class MergeSort {
    public void sort ( int[]array){
        var mid = array.length/2;
        int[]left = new int[mid];
        for (int i=0; i<mid ;i++){
            left[i] = array[i];
        }
        int[]right = new int[array.length - mid];
        for (int j=mid; j<array.length - mid ;j++){
            right[j-mid] = array[j];
        }
        sort(left);
        sort(right);
        merge(array , left , right);
    }
    private void merge(int[]result , int[] left , int[] right){

        int i =0 , j=0 , k=0;
        while(i< left.length && j<right.length){
            if(left[i] <=right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i< left.length)
            result[k++] = left[i++];
        while (j< right.length)
            result[k++] = right[j++];
    }
}
