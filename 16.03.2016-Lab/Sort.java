import java.util.Date;
import java.util.Random;


public class Sort {

	private long swap;
	private long comparison;
	
	public Sort(){
		this.comparison=0;
		this.swap=0;
	}
	
	private long getComparison(){
		return comparison;
	}
	   
	private long getSwap(){
		return swap;
	}
	
	private int[] SelectionSort(int array[]){
		
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
		return array;
	}
	private int[] BubbleSort(int[] array){
		
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
		return array;
	}
	public static void main(String[] args) {
		int lenght=10;
		for(int i=1;i<=4;i++){
			Random r=new Random();
			lenght*=10;
			int[] array=new int[lenght];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			System.out.println(lenght+" .............Boyutunda...........");
			Date time1=new Date();
			long now=time1.getTime();
			Sort s=new Sort();
			int array1[]=array;
			int sorted_arr[]=s.SelectionSort(array);
			Date time2=new Date();
			long after=time2.getTime();
			double gecen_zaman=(double)(after-now)/1000.0;
			System.out.println("----------------------SELECTÝON SORT----------------------");
			System.out.println("N:"+lenght);
			System.out.println("#ofCompare:"+s.getComparison());
			System.out.println("#ofSwap:"+s.getSwap());
			System.out.println("n2:"+(long)lenght*(long)lenght);
			System.out.println("Time:"+gecen_zaman+" sn");
			
			
			
			
			Date time3=new Date();
			long now1=time3.getTime();
			Sort s1=new Sort();
			int sorted_arr1[]=s1.BubbleSort(array1);
			Date time4=new Date();
			long after1=time4.getTime();
			double gecen_zaman1=(double)(after1-now1)/1000.0;
			System.out.println("------------------------BUBBLE SORT--------------------");
			System.out.println("N:"+lenght);
			System.out.println("#ofCompare:"+s1.getComparison());
			System.out.println("#ofSwap:"+s1.getSwap());
			System.out.println("n2:"+(long)lenght*(long)lenght);
			System.out.println("Time:"+gecen_zaman1+" sn");
			
		}
	}
}









