package cn.edu.sjtu.dclab.warrantydemo.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wink.server.handlers.HandlersFactory;
import org.apache.wink.server.handlers.RequestHandler;
import org.apache.wink.server.handlers.ResponseHandler;

public class ResourcePoolHandlersFactory extends HandlersFactory {

	public List<? extends ResponseHandler> getErrorHandlers() {
		return Arrays.asList(new WarrantyExceptionHandler());
	}

	public List<? extends RequestHandler> getRequestHandlers() {
		return Arrays.asList(new WarrantyRequestHandler());
	}

}
