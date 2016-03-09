
import java.util.Date;
import java.util.Random;
public class SubArray {

	private int maxSubSum1(int array[]){
		
		int maxSum=0;
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				int thisSum=0;
				for(int k=i;k<j;k++){
					thisSum+=array[k];
					if(thisSum>maxSum) maxSum=thisSum;
				}
			}
		}
		return maxSum;
	}
	private int maxSubSum2(int array[]){
		int maxSum=0;
		for(int i=0;i<array.length;i++){
			int thisSum=0;
			for(int j=i;j<array.length;j++){
				thisSum+=array[j];
				if(thisSum>maxSum)maxSum=thisSum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		Random r=new Random();
		double[] saniyeler=new double[6];
		int l=0;
		int dizi_boyutlari[]={10,100,1000};
		for(int boyut=0;boyut<3;boyut++){
			int[] array=new int[dizi_boyutlari[boyut]];
			//diziyi hazýrla
			for(int i=0;i<array.length;i++){
				array[i]=r.nextInt(array.length)+1;
			}
			Date dateobj1 = new Date();
			long now=dateobj1.getTime();
			int maxSum=new SubArray().maxSubSum1(array);
			Date dateobj2 = new Date();
		    long after=dateobj2.getTime();
		    saniyeler[l]=(after-now)/1000.0;
		    l+=1;
		    System.out.println(dizi_boyutlari[boyut]+" un maxSum1 is:"+maxSum);
		    System.out.println("geçen süre:"+((after-now)/1000.0));
		    
		    Date dateobj3 = new Date();
			long now1=dateobj3.getTime();
			int maxSum1=new SubArray().maxSubSum2(array);
			Date dateobj4= new Date();
		    long after1=dateobj4.getTime();
		    saniyeler[l]=(after1-now1)/1000.0;
		    l+=1;
		    System.out.println(dizi_boyutlari[boyut]+" un maxSum2 is:"+maxSum1);
		    System.out.println("geçen süre:"+((after1-now1)/1000.0));
			
		}
		new AnimatedChart2().ciz(saniyeler);
		
	
	}
}
