package br.gov.ms.defensoria.comum.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.gov.ms.defensoria.comum.exception.SystemException;

public class HttpOutputStreamHandler {

	public void sendByteArrayToOutputStream(String filename, String mimeType,
			byte[] content, HttpServletResponse response) {
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "" + "\";");
		response.setContentLength(content.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();

			// O conteúdo armazenado em content deve ser enviado aos poucos para
			// o canal de saída do servlet.
			// Se esse procedimento não for adotado, um array de bytes muito
			// grande pode tomar uma grande quantidade
			// de memória do servidor.
			ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(
					content);
			byte[] buffer = new byte[2048];
			for (int count = 0; (count = byteArrayInput.read(buffer)) > 0;) {
				ouputStream.write(buffer, 0, count);
				ouputStream.flush();
			}
			ouputStream.close();
		} catch (IOException e) {
			throw new SystemException(e);
		}
	}
}
