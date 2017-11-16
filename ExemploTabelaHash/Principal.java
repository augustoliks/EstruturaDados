package aula;

import java.util.Scanner;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n=0;
		String op;
		Hash hash = new Hash(10);
		
		do{
			System.out.println("1 - Inserir nome\n2 - Remover nome\n3 - Buscar nome\n4 - Inserir 1000 nomes aleatorios:\n5 - Imprimir\n6 - Sair");
			op = scan.next();
			
			switch(op) {
				case "1" : {
					System.out.println("Insira um nome: ");
					hash.inserir(scan.next());
			
					break;
		
				}
				case "2" : {
					System.out.println("Digite o nome para remover: ");
					hash.remover(scan.next());

					break;
				}
				case "3" : {
					System.out.println("Digite o nome para buscar: ");
					hash.buscar(scan.next());
					
					break;
				}
				
				case "4" : {	
					for (int k=0 ; k<1000 ; k++){
						hash.inserir(new CriarNome().CriarNome());
					}
					System.out.println("Inserido!!!");

					break;
				}
				
				case "5" : {
					hash.imprimir();
					break;
				}
				case "6" : {
					n = 1;
					break;
				}
				default : {
					break;
				}
			}
		}while(n!=1);
	}
}