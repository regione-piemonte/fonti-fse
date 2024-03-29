/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.fonti;

import it.csi.dma.dmafonti.dto.dmafonti.fonti.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import it.csi.dma.dmafonti.dto.dmafonti.fonti.InfoServizio;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/servizio-attivo")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the servizio-attivo API")

public interface ServizioAttivoApi  {
   
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Serve per verificare se il servizio risponde o meno ", response = InfoServizio.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = InfoServizio.class) })
    public Response servizioAttivoGet(@ApiParam(value = "" ,required=true)@HeaderParam("X-Request-ID") String xRequestID,@ApiParam(value = "" ,required=true)@HeaderParam("X-Codice-Servizio") String xCodiceServizio,@ApiParam(value = "" ,required=true)@HeaderParam("X-Forwarded-For") String xForwardedFor,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders );
}
