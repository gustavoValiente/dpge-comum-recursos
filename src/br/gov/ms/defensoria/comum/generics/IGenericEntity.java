package br.gov.ms.defensoria.comum.generics;

import java.io.Serializable;


/**
 * 
 * @author Equipe Desenvolvimento DPGE-MS
 *
 */
public interface IGenericEntity extends Serializable {
    
    /**
     * Retorna o id da classe.
     */
	
    public Long getId();
    
}
