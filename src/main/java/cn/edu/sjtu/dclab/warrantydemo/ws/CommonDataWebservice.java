package cn.edu.sjtu.dclab.warrantydemo.ws;

import java.awt.color.CMMException;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.wink.server.utils.LinkBuilders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.sjtu.dclab.warrantydemo.services.*;
import cn.edu.sjtu.se.dclab.cloud.dataaccessor.entityservice.ContextManager;

@Path("/service")
public class CommonDataWebservice {

	private static CommonDataWebservice instance;
	
	private CommonDataWebservice() {
		this.resourcePoolProcessor = new ResourcePoolProcessorImpl();
	}
	
	public static CommonDataWebservice getInstance() {
		if (instance == null) {
			instance = new CommonDataWebservice();
		}
		return instance;
	}
		
	private ResoucePoolProcessor resourcePoolProcessor;

	public void setResourcePoolProcessor(
			ResoucePoolProcessor resourcePoolProcessor) {
		this.resourcePoolProcessor = resourcePoolProcessor;
	}

	@Path("/test")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject test()
			throws Exception {
		
		JSONObject result = new JSONObject();
		result.put("hello", "world");
		return result;
	}

	
	@Path("/{resourceType}/{resourceId}")
	@GET
	//@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject get(
			@PathParam(value = "resourceType") String resourceType,
			@PathParam(value = "resourceId") Long resourceId) throws JSONException
			 {
		
		if (!resourceExists(resourceType)) {
			return exceptionObject(null);
		}
		Object result;
		try {
			result = resourcePoolProcessor.get(resourceType, resourceId);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionObject(e.getMessage());
		}
		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}")
	@GET
	//@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public Object list(
			@PathParam(value = "resourceType") String resourceType,
			@Context UriInfo uriInfo) throws JSONException  {
		
		if (!resourceExists(resourceType)) {
			return exceptionObject(null);
		}

		MultivaluedMap<String, String> formParams = uriInfo
				.getQueryParameters();

		List<Object> result;
		try {
			result = resourcePoolProcessor.list(resourceType, formParams);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionObject(e.getMessage());
		}

		return (JSONArray)toJson(result);
	}
	
	
	@Path("/{resourceType}")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject create(
			@PathParam(value = "resourceType") String resourceType,
			MultivaluedMap<String, String> formParams) throws JSONException  {
		
		if (!resourceExists(resourceType)) {
			return exceptionObject(null);
		}

		Object result;
		try {
			result = resourcePoolProcessor.insert(resourceType, formParams);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionObject(e.getMessage());
		}

		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}/{resourceId}")
	@PUT
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject update(
			@PathParam(value = "resourceType") String resourceType,
			@PathParam(value = "resourceId") Long resourceId,
			MultivaluedMap<String, String> formParams) throws JSONException {
		
		if (!resourceExists(resourceType)) {
			return exceptionObject(null);
		}

		Object result;
		try {
			result = resourcePoolProcessor.update(resourceType, resourceId,
					formParams);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionObject(e.getMessage());
		}

		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}/{resourceId}")
	@DELETE
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject delete(
			@PathParam(value = "resourceType") String resourceType,
			@PathParam(value = "resourceId") Long resourceId) throws JSONException
			  {
		if (!resourceExists(resourceType)) {
			return exceptionObject(null);
		}

		Boolean result;
		try {
			result = resourcePoolProcessor.delete(resourceType, resourceId);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionObject(e.getMessage());
		}

		return (JSONObject)toJson(result);
	}


	public String classNameForResourceType(String resourceType) {
		return resourceType.substring(0,1).toUpperCase() + resourceType.substring(1).toLowerCase();
	}
	
	private static Object toJson(Object o) {
		if (o == null) {
			return null;
		}
	
		if (Collection.class.isInstance(o) || o.getClass().isArray()) {
			net.sf.json.JSONArray jaa = net.sf.json.JSONArray.fromObject(o);
			JSONArray ja = new JSONArray(jaa);
			return ja;
		} else {
			net.sf.json.JSONObject joo = net.sf.json.JSONObject.fromObject(o);
			JSONObject jo = new JSONObject(joo);
			return jo;
		}		
	}
	
	private boolean resourceExists(String resource) {
		ContextManager cm = new ContextManager();
		return cm.pathForClass(resource) != null;
	}
	
	private JSONObject exceptionObject(String msg) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("status", "exception");
		if (msg != null) {
			obj.put("message", msg);
		}
		return obj;
	}
}
