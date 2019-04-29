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
  	if (!(c2 > size) && (data[index] < data[c1] || data[index] < data[c2])) { //go until child 2 is past the size (at the bottom) and it is less than one of its cildren
  		if (data[c1] > data[c2]) { //if child1
  		    swap(data, index, c1); //swap the numbers
  		    pushDown(data, size, c1); //continue to push the numbers down
  		}
      else {//child 2
  		    swap(data, index, c2);  //swap
  		    pushDown(data, size, c2);//continue to push numbers down
  		}
  	}
}



//- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
//- precondition: index is between 0 and data.length-1 inclusive.
private static void pushUp(int[]data,int index) {//RECURSIVE!!!
  int p = (index - 1) / 2;//parents
  	if (!(p < 0) && data[index] > data[p]) { //if number is bigger than parents and ur not at the top yet
  	    swap(data, index, p); //swap numbers
  	    pushUp(data, p); //continue to push the number up
  	}
}



//convert the array into a valid heap. [ should be O(n) ]
//public static void heapify(int[] data){

//}


// sort the array [ should be O(nlogn) ] :
// converting it into a heap
// removing the largest value n-1 times (remove places at end of the sub-array).
//public static void heapsort(int[] data) {

//}

public static void main(String[] args) {
  int[] data = new int[] {71,90,40,60,50,51,80,20,30,91};
  System.out.println(heapprinter.toString(data));
  System.out.println();
  System.out.println();
  System.out.println();
  System.out.println();
  int size = data.length;
  pushDown(data, size, 2);
  System.out.println(heapprinter.toString(data));
}




}
