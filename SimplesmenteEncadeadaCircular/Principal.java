package pacote;

public class Principal {

	public static void main(String[] args) {
		Lista l = new Lista();

		l.inserir(0); // 0
		l.inserir(2); // 1
		l.inserir(1); // 2
		l.inserir(4); // 3
		l.inserir(3); // 4
		l.inserir(7); // 5
		l.inserir(5); // 6

		System.out.print("Lista encadeada:");
		l.imprimir();

		System.out.println("\n\nLast node: "+ l.last().conteudo);
		
		System.out.println("\nSearch node: "+ l.buscar(5));

		System.out.println("\nDepht node: "+ l.depht(7));

		System.out.println("\nHeight node: "+ l.height(7));

	}
}