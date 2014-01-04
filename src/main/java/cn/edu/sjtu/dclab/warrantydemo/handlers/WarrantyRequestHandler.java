package cn.edu.sjtu.dclab.warrantydemo.handlers;

import java.util.Properties;

import javax.ws.rs.core.MediaType;

import org.apache.wink.server.handlers.HandlersChain;
import org.apache.wink.server.handlers.MessageContext;
import org.apache.wink.server.handlers.RequestHandler;

public class WarrantyRequestHandler implements RequestHandler {

	public static boolean init = false;

	public void init(Properties arg0) {

	}

	public void handleRequest(MessageContext context, HandlersChain chain)
			throws Throwable {
		// TODO Auto-generated method stub
		if (!init) {
			// ServiceBeanPool.getInstance().init();
			init = true;
		}
		//context.setResponseMediaType(MediaType.APPLICATION_JSON);
		chain.doChain(context);
	}
}
