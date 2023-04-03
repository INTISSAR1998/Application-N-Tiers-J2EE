package beans;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
	private String Designation;
	public List<String> getPromo(String promo){
		List<String> promolist = new ArrayList <String>() ;
		if(promo.equals("LFI3")) {
			promolist.add("Etudiant 1 LFI3");
			promolist.add("Etudiant 2 LFI3");
			promolist.add("Etudiant 3 LFI3");
			promolist.add("Etudiant 4 LFI3");
		}else  if(promo.equals("LAI3")) {
			promolist.add("Etudiant 1 LAI3");
			promolist.add("Etudiant 2 LAI3");
			promolist.add("Etudiant 3 LAI3");
			promolist.add("Etudiant 4 LAI3");
	}else {
		return null;
	}
		return promolist;
	}
}
