public class bubbleSort {
    public  void sort (int[] array){
        for (int i =0 ; i<array.length;++i){
            for (int j=1 ; j< array.length;++j){
                if (array[j]< array[j-1]){
                    var temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }

            }
        }
    }

}
