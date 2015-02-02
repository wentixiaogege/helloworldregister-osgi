package org.serc.helloworld.activator;

import java.util.List;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.serc.helloworld.Hello;
import org.serc.helloworld.impl.HelloImpl;

public class Activator implements BundleActivator{
	@SuppressWarnings("rawtypes")
	private List<ServiceRegistration> registrations = new ArrayList<ServiceRegistration>();

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("registed!");
		registrations.add(context.registerService(Hello.class.getName(),new HelloImpl("Hello, OSGi"), null));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		for(@SuppressWarnings("rawtypes") ServiceRegistration registration : registrations) {
			System.out.println("unregistering:"+ registration);
			registration.unregister();
		}
	}

}
