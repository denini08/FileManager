package f;

import java.io.File;

public class FileManager {
	
	private int contador_arquivos = 0, contador_pastas = 0;
	
	private void setContador_arquivos(int i) {
		this.contador_arquivos = i;
	}
	
	private void setContador_pastas(int i) {
		this.contador_pastas = i;
	}
	
	private int getContador_arquivos() {
		return this.contador_arquivos;
	}
	
	private int getContador_pastas() {
		return this.contador_pastas;
	}
	
	public void listarRoots() throws Exception {
		File [] rot = File.listRoots();
		if(rot == null) {
			throw new Exception("Erro inesperado");
		}
		System.out.println("Esses são todos os Root's:");
		for(int i = 0; i < rot.length ; i++) {
			System.out.println(rot[i]);
		}
	}
	
	public void listarTodosArquivos() throws Exception {
		File [] rot = File.listRoots();
		
		if(rot == null) {
			throw new Exception("Erro inesperado");
		}
		
		for(int i = 0; i < rot.length ; i++) {
			System.out.println(rot[i].toString());
			System.out.println(" Mostrando tudo de " + rot[i].toString());
			mostrartudo(rot[i].toString());
		}
		
		
		System.out.println("Quantidade de pastas:" + getContador_pastas() 	
						 + "\nQuantidade de arquivos" + getContador_arquivos());
		setContador_arquivos(0);   //contador = 0
		setContador_pastas(0); 		//contador = 0
	}
	
	private void mostrartudo(String caminho) throws Exception {
		File[] arquivos1 = new File(caminho).listFiles();
		
		if(arquivos1 == null) {
			throw new Exception("diretorio nao existe");
		}
		for(int i = 0; i < arquivos1.length ; i++) {
			System.out.println("Nome: " + arquivos1[i].getName() + " caminho: " + arquivos1[i].getAbsolutePath());
			if(arquivos1[i].isDirectory()) {
				mostrartudo(arquivos1[i].getAbsolutePath());
				setContador_pastas(getContador_pastas() + 1);
			}else {
				setContador_arquivos(getContador_arquivos() + 1);;
			}
			
		}
	}
	
	public void buscar(String filtro) {
		
	}
	
	public void listarDiretorio(String caminho) throws Exception {
		File[] arquivos1 = new File(caminho).listFiles();
		if(arquivos1 == null) {
			throw new Exception("Não foi possivel abrir o diretorio");
		}
		for(int i = 0; i < arquivos1.length ; i++) {
			System.out.print("Nome: " + arquivos1[i].getName());
			if(arquivos1[i].isDirectory()) {
				System.out.println(" É pasta");
				setContador_pastas(getContador_pastas() + 1);
			}else {
				System.out.println(" É arquivo");
				setContador_arquivos(getContador_arquivos() + 1);;
			}
			
		}
		System.out.println("Quantidade de pastas: " + getContador_pastas() + 
				"\nQuantidade de arquivos: " + getContador_arquivos());
		
		setContador_arquivos(0);
		setContador_pastas(0);
		
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
