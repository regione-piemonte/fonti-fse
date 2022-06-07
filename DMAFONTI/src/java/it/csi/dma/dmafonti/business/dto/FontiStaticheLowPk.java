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
public class FontiStaticheLowPk implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @generated
     */
    private Integer idFonteStatica;

    /**
     * @generated
     */
     public final void setIdFonteStatica(Integer val) {
        this.idFonteStatica = val;
    }

    /**
     * @generated
     */
     public final Integer getIdFonteStatica() {
        return this.idFonteStatica;
    }

    /**
     * @generated
     */
    public FontiStaticheLowPk() {
    }

    /**
     * @generated
     */
    public FontiStaticheLowPk(

    final Integer id

    ) {

        this.idFonteStatica = id;

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

        if (!(other instanceof FontiStaticheLowPk)) {
            return false;
        }

        final FontiStaticheLowPk cast = (FontiStaticheLowPk) other;

        if (idFonteStatica == null ? cast.getIdFonteStatica() != idFonteStatica : !idFonteStatica.equals(cast.getIdFonteStatica())) {
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

        if (idFonteStatica != null) {
            hashCode = 29 * hashCode + idFonteStatica.hashCode();
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

        ret.append("it.csi.dma.dmafonti.business.dto.FontiStaticheLowPk: ");
        ret.append("id=" + idFonteStatica);

        return ret.toString();
    }
}
