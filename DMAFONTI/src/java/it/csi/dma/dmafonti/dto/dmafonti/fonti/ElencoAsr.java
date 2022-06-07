/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.ArrayList;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.DocumentiInviati;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class ElencoAsr   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceAsr = null;
  private String descrizioneAsr = null;
  private Integer natura = null;
  private List<DocumentiInviati> documentiInviati = new ArrayList<DocumentiInviati>();

  /**
   * Identificativo della asr.
   **/
  
  @ApiModelProperty(value = "Identificativo della asr.")
  @JsonProperty("codice_asr") 
 
  public String getCodiceAsr() {
    return codiceAsr;
  }
  public void setCodiceAsr(String codiceAsr) {
    this.codiceAsr = codiceAsr;
  }

  /**
   * descrizione della asr.
   **/
  
  @ApiModelProperty(value = "descrizione della asr.")
  @JsonProperty("descrizione_asr") 
 
  public String getDescrizioneAsr() {
    return descrizioneAsr;
  }
  public void setDescrizioneAsr(String descrizioneAsr) {
    this.descrizioneAsr = descrizioneAsr;
  }

  /**
   * 1&#x3D;pub, 2&#x3D;priv, 3&#x3D;equiparato.
   **/
  
  @ApiModelProperty(value = "1=pub, 2=priv, 3=equiparato.")
  @JsonProperty("natura") 
 
  public Integer getNatura() {
    return natura;
  }
  public void setNatura(Integer natura) {
    this.natura = natura;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("documenti_inviati") 
 
  public List<DocumentiInviati> getDocumentiInviati() {
    return documentiInviati;
  }
  public void setDocumentiInviati(List<DocumentiInviati> documentiInviati) {
    this.documentiInviati = documentiInviati;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElencoAsr elencoAsr = (ElencoAsr) o;
    return Objects.equals(codiceAsr, elencoAsr.codiceAsr) &&
        Objects.equals(descrizioneAsr, elencoAsr.descrizioneAsr) &&
        Objects.equals(natura, elencoAsr.natura) &&
        Objects.equals(documentiInviati, elencoAsr.documentiInviati);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceAsr, descrizioneAsr, natura, documentiInviati);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElencoAsr {\n");
    
    sb.append("    codiceAsr: ").append(toIndentedString(codiceAsr)).append("\n");
    sb.append("    descrizioneAsr: ").append(toIndentedString(descrizioneAsr)).append("\n");
    sb.append("    natura: ").append(toIndentedString(natura)).append("\n");
    sb.append("    documentiInviati: ").append(toIndentedString(documentiInviati)).append("\n");
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

