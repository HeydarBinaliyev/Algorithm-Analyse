package odev2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Degerlendirme {
	
	//tabloyu rasgele bir biçimde oluþtur
	public void TabloOlustur(int k){
		File f=new File("C://Users/heydar/workspace/Alg-Anal-Odev1/src/odev2/tablo.txt");
		PrintWriter writer = null;
		try {
			writer=new PrintWriter(f,"UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//header satýrýný ekle
		String line="";
		for(int i=0;i<k;i++){
			line=line+"  "+"header-"+(i+1);
			writer.print(line);
			line="";
		}
		//1 ve 0 satýrlarýný ekle
		for(int i=0;i<k;i++){
			String satir="";
			writer.println();
			for(int j=0;j<k;j++){
				Random r=new Random();
				satir=satir+(r.nextInt(2));
				writer.print(satir);
				satir="";
			}
		}
		writer.close();
	}
	//uygun eþik degerine karþýlýk gelen header'larý geri dondur
	public String[] getHeader(int t,int k){
		BufferedReader br = null;
		String line;
		String[] headers=new String[k];
		try {
			br=new BufferedReader(new FileReader("C://Users/heydar/workspace/Alg-Anal-Odev1/src/odev2/tablo.txt"));
			line=br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<k;i++){
			int esik=0;
			for(int j=0;j<k;j++){
				try {
					line=br.readLine();
					char c=line.charAt(i);
					if(c=='1'){
						esik++;
					}
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			try {
				br=new BufferedReader(new FileReader("C://Users/heydar/workspace/Alg-Anal-Odev1/src/odev2/tablo.txt"));
				line=br.readLine();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(esik>t){
				headers[i]="header-"+(i+1);
			}
			
		}
		return headers;
	}
	public static void main(String[] args) {
			//6 headerý olan bir tablo oluþtur
			new Degerlendirme().TabloOlustur(6);
			//eþik degeri 2'den yuksek olan headerlarý geri dondur
			String[] s=new Degerlendirme().getHeader(2, 6);
			for (String string : s) {
				if(string!=null)
				System.out.println(string);
			}
	}
}
