/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class FontiDinamicheLowDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFonteDinamica;
    private String codiceAzienda;
    private String descrizioneAzienda;
	private BigDecimal idNaturaAzienda;
    private String codiceDocumento;
	private String descrizioneDocumento;
	private BigDecimal conteggioDocumento;
	private String alimentazioneDocumento;
	private Timestamp dataInizioValidita;
	private Timestamp dataFineValidita;


	public Integer getIdFonteDinamica() {
		return idFonteDinamica;
	}

	public void setIdFonteDinamica(Integer idFonteDinamica) {
		this.idFonteDinamica = idFonteDinamica;
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

	public BigDecimal getConteggioDocumento() {
		return conteggioDocumento;
	}

	public void setConteggioDocumento(BigDecimal conteggioDocumento) {
		this.conteggioDocumento = conteggioDocumento;
	}

	public String getAlimentazioneDocumento() {
		return alimentazioneDocumento;
	}

	public void setAlimentazioneDocumento(String alimentazioneDocumento) {
		this.alimentazioneDocumento = alimentazioneDocumento;
	}

	public Timestamp getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Timestamp dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Timestamp getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Timestamp dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public final boolean equals(Object other) {
        // TODO
        return super.equals(other);
    }

    public final int hashCode() {
        // TODO
        return super.hashCode();
    }

     public final FontiDinamicheLowPk createPk() {
        return new FontiDinamicheLowPk(idFonteDinamica);
    }

    public final String toString() {
        // TODO
        return super.toString();
    }

}
