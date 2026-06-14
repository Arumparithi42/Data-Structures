/* Applications of Dynamic Arrays:
(same as arrays)
Handling data whose size is unknown.
Implemented in C++ vectors, Java ArrayLists and python list.
Storing dynamically growing collections such as playlists (e.g song playlist), browser history, and social media data (posts, comments).
Building flexible data structures as in arrays. */

class Array{
    private int capacity = 3;
    private int[] array = new int[capacity];
    private int size = 0;

    void resize(){
        capacity = 2 * capacity;
        int[] dummyArray = new int[capacity];
        // copying
        System.arraycopy(array, 0, dummyArray, 0, size);
        array = dummyArray; // note : in java, arrays are object reference
    }

    void insert(int element,int index){
        
        if (index >= 0 && index <= size){
            if (size < capacity){
                resize();
            }
            for(int i = size - 1; i >= index; i-- ){
                array[i + 1] = array[i];
            }
            array[index] = element;
            size++;
        }
        else{
            System.out.println("Cannot be inserted : Invalid index");
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
            System.out.println("Cannot be deleted : Invalid index");
        }
    }
    int search(int element){
        for(int i = 0; i < size; i++){
            if (array[i] == element){
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }
    void update(int element, int index){
        if (index <= size && index >= 0){
            array[index] = element;
        }
        else{
            System.out.println("Cannot be updated : Invalid index");
        }
    }
    int get(int index){
        if (index <= size && index >= 0){
            return array[index];
        }
        else{
            System.out.println("Index is not valid");
            return -1;
        }
    }
    void display(){
        for(int i = 0; i <= size; i++){
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

*/
public class DynamicArrays {
    public static void main(String[] args) {
        Array arr = new Array();
        arr.insert(4,0);
        arr.insert(3,1);
        arr.insert(6,2);
        arr.insert(7,1);

        arr.display();
        arr.insert(30,1);
        arr.display();
        arr.delete(0);
        arr.display();

    }

}