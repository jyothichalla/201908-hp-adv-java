package in.conceptarchitect.util.collection;

public class LinkedList {
	class Node {
	
		public int value;
		public Node next;
		public Node previous;
	}
	Node first;
	int count;
	Node last;
	
	public int size() {
		
//		int count=0;
//		for(Node n=first;n!=null;n=n.next)
//			count++;
		
		return count;
		
	}
	
	public void add(int value) {
		//Step 1. create a new node
		Node newNode=new Node();
		newNode.value=value;
		newNode.next=null; //this will be the last node
		
		//Step 2. find the last node
//		Node last=first;
//		if (last!=null)
//			while(last.next!=null)
//				last=last.next;
		
		//Step 3. fix newNode into the list
		newNode.previous=last; //current last will come before newNode
		if(first==null) //list is currently empty
			first=newNode; 
		else
			last.next=newNode; //newNode comes next to last Node
		
		last=newNode;
		count++;
	}	
	public String toString() {
		String str="LinkedList(\t";
		
		for(Node n=first; n!=null;n=n.next)
			str+=n.value+"\t";
		
		str+=")";
		
		return str;
	}
	
	public int get(int index) {
	
		Node n = _locate(index);
			
		return n.value;
	}
	private Node _locate(int index) {
		if(index<0 || index>=size())
			throw new IndexOutOfBoundsException(index);
		
		Node n=first;
		for(int i=0;i<index;i++)
			n=n.next;
		return n;
	}
	
	
	public void set(int index, int value) {
		
		Node n = _locate(index);
		
		n.value=value;
		
	}
	public void remove(int index) {
		
		Node n= _locate(index);
		
		if(n==first)
			first=n.next;
		else
			n.previous.next=n.next;
		
		if(n.next!=null) //not the last node
			n.next.previous=n.previous;
			
		//del n; //--> java gc will claim it
		
	}
	
	
	
	
	
}