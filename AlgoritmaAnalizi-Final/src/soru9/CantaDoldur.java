package soru9;

import java.util.HashMap;
public class CantaDoldur {
	
	public int get_combinasyon_agirligi(int[]indises,Object[]agirliklar){
		int toplam=0;
		for(int i=0;i<indises.length;i++){
			toplam+=(Integer)agirliklar[indises[i]];
		}
		return toplam;
	}
	public void kombinasyonu_yaz(HashMap<Integer, Integer>tablo,Object[]agirliklar,int[]indises){
		for(int i=0;i<indises.length;i++){
			System.out.print((Integer)agirliklar[indises[i]]+" kg ");
		}
		System.out.println();
		System.out.println("degeri:"+new CantaDoldur().get_combinasyon_degeri(tablo, indises, agirliklar));
	}
	public int get_combinasyon_degeri(HashMap<Integer,Integer>tablo,int[]indises,Object[]agirliklar){
		int toplam=0;
		for(int i=0;i<indises.length;i++){
			toplam+=tablo.get((Integer)agirliklar[indises[i]]);
		}
		return toplam;
	}
	
	public void en_buyuk_deger_bul(HashMap<Integer, Integer>tablo){
		
		int en_buyuk_toplam_deger=0;
		int[]en_buyuk_indises = null;
		Object[] agirliklar=tablo.keySet().toArray();
		
		for(int kacli=1;kacli<=tablo.size();kacli++){
			
			CombinationGenerator x=new CombinationGenerator(agirliklar.length,kacli);
			
			int[]indises;
			
			while(x.hasMore()){
				//combinasyonun indexlerini al
				//0 2 5
				//0 2 4
				//0 2 3
				indises=x.getNext();
				
				int agirlik=new CantaDoldur().get_combinasyon_agirligi(indises, agirliklar);
				int deger=new CantaDoldur().get_combinasyon_degeri(tablo, indises, agirliklar);
				
				if(agirlik==15){
					new CantaDoldur().kombinasyonu_yaz(tablo, agirliklar, indises);	
					if(en_buyuk_toplam_deger<deger){
						en_buyuk_toplam_deger=deger;
						en_buyuk_indises=new int[indises.length];
						for(int i=0;i<indises.length;i++)
							en_buyuk_indises[i]=indises[i];
					}
				}
			}
		}
		System.out.println("--------------Seçilenler---------------");
		new CantaDoldur().kombinasyonu_yaz(tablo, agirliklar, en_buyuk_indises);
	}
	public static void main(String[] args) {
		//kg->değer
		HashMap<Integer, Integer>tablo=new HashMap<>();
		//tablo.put(kg,değer)
		tablo.put(1,2);
		tablo.put(2, 3);
		tablo.put(4, 4);
		tablo.put(5,6);
		tablo.put(8,9);
		tablo.put(7, 11);
		tablo.put(10, 12);
		tablo.put(12, 14);
		tablo.put(3, 8);
		tablo.put(6, 10);
		tablo.put(15, 16);
		tablo.put(13, 15);
		tablo.put(14, 14);
		new CantaDoldur().en_buyuk_deger_bul(tablo);
		
	}
}
