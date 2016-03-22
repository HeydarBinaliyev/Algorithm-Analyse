package odev3;

import java.util.Date;
import java.util.Random;

public class SelectionSort {
	
	private double swap;
	private double comparison;
	
	public SelectionSort(){
		this.comparison=0;
		this.swap=0;
	}
	
	private double getComparison(){
		return comparison;
	}
	   
	private double getSwap(){
		return swap;
	}
	private void  ALG_SelectionSort(int array[]){
		
		for (int i = 0; i < array.length-1; i++) {
			int en_kucuk_index=i;
			for (int j = i+1; j < array.length; j++) {
				if(array[j]<array[en_kucuk_index]){
					en_kucuk_index=j;
					comparison++;
				}
			}
			if(en_kucuk_index!=i){
				int temp=array[i];
				array[i]=array[en_kucuk_index];
				array[en_kucuk_index]=temp;
				swap++;
				comparison++;
			}
			
			
		}
	}
	public static void main(String[] args) {
		int lenght=100;
		System.out.println("----------------------SELECTION SORT----------------------");
		System.out.println("N           Karþýlaþtýrma      Yerdeðiþtirme       N2       Zaman");
		for(int i=0;i<10;i++){
			Random r=new Random();
			int[] array=new int[lenght];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			Date time=new Date();
			long now=time.getTime();
			SelectionSort s=new SelectionSort();
			s.ALG_SelectionSort(array);
			Date time2=new Date();
			long after=time2.getTime();
			double gecen_zaman=(double)((double)after-(double)now)/1000.0;
			
			System.out.println(lenght+"       "+s.getComparison()+"               "
					+ "      "+s.getSwap()+"         "+((double)lenght*(double)lenght)+"    "+gecen_zaman);
			
			lenght*=2;
		}
		
	}
}
