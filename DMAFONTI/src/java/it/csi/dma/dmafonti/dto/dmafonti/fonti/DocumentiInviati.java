/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class DocumentiInviati   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceDocumento = null;
  private String descrizioneDocumento = null;
  private Integer valoreConteggio = null;
  private String valoreAlimentazione = null;

  /**
   * Identificativo del documento.
   **/
  
  @ApiModelProperty(value = "Identificativo del documento.")
  @JsonProperty("codice_documento") 
 
  public String getCodiceDocumento() {
    return codiceDocumento;
  }
  public void setCodiceDocumento(String codiceDocumento) {
    this.codiceDocumento = codiceDocumento;
  }

  /**
   * Descrizione del documento.
   **/
  
  @ApiModelProperty(value = "Descrizione del documento.")
  @JsonProperty("descrizione_documento") 
 
  public String getDescrizioneDocumento() {
    return descrizioneDocumento;
  }
  public void setDescrizioneDocumento(String descrizioneDocumento) {
    this.descrizioneDocumento = descrizioneDocumento;
  }

  /**
   * Conteggio del documento.
   **/
  
  @ApiModelProperty(value = "Conteggio del documento.")
  @JsonProperty("valore_conteggio") 
 
  public Integer getValoreConteggio() {
    return valoreConteggio;
  }
  public void setValoreConteggio(Integer valoreConteggio) {
    this.valoreConteggio = valoreConteggio;
  }

  /**
   * S&#x3D;true o N&#x3D;false.
   **/
  
  @ApiModelProperty(value = "S=true o N=false.")
  @JsonProperty("valore_alimentazione") 
 
  public String getValoreAlimentazione() {
    return valoreAlimentazione;
  }
  public void setValoreAlimentazione(String valoreAlimentazione) {
    this.valoreAlimentazione = valoreAlimentazione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentiInviati documentiInviati = (DocumentiInviati) o;
    return Objects.equals(codiceDocumento, documentiInviati.codiceDocumento) &&
        Objects.equals(descrizioneDocumento, documentiInviati.descrizioneDocumento) &&
        Objects.equals(valoreConteggio, documentiInviati.valoreConteggio) &&
        Objects.equals(valoreAlimentazione, documentiInviati.valoreAlimentazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceDocumento, descrizioneDocumento, valoreConteggio, valoreAlimentazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentiInviati {\n");
    
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

