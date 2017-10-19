package pacote;

public class Principal {

	public static void main(String[] args) {
		Lista l = new Lista();
		
		l.inserir(0);	// 0
		l.inserir(1);	// 1
		l.inserir(2);	// 2
		l.inserir(33);	// 3
		l.inserir(4);	// 4
		l.inserir(5);	// 5
		l.inserir(6);	// 6
		
		System.out.println("Count (contador de elementos): "+l.count(0, l.inicio));
		System.out.println("Depht (Profundidade): "+l.depth(42));
		System.out.println("Height (Altura): "+l.height(34));
		System.out.println("");
		
		System.out.print("Lista encadeada:");
		l.imprimir();
			
		System.out.print("\n\nLista encadeada sort:");
		l.sort();
		l.imprimir();

/*
		System.out.print("\n\nLista encadeada unsort:");		
		l.unsort();
		l.imprimir();
*/	
		
		int[] array = l.toArray();
		
		System.out.println("\n\n>>> toArray");
		for (int k = 0; k < array.length; k++) {
			System.out.println("\tarray["+k+"] = "+array[k]);
		}
		
	}
}
