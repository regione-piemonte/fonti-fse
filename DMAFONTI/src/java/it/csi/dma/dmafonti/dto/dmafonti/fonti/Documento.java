/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;


public class Documento {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceDocumento = null;
  private String descrizioneDocumento = null;
  private String valoreConteggio = null;
  private String valoreAlimentazione = null;

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

  public String getValoreConteggio() {
    return valoreConteggio;
  }

  public void setValoreConteggio(String valoreConteggio) {
    this.valoreConteggio = valoreConteggio;
  }

  public String getValoreAlimentazione() {
    return valoreAlimentazione;
  }

  public void setValoreAlimentazione(String valoreAlimentazione) {
    this.valoreAlimentazione = valoreAlimentazione;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Documento documento = (Documento) o;
    return Objects.equals(getCodiceDocumento(), documento.getCodiceDocumento()) &&
            Objects.equals(getDescrizioneDocumento(), documento.getDescrizioneDocumento()) &&
            Objects.equals(getValoreConteggio(), documento.getValoreConteggio()) &&
            Objects.equals(getValoreAlimentazione(), documento.getValoreAlimentazione());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCodiceDocumento(), getDescrizioneDocumento(), getValoreConteggio(), getValoreAlimentazione());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fonte {\n");
    
    sb.append("    codiceDocumento: ").append(toIndentedString(codiceDocumento)).append("\n");
    sb.append("    descrizioneDocumento: ").append(toIndentedString(descrizioneDocumento)).append("\n");
    sb.append("    valoreConteggio: ").append(toIndentedString(valoreConteggio)).append("\n");
    sb.append("    valoreAlimentazione: ").append(toIndentedString(valoreAlimentazione)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

