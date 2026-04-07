// added generic "DT"
//Iterator do access value in list
//linked list

package Linked_list;
import java.util.Iterator;

class CustomLinkedList<DT> implements Iterable<DT>{
	node head;
	
	class node{
		DT data;
		node next;

		node(DT val){
			data = val;
			next = null;
		}
	}
	CustomLinkedList(){
		head = null;
	}
	
	public void InsertAtBeginning(DT val) {
		node Newnode = new node(val);
		Newnode.next = head;
		head = Newnode;
		
	}
   
	public void InsertAtEnd(DT val) {
		node Newnode = new node(val);
		if(head == null) {
			head = Newnode;
			return;
		}
		node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = Newnode ;
	}
	
	public void display() {
		node temp = head;
		while(temp != null) {
			System.out.print(temp.data +"  ");
			temp = temp.next;
		}
		//System.out.print("null");
    }
	
	public void InsertAtpos(int pos , DT val) {               
		node Newnode = new node(val);                                  
		if(pos == 0) {
			InsertAtBeginning(val);
			return;
		}
		else {
			node temp = head;
			for(int i = 1 ; i < pos ; i ++) {
				temp = temp.next;
				if(temp == null) {
					throw new IndexOutOfBoundsException("invalid position:" + pos);
				}
			}
			Newnode.next = temp.next;
			temp.next = Newnode;
			
		}
	}
	
	public int length() {
		if(head == null) {
			System.out.print("list is empty");
		}
		int count = 0;
		node temp = head;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public void DeleteAtPos(int pos) {
		if(head == null) {
			throw new IndexOutOfBoundsException("Deletion Attempted On Empty List");	
		}
		if(pos == 0) {
			head = head.next;
			return;
		}
		node temp = head;
		node prev = null;
		for(int i = 1 ; i < pos ; i++) {
			if(temp.next == null) {
				throw new IndexOutOfBoundsException("Invalid Position");
			}
			prev = temp;
			temp = temp.next;
		}
		if(temp.next == null) {
			throw new IndexOutOfBoundsException("Invalid Position");
		}
		
		prev.next = temp.next;
	}
	
	public void DeleteAtBeginning() {
		if(head == null) {
			throw new IndexOutOfBoundsException("Deletion Attempted On Empty List");	
		}
		
		head = head.next;
	}
	
	public DT GetIndex(int pos) {						
		node temp = head;								
		for(int i = 0 ; i < pos ; i++) {
			if(temp == null) {
				throw new IndexOutOfBoundsException("The entered index is out of bound");
			}
			temp = temp.next;
		}
		
		return temp.data;
	}
	
	public void UpdateAtpos(int pos , DT val) {
		node temp = head;
		if(pos < 0) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		for(int i = 0 ; i < pos ; i++) {
			if(temp == null) {
				throw new IndexOutOfBoundsException("Invalid position");
			}
			temp = temp.next;
			
		}
		if(temp == null) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		temp.data = val;
		
	}
	
	public boolean Containsvalue(DT val) {
		node temp = head;
		while(temp != null) {
			if(temp.data.equals(val)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public int SearchValue(DT val) {
		node temp = head;
		int index = 0;
		while(temp != null) {
			if(temp.data.equals(val)) {
				return index;
			}
			temp = temp.next;
			index++;
		}
		return -1;
	}
	@Override
	public 	Iterator<DT> iterator(){
		return new Iterator<DT>() {
			node temp = head;
			
			@Override
			public boolean hasNext() {
				return temp != null;
			}
			
			public DT next() {
				if(temp == null) {
					throw new java.util.NoSuchElementException();
				}
				DT val = temp.data;
				temp = temp.next;
				return val;
			}
		};
		
	}
}

public class LinkedList {

	public static void main(String[] args) {
		CustomLinkedList<Integer> List = new CustomLinkedList<Integer>();
		
		List.InsertAtBeginning(7);
		List.InsertAtBeginning(3);
		
		List.InsertAtEnd(14);
		List.InsertAtEnd(5);
		
		List.InsertAtpos(1 , 2);
		List.InsertAtpos(2 , 9);
		
		System.out.print("\n");
		List.display();
		System.out.print("\n");
		System.out.print("length : " + List.length());
		List.DeleteAtPos(2);
		
		System.out.print("\n");
		List.display();
		System.out.print("\n");
		System.out.print("value At The index :"+List.GetIndex(2));	
		System.out.print("\n");
		List.UpdateAtpos(2 , 10);
		List.display();	
		
		System.out.print("\n");
		System.out.print("length : " + List.length());
		System.out.print("\n");
		System.out.print("Value Status : " + List.Containsvalue(10));
		System.out.print("\n");
		System.out.print("The Index Of An Entered Value : " + List.SearchValue(10));
		System.out.print("\n");
		for(int a : List) {
			System.out.print(a + " ");
		}
	}

}