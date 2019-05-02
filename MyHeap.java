public class MyHeap {

//swap needed
private static void swap(int[] data, int first, int second) {
  int og = data[first];
	data[first] = data[second];
  data[second] = og;
}


//- size  is the number of elements in the data array.
//- push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
//- precondition: index is between 0 and size-1 inclusive
//- precondition: size is between 0 and data.length-1 inclusive.
private static void pushDown(int[]data, int size, int index){ //RECURSIVE!!!
    int c1 = 2 * index + 1; //children
    int c2 = 2 * index + 2;
    int larger;
    if (c2 < size) { //if it has two children
      if (data[c2] > data[c1]) { //if second one is larger
        larger = c2; //set second child as larger
      }
      else {
         larger = c1; //otherwise set first child
      }
    }
    else {
      larger = c1; //if only one child set that as larger
    }

    if(larger < size && data[larger] > data[index]) { //if it isnt the end and child is bigger
      swap(data, index, larger); //swap
      pushDown(data, size, larger); //recursive
    }
}



//- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
//- precondition: index is between 0 and data.length-1 inclusive.
private static void pushUp(int[]data,int index) { //recursive
  int p = (index - 1) / 2;//parents
  	if (!(p < 0) && data[index] > data[p]) { //if number is bigger than parents and ur not at the top yet
  	    swap(data, index, p); //swap numbers
  	    pushUp(data, p); //continue to push the number up
  	}
}



//convert the array into a valid heap. [ should be O(n) ]
public static void heapify(int[] data){
  for (int i = data.length-1; i >= 0; i--) {
        pushDown(data, data.length, i);
  }
}


// sort the array [ should be O(nlogn) ] :
// converting it into a heap
// removing the largest value n-1 times (remove places at end of the sub-array).
public static void heapsort(int[] data) {

}

public static void main(String[] args) {
  int[] data = new int[] {1,90,40,30,60,51,80,20,50,91};
  System.out.println(heapprinter.toString(data));
  System.out.println();
  System.out.println();
  System.out.println();
  System.out.println();
  int size = data.length;
  heapify(data);
  System.out.println(heapprinter.toString(data));
}




}
