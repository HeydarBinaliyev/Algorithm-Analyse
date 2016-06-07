package soru2;

import java.util.Date;
import java.util.Random;

public class Karsilastirma {
	Heap maxHeap;
	Kuyruk kuyruk;
	Random r=new Random();
	Date once;
	Date sonra;
	long once_san,sonra_san;
	int boyutlar[]={100,500,1000,5000,10000,50000};
	
	public void insert(){
		System.out.println("-----------------Insert Ýþlemi----------------------");
		for (int i : boyutlar) {
			System.out.println("------"+i+" boyutu için"+"-------");
			System.out.println("Heap...");
			once=new Date();
			once_san=once.getTime();
			maxHeap=new Heap(i);
			for(int j=0;j<i;j++){
				maxHeap.insert(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
			System.out.println("Kuyruk...");
			once=new Date();
			once_san=once.getTime();
			kuyruk=new Kuyruk(i);
			for(int j=0;j<i;j++){
				kuyruk.insert(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
		}
	}
	public void delete(){
		System.out.println("-----------------Delete Ýþlemi----------------------");
		for (int i : boyutlar) {
			System.out.println("------"+i+" boyutu için"+"-------");
			System.out.println("Heap...");
			maxHeap=new Heap(i);
			
			for(int j=0;j<i;j++)
				maxHeap.insert(r.nextInt(i));
			
			once=new Date();
			once_san=once.getTime();
			
			for(int j=0;j<i;j++){
				maxHeap.delete(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
			System.out.println("Kuyruk...");
			kuyruk=new Kuyruk(i);
			for(int j=0;j<i;j++)
				kuyruk.insert(r.nextInt(i));
			once=new Date();
			once_san=once.getTime();
			
			for(int j=0;j<i;j++){
				kuyruk.delete(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
		}
	}
	public void find(){
		System.out.println("-----------------Find Ýþlemi----------------------");
		for (int i : boyutlar) {
			System.out.println("------"+i+" boyutu için"+"-------");
			System.out.println("Heap...");
			maxHeap=new Heap(i);
			for(int j=0;j<i;j++)
				maxHeap.insert(r.nextInt(i));
			once=new Date();
			once_san=once.getTime();
			for(int j=0;j<i;j++){
				maxHeap.find(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
			System.out.println("Kuyruk...");
			kuyruk=new Kuyruk(i);
			for(int j=0;j<i;j++){
				kuyruk.insert(r.nextInt(i));
			}
			once=new Date();
			once_san=once.getTime();
			for(int j=0;j<i;j++){
				kuyruk.find(r.nextInt(i));
			}
			sonra=new Date();
			sonra_san=sonra.getTime();
			System.out.println("zaman "+(sonra_san-once_san)+" ms");
		}
	}
	public static void main(String[] args) {
			new Karsilastirma().insert();
			new Karsilastirma().delete();
			new Karsilastirma().find();
	}
}
