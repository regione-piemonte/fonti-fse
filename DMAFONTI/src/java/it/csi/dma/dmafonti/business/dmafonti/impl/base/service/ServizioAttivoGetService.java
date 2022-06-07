/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.impl.base.service;

import java.util.Date;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.dma.dmafonti.dto.dmafonti.fonti.InfoServizio;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.csi.dma.dmafonti.business.dmafonti.impl.base.FseRESTBaseService;
import it.csi.dma.dmafonti.util.Constants;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ServizioAttivoGetService extends FseRESTBaseService {

	public ServizioAttivoGetService( String xRequestID, String xCodiceServizio,
			SecurityContext securityContext, HttpHeaders httpHeaders) {
		super(securityContext, httpHeaders, null);
		
	}

	@Override
	protected Response execute() {
		
		InfoServizio info = new InfoServizio();
		info.setData(new Date());
		info.setNome(Constants.COMPONENT_NAME);
		info.setDescrizione("API Fonti del Fascicolo Sanitario Elettronico");
		info.setServizioAttivo(true);
		return Response.ok().entity(info).build();
	}
	

}
