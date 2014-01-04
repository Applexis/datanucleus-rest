package cn.edu.sjtu.dclab.warrantydemo.services;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

public interface ResoucePoolProcessor {

	Object insert(String type, MultivaluedMap<String, String> params)
			throws Exception;

	boolean delete(String type, Long id) throws Exception;

	List<Object> list(String type, MultivaluedMap<String, String> params)
			throws Exception;

	Object get(String type, Long id) throws Exception;

	Object update(String type, Long id, MultivaluedMap<String, String> params)
			throws Exception;

}
