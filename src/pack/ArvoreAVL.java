package pack;

import java.util.*;

public class ArvoreAVL {

	

	private int altura(Node N) {

		if (N == null)
			return 0;
		return N.getAltura();
	}

	Node inserir(Node node, int valor) {

		if (node == null) {
			return (new Node(valor));
		}

		if (valor < node.getValor())
			node.setEsquerda(inserir(node.getEsquerda(), valor));
		else
			node.setDireita(inserir(node.getDireita(), valor));

		node.setAltura(Math.max(altura(node.getEsquerda()), altura(node.getDireita())) + 1);

		int balance = getBalance(node);

		if (balance > 1 && valor < node.getEsquerda().getValor())
			return dRotate(node);

		if (balance < -1 && valor > node.getDireita().getValor())
			return eRotate(node);

		if (balance > 1 && valor > node.getEsquerda().getValor()) {
			node.setEsquerda(eRotate(node.getEsquerda()));
			return dRotate(node);
		}

		if (balance < -1 && valor < node.getDireita().getValor()) {
			node.setDireita(dRotate(node.getDireita()));
			return eRotate(node);
		}

		return node;
	}

	private Node dRotate(Node y) {
		Node x = y.getEsquerda();
		Node T2 = x.getDireita();

		x.setDireita(y);
		y.setEsquerda(T2);

		y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);
		x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);

		return x;
	}

	private Node eRotate(Node x) {
		Node y = x.getDireita();
		Node T2 = y.getEsquerda();

		y.setEsquerda(x);
		x.setDireita(T2);

		x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);
		y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);

		return y;
	}

	private int getBalance(Node N) {
		if (N == null)
			return 0;
		return altura(N.getEsquerda()) - altura(N.getDireita());
	}

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getValor() + " ");
			preOrder(root.getEsquerda());
			preOrder(root.getDireita());
		}
	}

	public void posOrder(Node root) {

		if (root != null) {
			preOrder(root.getEsquerda());
			preOrder(root.getDireita());
			System.out.print(root.getValor() + " ");

		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			preOrder(root.getEsquerda());
			preOrder(root.getDireita());

		}
	}

	private Node minValueNode(Node node) {
		Node current = node;

		while (current.getEsquerda() != null)
			current = current.getEsquerda();
		return current;
	}

	public Node deletarNode(Node root, int value) {

		if (root == null)
			return root;

		if (value < root.getValor())
			root.setEsquerda(deletarNode(root.getEsquerda(), value));

		else if (value > root.getValor())
			root.setDireita(deletarNode(root.getDireita(), value));

		else {

			if ((root.getEsquerda() == null) || (root.getDireita() == null)) {

				Node temp;
				if (root.getEsquerda() != null)
					temp = root.getEsquerda();
				else
					temp = root.getDireita();

				if (temp == null) {
					temp = root;
					root = null;
				} else //
					root = temp;

				temp = null;
			} else {

				Node temp = minValueNode(root.getDireita());

				root.setValor(temp.getValor());

				root.setDireita(deletarNode(root.getDireita(), temp.getValor()));
			}
		}

		if (root == null)
			return root;

		root.setAltura(Math.max(altura(root.getEsquerda()), altura(root.getDireita())) + 1);

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.getEsquerda()) >= 0)
			return dRotate(root);

		if (balance > 1 && getBalance(root.getEsquerda()) < 0) {
			root.setEsquerda(eRotate(root.getEsquerda()));
			return dRotate(root);
		}

		if (balance < -1 && getBalance(root.getDireita()) <= 0)
			return eRotate(root);

		if (balance < -1 && getBalance(root.getDireita()) > 0) {
			root.setDireita(dRotate(root.getDireita()));
			return eRotate(root);
		}

		return root;
	}

	public Node buscarNode(Node root, int value) {

		if (root == null)
			return root;

		if (value < root.getValor() && root.getEsquerda() != null)
			root.setEsquerda(buscarNode(root.getEsquerda(), value));

		else if (value > root.getValor() && root.getDireita() != null)
			root.setDireita(buscarNode(root.getDireita(), value));

		else if (value == root.getValor()) {
			System.out.println("Arvore contem este elemento");
			return root;

		} else {
			System.out.println("Arvore NÃO contem este elemento");
			return root;
		}

		return root;

	}

	public Node alturaDoElemento(Node root, int value, int altura) {
		
		

		if (root == null)
			System.out.println("invalido");

		if (value < root.getValor() && root.getEsquerda() != null) {
			altura++;
			root.setEsquerda(alturaDoElemento(root.getEsquerda(), value,altura));

		} else if (value > root.getValor() && root.getDireita() != null) {
			altura++;
			root.setDireita(alturaDoElemento(root.getDireita(), value,altura));

		} else if (value == root.getValor()) {

			System.out.println("Altura do elemento é = " + altura);

		} else {
			System.out.println("Arvore NÃO contem este elemento");

		}

		return root;

	}

	private int soma(Node root) {
		if (root == null) {
			return 0;
		} else {
			int soma = 0;
			soma += soma(root.getEsquerda());
			soma += soma(root.getDireita());
			soma += root.getValor();
			return soma;
		}

	}

	private int qtdElementos(Node root) {
		if (root == null) {
			return 0;
		} else {
			int contE = qtdElementos(root.getEsquerda());
			int contD = qtdElementos(root.getDireita());
			return contE + contD + 1;
		}

	}

	float mediaValores(Node root) {
		return soma(root) / qtdElementos(root);
	}

	public void print(Node root) {

		if (root == null) {
			System.out.println("(XXXXXX)");
			return;
		}
		if (root.getAltura() <= 4) {

			int altura = root.getAltura(), largura = (int) Math.pow(2, altura - 1);

			List<Node> current = new ArrayList<Node>(1), next = new ArrayList<Node>(2);
			current.add(root);

			final int maxHalfLength = 4;
			int elementos = 1;

			StringBuilder sb = new StringBuilder(maxHalfLength * largura);
			for (int i = 0; i < maxHalfLength * largura; i++)
				sb.append(' ');
			String textBuffer;

			for (int i = 0; i < altura; i++) {

				sb.setLength(maxHalfLength * ((int) Math.pow(2, altura - 1 - i) - 1));

				textBuffer = sb.toString();

				for (Node n : current) {

					System.out.print(textBuffer);

					if (n == null) {

						System.out.print("        ");
						next.add(null);
						next.add(null);

					} else {

						System.out.printf("(%6d)", n.getValor());
						next.add(n.getEsquerda());
						next.add(n.getDireita());

					}

					System.out.print(textBuffer);

				}

				System.out.println();

				if (i < altura - 1) {

					for (Node n : current) {

						System.out.print(textBuffer);

						if (n == null)
							System.out.print("        ");
						else
							System.out.printf("%s      %s", n.getEsquerda() == null ? " " : "/",
									n.getDireita() == null ? " " : "\\");

						System.out.print(textBuffer);

					}

					System.out.println();

				}

				elementos *= 2;
				current = next;
				next = new ArrayList<Node>(elementos);
			}

		}

	}

}
