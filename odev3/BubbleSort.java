package odev3;

import java.util.Date;
import java.util.Random;

public class BubbleSort {
	
	private double swap;
	private double comparison;
	
	public BubbleSort(){
		this.comparison=0;
		this.swap=0;
	}
	
	private double getComparison(){
		return comparison;
	}
	   
	private double getSwap(){
		return swap;
	}
	
	private void ALG_BubbleSort(int[] array){
		
		for (int i =array.length-1; i>0; i--) {
			for(int j=0;j<i;j++){
				int temp;
				if(array[j]>array[j+1]){
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
					swap++;
				}
				comparison++;
			}
		}
	}
	public static void main(String[] args) {
		int lenght=100;
		System.out.println("----------------------BUBBLE SORT----------------------");
		System.out.println("N           Karþýlaþtýrma      Yerdeðiþtirme       N2       Zaman");
		for(int i=0;i<10;i++){
			Random r=new Random();
			int[] array=new int[lenght];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			Date time=new Date();
			long now=time.getTime();
			BubbleSort s=new BubbleSort();
			s.ALG_BubbleSort(array);
			Date time2=new Date();
			long after=time2.getTime();
			double gecen_zaman=(double)((double)after-(double)now)/1000.0;
			
			System.out.println(lenght+"       "+s.getComparison()+"               "
					+ "      "+s.getSwap()+"         "+(lenght*lenght)+"    "+gecen_zaman);
			
			lenght*=2;
		}
		
	
	}
}
