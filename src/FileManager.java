
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	
	private static final Exception Exception = null;
	private int contador_arquivos = 0, contador_pastas = 0;
	private String diretorioAtual = "C://Users//Brenno//Desktop";
	
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
	
	public void buscaArquivoCopia(String arquivo)throws Exception {
		ArrayList<File> arq;
		Scanner s = new Scanner(System.in);
		int arquivoEscolhido;
		String caminhoNovoArquivo;
		
		arq = buscar(arquivo);
		
		if(arq.isEmpty()) {
			System.out.println("Nenhum arquivo encontrado");
			return;
		}
		
		if(arq.size() > 1) {
			System.out.println("Mais de um arquivo foi encontrado");
			System.out.println("Especifique qual você deseja copiar");
			
			for(int i = 0; i < arq.size(); i++) {
				System.out.println(i + " - "+ arq.get(i).getName() + " caminho: " + arq.get(i).getAbsolutePath());
			}
			
			System.out.println("digite o numero correspondente ao arquivo que você deseja copiar");
			
			arquivoEscolhido = s.nextInt();

			System.out.println("Nome: " + arq.get(arquivoEscolhido).getName());
			System.out.println("Caminho: " + arq.get(arquivoEscolhido).getAbsolutePath());
			System.out.println("Digite o diretorio para onde o novo arquivo vai ser copiado:");
			
			caminhoNovoArquivo = s.nextLine();
			
			copiaArquivo(arq.get(arquivoEscolhido),caminhoNovoArquivo);
		}
		else {
			System.out.println("Nome: " + arq.get(0).getName());
			System.out.println("Caminho: " + arq.get(0).getAbsolutePath());
			System.out.println("Digite o diretorio para onde o novo arquivo vai ser copiado:");
			
			caminhoNovoArquivo = s.nextLine();
			
			copiaArquivo(arq.get(0),caminhoNovoArquivo);
		}
		System.out.println("Arquivo copiado com sucesso");
	}
	
	public void copiaArquivo(File arquivo,String caminhoNovoArquivo) throws IOException {
		
		FileInputStream in = new FileInputStream(arquivo.getAbsolutePath());
		FileOutputStream out = new FileOutputStream(caminhoNovoArquivo+"Copia"+arquivo.getName());
		File arquivoLeitura = new File(arquivo.getAbsolutePath());
		
		int tamanhoArquivo = (int) arquivoLeitura.length();
		
		byte[] b = new byte [tamanhoArquivo];
		
		try {
			in.read(b);
			out.write(b);
		}
		catch(Exception e) {
			System.out.println("Erro ao copiar arquivos");
		}
		finally {
			in.close();
			out.close();
		}
		
	}
	
	public void listarRoots() throws Exception { // exibe todos os roots
		File [] rot = File.listRoots();
		if(rot == null) {
			throw new Exception("Erro inesperado");
		}
		System.out.println("Esses são todos os Root's:");
		for(int i = 0; i < rot.length ; i++) {
			System.out.println(rot[i]);
		}
	}
	
	public File[] getRoots() {	// retorna um array c os roots do pc 
		return File.listRoots();
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
	
	public ArrayList<File> buscar(String arquivo) throws java.lang.Exception{
		ArrayList<File>diretorios = new ArrayList<File>(); // arrayList q vai ser preenchido e percorrido p buscar o arquivo especificado
		ArrayList<File>arquivosEncontrados = new ArrayList<File>(); // arrayList q vai guardar os arquivos q forem sendo achados
		
		diretorios = getArquivos(this.diretorioAtual); // preenche o arrayList diretorios c todos os diretorios do root
		
		if(diretorios.isEmpty()) System.out.println(this.diretorioAtual + "especificado está vazio");
		
		for(int i = 0; i < diretorios.size(); i++) { // percorre o array diretorios
			if(diretorios.get(i).getName().equals(arquivo)) { // se for igual ao nome passado cmo parametro
				arquivosEncontrados.add(diretorios.get(i)); // add em arquivos encontrados
			}
		}
		
		if(arquivosEncontrados.isEmpty()) System.out.println("Nenhum arquivo encontrado");
		
		System.out.println(arquivosEncontrados.size() + " arquivo(s) encontrado(s):");
		
		for(int i = 0; i < arquivosEncontrados.size(); i++) {
			System.out.println("Nome: " + arquivosEncontrados.get(i).getName());
			System.out.println("Caminho: " + arquivosEncontrados.get(i).getAbsolutePath());
			System.out.println("______________________________________________________");
		}
		
		return arquivosEncontrados;
	}
	
	public ArrayList<File> getArquivos(String inicio) throws java.lang.Exception{ // retorna um arrayList c todos os diretorios a partir de um caminho especificado
		ArrayList<File> diretorios = new ArrayList<File>();
		addArquivos(inicio,diretorios);
		return diretorios;
	}
	
	public void addArquivos(String inicio, ArrayList<File> diretorios) throws Exception{ // add todos os arquivos num arraylist a partir de um caminho especificado 
		File[] arquivos1 = new File(inicio).listFiles();
		
		if(arquivos1 == null) {
			throw new Exception("diretorio nao existe");
		}
		
		for(int i = 0; i < arquivos1.length ; i++) {
			diretorios.add(arquivos1[i]);
			if(arquivos1[i].isDirectory()) {
				addArquivos(arquivos1[i].getAbsolutePath(),diretorios);
			}
		}
	}
	
	public void mostrartudo(String caminho) throws Exception {
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
				setContador_arquivos(getContador_arquivos() + 1);
			}	
		}
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
	
	public boolean apagar(String arquivo)  throws Exception {  //retorna true se conseguiu apagar
		
		ArrayList<File>arquivosEncontrados = buscar(arquivo);
		Scanner s = new Scanner(System.in);
		int arquivoEscolhido;
		int confirmacao;
		
		if(arquivosEncontrados.isEmpty()) return false;
		
		if(arquivosEncontrados.size() > 1) {
			System.out.println("Mais de um arquivo foi encontrado");
			System.out.println("Especifique qual você deseja excluir");
			
			for(int i = 0; i < arquivosEncontrados.size(); i++) {
				System.out.println(i + " - "+ arquivosEncontrados.get(i).getName() + " caminho: " + arquivosEncontrados.get(i).getAbsolutePath());
			}
			
			System.out.println("digite o numero correspondente ao arquivo que você deseja excluir");
			
			arquivoEscolhido = s.nextInt();
			
			System.out.println("Nome: " + arquivosEncontrados.get(arquivoEscolhido).getName());
			System.out.println("Caminho: " + arquivosEncontrados.get(arquivoEscolhido).getAbsolutePath());
			System.out.println("Tem certeza que deseja excluir esse arquivo? 1 - confirma/ 2 - cancela");
			System.out.println("______________________________________________________");
			
			confirmacao = s.nextInt();
			
			if(confirmacao == 1) {
				arquivosEncontrados.get(arquivoEscolhido).delete();
				return true;
			}
			else {
				return false;
			}
		} 
		else {
			
			System.out.println("Nome: " + arquivosEncontrados.get(0).getName());
			System.out.println("Caminho: " + arquivosEncontrados.get(0).getAbsolutePath());
			System.out.println("Tem certeza que deseja excluir esse arquivo? 1 - confirma/ 2 - cancela");
			System.out.println("______________________________________________________");
			
			confirmacao = s.nextInt();
			
			if(confirmacao == 1) {
				arquivosEncontrados.get(0).delete();
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void informacoes(String caminho) {
		
	}
	
	
	public boolean copia(String caminho,String destino) throws Exception  { //retorna true se conseguiu s
		
		return false;
		
	}
}
