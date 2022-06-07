/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dto;

import java.io.Serializable;

/**
 * @generated
 */
public class FontiDinamicheLowPk implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @generated
     */
    private Integer idFonteDinamica;

    public Integer getIdFonteDinamica() {
        return idFonteDinamica;
    }

    public void setIdFonteDinamica(Integer idFonteDinamica) {
        this.idFonteDinamica = idFonteDinamica;
    }

    /**
     * @generated
     */
    public FontiDinamicheLowPk() {
    }

    /**
     * @generated
     */
    public FontiDinamicheLowPk(

    final Integer id

    ) {

        this.idFonteDinamica = id;

    }

    /**
     * Method 'equals'
     * 
     * @param other
     * @return boolean
     */
    public final boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (!(other instanceof FontiDinamicheLowPk)) {
            return false;
        }

        final FontiDinamicheLowPk cast = (FontiDinamicheLowPk) other;

        if (idFonteDinamica == null ? cast.getIdFonteDinamica() != idFonteDinamica : !idFonteDinamica.equals(cast.getIdFonteDinamica())) {
            return false;
        }

        return true;
    }

    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    public final int hashCode() {
        int hashCode = 0;

        if (idFonteDinamica != null) {
            hashCode = 29 * hashCode + idFonteDinamica.hashCode();
        }

        return hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public final String toString() {
        StringBuffer ret = new StringBuffer();

        ret.append("it.csi.dma.dmafonti.business.dto.FontiDinamicheLowPk: ");
        ret.append("id=" + idFonteDinamica);

        return ret.toString();
    }
}
