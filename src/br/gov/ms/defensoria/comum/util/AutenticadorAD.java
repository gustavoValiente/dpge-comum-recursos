package br.gov.ms.defensoria.comum.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import br.gov.ms.defensoria.comum.wrapper.UserActiveDirectory;

/**
 * Classe de autenticação e listagem de usuários do Active Directory ou LDAP
 * 
 * @author Desenvolvimento DPGE-MS
 * @since JDK8 U45
 * @version 1.0
 * 
 **/
public class AutenticadorAD {
	private Hashtable<String, String> env = null;
	private LdapContext ctx = null;
	private String parametrosConexao = null;
	private StringBuffer searchBase = new StringBuffer();
	private int tipoConexao;
	public static final int TIPO_DOMINIO = 1;
	public static final int TIPO_OPENLDAP = 2;

	/**
	 * Construtor que recebe os parametros de autenticação simples
	 * 
	 * @param servidor
	 * @param paramConexao
	 * @param porta
	 * @param tipo
	 */
	public AutenticadorAD(String urlProvider, String dominio, int tipo) {
		this.tipoConexao = tipo;

		searchBase.append(urlProvider.toString());
		if (tipo == TIPO_DOMINIO) {
			this.parametrosConexao = "@" + dominio;
		} else {
			this.parametrosConexao = dominio;
		}
		env = new Hashtable<String, String>();
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, searchBase.toString());
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		searchBase = null;
	}

	/**
	 * Construtor que recebe os parametros para manipulação de dados no AD
	 * 
	 * @param env
	 *            - <code>HashTable</code>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AutenticadorAD(Hashtable env, String path) {
		this.env = env;
		this.searchBase.append(path);
	}

	/**
	 * Metodo de autenticação
	 * 
	 * @param usuario
	 * @param senha
	 * @return Object
	 */
	public Object autenticarUsuario(String usuario, String senha) {
		Boolean result = new Boolean("true");
		try {
			if (this.tipoConexao == TIPO_DOMINIO) {
				env.put(Context.SECURITY_PRINCIPAL, usuario.trim() + parametrosConexao.trim());
			} else {
				StringBuilder usu = new StringBuilder("uid=");
				usu.append(usuario.trim().toLowerCase()).append(",");
				usu.append(parametrosConexao.trim());
				env.put(Context.SECURITY_PRINCIPAL, usu.toString());
			}
			env.put(Context.SECURITY_CREDENTIALS, senha);
			ctx = new InitialLdapContext(env, null);
			System.out.println(ctx.toString());
		} catch (AuthenticationException e) {
			return result = new Boolean("false");
		} catch (Exception e) {
			return result = new Boolean("false");
		} finally {
			fecharConexaoJNDI();
		}
		return result;
	}

	/**
	 * Padroniza usuário principal DOMINIO OU OPENLDAP
	 * @param usuario
	 * @return securityPrincipal
	 */
	public String padronizarSecurityPrincipal(String usuario) {
		if (this.tipoConexao == TIPO_DOMINIO)
			return usuario.trim() + parametrosConexao.trim();
		else {
			StringBuilder usu = new StringBuilder("uid=");
			usu.append(usuario.trim().toLowerCase()).append(",");
			usu.append(parametrosConexao.trim());
			return usu.toString();
		}
	}

	private void fecharConexaoJNDI() {
		try {
			if (ctx != null) {
				ctx.close();
			}
		} catch (Exception e) {
		} finally {
			env = null;
			ctx = null;
		}
	}

	/**
	 * Método utilizado para filtrar os usuário do AD
	 * 
	 * @param regex
	 *            - Comumente utiliza-se cn,givenName ou samaccountname para
	 *            esse parametro
	 * @return List<ActiveDirectoryWrapper>
	 */
	@SuppressWarnings({ "rawtypes" })
	public List<UserActiveDirectory> filtrarUsuariosAD(String regex) {
		List<UserActiveDirectory> lista = new ArrayList<UserActiveDirectory>();
		try {
			NamingEnumeration results = null;
			DirContext ctx = new InitialDirContext(env);
			SearchControls search = new SearchControls();
			search.setSearchScope(SearchControls.SUBTREE_SCOPE);

			results = ctx.search(this.searchBase.toString(), "(&(objectClass=user)(" + regex + "))", search);
			UserActiveDirectory ad;
			while (results.hasMore()) {
				try {
					ad = new UserActiveDirectory();
					SearchResult searchResult = (SearchResult) results.next();
					// Listar todos atributos disponíveis
					// obterAtributosAD(searchResult);
					Attributes attributes = searchResult.getAttributes();
					ad.setCn(attributes.get("cn").toString().split(":")[1]);
					ad.setSamaccountname(attributes.get("samaccountname").toString().split(":")[1]);
					ad.setObjetos(searchResult.getName());
					lista.add(ad);
				} catch (Exception e) {
					// System.out.println(attrNome.get() + ";" +
					// e.getMessage());
				}
			}
			// System.out.println("Acabou" + count);
			ctx.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	/**
	 * Método para obter atributos disponíveis no AD
	 * 
	 * @param sr
	 *            - SearchResult
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	private void obterAtributosAD(SearchResult sr) {
		Attributes attrs = sr.getAttributes();
		if (attrs != null) {
			try {
				for (NamingEnumeration ae = attrs.getAll(); ae.hasMore();) {
					Attribute attr = (Attribute) ae.next();
				}
			} catch (NamingException e) {
				System.err.println("Problemas na listagem: " + e);
			}
		}
	}

	// Teste
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) throws AuthenticationException, Exception {
		Hashtable env = new Hashtable(5, 0.75f);
		String path = "ou=Defensoria,dc=dpge,dc=MS";
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "administrator@dpge.ms");
		env.put(Context.SECURITY_CREDENTIALS, "adm@2011-TI&Local");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://10.2.12.41:389");

		AutenticadorAD ad = new AutenticadorAD(env, path);
		for (UserActiveDirectory a : ad.filtrarUsuariosAD("cn=*ADAILTON*")) {
			System.out.println(a.getCn());
		}

		// System.out.println(AutenticadorAD.obterPadraoDC("dpge.MS"));
		/*
		 * AutenticadorAD ad = new AutenticadorAD("S176", "dpge.ms", "3268",
		 * TIPO_DOMINIO); try { Map<String, String> mapa =
		 * ad.carregarUsuariosActiveDirectory("givenName=*Ste*");// Buscar //
		 * todos // givenName=* // (* // filtro), // usuario //
		 * samaccountname=login
		 */

	}

	public static String obterPadraoDC(String domainController) {
		String[] dc = domainController.split("\\.");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < dc.length; i++) {
			result.append("dc=" + dc[i]);
			if (new Integer(i + 1) < dc.length)
				result.append(",");
		}
		return result.toString();
	}
}
