package soru2;

class Dugum{
	int data;
	public Dugum(int key){
		data=key;
	}
}

public class Kuyruk {
	int bas;
	int son;
	int N;
	Dugum[]dugumler;
	public Kuyruk(int N){
		bas=0;
		son=0;
		this.N=N;
		dugumler=new Dugum[N];
	}
	public boolean QBosmu(){
			if(bas!=son)
				return false;
			return true;
	}
	public boolean insert(int key){
		Dugum d=new Dugum(key);
		if(this.bas==this.son){
			this.dugumler[bas]=d;
			return true;
		}
		if(son==N){
			System.out.println("Kuyruk Dolu...");
			return false;
		}
		son++;
		this.dugumler[son]=d;
		return true;
	}
	public boolean delete(int key){
		if(QBosmu())
			return false;
		int index=0;
		for (Dugum dugum : dugumler) {
			if(dugum.data==key)
				break;
			index++;
		}
		if(bas==index){
			bas++;
			return true;
		}else if(son==index){
			son--;
			return true;
		}else{
			for(int i=index;i<son;i++){
				dugumler[i]=dugumler[i+1];
			}
			son--;
		}
		return true;
	}
	public int find(int key){
		int index=0;
		if(bas==son)
			return -1;
		for (Dugum dugum : dugumler) {
			if(dugum.data==key)
				return index;
			index++;
		}
		return -1;
	}
	
}
