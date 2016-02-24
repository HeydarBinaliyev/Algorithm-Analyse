package ders01;

public class sum {
	
	private int getTotal(int n){
		int t=0;//1 birim zaman tuketir
		for(int i=0;i<=n;i++){//1;n+2;n birim
			t=(int) (t+Math.pow(i, 3));//n birim
		}
		return t;//1
		
	}
	//karmaþýklýk f(n)=3n+6
	
	//n. fibonacciyi bul
	//karamaþýklýk=O(N)=4+2n-3+3(n-2)=5n-5
	private int getFib(int n){
		int f1=0;//1
		int f2=1;//1
		int f=1;//1
		for(int i=2;i<=n;i++){//1 + 2(n-3+1)  
			f=f1+f2;//1
			f1=f2;//1
			f2=f;//1
		}
		return f;//1
	}
	
	private int getFibRecursively(int n){
		if(n<2)return n;
		else return getFibRecursively(n-1)+getFibRecursively(n-2);
	}
	
	//herhangi bir n e baðlýlýk yok.karmaþýklýk=>O(1)
	private float getAverage(int a,int b,int c){
		return ((float)a+(float)b+(float)c)/3;
	}
	
	public static void main(String[] args) {
		System.out.println(new sum().getTotal(4));
		System.out.println(new sum().getFib(9));
		System.out.println(new sum().getFibRecursively(9));
		System.out.println(new sum().getAverage(1, 4, 3));
		}
}
