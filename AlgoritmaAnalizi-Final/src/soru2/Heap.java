package soru2;

class Node{
	int data;
	public Node(int key){
		this.data=key;
	}
	public int getKey(){
		return data;
	}
}
public class Heap{
	
	private int maxSize;
	private   int elements=0;
	private Node[] nodes;
	
	public Heap(int size){
		this.maxSize=size;
		nodes=new Node[maxSize];
	}
	
	public boolean insert(int key){
		Node n=new Node(key);
		if(elements==0){
			nodes[0]=n;
			elements++;
			return true;
		}
		if(maxSize<elements){
			System.out.println("heap doldu");
			return false;
		}
		nodes[elements]=n;
		elements++;
		int index=elements-1;
		for(int i=index;i>0;i--){
			if(nodes[i-1].getKey()<n.getKey()){
				Node temp=nodes[i-1];
				nodes[i-1]=n;
				nodes[i]=temp;
			}else
				break;
		}
		return true;
	}
	public boolean delete(int key){
		if(elements<1)
			return false;
		int index;
		for(index=0;index<elements;index++){
			if(nodes[index].getKey()==key)
				break;
			if(index==elements-1)
				return false;
		}
		for(int i=index;i<elements-2;i++){
			if(nodes[i+1].getKey()<nodes[i+2].getKey()){
				nodes[i]=nodes[i+2];
				nodes[i+2]=nodes[i+1];
			}
		}
		elements--;
		return true;
	}
	public int find(int key){
		int index;
		for(index=0;index<elements;index++)
			if(nodes[index].getKey()==key)
				return index;
		return -1;
	}
	
}