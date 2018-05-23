
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		

		escolhas();
		
		
	}
	
	public static void escolhas () throws Exception {
		
		FileManager fm = new FileManager("C://Users//Brenno//Desktop");
		String caminho, filtro;
		int escolha = 0;
		
		Scanner s =new Scanner(System.in);
		while(escolha != 8) {
			System.out.println("\n\n++++------------------+++++");
			System.out.println("Voc� est� em: "+ fm.getDiretorioAtual());
			System.out.println("Escolha sua op��o:\n"
					+ "0 - Mudar de diretorio\n"
					+ "1 - Listar todos os roots\n"
					+ "2 - Listar todos as arquivos de todos os Rots \n"
					+ "3 - Listar/Filtrar todos s arquivos a partir de um texto (Search)\n"
					+ "4 - Exibir todos os arquivos do diret�rio atual\n"
					+ "5 - Deletar arquivo\n"
					+ "6 - Listar atributos de um arquivo\n"
					+ "7 - Copiar um arquivo\n"
					+ "8 - Sair");
			escolha = s.nextInt();
			switch(escolha) {
				
				case 0:	
				try {
					System.out.println("Para qual diret�rio voc� deseja ir?");
					String diretorio = s.next();
					fm.setDiretorioAtual(diretorio);
				} catch (Exception e3) {
					System.out.println("Erro: " + e3.getMessage());
				}
					break;
			
			
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
					try {
						System.out.println("Mostrando todos os arquivos de "+fm.getDiretorioAtual());
						fm.listarDiretorio();
					} catch (Exception e2) {
						System.out.println("Erro: " + e2.getMessage());
					}
					
					break;
					
					
				case 5:
					System.out.println("Digite o nome do arquivo qual voc� deseja apagar:");
					caminho = s.next();
					try {
						if(fm.apagar(caminho)) {
							System.out.println("Arquivo deletado com sucesso");
						}
						else {
							System.out.println("Opera��o de exclus�o cancelada");
						}
					} catch (Exception e1) {
						
						System.out.println("Erro: " + e1.getMessage());
					}
					break;
					
					
				case 6:
					System.out.println("Digite o nome do arquivo qual voc� deseja ver informa��es:");
					caminho = s.next();
					fm.informacoes(caminho);
					
					break;
					
					
				case 7:
					System.out.println("Digite o nome do arquivo qual voc� deseja COPIAR:");
					caminho = s.next();
					
					try {
						fm.buscaArquivoCopia(caminho);
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					
					
					break;
					
					
				case 8:
						System.out.println("At� mais!");
						break;
				default: 
					System.out.println("Voce digitou a op��o errada");
					break;
			}
			
		}
		
	}
}
