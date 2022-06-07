/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.ArrayList;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.ElencoAziende;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class GetAziendeResponse   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private List<ElencoAziende> elencoAziende = new ArrayList<ElencoAziende>();

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("elenco_aziende") 
 
  public List<ElencoAziende> getElencoAziende() {
    return elencoAziende;
  }
  public void setElencoAziende(List<ElencoAziende> elencoAziende) {
    this.elencoAziende = elencoAziende;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAziendeResponse getAziendeResponse = (GetAziendeResponse) o;
    return Objects.equals(elencoAziende, getAziendeResponse.elencoAziende);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elencoAziende);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAziendeResponse {\n");
    
    sb.append("    elencoAziende: ").append(toIndentedString(elencoAziende)).append("\n");
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

