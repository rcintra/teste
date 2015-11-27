package br.ccb.com.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ParametroService
 */
@Stateless
@LocalBean
public class ParametroService implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1205988389423760047L;

	public String sayHello(String name) {
		return "Hello " + name;
	}

}
