//Leonardo Mazuran
//CS 3200 Data Structures and Algorithms SUMMER16
//last modified: 1 June 2016
//start code (provided from book)
import java.util.Scanner;
public class SinglyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
					}
		public E getElement( ) { return element; }
		public Node<E> getNext( ) { return next; }
		
		public void setNext(Node<E> n) { next = n; }
	}
	private Node<E> head = null;
	
	private Node<E> tail = null;
	private int size = 0;
	public static String[] L = {"4", "3","2","1"};
	public static String [] M = {"6", "5"};
	
	public SinglyLinkedList( ) { }
	public int size( ) { return size; }
	
	//todo1
	//public Node <E> getHead() { return head;}
	//
	public boolean isEmpty( ) { return size == 0; }
	public E first( ) {
		if (isEmpty( )) return null;
		return head.getElement( );
	}
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty( ))
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	public E removeFirst( ) {
		if (isEmpty( )) return null;
		E answer = head.getElement( );
		head = head.getNext( );
		size--;
		if (size == 0)
		tail = null;
		return answer;
	}
//end of code (provided from book)
	//Task1
//display Head and all numbers
	public Node<E> getHead(){
	
		return head;
	}
//Task 2
//concarenate the list
	public void concatenateList (SinglyLinkedList<E> M)
	{
  
	Node<E> scan = M.getHead();
	tail.setNext(M.getHead());
	tail = tail.getNext();
    scan = scan.next;
      
		
	}
	//Task 3
//rotate the list
	public void rotate(){
		//addLast(removeFirst());
		tail.setNext(head);
		head = head.getNext();
		tail= tail.getNext();
		
		tail.setNext(null);
		
		
	}
	//Task4
// reverse the list
	public void reverse(){
		Node<E> r = null;
		while (head != null) {
		    Node<E> next = head.next;
		    head.next = r;
		    r = head;
		    head = next;
		}
		head =r;
		
		
	}
//Task 5
	// Main
private static Scanner input;
	public static void main (String[] args){
	while (true){
	int pick;
	input = new Scanner (System.in);
			SinglyLinkedList<String> list = new SinglyLinkedList<String>();
			SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		
		for (int i=0; i< L.length; i++)
		{
			list.addFirst(L[i]);
		
		}
		
		for (int i=0; i<M.length; i++)
		{
			list2.addFirst(M[i]); 
		}
		
		System.out.println("Pick a Number");
		System.out.println("1. getHead");
		System.out.println("2. rotate");
		System.out.println("3. reverse");
		System.out.println("4. concatenate");
		pick = input.nextInt();
		while (pick > 4 || pick < 1)
		{
			System.out.println("Incorrect Input, try again:");
			pick= input.nextInt();
		}
		switch (pick){
		case 1:
			list.getHead();
			System.out.println(list);
			break;
		
		case 2:
			list.rotate();
			System.out.println(list);
		case 3:
			list.reverse();
			System.out.println(list);
		case 4:
			list.concatenateList(list2);
			System.out.println(list);
			
		
		}
		}
		//list.concatenateList(list2);
		//System.out.print(list);
		//System.out.println("");
		//System.out.print("Rotate ");
		
		
		
		
	

	
		
		
	}
//task6
	// TOSTRING
		public String toString(){
			
			
			String result = "" ;
			
			while (head != null ){
				result = result + (head.getElement()).toString() + " " ;
			head =head.getNext();
				
			}
			return  result ;
			
			
		}
		
	
}