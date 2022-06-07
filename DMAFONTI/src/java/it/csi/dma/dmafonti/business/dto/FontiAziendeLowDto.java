/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dto;

import java.io.Serializable;

public class FontiAziendeLowDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long aziendaCodice;
	private String aziendaDescrizione;
	private Long natura_id;
	private String naturaDescrizione;		

    public Long getAziendaCodice() {
		return aziendaCodice;
	}



	public void setAziendaCodice(Long aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}



	public String getAziendaDescrizione() {
		return aziendaDescrizione;
	}



	public void setAziendaDescrizione(String aziendaDescrizione) {
		this.aziendaDescrizione = aziendaDescrizione;
	}



	public Long getNatura_id() {
		return natura_id;
	}



	public void setNatura_id(Long natura_id) {
		this.natura_id = natura_id;
	}



	public String getNaturaDescrizione() {
		return naturaDescrizione;
	}



	public void setNaturaDescrizione(String naturaDescrizione) {
		this.naturaDescrizione = naturaDescrizione;
	}



	public final String toString() {
        // TODO
        return super.toString();
    }

}
