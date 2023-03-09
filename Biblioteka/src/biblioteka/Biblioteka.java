package biblioteka;

import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private List<Knjiga> knjige = new ArrayList<>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null!");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga vec postoji!");
		
		knjige.add(knjiga);

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		
		knjige.remove(knjiga);

	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjige(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn < 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Makar jedan kriterijum morate uneti!");
		

		
		List<Knjiga> result = new ArrayList<>();

		if (naslov != null) {
			for (Knjiga k : knjige) {
				if (k.getNaslov().toLowerCase().trim().contains(naslov.toLowerCase()))
					result.add(k);
			} 
		}
		return result;
	}

}
