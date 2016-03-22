package odev3;

import java.util.Date;
import java.util.Random;

public class QuickSort {
	private double swap;
	private double comparison;
	
	public QuickSort(){
		this.comparison=0;
		this.swap=0;
	}
	
	private double getComparison(){
		return comparison;
	}
	   
	private double getSwap(){
		return swap;
	}
	public  void ALG_QuickSort(int[] arr, int low, int high) {
		
		
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
				comparison++;
			}
 
			while (arr[j] > pivot) {
				j--;
				comparison++;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
				swap++;
			}
			comparison++;
		}
 
		
		if (low < j){
			ALG_QuickSort(arr, low, j);
			comparison++;
		}
			
 
		if (high > i){
			ALG_QuickSort(arr, i, high);
			comparison++;
		}
		
	}
	
	public static void main(String[] args) {
		int lenght=100;
		System.out.println("----------------------Quick SORT----------------------");
		System.out.println("N           Karþýlaþtýrma      Yerdeðiþtirme       N2       Zaman");
		for(int i=0;i<10;i++){
			Random r=new Random();
			int[] array=new int[lenght];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			Date time=new Date();
			long now=time.getTime();
			QuickSort s=new QuickSort();
		    s.ALG_QuickSort(array, 0, array.length-1);
			Date time2=new Date();
			long after=time2.getTime();
			double gecen_zaman=(double)((double)after-(double)now)/1000.0;
			
			System.out.println(lenght+"       "+s.getComparison()+"               "
					+ "      "+s.getSwap()+"         "+((double)lenght*(double)lenght)+"    "+gecen_zaman);
			
			lenght*=2;
		}
	}

}