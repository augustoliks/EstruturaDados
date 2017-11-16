package aula;

public class CriarNome {

	public String CriarNome() {
		String r = "";
		for (int k=0 ; k<10 ; k++) {
			char letra = (char)(Math.random()*26+97);
			r+=letra;
		}
		return r;
	}	
}