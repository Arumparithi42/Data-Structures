class Array{
    private final int capacity = 5;
    private int[] array = new int[capacity ];
    private int size = 0;

    void insert(int element,int index){
        if(index < 0 || index > size){
            System.out.println("Cannot be inserted : Invalid index");
            return;
        }
        if (size < capacity ){
            for(int i = size - 1; i >= index; i-- ){
                array[i + 1] = array[i];
            }
            array[index] = element;
            size++;
        }
        else{
            System.out.println("Cannot be inserted : Capacity full");
        }
    }
    void delete(int index){// deletion by index
        
        if (index <= size && index >= 0){
            for(int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            size--;
        }
        else{
            System.out.println("index exceeds size of the array");
        }
    }
    int search(int element){
        for(int i = 0; i < size; i++){
            if (array[i] == element){
                return i;
            }
        }
        return -1;
    }
    void update(int element, int index){
        if (index <= size && index >= 0){
            array[index] = element;
        }
        else{
             System.out.println("index exceeds size of the array");
        }
    }
    int get(int index){
        if (index < size && index >= 0){
            return array[index];
        }
        else{
            System.out.println("Index is not valid");
            return -1;
        }
    }
    void display(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
/*
Advantages :
1.Faster access using index
2. Efficient memory usage

Disadvantages :
1. Costly operation for insertion and deletion due to shifting of elements
2. Fixed size length

*/

public class Arrays{
    public static void main(String[] args) {
        Array arr = new Array();
        arr.insert(4,0);
        arr.insert(3,1);
        arr.insert(6,2);
        arr.insert(7,3);

        arr.display();
        arr.insert(30,1);
        arr.display();
        arr.delete(0);
        arr.display();

    }

}