package fila1809;

import javax.swing.*;


public class TesteFila {
	private static class Fila {

		public int numero;
		public String nome;
		public Fila  prox;
	}

	public static void main(String[] args) {
		Fila inicio = null;
		Fila fim = null;
		Fila aux;
		int op = 0;
		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(menu(), "1"));
				if (op < 1 || op > 6)
					JOptionPane.showMessageDialog(null, "Opção vinálida", "mensagem", JOptionPane.CLOSED_OPTION);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "TECLA CANCELAR FOI ACIONADA - ENCERRANDO.....", "MENSAGEM",
						JOptionPane.CLOSED_OPTION);
				break;
			}
			// inserir Fila
			if (op == 1) {
				int numero = Integer.parseInt(JOptionPane.showInputDialog("Número", "0"));
				aux = fim;
				boolean achou = false;
				while (aux != null) {
					if (aux.numero == numero) {
						achou = true;
						mensagem("Esse número já está na fila");
						break;
					}
					aux = aux.prox;
				}

				if (achou == false) {
					Fila novo = new Fila();
					novo.numero = numero;
					novo.nome = JOptionPane.showInputDialog("Nome", "Insira Seu Nome");
					novo.prox = fim;
					fim = novo;
				}
				// Contular toda fila
			}
			if (op == 2) {
				if(fim==null) {
					mensagem("A fila está vazia");
				}else {
					JTextArea saida = new JTextArea(6, 35); //Heigt x Width
					JScrollPane scroll = new JScrollPane(saida);
					saida.append("Numero\t"+"Nome\n");
					saida.append("==================\n");
					aux=fim;
					while(aux!=null) {
						//Verificar ender e prox(Desafio 2)
						if(aux.prox !=null) {
							System.out.println(
									"Num:" +aux.numero + ",endereço:"
									+aux.hashCode()+"=>"+"Prox =>"
									+aux.prox.hashCode()+"\n");
								}
						saida.append(aux.numero+"\t"+ aux.nome +"\n");
						aux = aux.prox;	
					}
					JOptionPane.showMessageDialog(null, scroll, 
							"CONSULTAR CHAPAS CADASTRADAS",
							JOptionPane.INFORMATION_MESSAGE);
						
				}
				
				// Remover da fila
			}
			if (op == 3) {
				// Escvaziar fila
			}
			if (op == 4) {
				// Quantidade de elementos de cada fila
			}
			if (op == 5) {
				aux=fim;
				int n=0;
				while(aux!=null) {
					aux=aux.prox;
					n++;
				}
				mensagem("A Pilha contém:" + n+ "elementos");

			}
			if (op == 6) {

			}
			
			} while (op != 7);
			System.out.println("PROGRAMA ENCERRADO!");

	}

			private static String menu() {
				String menu = "\nMenu de opções\n" + 
						"\n1 - Inserido na fila" + 
						"\n2 - Consulta Fila" + 
						"\n3 - Remover da fila "+
						"\n4 - Esvaziar fila" + 
						"\n5 - Quantidade de elementos da fil" +
						"\n6 -Sair";
				return menu;
			}
		
			private static void mensagem(String a) {
				JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
		
			}

}
