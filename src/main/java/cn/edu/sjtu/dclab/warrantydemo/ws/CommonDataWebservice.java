package cn.edu.sjtu.dclab.warrantydemo.ws;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.sjtu.dclab.warrantydemo.services.*;

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
			@PathParam(value = "resourceId") Long resourceId)
			throws Exception {
		
		Object result = resourcePoolProcessor.get(resourceType, resourceId);
		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}")
	@GET
	//@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONArray list(
			@PathParam(value = "resourceType") String resourceType,
			@Context UriInfo uriInfo) throws Exception {
		MultivaluedMap<String, String> formParams = uriInfo
				.getQueryParameters();

		List<Object> result = resourcePoolProcessor.list(resourceType, formParams);

		return (JSONArray)toJson(result);
	}
	
	
	@Path("/{resourceType}")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject create(
			@PathParam(value = "resourceType") String resourceType,
			MultivaluedMap<String, String> formParams) throws Exception {

		Object result = resourcePoolProcessor.insert(resourceType, formParams);

		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}/{resourceId}")
	@PUT
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject update(
			@PathParam(value = "resourceType") String resourceType,
			@PathParam(value = "resourceId") Long resourceId,
			MultivaluedMap<String, String> formParams) throws Exception {

		Object result = resourcePoolProcessor.update(resourceType, resourceId,
				formParams);

		return (JSONObject)toJson(result);
	}
	
	
	@Path("/{resourceType}/{resourceId}")
	@DELETE
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject delete(
			@PathParam(value = "resourceType") String resourceType,
			@PathParam(value = "resourceId") Long resourceId)
			throws Exception {

		Boolean result = resourcePoolProcessor.delete(resourceType, resourceId);

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
}
