/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.fonti.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.csi.dma.dmafonti.business.dmafonti.fonti.CittadiniApi;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.ServiceExecutor;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.service.CittadiniAziendeGetService;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.service.CittadiniDocumentiGetService;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.service.CittadiniFontiGetService;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CittadiniApiServiceImpl implements CittadiniApi {
	@Override
	public Response cittadiniFontiGet(String shibIdentitaCodiceFiscale,String xRequestID,String xCodiceServizio,String xForwardedFor,SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest request ) {


		return ServiceExecutor.execute(CittadiniFontiGetService.class, shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio, xForwardedFor,
				securityContext, httpHeaders, request);
	}

	@Override
	public Response cittadiniAziendeGet(String shibIdentitaCodiceFiscale, String xRequestID, String xCodiceServizio,
			String xForwardedFor, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest request) {

		return ServiceExecutor.execute(CittadiniAziendeGetService.class, shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio, xForwardedFor,
				securityContext, httpHeaders, request);
	}

	@Override
	public Response cittadiniDocumentiGet(String shibIdentitaCodiceFiscale, String xRequestID, String xCodiceServizio,
			String xForwardedFor, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest request) {

		return ServiceExecutor.execute(CittadiniDocumentiGetService.class, shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio, xForwardedFor,
				securityContext, httpHeaders, request);
	}

}
