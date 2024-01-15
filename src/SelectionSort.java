public class SelectionSort {

    public void sort(int[] array){
        for (int i=0 ; i< array.length;++i){
            int minIndex=i;
            for (int j=i;j< array.length;++j){
                if (array[j] < array[minIndex])
                    minIndex = j;
                //swap(array , minIndex , i)
            }
        }
    }
}
