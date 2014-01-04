package cn.edu.sjtu.se.dclab.cloud.dataaccessor.entityservice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ContextManager {

	public String persistenceFilePath;
	private Map<String, String> classMap;
	
	
	public ContextManager() {
		classMap = new HashMap<String, String>();
		setPersistenceFilePath("META-INF/persistence.xml");
	}

	
	public String getPersistenceFilePath() {
		return persistenceFilePath;
	}

	public void setPersistenceFilePath(String persistenceFilePath) {
		this.persistenceFilePath = persistenceFilePath;
		refresh();
	}
	
	
	private void refresh() {
		classMap.clear();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			File xmlFile = new File(this.getClass().getClassLoader().getResource(persistenceFilePath).toURI());
			Document doc = builder.parse(xmlFile);
			//Element table = doc.getDocumentElement();
			NodeList nodeList = doc.getElementsByTagName("*");
			for (int i = 0; i < nodeList.getLength(); i ++) {
				Node node = nodeList.item(i);
				if (node.getNodeName().equals("class")) {
					String classPath = node.getTextContent();
					if (classPath.contains(".")) {
						String[] components = classPath.split("\\.");
						String className = components[components.length - 1];
						classMap.put(EntityDataService.stringByUpperTheFirstChar(className), classPath);
					}
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public String pathForClass(String className) {
		String cm = EntityDataService.stringByUpperTheFirstChar(className);
		if (classMap.containsKey(cm)) {
			return classMap.get(cm);
		} else {
			return null;
		}
	}
}
