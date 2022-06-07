/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dto;

import java.io.Serializable;

public class FontiDocumentiLowDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String descrizione;		

    public String getCodice() {
		return codice;
	}



	public void setCodice(String codice) {
		this.codice = codice;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public final String toString() {
        // TODO
        return super.toString();
    }

}
