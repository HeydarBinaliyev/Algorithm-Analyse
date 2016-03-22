package odev3;

import java.util.Date;
import java.util.Random;

public class InsertionSort {
	private double swap;
	private double comparison;
	
    public InsertionSort() {
		// TODO Auto-generated constructor stub
		this.comparison=0;
		this.swap=0;
	}
	
	private double getComparison(){
		return comparison;
	}
	   
	private double getSwap(){
		return swap;
	}
	
	private int[] ALG_InsertionSort(int[] array){
		 int j;           
	     int temp;                
	     int i;  

	     for (j = 1; j < array.length; j++)    
	    {
	           temp = array[ j ];
	           for(i = j - 1; i >= 0; i--) 
	          {
	        	   if(array[ i ] < temp){
	        		   array[ i+1 ] = array[ i ];
	        		   swap++;
	        	   }
	        	   comparison++;
	                
	          }
	         array[ i+1 ] = temp;
	     }
	     return array;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int lenght=100;
		System.out.println("----------------------Insertion SORT----------------------");
		System.out.println("N           Karþýlaþtýrma      Yerdeðiþtirme       N2       Zaman");
		for(int i=0;i<10;i++){
			Random r=new Random();
			int[] array=new int[lenght];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			Date time=new Date();
			long now=time.getTime();
			InsertionSort s=new InsertionSort();
			s.ALG_InsertionSort(array);
			Date time2=new Date();
			long after=time2.getTime();
			double gecen_zaman=(double)((double)after-(double)now)/1000.0;
			System.out.println(lenght+"       "+s.getComparison()+"               "
					+ "      "+s.getSwap()+"         "+((double)lenght*(double)lenght)+"    "+gecen_zaman);
			
			lenght*=2;
		}
	}
	
}