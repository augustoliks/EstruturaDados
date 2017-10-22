package pacote;

public class Lista {
	No inicio;

	Lista() {
		inicio = null;
	}

	// METODO IMPRIMIR

	void imprimir() {
		if (inicio == null) {					//Verifica se existe algum "no" a lista encadeada circular
			System.out.println("Lista vazia");
		}
		else {
			System.out.println(); /* quebra de linha na tela */

			No ultimo = inicio;		///Atribui "No ultimo" com o endereco do "inicio", que servira como um marcador inicial para percorrer a lista até seu final, deixando a referencia de "No inicio" intacta

			do {
				System.out.print(ultimo.conteudo + " ");	//Imprimi o conteudo da referencia do "No ultimo" no momento
				ultimo = ultimo.proximo;	//Percorre um "no" na lista encadeada
			} while (ultimo != inicio);		/*Verifica a referencia de "No ultimo" eh a referencia do primeiro no da lista encadeada
			 									caso for, significa que a lista encadeada circular completou uma volta completa	*/
		}
	}

	// METODO INSERIR

	void inserir(int nro) {
		No no = new No();		//Cria um novo "no"
		no.conteudo = nro;		//Atribui o conteudo ao "no" criado

		if (inicio == null) {	//Verifica se a variavel global "No inicio", esta sem referencia, caso esteja, indica o "no" criado ha duas linhas acima como o primeiro "no" da lista encadeada
			inicio = no;		//atribui a referencia do "No inicio" com o endereco do novo "No no" criado
			inicio.proximo = no;//Por a lista ser circular, se houver apenas um no existente em sua composicao, o proximo no da lista sera o propio inicio
		}

		else {
			No ultimo = inicio;					//Atribui "No ultimo" com o endereco do "inicio", que servira como um marcador inicial para percorrer a lista até seu final, deixando a referencia de "No inicio" intacta
			while (ultimo.proximo != inicio) {	//Verifica se o proximo "no" do "No ultimo" eh diferente do "No inicio"
				ultimo = ultimo.proximo;		//"No ultimo" recebe o endereco do proximo "no" da lista encadeada
			}									//***Esse bloco serve para fazer com que a variavel "ultimo" receba a referencia do ultimo "no" inserido a lista encadeada
			ultimo.proximo = no;	//Atribui em "ultimo.proximo" o endereco do "No no" criado no inicio do bloco, ou seja, adiciona um novo no a lista encadeada
			no.proximo=inicio;		//Atribui o endereco de "No inicio" ao ultimo "no" adicionado na lista, fechando o circulo da lista encadeada circular
		}
	}

/*	ERRADO
	void inserirSort(int nro) {
		No no = new No();		//Cria um novo "no"
		no.conteudo = nro;		//Atribui o conteudo ao "no" criado

		if (inicio == null) {	//Verifica se a variavel global "No inicio", esta sem referencia, caso esteja, indica o "no" criado ha duas linhas acima como o primeiro "no" da lista encadeada
			inicio = no;		//atribui a referencia do "No inicio" com o endereco do novo "No no" criado
			inicio.proximo = no;//Por a lista ser circular, se houver apenas um no existente em sua composicao, o proximo no da lista sera o propio inicio
		}

		else {
			No atual = inicio;
			No depois = inicio.proximo;

			 do{

				if(nro<inicio.conteudo) {
					inicio = no;
					no.proximo=depois;
					depois.proximo=inicio;
					return;
				}

				if (nro<atual.conteudo) {
					atual.proximo = no;
					no.proximo=depois;
					depois.proximo=no;
					return;
				}

				atual=depois;
				depois = depois.proximo;
			}while(atual!=inicio);
		}
	}*/

	No last() {
		No ultimo = inicio;
		do {
			ultimo = ultimo.proximo;
		}while(ultimo.proximo != inicio);

		return ultimo;
	}

	int depht(int conteudo) { // Conta os nos da no ateh encontrar o "no" da busca, uma vez encontrado, ele para contar, se nao parar de contar significa q o "no" da busca nao existe
		No ultimo = inicio;
		boolean contar = true;
		int k=0;
		do {

			if (ultimo.conteudo==conteudo) {	//Quando encontra o "no" da busca, para de contar os nos seguintes
				contar = false;

			}

			if(contar) {	//Inicia a contagem, ou continua...
				k++;		//Acrescenta +1 ao contador de nos
			}

			ultimo=ultimo.proximo;	//Avanca a referencia da lista encadeada
		} while (ultimo != inicio);

		return contar ? -1 : k;	//Se eu parei de contar (contar==false), significa que eu encontrei o numero, entao retorna a contagem
								//Se eu nao parei de contar (contar==true), significa que nao encontrei o "no" da busca
	}

	int height(int conteudo){
		No ultimo = inicio;
		boolean contar = false;
		int k=0;

		do {
			if(ultimo.conteudo==conteudo) {	//Verifica se o "conteudo" da referencia do "No ultimo" eh igual ao valor do "conteudo" da busca
				contar=true;	//caso for, inicia a condicao para que uma contagem ate o final da lista encadeada seja executada
			}
			if(contar) {	// verifica se pode iniciar a contagem de nos
				k++;		//Acrescenta +1 ao contador de nos
			}
			ultimo = ultimo.proximo;	//Avanca a referencia da lista encadeada

		}while (ultimo.proximo != inicio);	//Percorre a lista ate encontrar o "No ultimo" tiver o a referencia igual ao "No inicio", ou seja, verifica toda a lista circular

		return contar ? k : -1;	//Se eu nem comecei a contar (contar==false), significa que NAO encontrei o "no" da busca, entao retorna a -1 indicando erro
								//Se eu comecei a contar (contar==true), significa que EU ENCONTREI o "no" da busca,  entao retorna a contagem (k)

	}

	No buscar(int conteudo) {
		No ultimo = inicio;

		while (ultimo.proximo != inicio && ultimo.conteudo != conteudo) {
			ultimo = ultimo.proximo;
		}

		return ultimo.conteudo == conteudo ? ultimo : null;
	}

	void remover(int nro) {
		if (inicio != null) {

			No anterior = inicio;
			No atual = inicio.proximo;

			while (atual != inicio && atual.conteudo != nro) {
				anterior = atual;
				atual = atual.proximo;
			}

			if (atual == anterior) {
				inicio = null;	/* Remove o único nó da lista */
			}
			else if (atual == inicio) {
				inicio = inicio.proximo;	/* remove o 1o nó da lista */
				anterior.proximo = inicio;
			}
			else {
				anterior.proximo = atual.proximo; 	/* remove do meio ou final da sequência */
			}
		}
	}

}
