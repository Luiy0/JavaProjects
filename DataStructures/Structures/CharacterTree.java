package Structures;

import java.io.PrintWriter;
import java.util.Scanner;

public class CharacterTree<T> {

	TreeNode<Character> root;

	public void add(Character c) throws DuplicateElementException {		
		root = addHelper(c,root);
	}
	
	private TreeNode<Character> addHelper(Character c,TreeNode<Character> node) throws DuplicateElementException{

		if(node == null){
			node= new TreeNode<Character>(c, null, null);
		}else {
			int compare = c.compareTo(node.data);
			if (compare < 0)
				node.left = addHelper(c,node.left);
			else if (compare > 0 ){
				node.right = addHelper(c,node.right);
			}
			else 
				throw new DuplicateElementException();	
		}
		return node;
	}

	public void clear(){
		root= null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public int size(){
		return sizeHelper(root);
	}
	private int sizeHelper(TreeNode<Character> tnode){
		if (tnode == null)
			return 0;
		else
			return 1 + sizeHelper(tnode.left) + sizeHelper(tnode.right);
	}
	
	public boolean contains(Character charac) {
		return containsHelper(charac,root);
	}

	private boolean containsHelper(Character charac,TreeNode<Character> tnode){
		if(tnode.getData().equals(charac))
			return true;
		else{
			if(tnode.getData() < charac)
				return containsHelper(charac,tnode.getRight());
			else if(tnode.getData() > charac)
				return containsHelper(charac, tnode.getLeft());
		}
		return false;

	}
	public int level(Character charac){
		return levelHelper(charac, root);	
	}


	private int levelHelper(Character charac,TreeNode<Character> tnode){
		if(tnode.getData().equals(charac))
			return 0;
		else{
			if(tnode.getData() < charac)
				return 1 + levelHelper(charac,tnode.getRight());
			else if (tnode.getData() > charac)
				return 1 + levelHelper(charac, tnode.getLeft());
		}
		return -1;

	}

	public String toString(){
		return  toStringHelper(root) ;
	}


	private String toStringHelper(TreeNode<Character> tnode){
		if (tnode == null) {
			return "";
		}else if (tnode.left == null && tnode.right == null) {
			return "[" + tnode.getData() + "]";
		}
		else {
			String result = "(";
			result += toStringHelper(tnode.getLeft());
			result += " " + tnode.getData() + " ";
			result += toStringHelper(tnode.getRight());
			result += ")";
			return result;}
	}

	public void save(PrintWriter outp){
		saveHelper(outp, root);
	}


	private void saveHelper(PrintWriter outp, 
			TreeNode<Character> tnode){

		if (tnode == null) {
			outp.print("");
		}else if (tnode.left == null && tnode.right == null) {
			outp.print("[" + tnode.getData() + "]");
		}
		else {
			String result = "(";
			result += toStringHelper(tnode.getLeft());
			result += " " + tnode.getData() + " ";
			result += toStringHelper(tnode.getRight());
			result += ")";
			outp.print(result);
		}


	}

	public void load(Scanner inF) throws DuplicateElementException{
		char c;
		while(inF.hasNext()){
			c = inF.next().charAt(0);
			add(c);
		}

	}


	public Character minimum() {
		TreeNode<Character> curr = root;
		while(curr.getLeft() != null){
			curr = curr.getLeft();
		}
		return curr.getData();
	}


	public Character maximum() {
		TreeNode<Character> curr = root;
		while(curr.getRight() != null){
			curr = curr.getRight();
		}
		return curr.getData();
	}

}



