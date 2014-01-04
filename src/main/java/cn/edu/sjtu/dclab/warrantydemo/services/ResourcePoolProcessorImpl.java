package cn.edu.sjtu.dclab.warrantydemo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;


import cn.edu.sjtu.se.dclab.cloud.dataaccessor.entityservice.*;

public class ResourcePoolProcessorImpl implements ResoucePoolProcessor {

	EntityDataService eds = new EntityDataService();
	

	public Object insert(String type, MultivaluedMap<String, String> params)
			throws Exception {
		return eds.insertByMap(type, mapByMultiValueMap(params));
	}


	public boolean delete(String type, Long id) throws Exception {
		return eds.delById(type, id);
	}

	public List<Object> list(String type, MultivaluedMap<String, String> params)
			throws Exception {
		return eds.getByCondition(type, mapByMultiValueMap(params));
	}

	public Object get(String type, Long id) throws Exception {
		System.out.println(fullClassNameForType(type));
		return eds.getById(Class.forName(fullClassNameForType(type)), id);
	}

	public Object update(String type, Long id,
			MultivaluedMap<String, String> params) throws Exception {
		return eds.updateByMap(Class.forName(fullClassNameForType(type)), id, mapByMultiValueMap(params));
	}
	
	private Map<String, Object> mapByMultiValueMap(MultivaluedMap<String, String> mm) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (String key: mm.keySet()) {
			map.put(key, mm.get(key));
		}
		return map;
	}
	
	private String fullClassNameForType(String type) {
		return type;
		//return packageName + "." + type.substring(0, 1).toUpperCase() + type.substring(1);
	}
	
}
