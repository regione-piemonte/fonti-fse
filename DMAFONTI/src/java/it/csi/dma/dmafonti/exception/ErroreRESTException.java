/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.exception;

import it.csi.dma.dmafonti.dto.dmafonti.fonti.Errore;

import javax.ws.rs.core.MediaType;


public class ErroreRESTException extends RESTException {

	private static final long serialVersionUID = -6454021553480738359L;

	public ErroreRESTException(Errore errore, String message) {
		super(errore.getStatus(), MediaType.APPLICATION_JSON_TYPE, errore, message);
	}
	
	public ErroreRESTException(Errore errore) {
		super(errore.getStatus(), MediaType.APPLICATION_JSON_TYPE, errore, errore.toString());
	}
	
	
}
