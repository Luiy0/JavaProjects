/* Luis A. Flores 841-10-2500
 * Class that implements a queue as an array
 */

package Structures;

import java.util.Iterator;

public class ArrayQueue<E> extends AbstractCollection<E> implements Queue<E> {

	public static final int DEFAULT_CAPACITY = 10;
	private E[] data;
	private int front = 0, rear = 0;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity){
		data = (E[]) new Object[initialCapacity];
	}

	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}

	@Override
	public E front(){
		if (isEmpty())
			throw new EmptyCollectionException("Queue is empty.");
		return data[front];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear(){
		super.clear();
		data = (E[]) new Object[DEFAULT_CAPACITY]; 
		// haciendo casting de object a E pero la compu no sabe que es E (supress warnings)
	}


	// Returns true if an element is contained in the array
	@Override
	public boolean contains(E element) {
		// changed size for data.length in the for loop
		for (int current = 0; current < data.length; current++)
			if (element.equals(data[current]))
				return true;
		return false;
	}

	// inserts an element to the last position
	@Override
	public void enqueue(E element) {
		if(size == data.length)
			doubleCapacity();
		data[rear] = element;
		rear = (rear + 1) % data.length;
		// si el rear+1 se pasa del data length apunta al arreglo en la pos 0(front) 
		size++;

	}

	// Removes the first element
	@Override
	public E dequeue() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue is empty");
		E element = data[front];
		size--;
		data[front]= null;
		front = (front + 1) % data.length;
		return element;
	}

	// doubles the capacity of the array
	@SuppressWarnings("unchecked")
	private void doubleCapacity(){
		E[] temp = (E[]) new Object[data.length*2];
		for(int current = 0; current<size;current++)
			temp[current]=data[(current+front) % data.length];
		data=temp;
		front=0;
		rear=size;
	}

	public Iterator<E> iterator(){
		return new Iterator<E>(){

			private int current = 0;

			@Override
			public boolean hasNext(){
				return (current < size);			
			}		
			@Override
			public E next(){
				E element = data[(current+front) % data.length];
				current++;
				return element;
			}	
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// Count how many times an element is repeated
	public int count(E element) {
		// changed size for data.length in the for loop and now it works.
		int count = 0;
		for (int current = 0; current < data.length; current++)
			if (element.equals(data[current]))
				count++;
		return count;
	}

}
