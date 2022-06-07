/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class FontiStaticheLowDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFonteStatica;
    private String codiceAzienda;
    private String descrizioneAzienda;
	private BigDecimal idNaturaAzienda;
    private String codiceDocumento;
	private String descrizioneDocumento;
	private String alimentazioneDocumento;


	public Integer getIdFonteStatica() {
		return idFonteStatica;
	}

	public void setIdFonteStatica(Integer idFonteStatica) {
		this.idFonteStatica = idFonteStatica;
	}

	public String getCodiceAzienda() {
		return codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		this.codiceAzienda = codiceAzienda;
	}

	public String getDescrizioneAzienda() {
		return descrizioneAzienda;
	}

	public void setDescrizioneAzienda(String descrizioneAzienda) {
		this.descrizioneAzienda = descrizioneAzienda;
	}

	public BigDecimal getIdNaturaAzienda() {
		return idNaturaAzienda;
	}

	public void setIdNaturaAzienda(BigDecimal idNaturaAzienda) {
		this.idNaturaAzienda = idNaturaAzienda;
	}

	public String getCodiceDocumento() {
		return codiceDocumento;
	}

	public void setCodiceDocumento(String codiceDocumento) {
		this.codiceDocumento = codiceDocumento;
	}

	public String getDescrizioneDocumento() {
		return descrizioneDocumento;
	}

	public void setDescrizioneDocumento(String descrizioneDocumento) {
		this.descrizioneDocumento = descrizioneDocumento;
	}

	public String getAlimentazioneDocumento() {
		return alimentazioneDocumento;
	}

	public void setAlimentazioneDocumento(String alimentazioneDocumento) {
		this.alimentazioneDocumento = alimentazioneDocumento;
	}

	public final boolean equals(Object other) {
        // TODO
        return super.equals(other);
    }

    public final int hashCode() {
        // TODO
        return super.hashCode();
    }

     public final FontiStaticheLowPk createPk() {
        return new FontiStaticheLowPk(idFonteStatica);
    }

    public final String toString() {
        // TODO
        return super.toString();
    }

}
