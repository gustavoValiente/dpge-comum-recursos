package br.gov.ms.defensoria.comum.generics;

import java.util.List;
import java.util.Map;

public abstract class ServiceAdapter {

	@SuppressWarnings("rawtypes")
	public abstract IGenericEntity buscarPorID(Class clazz, Long id);

	public abstract IGenericEntity salvar(IGenericEntity entity);

	@SuppressWarnings("rawtypes")
	public abstract List<IGenericEntity> findAll(Class entity);

	public abstract void removerEntity(IGenericEntity entity);

	@SuppressWarnings("rawtypes")
	public abstract List<IGenericEntity> carregarPesquisaLazy(int startingAt, int maxPerPage, String fieldOrder, String order, Map<String, Object> parametros, Class entity);

	@SuppressWarnings("rawtypes")
	public abstract Long carregarPesquisaLazySize(String fieldOrder, String order, Map<String, Object> parametros, Class entity);

}
