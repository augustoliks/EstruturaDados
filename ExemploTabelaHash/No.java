package aula;

public class No {
	 public int chave, ocorrencia;
	 public No proximo;
	 public String nome;
	 @Override
	 public String toString(){
	 return "("+chave +":"+ ocorrencia+")";
	 }
}
