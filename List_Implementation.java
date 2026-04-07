
package Linked_list;
import java.util.Iterator;
import java.util.Scanner;
class DynamicArray<T> implements Iterable <T> {
	private static final int initial_capacity = 5 ;
	private T arr[];
	private int size ;
	private int capacity ;
	@SuppressWarnings("unchecked")
	DynamicArray() {
		size = 0;
		arr = (T[]) new Object[initial_capacity];
		capacity = initial_capacity;
	}
	public void add(T val) {
		if(size == capacity) {
			ExpandArray();
		}
		arr[size++] = val;
	}
	private void ExpandArray() {
		capacity *= 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}
	public void display() {
		for(int i = 0 ; i < size ; i ++) {
			System.out.print(arr[i] + ",");
		}
	}
	public void InsertAtPos(int pos,T val) {
		if(pos < 0 || pos > size) {
			System.out.print("invalid position");
			return;
		}
		if(size == capacity) {
			ExpandArray();                                       
		}
		for(int i = size-1 ; i >= pos ; i--){
			arr[i+1] = arr[i];
	    }
		arr[pos] = val;
		size++;
	}
	public void deleteAtPos(int pos) {
		for(int i = pos+1 ; i < size ; i++) {
			arr[i-1] = arr[i];
		}
		size--;
		if(capacity > initial_capacity && capacity > 3*size) {
			ArrayShrink();
		}
	}
	private void ArrayShrink() {
		capacity /= 2;
		arr = java.util.Arrays.copyOf(arr , capacity);
	}
	public int length() {
		return size;
	}
	@Override
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			
			int index = 0;
			public T next() {
				if(!hasNext()) {
					throw new java.util.NoSuchElementException();
				}
				return arr[index++];
				
			}
			@Override
			public boolean hasNext() {
				return index < size;
			}
			
		};
	}
}

public class List_Implementation {

	public static void main(String[] args) {
		DynamicArray<Integer> list = new DynamicArray<Integer>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("\n_____________list menu_____________\n");
			System.out.println("1.Insert An data\n");
			System.out.println("2.Display The List\n");
			System.out.println("3.Insert At Specificied Position\n");
			System.out.println("4.Delete At Specified Position\n");
			System.out.println("5.Exit\n");
			System.out.println("6.Length of The Array");
			System.out.println("\n___________________________________\n");
			System.out.println("Enter Your Choice: \t ");
			int choice = scan.nextInt();
			int val,pos;
			switch(choice) {
			case 1:System.out.print("Enter The data:");
			       val = scan.nextInt();
			       list.add(val);
			       break;
			case 2:list.display();
			   for(Integer T : list) {
		    	    System.out.print(T + " ");
		    	}
		
			       break;
			case 3:System.out.print("enter the pos(starting from 0):");
			       pos = scan.nextInt();
			       if(pos < 0) {
			    	   System.out.print("invalid position");
			       }
			       System.out.print("enter the value:");
			       val = scan.nextInt();
			       list.InsertAtPos(pos , val);
			       break;
			case 4:System.out.print("Enter The pos(start at 0):");
			       pos = scan.nextInt();
			       if(pos<0) {
			    	   System.out.print("invalid position");
			       }
			       list.deleteAtPos(pos);
			       break;
			case 5:System.exit(0);   
			case 6:int result = list.length();
			       System.out.print(result);
			    
			//default:System.out.print("invalid choice");
			
			}
			
		}		

	}

}