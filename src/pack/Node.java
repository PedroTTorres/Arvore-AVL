package pack;

public class Node {
	private Node esquerda, direita;
	private int altura = 1;
	private int valor;

	public Node(int val) {
		this.setValor(val);
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node left) {
		this.esquerda = left;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node right) {
		this.direita = right;
	}
}
