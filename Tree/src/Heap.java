public class Heap {

    private int[] items = new int[10];

    private int size;

    public void insert(int value){
        items[size++] = value;

        var index = size-1;

        while (index>0 && items[index] > items[parent(index)]){
            swap(index , parent(index));
            index = parent(index);
        }

    }
    public int findIndex(int value){
        for (int i =0 ; i< items.length;++i){
            if(items[i]==value)
                return i;
        }
        return -1;
    }

    public void remove(int value){
        items[0] = items[--size];
        int index = 0;
        while ( index<=size &&items[index]<leftChild(index) && items[index]<leftChild(index)){
            var largerChildIndex = (leftChild(index)>rightChild(index))?
                    leftChildIndex(index):rightChildIndex(index);
            swap(index , largerChildIndex);
            index = largerChildIndex;
        }
    }
    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }
    private int leftChildIndex(int index){
        return (index*2) + 1;
    }
    private int rightChildIndex(int index){
        return (index*2) + 2;
    }
    private void swap(int first , int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    private int parent (int index){
        return (index-1)/2;
    }
    //amirejokar
}
