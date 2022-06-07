/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.fonti.impl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.csi.dma.dmafonti.business.dmafonti.fonti.ServizioAttivoApi;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.ServiceExecutor;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.service.ServizioAttivoGetService;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ServizioAttivoApiServiceImpl implements ServizioAttivoApi {
      public Response servizioAttivoGet(String xRequestID,String xCodiceServizio,String xForwardedFor,SecurityContext securityContext, HttpHeaders httpHeaders ) {
      // do some magic!
          return ServiceExecutor.execute(ServizioAttivoGetService.class, xRequestID, xCodiceServizio,  securityContext, httpHeaders);
  }
}
