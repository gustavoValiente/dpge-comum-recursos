package br.gov.ms.defensoria.comum.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.commons.io.FileUtils;
import org.jboss.logging.Logger;

import br.gov.ms.defensoria.comum.exception.SystemException;

public class FileFacility {

	/** Constante UTF8 */
	private static final String ENCODING = "UTF-8";

	/** Instancia do Logger */
	private static Logger _logger = Logger.getLogger(FileFacility.class
			.getName());

	/** Constantes com o tipos de arquivo */
	private static Map<String, String> _mimeTypes = new HashMap<String, String>();
	static {
		_mimeTypes = new HashMap<String, String>();
		_mimeTypes.put("java", "text/plain");
		_mimeTypes.put("class", "application/java");
		_mimeTypes.put("txt", "text/plain");
		_mimeTypes.put("xml", "application/xml");
		_mimeTypes.put("sql", "text/plain");
		_mimeTypes.put("rtf", "text/rtf");
		_mimeTypes.put("htm", "text/html");
		_mimeTypes.put("html", "text/html");
		_mimeTypes.put("shtml", "text/html");
		_mimeTypes.put("css", "text/css");
		_mimeTypes.put("pdf", "application/pdf");
		_mimeTypes.put("doc", "application/msword");
		_mimeTypes.put("xls", "application/x-msexcel");
		_mimeTypes.put("mpp", "application/vnd.ms-project");
		_mimeTypes.put("ppt", "application/mspowerpoint");
		_mimeTypes.put("pps", "application/mspowerpoint");
		_mimeTypes.put("tar", "application/x-tar");
		_mimeTypes.put("zip", "application/x-compressed");
	}

	/**
	 * Move o arquivo para outro diretório
	 * 
	 * @return retorna verdadeiro se a operacao foi realizada com sucesso e
	 *         falso caso contrario.
	 * @param file
	 *            arquivo (file) a ser movido
	 * @param path
	 *            caminho para onde o arquivo deve ser movido
	 **/
	public static Boolean moveFile(File file, String path) throws IOException {
		if (file == null || path == null) {
			_logger.error("Parametro não informado corretamente.");
			return false;
		}
		// Destination directory
		File dir = new File(path);
		if (_logger.isDebugEnabled()) {
			_logger.debug("Diretório existe: " + dir.exists());
			_logger.debug("Arquivo existe: " + file.exists());
		}
		// Move file to new directory
		boolean success = file.renameTo(new File(path, file.getName()));
		if (!success) {
			return false;
		}
		return true;
	}

	/**
	 * Compacta um arquivo usando o zip
	 * 
	 * @param content
	 *            a ser compactado
	 * @return arquivo compactado
	 * @see http://www.exampledepot.com/egs/java.util.zip/CompArray.html
	 */
	public static byte[] zipFile(byte[] content) {
		if (content == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		// Create the compressor with highest level of compression
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		// Give the compressor the data to compress
		deflater.setInput(content);
		deflater.finish();
		// Create an expandable byte array to hold the compressed data.
		// You cannot use an array that's the same size as the orginal because
		// there is no guarantee that the compressed data will be smaller than
		// the uncompressed data.
		ByteArrayOutputStream bos = new ByteArrayOutputStream(content.length);
		// Compress the data
		byte[] buf = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buf);
			bos.write(buf, 0, count);
		}
		try {
			bos.close();
		} catch (IOException e) {
			_logger.error("Erro ao compactar arquivo.", e);
			throw new SystemException(e);
		}
		// Get the compressed data
		byte[] compressedData = bos.toByteArray();
		return compressedData;
	}

	/**
	 * Descompacta um arquivo zipado
	 * 
	 * @param content
	 *            a ser descompactado
	 * @return arquivo descompactado
	 * @see http://www.exampledepot.com/egs/java.util.zip/DecompArray.html
	 */
	public static byte[] unzipFile(byte[] content) {
		if (content == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		// Create the decompressor and give it the data to compress
		Inflater inflater = new Inflater();
		inflater.setInput(content);
		// Create an expandable byte array to hold the decompressed data
		ByteArrayOutputStream bos = new ByteArrayOutputStream(content.length);
		// Decompress the data
		byte[] buf = new byte[1024];
		while (!inflater.finished()) {
			try {
				int count = inflater.inflate(buf);
				bos.write(buf, 0, count);
			} catch (DataFormatException e) {
				_logger.error("Erro ao descompactar arquivo.", e);
				throw new SystemException(e);
			}
		}
		try {
			bos.close();
		} catch (IOException e) {
			_logger.error("Erro ao descompactar arquivo.", e);
			throw new SystemException(e);
		}
		// Get the decompressed data
		byte[] decompressedData = bos.toByteArray();
		return decompressedData;
	}

	/**
	 * Retorna uma lista com as N primeiras linhas de um arquivo passado como
	 * parâmetro. O arquivo é lido segundo o encoding UTF-8.
	 * 
	 * @param file
	 * @param numberOfLinesToRead
	 * @return
	 * @throws IOException
	 */
	public static List<String> head(File file, int numberOfLinesToRead)
			throws IOException {
		return head(file, ENCODING, numberOfLinesToRead);
	}

	/**
	 * Retorna uma lista com as N primeiras linhas de um arquivo passado como
	 * parâmetro. O arquivo é lido segundo o encoding especificado.
	 * 
	 * @param file
	 * @param numberOfLinesToRead
	 * @return
	 * @throws IOException
	 */
	public static List<String> head(File file, String encoding,
			int numberOfLinesToRead) throws IOException {
		if ((file == null) || !file.exists() || !file.isFile()
				|| !file.canRead()) {
			_logger.error("Nao é possível ler do arquivo especificado.");
			throw new SystemException(
					"Nao é possível ler do arquivo especificado.");
		}
		LinkedList<String> lines = new LinkedList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), encoding));
		for (String line = null; (numberOfLinesToRead-- > 0)
				&& (line = reader.readLine()) != null;) {
			lines.addLast(line);
		}
		reader.close();
		return lines;
	}

	/**
	 * Grava um arquivo no repositório. Retorna o nome do arquivo gerado.
	 * 
	 * @param fileName
	 *            Nome do arquivo enviado pelo cliente ou o seu link.
	 * @param fileContent
	 *            Conteúdo do arquivo em bytes. Pode ser null em caso de link.
	 * @param mimeType
	 *            Mime-type do arquivo enviado. Pode ser null em caso de link.
	 * @param repository
	 *            Nome do repositório onde o aquivo será salvo.
	 * @return Nome do arquivo gerado.
	 */
	public static String storeFile(String fileName, byte[] fileContent,
			String mimeType, String repository) throws IOException {
		if (repository == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		if (_logger.isDebugEnabled()) {
			_logger.debug("Gerando arquivo em disco. fileName = " + fileName);
		}
		FileOutputStream fOut = new FileOutputStream(getFullPath(repository,
				fileName, mimeType));
		BufferedOutputStream bufOut = new BufferedOutputStream(fOut);
		try {
			bufOut.write(fileContent, 0, fileContent.length);
		} finally {
			bufOut.close();
			fOut.close();
		}
		return fileName;
	}

	/**
	 * Trata o repositorio o path para manter arquivos
	 * 
	 * @param repository
	 */
	private static String getFullPath(String repository, String fileName,
			String mimeType) {
		if (!repository.endsWith("\\") || !repository.endsWith("/")) {
			repository += "/";
		}
		String storedFilename = fileName;
		String fullPath = null;
		if (mimeType != null) {
			fullPath = repository + storedFilename + mimeType;
		} else {
			fullPath = repository + storedFilename;
		}
		return fullPath;
	}

	/**
	 * Remove um arquivo do repositório.
	 * 
	 * @param filename
	 *            Nome do arquivo a ser removido.
	 * @param repository
	 *            Nome do repositório onde o aquivo será salvo.
	 */
	public static void removeFile(String filename, String repository)
			throws IOException {
		if (filename == null || repository == null) {
			_logger.error("Parametro não informado corretamente.");
			return;
		}
		if (_logger.isDebugEnabled()) {
			_logger.debug("Apagando arquivo em disco. filename = " + filename);
		}
		if (!repository.endsWith("\\") || !repository.endsWith("/")) {
			repository += "/";
		}
		String fullPath = repository + filename;
		File file = new File(fullPath);
		if (!file.delete()) {
			_logger.error("Erro ao apagar o arquivo" + filename);
			throw new RuntimeException("Erro ao apagar o arquivo " + filename);
		}
	}

	/**
	 * Retorna a extensão do arquivo
	 * 
	 * @param fileName
	 *            - nome do arquivo
	 * @return
	 */
	public static String getExtension(String fileName) {
		if (fileName == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		int dotIndex = fileName.lastIndexOf(".");
		if (dotIndex == -1) {
			return "";
		} else {
			return fileName.substring(dotIndex + 1);
		}
	}

	/**
	 * Retorna o tipo do arquivo
	 * 
	 * @param filename
	 *            - nome do arquivo
	 * @return
	 */
	public static String getMimeTypeForFilename(String filename) {
		if (filename == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		String extension = getExtension(filename);
		return getMimeTypeForExtension(extension);
	}

	/**
	 * Retorna o tipo do arquivo
	 * 
	 * @param extension
	 *            - extensão
	 * @return
	 */
	private static String getMimeTypeForExtension(String extension) {
		if (extension == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		String result = (String) _mimeTypes.get(extension);
		if (result == null || result.trim().length() < 1) {
			result = "application/octet-stream";
		}
		return result;
	}

	/**
	 * Retorna o nome do arquivo contido dentro do path. Por exemplo: Se o path
	 * for "c:/Inetpub/wwwroot/index.html" retorna a String "index.html".
	 * 
	 * @param path
	 *            O path completo do arquivo.
	 * @return o nome do arquivo contido dentro do path. Por exemplo: Se o path
	 *         for "c:/Inetpub/wwwroot/index.html" retorna a String
	 *         "index.html".
	 */
	public static String getOnlyFileName(String path) {
		if (path == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		// ajusta diferencas de plataforma Windows x Unix
		path = path.replace('/', File.separatorChar);
		path = path.replace('\\', File.separatorChar);
		String fileName = null;
		int intLastIndexOfSeparator = path.lastIndexOf(File.separatorChar);
		if (intLastIndexOfSeparator != -1) {
			fileName = path.substring(intLastIndexOfSeparator + 1);
		} else {
			fileName = path;
		}
		return fileName;
	}

	/**
	 * Este método le os dados que estão em uma URL e transforma estes dados em
	 * um InputStream
	 * 
	 * @param url
	 * @return InputStream
	 * @throws Exception
	 */
	public static InputStream urlReader(String url) throws Exception {
		if (url == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		URL urlF = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlF.openStream()));
		String inputLine;
		String resultIO = new String();
		while ((inputLine = in.readLine()) != null) {
			resultIO += inputLine;
		}
		in.close();
		InputStream byteArrayInputStream = new ByteArrayInputStream(
				resultIO.getBytes());
		return byteArrayInputStream;
	}

	/**
	 * Lê o arquivo do filesystem, o método procura no filesystem, se não
	 * encontrar ele busca no classloader
	 * 
	 * @param fileName
	 * @return array de bytes do arquivo encontrado
	 * @throws IOException
	 */
	public static byte[] readFile(String fileName, String repository)
			throws IOException {
		if (fileName == null || repository == null) {
			_logger.error("Parametro não informado corretamente.");
			return null;
		}
		File file = new File(getFullPath(repository, fileName, null));
		byte[] content;
		try {
			content = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			_logger.error("Erro ao ler arquivo", e);
			throw new IOException("Erro ao ler arquivo", e);
		}
		return content;
	}
}
