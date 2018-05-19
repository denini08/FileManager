import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		

		FileManager fm = new FileManager();
		
		fm.buscar("nenhum.txt");
		
	}
	
	public void escolhas () throws Exception {
		
		FileManager fm = new FileManager();
		String caminho, filtro;
		int escolha = 0;
		
		Scanner s =new Scanner(System.in);
		while(escolha != 8) {
			System.out.println("\n\n++++------------------+++++");
			System.out.println("Escolha sua opção:\n"
					+ "1 - Listar todos os roots\n"
					+ "2 - Listar todos as arquivos de todos os Rots \n"
					+ "3 - Listar/Filtrar todos s arquivos a partir de um texto (Search)\n"
					+ "4 - Listar diretorio\n"
					+ "5 - Deletar arquivo\n"
					+ "6 - Listar atributos de um arquivo\n"
					+ "7 - Copiar um arquivo\n"
					+ "8 - Sair");
			escolha = s.nextInt();
			switch(escolha) {
				case 1:	
				try {
					fm.listarRoots();
				} catch (Exception e3) {
					System.out.println("Erro: " + e3.getMessage());
				}
					break;
					
					
				case 2:
				try {
					fm.listarTodosArquivos();
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
					break;
					
					
				case 3:
					System.out.println("Digite o filtro da pesquisa:");
					caminho = s.next();
					fm.buscar(caminho);
					break;
					
					
				case 4:
					System.out.println("Digite o endereço qual você deseja listar:");
					filtro = s.next();
					try {
						fm.listarDiretorio(filtro);
					} catch (Exception e2) {
						System.out.println("Erro: " + e2.getMessage());
					}
					
					break;
					
					
				case 5:
					System.out.println("Digite o endereço do arquivo qual você deseja apagar:");
					caminho = s.next();
					try {
						fm.apagar(caminho);
					} catch (Exception e1) {
						
						System.out.println("Erro: " + e1.getMessage());
					}
					break;
					
					
				case 6:
					System.out.println("Digite o endereço do arquivo qual você deseja ver informações:");
					caminho = s.next();
					fm.informacoes(caminho);
					
					break;
					
					
				case 7:
					System.out.println("Digite o endereço do arquivo qual você deseja COPIAR:");
					caminho = s.next();
				
					System.out.println("Digite o endereço do arquivo qual você deseja COLAR:");
					String destino = s.next();
					
					try {
						fm.copia(caminho,destino);
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					
					
					break;
					
					
				case 8:
						System.out.println("Até mais!");
						break;
				default: 
					System.out.println("Voce digitou a opção errada");
					break;
			}
			
		}
		
	}
}
