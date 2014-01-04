package cn.edu.sjtu.dclab.warrantydemo.handlers;

import java.util.Properties;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.wink.server.handlers.HandlersChain;
import org.apache.wink.server.handlers.MessageContext;
import org.apache.wink.server.handlers.ResponseHandler;
import org.json.JSONObject;

public class WarrantyExceptionHandler implements ResponseHandler {

	public void init(Properties arg0) {
		
	}

	@Produces(MediaType.APPLICATION_JSON)
	public void handleResponse(MessageContext arg0, HandlersChain arg1)
			throws Throwable {
		JSONObject result=new JSONObject();
		result.put("status", "exception");
		arg0.setResponseEntity(result);
		arg0.setResponseMediaType(MediaType.APPLICATION_JSON_TYPE);
		arg1.doChain(arg0);		
	}
}
