package Structures;

import java.util.Iterator;

public class CircularLinkedQueue<E> implements Queue<E>{

	// Fields for references to the front and rear nodes of this queue
	private Node<E> rear;        

	public CircularLinkedQueue(){ rear = null; }

	@Override
	public void enqueue(E element){
		Node<E> node = new Node<>(element, null);

		if (rear == null)
			node.setNext(node);

		node.setNext(rear);      
		rear = node;    
	}// end enqueue()

	@Override
	@SuppressWarnings("unchecked")
	public  E dequeue(){
		if (isEmpty())
			throw new EmptyCollectionException("Queue is empty.");
		else
		{
			Node<E> element = rear.getNext();       
			rear = rear.getNext();
			return (E) element;     			
		}
	}

	public boolean isEmpty(){ return (rear == null); }

	@SuppressWarnings("unchecked")
	public E front(){
		Node<E> frontObj;
		frontObj = rear.getNext();  
		return (E) frontObj;
	}

	public int size(){
		Node<E> node;
		node = rear;
		int count = 0;
		while (node != null)
		{
			count++;
			node = node.getNext();
		}
		return count;
	}// end size()

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

}// end class CircularLinkedQueue



