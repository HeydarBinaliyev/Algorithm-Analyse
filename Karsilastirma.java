package odev3;
import java.util.Date;
import java.util.Random;
public class Karsilastirma {
public  void ALG_QuickSort(int[] arr, int low, int high) {	
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];	
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j){
			ALG_QuickSort(arr, low, j);
		}	
		if (high > i){
			ALG_QuickSort(arr, i, high);
		}
	}
private void ALG_BubbleSort(int[] array){
	for (int i =array.length-1; i>0; i--) {
		for(int j=0;j<i;j++){
			int temp;
			if(array[j]>array[j+1]){
				temp=array[j+1];
				array[j+1]=array[j];
				array[j]=temp;	
			}
		}
	}
}
public static void main(String[] args) {
		Karsilastirma s=new Karsilastirma();
		double[] oranlar=new double[1000];
		for(int i=0;i<1000;i++){
			Random r=new Random();
			int[] array=new int[10000];
			for (int j = 0; j < array.length; j++) {
				array[j]=r.nextInt();
			}
			Date time=new Date();
			long now=time.getTime();
		    s.ALG_QuickSort(array, 0, array.length-1);
			Date time2=new Date();
			long after=time2.getTime();
			double quick_gecen_zaman=(double)((double)after-(double)now);
			//System.out.println("quick-->"+(i+1)+".calistirma zaman:"+quick_gecen_zaman);
			Date time3=new Date();
			long now1=time3.getTime();
			s.ALG_BubbleSort(array);
			Date time4=new Date();
			long after1=time4.getTime();
			double bubble_gecen_zaman=(double)((double)after1-(double)now1);
			//System.out.println("bubble-->"+(i+1)+".calistirma zaman:"+bubble_gecen_zaman);
			//System.out.println("oran:"+(bubble_gecen_zaman/quick_gecen_zaman));
			oranlar[i]=bubble_gecen_zaman/quick_gecen_zaman;
		}
		double toplam=0;
		for(int i=0;i<1000;i++)
			toplam+=oranlar[i];
		System.out.println("ortalama zaman orani:"+toplam/1000);
	}
	
}
