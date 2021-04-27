package pack;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ArvoreAVL t = new ArvoreAVL();
		Node root = null;
		int length;
		int val;
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		System.out.print("Quantidade de elementos da arvore : ");
		length = in.nextInt();

		for (int i = 0; i < length; i++) {
			val = random.nextInt(50);
			root = t.inserir(root, val);

		}
		System.out.println("\n");
		t.print(root);

		while (true) {

			System.out.println("(1) Inserir");
			System.out.println("(2) Deletar");
			System.out.println("(3) Buscar");
			System.out.println("(4) Imprimir media dos valores");
			System.out.println("(5) Imprimir em pré-ordem");
			System.out.println("(6) Imprimir em pós-ordem");
			System.out.println("(7) Imprimir em ordem simétrica");
			System.out.println("(8) Imprimir a altura de um elemento");
			System.out.println("(9) Imprimir profundidade da arvore");
			int op = in.nextInt();

			switch (op) {
			case 1:
				System.out.print("Digite o valor a ser inserido: ");
				val = in.nextInt();
				root = t.inserir(root, val);
				break;
			case 2:
				System.out.print("Digite o valor a ser deletado: ");
				val = in.nextInt();
				root = t.deletarNode(root, val);
				break;
			case 3:
				System.out.print("Digite o valor a ser Buscado: ");
				val = in.nextInt();
				root = t.buscarNode(root, val);

				break;
			case 4:
				System.out.println("A media dos valores é = " + t.mediaValores(root));
				break;

			case 5:
				t.preOrder(root);
				System.out.println("\n");
				break;

			case 6:
				t.posOrder(root);
				System.out.println("\n");
				break;

			case 7:
				t.inOrder(root);
				System.out.println("\n");
				break;
				
			case 8:
				System.out.print("Digite o valor a ser Buscado: ");
				val = in.nextInt();
				t.alturaDoElemento(root, val,0);
				break;
				
			case 9:
				System.out.println("A profundida da arvore é de "+root.getAltura()+" nós");
				break;

			default:
				System.out.println("Opção invalida / Tente novamente");

				break;
			}

			t.print(root);

		}

	}
}
