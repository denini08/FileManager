package f;

import java.io.File;

public class FileManager {
	
	public void listarRoots() {
		
	}
	
	public void listarTodosArquivos() {
		
	}
	
	public void buscar(String filtro) {
		
	}
	
	public void listarDiretorio(String caminho) throws Exception {
		File[] arquivos1 = new File(caminho).listFiles();
		int contador_arquivos = 0, contador_pastas = 0;
		if(arquivos1 == null) {
			throw new Exception("Não foi possivel abrir o diretorio");
		}
		for(int i = 0; i < arquivos1.length ; i++) {
			System.out.print("Nome: " + arquivos1[i].getName());
			if(arquivos1[i].isDirectory()) {
				System.out.println(" É pasta");
				contador_pastas++;
			}else {
				System.out.println(" É arquivo");
				contador_arquivos++;
			}
			
		}
		System.out.println("Quantidade de pastas: " + contador_pastas + 
				"\nQuantidade de arquivos: " + contador_arquivos);
	}
	
	public boolean apagar(String caminho)  throws Exception {  //retorna true se conseguiu apagar
		return false;
		
	}
	
	public void informacoes(String caminho) {
		
	}
	
	
	public boolean copia(String caminho,String destino) throws Exception  { //retorna true se conseguiu s
		
		return false;
		
	}
}
