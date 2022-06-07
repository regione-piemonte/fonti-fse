/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.fonti;

import it.csi.dma.dmafonti.util.LogUtil;
import it.csi.dma.dmafonti.util.SpringApplicationContextProvider;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@ApplicationPath("api/v1")
public class RestApplication extends Application {
	private LogUtil log = new LogUtil(RestApplication.class);
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RestApplication() {
		final String METHOD_NAME = "RestApplication";
		log.debug(METHOD_NAME, "init RestApplication.");
		
		ApplicationContext appContext = SpringApplicationContextProvider.getApplicationContext();
		Map<String, Object> beans = appContext.getBeansWithAnnotation(Path.class);
		
		log.debug(METHOD_NAME, "Discovering @Path annotated beans... ");
		Collection<Object> values = beans.values();
		values.stream().forEach(this::register);

	}
	
	private void register(Object serviceImpl) {
		final String METHOD_NAME = "RestApplication";
		if(serviceImpl == null) {
			return;
		}
		log.info(METHOD_NAME, "Registering Rest bean: %s", serviceImpl.getClass().getName());
		singletons.add(serviceImpl);
	}
	

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	

}
