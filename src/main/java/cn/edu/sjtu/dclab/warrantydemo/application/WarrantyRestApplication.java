package cn.edu.sjtu.dclab.warrantydemo.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import cn.edu.sjtu.dclab.warrantydemo.ws.CommonDataWebservice;

public class WarrantyRestApplication extends Application {
	
	private Set<Object> svc_singletons = new HashSet<Object>();	
	private Set<Class<?>> svc_classes  = new HashSet<Class<?>>();

	public WarrantyRestApplication() {
		System.out.println("application init");
		svc_singletons.add(CommonDataWebservice.getInstance());
	}
	
	public Set<Object> getSingletons() {
		return svc_singletons;
	}
	 
	public Set<Class<?>> getClasses() {
		return svc_classes;
	}


	
}
