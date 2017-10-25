package pacote;

public class Principal {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		
		/* insere os valores na árvore a partir do nó raiz */
		arvore.raiz = arvore.inserir(arvore.raiz, 8);
		arvore.raiz = arvore.inserir(arvore.raiz, 10);
		arvore.raiz = arvore.inserir(arvore.raiz, 3);
		arvore.raiz = arvore.inserir(arvore.raiz, 6);
		arvore.raiz = arvore.inserir(arvore.raiz, 1);
		arvore.raiz = arvore.inserir(arvore.raiz, 14);
		arvore.raiz = arvore.inserir(arvore.raiz, 4);
		arvore.raiz = arvore.inserir(arvore.raiz, 13);
		arvore.raiz = arvore.inserir(arvore.raiz, 7);
		
		System.out.println("\nOrdem EsqRaizDir: ");	
		arvore.imprimirEsqRaizDir(arvore.raiz);
		
		System.out.println("\nOrdem RaizEsqDir: ");
		arvore.imprimirRaizEsqDir(arvore.raiz);
		
		System.out.println("\nOrdem EsqDirRaiz: ");
		arvore.imprimirEsqDirRaiz(arvore.raiz);
	}
}
