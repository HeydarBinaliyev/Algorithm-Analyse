public class Search {
	
	private int binary_search(int myArray[],int number){
		int midle=myArray.length/2;
		int score=1;
		if(number>myArray[midle]){
			for(int i=midle;i<myArray.length;i++){
				if(number==myArray[i]){
					System.out.println(score+" times.");
					return 1;
				}
				score++;
			}
		}
		else if(number<myArray[midle]){
			for(int i=0;i<midle;i++){
				if(number==myArray[i]){
					System.out.println(score+" times.");
					return 1;
				}
				score++;
			}
		}
		else{
			System.out.println(score+" times.");
			return 1;
		}
		return -1;
	}
	private int normal_search(int myArray[],int number){
		int score=1;
		for(int i=0;i<myArray.length;i++){
			if(number==myArray[i]){
				System.out.println(score+" times.");
				return 1;
			}
			score++;
		}
		return -1;
	}
	public static void main(String[] args) {
		int myArray[]={41,45,46,49,58,59,63,67,69,72,74,75,76,84,86,89,91,92,97,99};
		System.out.println("-------Binary Search--------");
		System.out.println(new Search().binary_search(myArray,97));
		System.out.println("-------Normal Search--------");
		System.out.println(new Search().normal_search(myArray, 67));
		
	}
}
