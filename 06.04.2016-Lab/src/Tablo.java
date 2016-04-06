import java.util.Random;
import java.util.Scanner;


public class Tablo {

	//karmaþýklýk O(n)
	private int getMostPopular(int[][] tablo,int n){
		int mostPopular=0;
		int mostScore=0;
		for(int i=0;i<100;i++){
			int score=0;
			for(int j=0;j<n;j++){
				if(tablo[j][i]==1)score++;
			}
			if(mostScore<score){
				mostPopular=i;
				mostScore=score;
			}
		}
		return mostPopular;
	}
	
	
	public static void main(String[] args) {
		int n;
		Scanner scanner=new Scanner(System.in);
		n=Integer.parseInt(scanner.nextLine());
		int[][] tablo=new int[n][100];
		Random r=new Random();
		for(int i=0;i<n;i++){
			for (int j = 0; j <100; j++) {
				tablo[i][j]=(r.nextInt(100))%2;
			}
		}
				
		System.out.println(new Tablo().getMostPopular(tablo, n));
		int sutun=new Tablo().getMostPopular(tablo, n);
		int kacbirvar=0;
		for(int j=0;j<n;j++){
			if(tablo[j][sutun]==1)kacbirvar++;
			System.out.print(tablo[j][sutun]);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("bir sayisi:"+kacbirvar);
		
	}
}
