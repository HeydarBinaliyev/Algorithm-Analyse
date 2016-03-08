
import java.util.Arrays;
import java.util.Random;

public class Search {
	
	private int binary_search(int myArray[],int number){
		int midle=myArray.length/2;
		int score=1;
		if(number>myArray[midle]){
			for(int i=midle+1;i<myArray.length;i++){
				if(number<myArray[i]){
					System.out.println("bulunamadý:"+score+" times.");
					return score;
				}
				if(number==myArray[i]){
					System.out.println(score+" times.");
					return score;
				}
				score++;
			}
		}
		else if(number<myArray[midle]){
			for(int i=midle-1;i>=0;i--){
				if(number>myArray[i]){
					System.out.println("bulunamadý:"+score+" times.");
					return score;
				}
				if(number==myArray[i]){
					System.out.println(score+" times.");
					return score;
				}
				score++;
			}
		}
		else{
			System.out.println(score+" times.");
			return score;
		}
		return -1;
	}

	
	public static void main(String[] args) {
		int boyut=0;
		double[] average=new double[7];
		for(int sayac=0;sayac<7;sayac++){
			boyut=boyut+100;
			Random r=new Random();
			int[] array=new int[boyut];
			//create an array
			for(int i=0;i<boyut;i++){
				array[i]=r.nextInt(boyut)+1;
			}
			Arrays.sort(array);
			
			System.out.println(boyut+" boyut için.");
			//get scores
			int[] scores=new int[5];
			for(int j=0;j<5;j++){
				int number=r.nextInt(boyut)+1;
				System.out.println((j+1)+".call and number is:"+number);
				scores[j]=new Search().binary_search(array,number);
			}
			int toplam=0;
			for(int j=0;j<5;j++){
				toplam+=scores[j];
			}
			//her boyut için hit ortalamasýný bul
			average[sayac]=(double)toplam/5;
			System.out.println("average is:"+average[sayac]);
			
		}
		//grafiði çiz
		new AnimatedChart().ciz(average);
		
	}
}
