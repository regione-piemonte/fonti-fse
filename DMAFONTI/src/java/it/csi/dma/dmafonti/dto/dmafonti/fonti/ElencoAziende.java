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



public class ElencoAziende   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer aziendaCodice = null;
  private String aziendaDescrizione = null;
  private Integer naturaId = null;
  private String naturaDescrizione = null;

  /**
   * codice azienda.
   **/
  
  @ApiModelProperty(value = "codice azienda.")
  @JsonProperty("azienda_codice") 
 
  public Integer getAziendaCodice() {
    return aziendaCodice;
  }
  public void setAziendaCodice(Integer aziendaCodice) {
    this.aziendaCodice = aziendaCodice;
  }

  /**
   * descrizione azienda.
   **/
  
  @ApiModelProperty(value = "descrizione azienda.")
  @JsonProperty("azienda_descrizione") 
 
  public String getAziendaDescrizione() {
    return aziendaDescrizione;
  }
  public void setAziendaDescrizione(String aziendaDescrizione) {
    this.aziendaDescrizione = aziendaDescrizione;
  }

  /**
   * 1&#x3D;pub, 2&#x3D;priv, 3&#x3D;equiparato.
   **/
  
  @ApiModelProperty(value = "1=pub, 2=priv, 3=equiparato.")
  @JsonProperty("natura_id") 
 
  public Integer getNaturaId() {
    return naturaId;
  }
  public void setNaturaId(Integer naturaId) {
    this.naturaId = naturaId;
  }

  /**
   * codice natura.
   **/
  
  @ApiModelProperty(value = "codice natura.")
  @JsonProperty("natura_descrizione") 
 
  public String getNaturaDescrizione() {
    return naturaDescrizione;
  }
  public void setNaturaDescrizione(String naturaDescrizione) {
    this.naturaDescrizione = naturaDescrizione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElencoAziende elencoAziende = (ElencoAziende) o;
    return Objects.equals(aziendaCodice, elencoAziende.aziendaCodice) &&
        Objects.equals(aziendaDescrizione, elencoAziende.aziendaDescrizione) &&
        Objects.equals(naturaId, elencoAziende.naturaId) &&
        Objects.equals(naturaDescrizione, elencoAziende.naturaDescrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aziendaCodice, aziendaDescrizione, naturaId, naturaDescrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElencoAziende {\n");
    
    sb.append("    aziendaCodice: ").append(toIndentedString(aziendaCodice)).append("\n");
    sb.append("    aziendaDescrizione: ").append(toIndentedString(aziendaDescrizione)).append("\n");
    sb.append("    naturaId: ").append(toIndentedString(naturaId)).append("\n");
    sb.append("    naturaDescrizione: ").append(toIndentedString(naturaDescrizione)).append("\n");
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

