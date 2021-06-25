package Structures;

public class Node<T> {
	
	// package protected fields
	T data;
	Node<T> next;
	
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data + "-->"+ next;
		// devuelve data encadena la flecha y muestra next que tiene otro toString, vuelve y se hace hasta q next sea null
	}
	
	
	
	

}
