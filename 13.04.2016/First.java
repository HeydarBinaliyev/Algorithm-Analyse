package main;

public class First {

	String name="ayse";
	
	public static void main(String[] args) {
	    First s1=new First();
		First s2=new First();
		try {
			s1=(First) s2.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.name="bob";
		System.out.println(s2.name);
	}
}
